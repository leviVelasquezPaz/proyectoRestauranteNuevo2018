/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa4_persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import restaurant.capa3_dominio.Cliente;
import restaurant.capa3_dominio.LineaPedido;
import restaurant.capa3_dominio.Mesa;
import restaurant.capa3_dominio.Usuario;
import restaurant.capa3_dominio.Pedido;
import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;

/**
 *
 * @author Antonio AB
 */
public class PedidoDAOPostgre {

    GestorJDBC gestorJDBC;

    public PedidoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public int ingresar(Pedido pedido) throws SQLException {
        int registros_afectados;
        int resgistro_afectado_mesa = -1;
        pedido.getMesa().setMesaEstado(Mesa.ESTADO_OCUPADO);
        String sentenciaSQL = "INSERT INTO pedido (pedidocodigo, usuariocodigo, mesacodigo, clientecodigo,pedidofecha, pedidoestado)"
                + "	VALUES (?, ?, ?, ?, ?, ?)";
        String sentenciaSQLlineaDePedido = "INSERT INTO lineapedido(lineapedidocodigo, lineapedidocantidad, productocodigo, lineapedidoestado, lineapedidoprecio,pedidocodigo) VALUES (?, ?, ?, ?, ?,?)";

        try {
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, pedido.getPedidoCodigo());
            sentencia.setInt(2, pedido.getUsuario().getUsuarioCodigo());
            sentencia.setInt(3, pedido.getMesa().getMesaCodigo());
            sentencia.setInt(4, pedido.getCliente().getClienteCodigo());
            sentencia.setDate(5, pedido.getPedidoFecha());
            sentencia.setString(6, pedido.getPedidoEstado());
            registros_afectados = sentencia.executeUpdate();
            if (registros_afectados == 1) {
                ///ahora pasaremos a ingresar en la table de la base de datos linea pedido 
                for (LineaPedido lineaPedido : pedido.getListaLineaPedido()) {
                    int registros_afectados_lineadepedido = 0;
                    PreparedStatement sentencialineadepedido = gestorJDBC.prepararSentencia(sentenciaSQLlineaDePedido);
                    LineaPedidoDAOPostgres lineaPedidoPostgres = new LineaPedidoDAOPostgres(gestorJDBC);
                    sentencialineadepedido.setInt(1, lineaPedidoPostgres.obtenerUltimoCodigo() + 1);
                    sentencialineadepedido.setInt(2, lineaPedido.getCantidad());
                    sentencialineadepedido.setDouble(3, lineaPedido.getProducto().getProductoCodigo());
                    sentencialineadepedido.setString(4, lineaPedido.getEstado());
                    sentencialineadepedido.setDouble(5, lineaPedido.getProducto().getProductoPrecio());
                    sentencialineadepedido.setDouble(6, lineaPedido.getPedido().getPedidoCodigo());
                    registros_afectados_lineadepedido = sentencialineadepedido.executeUpdate();
                    //---------------  Actualizacion de stock ------------------------------
                    if (registros_afectados_lineadepedido == 1) {
                        //actualizar stock
                        ProductoDAOPostgre productoDAO = new ProductoDAOPostgre(gestorJDBC);
                        productoDAO.actualizarStock(lineaPedido.getProducto());
                        MesaDAOPostgre mesaDAOPostgre = new MesaDAOPostgre(gestorJDBC);
                        mesaDAOPostgre.modificar(pedido.getMesa());

                    }
                }

            }
            return registros_afectados;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return -1;
        }
    }

    public int obtenerUltimoCodigo() throws SQLException {

        ResultSet resultado;
        String sentenciaSQL;
        int codigo = 0;
        sentenciaSQL = "Select  count(*) as codigo from pedido ";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            codigo = (resultado.getInt("codigo"));

        }
        resultado.close();
        return codigo;
    }

    public Pedido buscarPedido(int pedidoCodigo) throws SQLException {
        Pedido pedido = null;
        ResultSet resultSetPedido, resultSetLinea;

        String sentenciaSQL_Pedido = "select p.pedidocodigo,p.pedidofecha,p.pedidoestado,p.clientecodigo,p.mesacodigo,p.usuariocodigo from Pedido p inner join Usuario mo on p.pedidoCodigo=mo.usuarioCodigo"
                + "inner join Mesa me on me.mesaCodigo=p.mesaCodigo inner join Cliente cl on cli.clienteCodigo=p.clienteCodigo"
                + "where p.pedidocodigo=" + pedidoCodigo + "";
        String sentenciaSQL_lineas = "select *from lineapedido li inner join producto pr on pr.productocodigo=li.productdocodigo"
                + "inner join pedido p on p.pedidocodigo=li.pedidocodigo"
                + "where p.pedidoCodigo=";

        resultSetPedido = gestorJDBC.ejecutarConsulta(sentenciaSQL_Pedido);
        if (resultSetPedido.next()) {
            pedido = new Pedido();
            pedido.setPedidoCodigo(resultSetPedido.getInt("p.pedidocodigo"));
            pedido.setPedidoFecha(resultSetPedido.getDate("p.pedidofecha"));

            ClienteDAOPostgre clienteDAO = new ClienteDAOPostgre(gestorJDBC);
            MesaDAOPostgre mesaDao = new MesaDAOPostgre(gestorJDBC);
            UsuarioDAOPostgre usuarioDAO = new UsuarioDAOPostgre(gestorJDBC);

            Mesa mesa = mesaDao.buscarCodigo(resultSetPedido.getInt("p.mesadodigo"));
            Usuario usuario = usuarioDAO.buscarCodigo(resultSetPedido.getInt("p.usuariocodigo"));
            Cliente cliente = clienteDAO.buscarPorCodigo(resultSetPedido.getInt("p.clientecodigo"));

            pedido.setCliente(cliente);
            pedido.setMesa(mesa);
            pedido.setUsuario(usuario);

            sentenciaSQL_lineas = sentenciaSQL_lineas + pedido.getPedidoCodigo(); //hasta qui el pedido ya debe tener un id
            resultSetLinea = gestorJDBC.ejecutarConsulta(sentenciaSQL_lineas + pedido.getPedidoCodigo());
            while (resultSetLinea.next()) {
                Producto producto = new Producto();
                producto.setProductoCodigo(resultSetLinea.getInt("productocodigo"));
                producto.setProductoNombre(resultSetLinea.getString("productonombre"));
                producto.setProductoDescripcion(resultSetLinea.getString("productodescripcion"));
                producto.setProdcutoStock(resultSetLinea.getInt("productostock"));
                TipoProductoDAOPostgre tipoProductoDAO = new TipoProductoDAOPostgre(gestorJDBC);
                TipoProducto tipoProducto = tipoProductoDAO.buscarPorCodigo(resultSetLinea.getInt("tipoproductocodigo"));
                producto.setTipoDeProducto(tipoProducto);
                producto.setProductoFechaRegistro(resultSetLinea.getDate("productofecharegistro"));
                producto.setProductoEstado(resultSetLinea.getString("`prodcutoestado"));
            }
        }
        resultSetPedido.close();
        return pedido;

    }

    public List<Pedido> listaPedidos() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList();
        Pedido pedido;
        ResultSet resultado;
        String sentenciaSQL;

        String sentenciaSQL_Pedido = "select p.pedidocdigo,p.pedidofecha,p.pedidoestado,p.clientecodigo,p.mesacodigo,p.usuariocodigo from pedido p inner join usuario mo on p.pedidocodigo=mo.usuariocodigo "
                + "inner join Cliente cl on cli.clienteCodigo=p.clienteCodigo";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL_Pedido);
        while (resultado.next()) {
            pedido = new Pedido();
            pedido.setPedidoCodigo(resultado.getInt("p.pedidocodigo"));
            pedido.setPedidoFecha(resultado.getDate("p.pedidofecha"));

            ClienteDAOPostgre clienteDAO = new ClienteDAOPostgre(gestorJDBC);
            UsuarioDAOPostgre usuarioDAO = new UsuarioDAOPostgre(gestorJDBC);

            Usuario usuario = usuarioDAO.buscarCodigo(resultado.getInt("p.usuariocodigo"));
            Cliente cliente = clienteDAO.buscarPorCodigo(resultado.getInt("p.clientecodigo"));
            pedido.setCliente(cliente);
            pedido.setUsuario(usuario);
            pedidos.add(pedido);
        }
        resultado.close();
        return pedidos;
    }

    public Pedido buscarPedidoPorMesa(Mesa mesa) throws Exception {
        Pedido pedido = null;
        ResultSet resultSetPedido, resultSetLinea;
        String sentenciaSQL_Pedido = "select *from pedido p inner join usuario mo on p.pedidoCodigo=mo.usuarioCodigo inner join mesa me on me.mesaCodigo=p.mesaCodigo inner join cliente cli on cli.clienteCodigo=p.clienteCodigo where me.mesacodigo=" + mesa.getMesaCodigo() + "";

        String sentenciaSQL_lineas = "select *from producto pr inner join lineapedido li on pr.productocodigo=li.productocodigo "
                + "inner join pedido pe on pe.pedidocodigo=li.pedidocodigo where pe.pedidocodigo=";

        resultSetPedido = gestorJDBC.ejecutarConsulta(sentenciaSQL_Pedido);
        if (resultSetPedido.next()) {
            pedido = new Pedido();
            pedido.setPedidoCodigo(resultSetPedido.getInt("pedidocodigo"));
            pedido.setPedidoFecha(resultSetPedido.getDate("pedidofecha"));

            ClienteDAOPostgre clienteDAO = new ClienteDAOPostgre(gestorJDBC);
            UsuarioDAOPostgre usuarioDAO = new UsuarioDAOPostgre(gestorJDBC);

            Usuario usuario = usuarioDAO.buscarCodigo(resultSetPedido.getInt("usuariocodigo"));
            Cliente cliente = clienteDAO.buscarPorCodigo(resultSetPedido.getInt("clientecodigo"));
            pedido.setCliente(cliente);
            pedido.setUsuario(usuario);

            sentenciaSQL_lineas = sentenciaSQL_lineas + pedido.getPedidoCodigo(); //hasta qui el pedido ya debe tener un id
            resultSetLinea = gestorJDBC.ejecutarConsulta(sentenciaSQL_lineas);
            while (resultSetLinea.next()) {
                Producto producto = new Producto();
                producto.setProductoCodigo(resultSetLinea.getInt("productocodigo"));
                producto.setProductoNombre(resultSetLinea.getString("productonombre"));
                producto.setProductoDescripcion(resultSetLinea.getString("productodescripcion"));
                producto.setProdcutoStock(resultSetLinea.getInt("productostock"));
                producto.setProductoPrecio(resultSetLinea.getInt("productoprecio"));
                int codigoLineaPedido = resultSetLinea.getInt("lineapedidocodigo");

                int cantidadLineaPedido = resultSetLinea.getInt("lineapedidocantidad");
                int precioLineaPedido = resultSetLinea.getInt("lineapedidoprecio");
                String estadoLineaPedido = resultSetLinea.getString("lineapedidoestado");

                TipoProductoDAOPostgre tipoProductoDAO = new TipoProductoDAOPostgre(gestorJDBC);
                TipoProducto tipoProducto = tipoProductoDAO.buscarPorCodigo(resultSetLinea.getInt("tipoproductocodigo"));

                producto.setTipoDeProducto(tipoProducto);
                producto.setProductoFechaRegistro(resultSetLinea.getDate("productofecharegistro"));
                producto.setProductoEstado(resultSetLinea.getString("productoestado"));

                LineaPedido lineaPedido = new LineaPedido();
                lineaPedido.setLineaPedidoCodigo(codigoLineaPedido);
                lineaPedido.setCantidad(cantidadLineaPedido);
                lineaPedido.setPedido(pedido);
                lineaPedido.setProducto(producto);
                lineaPedido.setEstado(estadoLineaPedido);
                
                pedido.agregarLineaPedido(cantidadLineaPedido, producto);
            }
        }
        resultSetPedido.close();
        return pedido;
    }

}
