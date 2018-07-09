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
import restaurant.capa2_aplicacion.GestionarTipoUsuarioServicio;
import restaurant.capa3_dominio.TipoUsuario;
import restaurant.capa3_dominio.Usuario;

/**
 *
 * @author Antonio AB
 */
public class UsuarioDAOPostgre {

    GestorJDBC gestorJDBC;

    public UsuarioDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public List<Usuario> buscarNombre(String nombre) throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        Usuario usuario;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT usuariosexo, usuariopaterno, usuarionombre, usuariomaterno, usuariodni, usuariopassword, usuariocodigo, usuarioestado"
                + "	FROM usuario where usuarionombre like '%" + nombre + "%' order by usuarionombre";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            usuario = new Usuario();
            usuario.setUsuarioCodigo(resultado.getInt("usuariocodigo"));
            usuario.setUsuarioPaterno(resultado.getString("usuariopaterno"));
            usuario.setUsuarioMaterno(resultado.getString("usuariomaterno"));
            usuario.setUsuarioNombre(resultado.getString("usuarionombre"));
            usuario.setUsuarioSexo(resultado.getString("usuariosexo"));
            usuario.setUsuarioPassword(resultado.getString("usuariopassword"));
            usuario.setUsuarioDni(resultado.getString("usuariodni"));
            usuario.setUsuarioEstado(resultado.getString("usuarioestado"));
            listaUsuarios.add(usuario);
        }
        resultado.close();
        return listaUsuarios;
    }

    public Usuario buscarCodigo(int usuarioId) throws SQLException {
        Usuario usuario = null;
        ResultSet resultadoUsuario, resultadoTipoUsuario;
        String sentenciaSQL;
        TipoUsuario tipoUsuario;
        sentenciaSQL = "SELECT usuariocodigo,tipousuariocodigo,usuarionombre,usuariopaterno,usuariomaterno,usuariodni,usuariosexo,usuariopassword,usuarioestado from usuario  where usuariocodigo='" + usuarioId + "'";

        resultadoUsuario = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        GestionarTipoUsuarioServicio gestionarTipoUsuarioServicio;
        if (resultadoUsuario.next()) {
            gestionarTipoUsuarioServicio = new GestionarTipoUsuarioServicio();
            usuario = new Usuario();
            tipoUsuario = new TipoUsuario();
            usuario.setUsuarioCodigo(resultadoUsuario.getInt("usuariocodigo"));
            usuario.setUsuarioNombre(resultadoUsuario.getString("usuarionombre"));
            usuario.setUsuarioMaterno(resultadoUsuario.getString("usuariomaterno"));
            usuario.setUsuarioPaterno(resultadoUsuario.getString("usuariopaterno"));
            usuario.setUsuarioDni(resultadoUsuario.getString("usuariodni"));
            usuario.setUsuarioSexo(resultadoUsuario.getString("usuariosexo"));
            usuario.setUsuarioPassword(resultadoUsuario.getString("usuariopassword"));
            usuario.setUsuarioEstado(resultadoUsuario.getString("usuarioestado"));
            int codigoTipoUsuario = resultadoUsuario.getInt("tipousuariocodigo");
            try {
                tipoUsuario = gestionarTipoUsuarioServicio.buscarPorCodigo(codigoTipoUsuario);

            } catch (Exception e) {
            }

            usuario.setTipoUsuario(tipoUsuario);
        }
        resultadoUsuario.close();
        return usuario;
    }

    public Usuario buscarPorDNI(String dni) throws Exception {
        Usuario usuario = null;

        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT usuariopaterno, usuariomaterno, usuarionombre,usuariosexo, usuariodni, usuariopassword, usuariocodigo, usuarioestado FROM usuario where usuariodni= '" + dni + "'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            usuario = new Usuario();
            usuario.setUsuarioCodigo(resultado.getInt("usuariocodigo"));
            usuario.setUsuarioPaterno(resultado.getString("usuariopaterno"));
            usuario.setUsuarioMaterno(resultado.getString("usuariomaterno"));
            usuario.setUsuarioNombre(resultado.getString("usuarionombre"));
            usuario.setUsuarioPassword(resultado.getString("usuariopassword"));
            usuario.setUsuarioSexo(resultado.getString("usuariosexo"));
            usuario.setUsuarioDni(resultado.getString("usuariodni"));
            usuario.setUsuarioEstado(resultado.getString("usuarioestado"));
        }
        resultado.close();

        return usuario;
    }

    public int ingresar(Usuario usuario) throws SQLException {
        String sentenciaSQL = "INSERT INTO usuario (usuariocodigo,usuariopaterno, usuariomaterno, usuarionombre, usuariodni,usuariosexo, usuariopassword,usuarioestado ,tipousuariocodigo) VALUES (?, ?, ?, ?, ?, ?, ?,?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, usuario.getUsuarioCodigo());
        sentencia.setString(2, usuario.getUsuarioPaterno());
        sentencia.setString(3, usuario.getUsuarioMaterno());
        sentencia.setString(4, usuario.getUsuarioNombre());
        sentencia.setString(5, usuario.getUsuarioDni());
        sentencia.setString(6, usuario.getUsuarioSexo());
        sentencia.setString(7, usuario.getUsuarioPassword());
        sentencia.setString(8, usuario.getUsuarioEstado());
        sentencia.setInt(9, usuario.getTipoUsuario().getTipoUsuarioCodigo());
        return sentencia.executeUpdate();
    }

    public int modificar(Usuario usuario) throws SQLException {
        String sentenciaSQL = "UPDATE usuario SET usuariopaterno=?, usuariomaterno=?, usuarionombre=?, usuariodni=?, usuariosexo=?, usuariopassword=?, usuarioestado=?,tipousuariocodigo=? WHERE usuariocodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);

        sentencia.setString(1, usuario.getUsuarioPaterno());
        sentencia.setString(2, usuario.getUsuarioMaterno());
        sentencia.setString(3, usuario.getUsuarioNombre());
        sentencia.setString(4, usuario.getUsuarioDni());
        sentencia.setString(5, usuario.getUsuarioSexo());
        sentencia.setString(6, usuario.getUsuarioPassword());
        sentencia.setString(7, usuario.getUsuarioEstado());
        sentencia.setInt(8, usuario.getTipoUsuario().getTipoUsuarioCodigo());
        sentencia.setInt(9, usuario.getUsuarioCodigo());
        return sentencia.executeUpdate();
    }

    public int eliminar(Usuario usuario) throws SQLException {
        String sentenciaSQL = "delete from usuario where usuariocodigo= ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, usuario.getUsuarioCodigo());
        return sentencia.executeUpdate();
    }

    public int obtenerUltimoCodigo() throws Exception {
        ResultSet resultado;
        String sentenciaSQL;
        int ultimoCodigo = 0;
        sentenciaSQL = "Select max(usuariocodigo) as codigo FROM usuario ";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            ultimoCodigo = resultado.getInt("codigo");
        }
        resultado.close();
        return ultimoCodigo;

    }

    public List<Usuario> mostrarTodos() throws Exception {
        ResultSet resultado;
        String sentenciaSQL;
        List<Usuario> listaUsuario = new ArrayList<>();
        Usuario usuario;
        sentenciaSQL = "SELECT usuariocodigo,usuarionombre,usuariopaterno,usuariomaterno,usuariodni,usuariosexo,usuariopassword,usuarioestado from usuario where usuarioestado='A' order by usuariocodigo ";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            usuario = new Usuario();
            usuario.setUsuarioCodigo(resultado.getInt("usuariocodigo"));
            usuario.setUsuarioNombre(resultado.getString("usuarionombre"));
            usuario.setUsuarioPaterno(resultado.getString("usuariomaterno"));
            usuario.setUsuarioMaterno(resultado.getString("usuariomaterno"));
            usuario.setUsuarioDni(resultado.getString("usuariodni"));
            usuario.setUsuarioSexo(resultado.getString("usuariosexo"));
            usuario.setUsuarioPassword(resultado.getString("usuariopassword"));
            usuario.setUsuarioEstado(resultado.getString("usuarioestado"));

            listaUsuario.add(usuario);
        }
        resultado.close();
        return listaUsuario;
    }

    public Usuario verificarUsuario(String dni, String password) throws Exception {
        Usuario usuario = null;
        ResultSet resultado;
        TipoUsuario tipoUsuario;
        String sentenciaSQL;
        GestionarTipoUsuarioServicio gestionarTipoUsuarioServicio;

        sentenciaSQL = "Select *from usuario where usuariopassword='" + password + "' and usuariodni='" + dni + "' ";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            gestionarTipoUsuarioServicio = new GestionarTipoUsuarioServicio();
            usuario = new Usuario();
            tipoUsuario = new TipoUsuario();
            usuario.setUsuarioCodigo(resultado.getInt("usuariocodigo"));
            usuario.setUsuarioNombre(resultado.getString("usuarionombre"));
            usuario.setUsuarioPaterno(resultado.getString("usuariomaterno"));
            usuario.setUsuarioMaterno(resultado.getString("usuariomaterno"));
            usuario.setUsuarioDni(resultado.getString("usuariodni"));
            usuario.setUsuarioSexo(resultado.getString("usuariosexo"));
            usuario.setUsuarioPassword(resultado.getString("usuariopassword"));
            usuario.setUsuarioEstado(resultado.getString("usuarioestado"));
            tipoUsuario = gestionarTipoUsuarioServicio.buscarPorCodigo(resultado.getInt("tipousuariocodigo"));
            usuario.setTipoUsuario(tipoUsuario);
        }
        resultado.close();
        return usuario;
    }

}
