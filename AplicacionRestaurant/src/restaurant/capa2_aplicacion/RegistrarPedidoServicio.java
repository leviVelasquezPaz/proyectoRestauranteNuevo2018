/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa2_aplicacion;

import java.util.List;
import javax.swing.JOptionPane;
import restaurant.capa3_dominio.Cliente;
import restaurant.capa3_dominio.LineaPedido;
import restaurant.capa3_dominio.Mesa;
import restaurant.capa3_dominio.Usuario;
import restaurant.capa3_dominio.Pedido;
import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;
import restaurant.capa4_persistencia.ClienteDAOPostgre;
import restaurant.capa4_persistencia.GestorJDBC;
import restaurant.capa4_persistencia.GestorJDBCPostgre;
import restaurant.capa4_persistencia.MesaDAOPostgre;
import restaurant.capa4_persistencia.UsuarioDAOPostgre;
import restaurant.capa4_persistencia.PedidoDAOPostgre;
import restaurant.capa4_persistencia.ProductoDAOPostgre;
import restaurant.capa4_persistencia.TipoProductoDAOPostgre;

/**
 *
 * @author Antonio AB
 */
public class RegistrarPedidoServicio {

    private GestorJDBC gestorJDBC;
    private PedidoDAOPostgre pedidoDAOPostgre;
    private UsuarioDAOPostgre mozoDAOPostgre;
    private TipoProductoDAOPostgre tipoProductoDAOPostgre;
    private ClienteDAOPostgre clienteDAOPostgre;
    private MesaDAOPostgre mesaDAOPostgre;
    private ProductoDAOPostgre productoDAOPostgre;

    public RegistrarPedidoServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        productoDAOPostgre = new ProductoDAOPostgre(gestorJDBC);
        pedidoDAOPostgre = new PedidoDAOPostgre(gestorJDBC);
        mozoDAOPostgre = new UsuarioDAOPostgre(gestorJDBC);
        mesaDAOPostgre = new MesaDAOPostgre(gestorJDBC);
        tipoProductoDAOPostgre = new TipoProductoDAOPostgre(gestorJDBC);
        clienteDAOPostgre = new ClienteDAOPostgre(gestorJDBC);
    }

    public List<Producto> mostrarProducto(int tipoProducto) {
        List<Producto> listaProducto = null;
        try {
            gestorJDBC.abrirConexion();
            listaProducto = productoDAOPostgre.mostrarPorTipo(tipoProducto);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listaProducto;
    }

    public Usuario buscarMozoDNI(String dni) throws Exception {
        gestorJDBC.abrirConexion();
        Usuario mozo = mozoDAOPostgre.buscarPorDNI(dni);
        gestorJDBC.cerrarConexion();
        return mozo;
    }

    public Mesa buscarMesa(int numero) throws Exception {
        gestorJDBC.abrirConexion();
        Mesa mesa = mesaDAOPostgre.buscarPorNumero(numero);
        if (mesa != null) {
            if (mesa.getMesaEstado().equals(Mesa.ESTADO_RESERVADA)) {
                JOptionPane.showMessageDialog(null, "La mesa  esta reservada");
                mesa = null;
            } else if (mesa.getMesaEstado().equals(Mesa.ESTADO_OCUPADO)) {
                JOptionPane.showMessageDialog(null, "mesa  ocupada ");
                mesa = null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "La mesa no existe");
        }

        gestorJDBC.cerrarConexion();
        return mesa;
    }

    public List<TipoProducto> mostrarTipoProducto() throws Exception {
        gestorJDBC.abrirConexion();
        List<TipoProducto> listaTipoProducto = tipoProductoDAOPostgre.mostrar();
        gestorJDBC.cerrarConexion();
        return listaTipoProducto;
    }

    public Cliente buscarClientePorDNI(String dni) throws Exception {
        Cliente cliente = null;

        gestorJDBC.abrirConexion();
        cliente = clienteDAOPostgre.buscarDni(dni);
        gestorJDBC.cerrarConexion();

        return cliente;
    }

    public int crearPedido(Pedido pedido) throws Exception {

        gestorJDBC.abrirConexion();
        List<LineaPedido> listaPedidos = pedido.getListaLineaPedido();
        try {
            int contador = 0;
            for (LineaPedido lineaPedido : listaPedidos) {
                int cantidad = lineaPedido.getCantidad();
                listaPedidos.get(contador).getProducto().restarStock(cantidad);
                contador++;
            }
            
            gestorJDBC.iniciarTransaccion();
            int resgistros_afectador = pedidoDAOPostgre.ingresar(pedido);
            gestorJDBC.terminarTransaccion();
            return resgistros_afectador;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }

    }

    public List<Pedido> listadoPedidos() throws Exception {
        try {
            gestorJDBC.abrirConexion();
            List<Pedido> listaPedidos = pedidoDAOPostgre.listaPedidos();
            gestorJDBC.cerrarConexion();
            return listaPedidos;
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public Pedido buscarPedido(int idPedido) throws Exception {
        gestorJDBC.abrirConexion();
        Pedido pedido = pedidoDAOPostgre.buscarPedido(idPedido);
        gestorJDBC.cerrarConexion();
        return pedido;
    }

    public Producto buscarProductoCodigo(int productoCodigo) throws Exception {
        gestorJDBC.abrirConexion();
        Producto producto = productoDAOPostgre.buscar(productoCodigo);
        gestorJDBC.cerrarConexion();
        return producto;
    }

    public List<Producto> mostrarProducto() {

        List<Producto> listaProducto = null;
        try {
            gestorJDBC.abrirConexion();
            listaProducto = productoDAOPostgre.mostrarTodos();
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listaProducto;
    }

    public List<Producto> buscarPorTipoProducto(int codigo) throws Exception {
        List<Producto> listaProductos = null;
        gestorJDBC.abrirConexion();
        listaProductos = productoDAOPostgre.mostrarPorTipo(codigo);
        gestorJDBC.cerrarConexion();
        return listaProductos;

    }

    public int obtenerUltimoCodigo() throws Exception {
        int codigo = 0;
        try {
            gestorJDBC.abrirConexion();
            codigo = pedidoDAOPostgre.obtenerUltimoCodigo();
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
         
        }

        return codigo;
    }

    public Pedido buscarPedidoPorMesa(Mesa mesa) {
        try {
            Pedido pedido = null;
            gestorJDBC.abrirConexion();;
            pedido = pedidoDAOPostgre.buscarPedidoPorMesa(mesa);
            gestorJDBC.cerrarConexion();
            return pedido;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }

    }
}
