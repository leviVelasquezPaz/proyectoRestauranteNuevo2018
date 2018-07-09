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

import restaurant.capa3_dominio.Cliente;

/**
 *
 * @author Antonio AB
 */
public class ClienteDAOPostgre {

    GestorJDBC gestorJDBC;

    public ClienteDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public Cliente buscarDni(String dni) throws SQLException {
        Cliente cliente = null;

        ResultSet resultado;
        String sentenciaSQL;
        sentenciaSQL = "select clientecodigo, clientepaterno, clientematerno, clientenombre, clientedni, clienteestado from cliente where clientedni='" + dni + "'";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);

        if (resultado.next()) {
            cliente = new Cliente();

            cliente.setClienteCodigo(resultado.getInt("clientecodigo"));
            cliente.setClientePaterno(resultado.getString("clientepaterno"));
            cliente.setClienteMaterno(resultado.getString("clientematerno"));
            cliente.setClienteNombre(resultado.getString("clientenombre"));
            cliente.setClienteDni(resultado.getString("clientedni"));
            cliente.setClienteEstado(resultado.getString("clienteestado"));

        }
        resultado.close();
        return cliente;
    }

    public List<Cliente> buscarPorNombre(String dni) throws SQLException {
        ArrayList<Cliente> listaClientes = new ArrayList();
        Cliente cliente;
        ResultSet resultado;
        String sentenciaSQL;
        sentenciaSQL = "Select clienteCodigo, clientePaterno, clienteMaterno, clienteNombre, clienteDni,clienteEstado"
                + "FROM Cliente where clienteNombre like '%" + dni + "%'";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            cliente = new Cliente();
            cliente.setClienteCodigo(resultado.getInt("clienteCodigo"));
            cliente.setClientePaterno(resultado.getString("clientePaterno"));
            cliente.setClienteMaterno(resultado.getString("clienteMaterno"));
            cliente.setClienteNombre(resultado.getString("clienteNombre"));
            cliente.setClienteDni(resultado.getString("clienteDni"));
            cliente.setClienteEstado(resultado.getString("clienteEstado"));

            listaClientes.add(cliente);
        }
        resultado.close();
        return listaClientes;
    }

    public Cliente buscarPorCodigo(int clienteCodigo) throws SQLException {
        Cliente cliente = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "Select clienteCodigo, clientePaterno, clienteMaterno, clienteNombre, clienteDni,clienteEstado"
                + "	FROM Cliente where clienteCodigo= " + clienteCodigo;

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            cliente = new Cliente();
            cliente.setClienteCodigo(resultado.getInt("clienteCodigo"));
            cliente.setClientePaterno(resultado.getString("clientePaterno"));
            cliente.setClienteMaterno(resultado.getString("clienteMaterno"));
            cliente.setClienteNombre(resultado.getString("clienteNombre"));
            cliente.setClienteDni(resultado.getString("clienteDni"));
            cliente.setClienteEstado(resultado.getString("clienteEstado"));

        }
        resultado.close();
        return cliente;
    }

    public int ingresar(Cliente cliente) throws SQLException {
        String sentenciaSQL = "INSERT INTO Cliente(clienteCodigo, clientePaterno, clienteMaterno, clienteNombre, clienteDni,clienteEstado)"
                + "	VALUES (?, ?, ?, ?, ?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, cliente.getClienteCodigo());
        sentencia.setString(2, cliente.getClientePaterno());
        sentencia.setString(3, cliente.getClienteMaterno());
        sentencia.setString(4, cliente.getClienteNombre());
        sentencia.setString(5, cliente.getClienteDni());
        sentencia.setString(6, cliente.getClienteEstado());
        return sentencia.executeUpdate();
    }

    public int modificar(Cliente cliente) throws SQLException {
        String sentenciaSQL = "UPDATE Cliente SET clientePaterno=?, clienteMaterno=?, clienteNombre=?,clienteDni=?,clienteEstado=? WHERE clienteCodigo=?";

        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, cliente.getClientePaterno());
        sentencia.setString(2, cliente.getClienteMaterno());
        sentencia.setString(3, cliente.getClienteNombre());
        sentencia.setString(4, cliente.getClienteDni());
        sentencia.setString(5, cliente.getClienteEstado());
        sentencia.setInt(6, cliente.getClienteCodigo());
        return sentencia.executeUpdate();
    }

    public int eliminar(Cliente cliente) throws SQLException {
        String sentenciaSQL = "delete from Cliente where clienteCodigo=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, cliente.getClienteCodigo());
        return sentencia.executeUpdate();
    }

    public int obtenerUltimoCodigo() throws Exception {

        ResultSet resultado;
        String sentenciaSQL;
        int ultimoCodigo = 0;
        sentenciaSQL = "Select max(clientecodigo) as codigo FROM cliente ";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {

            ultimoCodigo = resultado.getInt("codigo");
        }
        resultado.close();
        return ultimoCodigo;

    }

    public List<Cliente> mostrarTodos(String estado) throws Exception {
        ResultSet resultado;
        String sentenciaSQL;
        List<Cliente> listaCliente = new ArrayList<>();
        Cliente cliente;
        sentenciaSQL = "SELECT clientecodigo, clientepaterno, clientematerno, clientenombre, clientedni, clienteestado	FROM cliente where clienteestado='"+estado+"'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            cliente = new Cliente();
            cliente.setClienteCodigo(resultado.getInt("clientecodigo"));
            cliente.setClientePaterno(resultado.getString("clientepaterno"));
            cliente.setClienteMaterno(resultado.getString("clientematerno"));
            cliente.setClienteNombre(resultado.getString("clientenombre"));
            cliente.setClienteDni(resultado.getString("clientedni"));
            cliente.setClienteEstado(resultado.getString("clienteestado"));

            listaCliente.add(cliente);
        }
        resultado.close();
        return listaCliente;
    }
}
