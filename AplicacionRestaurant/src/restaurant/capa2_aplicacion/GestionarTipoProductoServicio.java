/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa2_aplicacion;

import java.util.List;
import restaurant.capa3_dominio.TipoProducto;
import restaurant.capa4_persistencia.GestorJDBC;
import restaurant.capa4_persistencia.GestorJDBCPostgre;
import restaurant.capa4_persistencia.TipoProductoDAOPostgre;

/**
 *
 * @author Antonio AB
 */
public class GestionarTipoProductoServicio {

    private GestorJDBC gestorJDBC;
    private TipoProductoDAOPostgre tipoProductoDAO;

    public GestionarTipoProductoServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        tipoProductoDAO = new TipoProductoDAOPostgre(gestorJDBC);
    }

    public List<TipoProducto> buscarTiposDeProductos(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<TipoProducto> tipoProductos = tipoProductoDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return tipoProductos;
    }

    public TipoProducto buscarPorCodigo(int tipoProductoCodigo) throws Exception {
        gestorJDBC.abrirConexion();
        TipoProducto tipoProducto = tipoProductoDAO.buscarPorCodigo(tipoProductoCodigo);
        gestorJDBC.cerrarConexion();
        return tipoProducto;
    }

    public int crearTipoProducto(TipoProducto tipoProducto) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = tipoProductoDAO.ingresar(tipoProducto);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int modificarTipoProducto(TipoProducto tipoProducto) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = tipoProductoDAO.modificar(tipoProducto);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int eliminarTipoProducto(TipoProducto tipoProducto) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = tipoProductoDAO.eliminar(tipoProducto);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int obtenerUltimoCodigo() throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = tipoProductoDAO.obtenerUltimoCodigo();
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

    public List<TipoProducto> mostrarTipoProductos() throws Exception {
        gestorJDBC.abrirConexion();
        List<TipoProducto> listaTipoProducto = tipoProductoDAO.mostrar();
        gestorJDBC.cerrarConexion();
        return listaTipoProducto;
    }

    public List<TipoProducto> buscarPorNombre(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<TipoProducto> listaTipoProducto = tipoProductoDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaTipoProducto;
    }
}
