/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa2_aplicacion;

import java.util.List;
import javax.swing.JOptionPane;
import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;
import restaurant.capa4_persistencia.GestorJDBC;
import restaurant.capa4_persistencia.GestorJDBCPostgre;
import restaurant.capa4_persistencia.ProductoDAOPostgre;
import restaurant.capa4_persistencia.TipoProductoDAOPostgre;

/**
 *
 * @author levi
 */
public class GestionarProductoServicio {

    private GestorJDBC gestorJDBC;
    private ProductoDAOPostgre productoDAOPostgre;
    private TipoProductoDAOPostgre tipoProductoDAOPostgre;

    public GestionarProductoServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        productoDAOPostgre = new ProductoDAOPostgre(gestorJDBC);
        tipoProductoDAOPostgre = new TipoProductoDAOPostgre(gestorJDBC);
    }

    public int guardarProducto(Producto producto) throws Exception {
        gestorJDBC.abrirConexion();
        int numerosAfecatdos = productoDAOPostgre.guardar(producto);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public int modificarProducto(Producto producto) throws Exception {
        gestorJDBC.abrirConexion();
        int numerosAfecatdos = productoDAOPostgre.modificar(producto);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
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

    public Producto buscarProductoCodigo(int productoCodigo) throws Exception {
        gestorJDBC.abrirConexion();
        Producto producto = productoDAOPostgre.buscar(productoCodigo);
        gestorJDBC.cerrarConexion();
        return producto;
    }

    public List<Producto> buscarProductoPorNombre(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<Producto> listaProducto = productoDAOPostgre.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaProducto;
    }

    public List<TipoProducto> mostrarTiposProductos() throws Exception {
        List<TipoProducto> listaTipoProducto;
        gestorJDBC.abrirConexion();
        listaTipoProducto = tipoProductoDAOPostgre.mostrar();
        gestorJDBC.cerrarConexion();
        return listaTipoProducto;
    }

    public int obtenerUltimoCodigo() throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = productoDAOPostgre.obtenerUltimoCodigo();
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

    public int eliminarProducto(Producto producto) throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = productoDAOPostgre.eliminar(producto);
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;

    }

    public List<Producto> mostrarPorTipoProducto(int codigo) throws Exception {
        List<Producto> listaProductos = null;
        gestorJDBC.abrirConexion();
        listaProductos = productoDAOPostgre.mostrarPorTipo(codigo);
        gestorJDBC.cerrarConexion();
        return listaProductos;
    }

}
