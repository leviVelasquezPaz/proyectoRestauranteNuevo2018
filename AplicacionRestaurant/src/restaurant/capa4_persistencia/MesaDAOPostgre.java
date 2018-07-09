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
import restaurant.capa3_dominio.Mesa;
import restaurant.capa3_dominio.Usuario;

/**
 *
 * @author Antonio AB
 */
public class MesaDAOPostgre {

    GestorJDBC gestorJDBC;

    public MesaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public Mesa buscarPorNumero(int numero) throws SQLException {

        Mesa mesa = null;
        ResultSet resultado;
        String sentenciaSQL;
        sentenciaSQL = "SELECT mesacodigo, mesacapacidad, mesanumero, mesapiso, mesaestado from mesa where mesanumero=" + numero + " ";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            mesa = new Mesa();
            mesa.setMesaCodigo(resultado.getInt("mesacodigo"));
            mesa.setMesaCapacidad(resultado.getInt("mesacapacidad"));
            mesa.setMesaNumero(resultado.getInt("mesanumero"));
            mesa.setMesaPiso(resultado.getInt("mesapiso"));
            mesa.setMesaEstado(resultado.getString("mesaestado"));
        }
        resultado.close();
        return mesa;
    }

    public Mesa buscarCodigo(int mesaCodigo) throws SQLException {
        Mesa mesa = null;
        ResultSet resultado;
        String sentenciaSQL;
        sentenciaSQL = "SELECT mesacodigo, mesacapacidad, mesanumero, mesapiso, mesaestado FROM mesa where  mesacodigo='" + mesaCodigo + "' ";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            mesa = new Mesa();
            mesa.setMesaCodigo(resultado.getInt("mesacodigo"));
            mesa.setMesaCapacidad(resultado.getInt("mesacapacidad"));
            mesa.setMesaNumero(resultado.getInt("mesanumero"));
            mesa.setMesaPiso(resultado.getInt("mesapiso"));
            mesa.setMesaEstado(resultado.getString("mesaestado"));
        }
        resultado.close();
        return mesa;
    }

    public int ingresar(Mesa mesa) throws SQLException {
        String sentenciaSQL = "INSERT INTO mesa(mesacodigo, mesacapacidad, mesanumero, mesapiso, mesaestado)VALUES (?, ?, ?, ?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, mesa.getMesaCodigo());
        sentencia.setInt(2, mesa.getMesaCapacidad());
        sentencia.setInt(3, mesa.getMesaNumero());
        sentencia.setInt(4, mesa.getMesaPiso());
        sentencia.setString(5, mesa.getMesaEstado());
        return sentencia.executeUpdate();
    }

    public int modificar(Mesa mesa) throws SQLException {
        String sentenciaSQL = "UPDATE mesa SET mesacapacidad=?, mesanumero=?, mesapiso=?, mesaestado=? WHERE mesacodigo=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, mesa.getMesaCapacidad());
        sentencia.setInt(2, mesa.getMesaNumero());
        sentencia.setInt(3, mesa.getMesaPiso());
        sentencia.setString(4, mesa.getMesaEstado());
        sentencia.setInt(5, mesa.getMesaCodigo());
        return sentencia.executeUpdate();
    }

    public int eliminar(Mesa mesa) throws SQLException {
        String sentenciaSQL = "delete from mesa where mesaCodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, mesa.getMesaCodigo());
        return sentencia.executeUpdate();
    }

    public int obtenerUltimoCodigo() throws Exception {

        ResultSet resultado;
        String sentenciaSQL;
        int ultimoCodigo = 0;
        sentenciaSQL = "Select max(mesacodigo) as codigo FROM mesa";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {

            ultimoCodigo = resultado.getInt("codigo");
        }
        resultado.close();
        return ultimoCodigo;
    }

    public List<Mesa> mostrarTodosLasMesas() throws Exception {
        List<Mesa> listaMesas = new ArrayList<>();
        Mesa mesa = null;
        ResultSet resultado;
        String sentenciaSQL;
        sentenciaSQL = "SELECT mesacodigo, mesacapacidad, mesanumero, mesapiso, mesaestado FROM  mesa order by mesacodigo";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            mesa = new Mesa();
            mesa.setMesaCodigo(resultado.getInt("mesacodigo"));
            mesa.setMesaCapacidad(resultado.getInt("mesacapacidad"));
            mesa.setMesaNumero(resultado.getInt("mesanumero"));
            mesa.setMesaPiso(resultado.getInt("mesapiso"));
            mesa.setMesaEstado(resultado.getString("mesaestado"));
            listaMesas.add(mesa);

        }
        resultado.close();
        return listaMesas;
    }

}
