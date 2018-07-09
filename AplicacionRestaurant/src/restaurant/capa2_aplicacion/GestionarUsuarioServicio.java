/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa2_aplicacion;

import java.util.List;
import javax.swing.JOptionPane;
import restaurant.capa3_dominio.TipoUsuario;
import restaurant.capa3_dominio.Usuario;
import restaurant.capa4_persistencia.GestorJDBC;
import restaurant.capa4_persistencia.GestorJDBCPostgre;
import restaurant.capa4_persistencia.TipoUsuarioDAOPostgre;
import restaurant.capa4_persistencia.UsuarioDAOPostgre;

/**
 *
 * @author Antonio AB
 */
public class GestionarUsuarioServicio {

    private GestorJDBC gestorJDBC;
    private UsuarioDAOPostgre usuarioDAOPostgre;
    private TipoUsuarioDAOPostgre tipoUsuarioDAOPostgre;

    public GestionarUsuarioServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        usuarioDAOPostgre = new UsuarioDAOPostgre(gestorJDBC);
        tipoUsuarioDAOPostgre = new TipoUsuarioDAOPostgre(gestorJDBC);
    }

    public int guardarUsuario(Usuario usuario) throws Exception {
        gestorJDBC.abrirConexion();
        int numerosAfecatdos = usuarioDAOPostgre.ingresar(usuario);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;

    }

    public int obtenerUltimoCodigo() throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = usuarioDAOPostgre.obtenerUltimoCodigo();
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

    public int modificarUsuario(Usuario usuario) throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = usuarioDAOPostgre.modificar(usuario);
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

    public List<Usuario> mostrarUsuarios() {
        List<Usuario> listaProducto = null;
        try {
            gestorJDBC.abrirConexion();
            listaProducto = usuarioDAOPostgre.mostrarTodos();
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listaProducto;

    }

    public Usuario buscarUsuarioPorCodigo(int codigo) throws Exception {
        Usuario usuario = null;
        try {
            gestorJDBC.abrirConexion();
            usuario = usuarioDAOPostgre.buscarCodigo(codigo);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
        }

        return usuario;

    }

    public int eliminarUsuario(Usuario usuario) throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = usuarioDAOPostgre.eliminar(usuario);
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

    public List<TipoUsuario> mostrarTiposUsuarios() throws Exception {
        List<TipoUsuario> listaTipoUsuario = null;
        gestorJDBC.abrirConexion();;
        listaTipoUsuario = tipoUsuarioDAOPostgre.mostrar();
        gestorJDBC.cerrarConexion();
        return listaTipoUsuario;
    }

    public Usuario verificarUsuario(String dni, String password) throws Exception {
        Usuario usuario1;
        gestorJDBC.abrirConexion();
        usuario1 = usuarioDAOPostgre.verificarUsuario(dni, password);
        gestorJDBC.cerrarConexion();
        return usuario1;
    }

}
