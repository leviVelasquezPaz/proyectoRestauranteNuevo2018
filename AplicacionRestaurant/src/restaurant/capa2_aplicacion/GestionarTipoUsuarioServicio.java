/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa2_aplicacion;

import java.util.List;
import restaurant.capa3_dominio.TipoUsuario;
import restaurant.capa4_persistencia.GestorJDBC;
import restaurant.capa4_persistencia.GestorJDBCPostgre;
import restaurant.capa4_persistencia.TipoUsuarioDAOPostgre;

/**
 *
 * @author Antonio AB
 */
public class GestionarTipoUsuarioServicio {

    private GestorJDBC gestorJDBC;
    private TipoUsuarioDAOPostgre tipoUsuarioDAO;

    public GestionarTipoUsuarioServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        tipoUsuarioDAO = new TipoUsuarioDAOPostgre(gestorJDBC);
    }

    public List<TipoUsuario> buscarTiposDeUsuarios(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<TipoUsuario> tipoUsuarios = tipoUsuarioDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return tipoUsuarios;
    }

    public TipoUsuario buscarPorCodigo(int tipoUsuarioCodigo) throws Exception {
        gestorJDBC.abrirConexion();
        TipoUsuario tipoUsuario = tipoUsuarioDAO.buscarPorCodigo(tipoUsuarioCodigo);
        gestorJDBC.cerrarConexion();
        return tipoUsuario;
    }

    public int crearTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = tipoUsuarioDAO.ingresar(tipoUsuario);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int modificarTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = tipoUsuarioDAO.modificar(tipoUsuario);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int eliminarTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = tipoUsuarioDAO.eliminar(tipoUsuario);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int obtenerUltimoCodigo() throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = tipoUsuarioDAO.obtenerUltimoCodigo();
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

    public List<TipoUsuario> mostrarTipoUsuarios() throws Exception {
        gestorJDBC.abrirConexion();
        List<TipoUsuario> listaTipoUsuario = tipoUsuarioDAO.mostrar();
        gestorJDBC.cerrarConexion();
        return listaTipoUsuario;
    }

    public List<TipoUsuario> buscarPorNombre(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<TipoUsuario> listaTipoUsuario = tipoUsuarioDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaTipoUsuario;
    }
}
