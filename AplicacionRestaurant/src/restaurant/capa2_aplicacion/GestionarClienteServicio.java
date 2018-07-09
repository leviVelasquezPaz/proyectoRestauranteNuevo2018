/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa2_aplicacion;

import java.util.List;
import javax.swing.JOptionPane;
import restaurant.capa3_dominio.Cliente;
import restaurant.capa4_persistencia.ClienteDAOPostgre;
import restaurant.capa4_persistencia.GestorJDBC;
import restaurant.capa4_persistencia.GestorJDBCPostgre;

public class GestionarClienteServicio {

    private GestorJDBC gestorJDBC;
    private ClienteDAOPostgre clienteDAOPostgre;

    public GestionarClienteServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        clienteDAOPostgre = new ClienteDAOPostgre(gestorJDBC);
    }

    public int guardarCliente(Cliente cliente) throws Exception {
        gestorJDBC.abrirConexion();
        int numerosAfecatdos = clienteDAOPostgre.ingresar(cliente);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public int obtenerUltimoCodigo() throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = clienteDAOPostgre.obtenerUltimoCodigo();
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

    public int modificarCliente(Cliente cliente)throws Exception{
        gestorJDBC.abrirConexion();
        int ultimoCodigo = clienteDAOPostgre.modificar(cliente);
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

    public List<Cliente> mostrarClientes(String estado) {
        List<Cliente> listaProducto = null;
        try {
            gestorJDBC.abrirConexion();
            listaProducto = clienteDAOPostgre.mostrarTodos(estado);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listaProducto;

    }

    public Cliente buscarClientePorCodigo(int codigo) throws Exception {

        gestorJDBC.abrirConexion();
        Cliente cliente = clienteDAOPostgre.buscarPorCodigo(codigo);
        gestorJDBC.cerrarConexion();
        return cliente;
    }

    public int eliminarCliente(Cliente cliente) throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = clienteDAOPostgre.eliminar(cliente);
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

}
