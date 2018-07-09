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
import restaurant.capa3_dominio.TipoUsuario;

/**
 *
 * @author Antonio AB
 */
public class TipoUsuarioDAOPostgre {

    GestorJDBC gestorJDBC;

    public TipoUsuarioDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public List<TipoUsuario> buscarPorNombre(String nombre) throws SQLException {
        ArrayList<TipoUsuario> tipoUsuarios = new ArrayList();
        TipoUsuario tipoUsuario;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "select tipousuariocodigo, tipousuarionombre, tipousuariodescripcion, tipousuarioestado"
                + " from tipousuario where tipousuarionombre like '%" + nombre + "%' order by tipousuarionombre";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            tipoUsuario = new TipoUsuario();
            tipoUsuario.setTipoUsuarioCodigo(resultado.getInt("tipousuariocodigo"));
            tipoUsuario.setTipoUsuarioNombre(resultado.getString("tipousuarionombre"));
            tipoUsuario.setTipoUsuarioDescripcion(resultado.getString("tipousuariodescripcion"));
            tipoUsuario.setTipoUsuarioEstado(resultado.getString("tipousuarioestado"));

            tipoUsuarios.add(tipoUsuario);
        }
        resultado.close();
        return tipoUsuarios;
    }

    public TipoUsuario buscarPorCodigo(int tipoUsuarioCodigo) throws SQLException {
        TipoUsuario tipoUsuario = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT * FROM tipousuario where tipousuariocodigo= " + tipoUsuarioCodigo;

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            tipoUsuario = new TipoUsuario();
            tipoUsuario.setTipoUsuarioCodigo(resultado.getInt("tipousuariocodigo"));
            tipoUsuario.setTipoUsuarioNombre(resultado.getString("tipousuarionombre"));
            tipoUsuario.setTipoUsuarioDescripcion(resultado.getString("tipousuariodescripcion"));
            tipoUsuario.setTipoUsuarioEstado(resultado.getString("tipousuarioestado"));

        }
        resultado.close();
        return tipoUsuario;
    }

    public List<TipoUsuario> mostrar() throws SQLException {

        List<TipoUsuario> listaUsuarios = new ArrayList<>();
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "select tipousuariocodigo, tipousuarionombre, tipousuariodescripcion, tipousuarioestado from tipousuario where tipousuarioestado='A' order by tipousuariocodigo";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setTipoUsuarioCodigo(resultado.getInt("tipousuariocodigo"));
            tipoUsuario.setTipoUsuarioNombre(resultado.getString("tipousuarionombre"));
            tipoUsuario.setTipoUsuarioDescripcion(resultado.getString("tipousuariodescripcion"));
            tipoUsuario.setTipoUsuarioEstado(resultado.getString("tipousuarioestado"));
            listaUsuarios.add(tipoUsuario);
        }
        resultado.close();
        return listaUsuarios;
    }

    public int ingresar(TipoUsuario tipoUsuario) throws SQLException {
        String sentenciaSQL = "INSERT INTO tipousuario(tipousuariocodigo, tipousuarionombre, tipousuariodescripcion, tipousuarioestado)VALUES (?, ?, ?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, tipoUsuario.getTipoUsuarioCodigo());
        sentencia.setString(2, tipoUsuario.getTipoUsuarioNombre());
        sentencia.setString(3, tipoUsuario.getTipoUsuarioDescripcion());
        sentencia.setString(4, tipoUsuario.getTipoUsuarioEstado());
        return sentencia.executeUpdate();
    }

    public int modificar(TipoUsuario tipoUsuario) throws SQLException {
        String sentenciaSQL = "update tipousuario set tipousuarionombre = ?, tipousuariodescripcion = ?, tipousuarioestado = ? "
                + "where tipousuariocodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, tipoUsuario.getTipoUsuarioNombre());
        sentencia.setString(2, tipoUsuario.getTipoUsuarioDescripcion());
        sentencia.setString(3, tipoUsuario.getTipoUsuarioEstado());
        sentencia.setInt(4, tipoUsuario.getTipoUsuarioCodigo());
        return sentencia.executeUpdate();
    }

    public int eliminar(TipoUsuario tipoUsuario) throws SQLException {
        String sentenciaSQL = "delete from tipousuario where tipousuariocodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, tipoUsuario.getTipoUsuarioCodigo());
        return sentencia.executeUpdate();
    }

    public int obtenerUltimoCodigo() throws Exception {
        ResultSet resultado;
        String sentenciaSQL;
        int ultimoCodigo = 0;
        sentenciaSQL = "Select max(tipousuariocodigo) as codigo FROM tipousuario ";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {

            ultimoCodigo = resultado.getInt("codigo");
        }
        resultado.close();
        return ultimoCodigo;
    }

}
