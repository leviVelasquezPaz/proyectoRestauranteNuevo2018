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
import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;

/**
 *
 * @author Antonio AB
 */
public class ProductoDAOPostgre {

    GestorJDBC gestorJDBC;

    public ProductoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public int guardar(Producto producto) throws SQLException {
        String sentenciaSQL = "INSERT INTO producto(productocodigo, productonombre, productodescripcion, productoprecio, productostock, productofecharegistro, tipoproductocodigo, productoestado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, producto.getProductoCodigo());
        sentencia.setString(2, producto.getProductoNombre());
        sentencia.setString(3, producto.getProductoDescripcion());
        sentencia.setDouble(4, producto.getProductoPrecio());
        sentencia.setInt(5, producto.getProdcutoStock());
        sentencia.setDate(6, producto.getProductoFechaRegistro());
        sentencia.setInt(7, producto.getTipoDeProducto().getTipoProductoCodigo());
        sentencia.setString(8, producto.getProductoEstado());

        return sentencia.executeUpdate();
    }

    public Producto buscar(int productoCodigo) throws SQLException {
        Producto producto = null;
        ResultSet resultado;
        String sentenciaSQL;
        sentenciaSQL = "Select productocodigo, productonombre, productodescripcion, productoprecio, productostock, productofecharegistro, tipoproductocodigo, productoestado FROM producto where productocodigo='" + productoCodigo + "'";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            producto = new Producto();
            producto.setProductoCodigo(resultado.getInt("productocodigo"));
            producto.setProductoNombre(resultado.getString("productonombre"));
            producto.setProductoDescripcion(resultado.getString("productodescripcion"));
            producto.setProductoPrecio(resultado.getDouble("productoprecio"));
            producto.setProdcutoStock(resultado.getInt("productostock"));
            TipoProductoDAOPostgre tipoProductoDAOPostgre = new TipoProductoDAOPostgre(gestorJDBC);
            TipoProducto tipoProducto = tipoProductoDAOPostgre.buscarPorCodigo(resultado.getInt("tipoproductocodigo"));
            producto.setTipoDeProducto(tipoProducto);
            producto.setProductoEstado(resultado.getString("productoestado"));

        }
        resultado.close();
        return producto;
    }

    public List<Producto> buscarPorNombre(String nombre) throws SQLException {
        Producto producto = null;
        ResultSet resultado;
        String sentenciaSQL;
        List<Producto> ListaProducto = new ArrayList<>();
        sentenciaSQL = "Select productocodigo, productonombre, productodescripcion, productoprecio, productostock, productofecharegistro, tipoproductocodigo, productoestado FROM producto where productonombre like '%" + nombre + "%' order by productocodigo";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            producto = new Producto();
            producto.setProductoCodigo(resultado.getInt("productocodigo"));
            producto.setProductoNombre(resultado.getString("productonombre"));
            producto.setProductoDescripcion(resultado.getString("productodescripcion"));
            producto.setProductoPrecio(resultado.getDouble("productoprecio"));
            producto.setProdcutoStock(resultado.getInt("productostock"));
            TipoProductoDAOPostgre tipoProductoDAOPostgre = new TipoProductoDAOPostgre(gestorJDBC);
            TipoProducto tipoProducto = tipoProductoDAOPostgre.buscarPorCodigo(resultado.getInt("tipoproductocodigo"));
            producto.setTipoDeProducto(tipoProducto);
            producto.setProductoEstado(resultado.getString("productoestado"));
            ListaProducto.add(producto);

        }
        resultado.close();
        return ListaProducto;
    }

    public int obtenerUltimoCodigo() throws Exception {
        Producto producto = null;
        ResultSet resultado;
        String sentenciaSQL;
        int ultimoCodigo = 0;
        sentenciaSQL = "Select max(productocodigo) as codigo FROM producto ";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {

            ultimoCodigo = resultado.getInt("codigo");
        }
        resultado.close();
        return ultimoCodigo;
    }

    public List<Producto> mostrarPorTipo(int tipoProductoCodigo) throws SQLException {

        ResultSet resultado;
        String sentenciaSQL;
        List<Producto> listaProducto = new ArrayList<>();
        sentenciaSQL = "Select  p.productocodigo, p.productonombre, p.productodescripcion, p.productoprecio, p.productostock, p.productofecharegistro, p.tipoproductocodigo, p.productoestado FROM producto p inner join tipoproducto tp  on p.tipoproductocodigo=tp.tipoproductocodigo where tp.tipoproductocodigo='" + tipoProductoCodigo + "' order by p.productocodigo";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            Producto producto = new Producto();
            producto.setProductoCodigo(resultado.getInt("productocodigo"));
            producto.setProductoNombre(resultado.getString("productonombre"));
            producto.setProductoDescripcion(resultado.getString("productodescripcion"));
            producto.setProductoPrecio(resultado.getDouble("productoprecio"));
            producto.setProdcutoStock(resultado.getInt("productostock"));
            producto.setProductoFechaRegistro(resultado.getDate("productofecharegistro"));
            TipoProductoDAOPostgre tipoProductoDAOPostgre = new TipoProductoDAOPostgre(gestorJDBC);
            TipoProducto tipoProducto = tipoProductoDAOPostgre.buscarPorCodigo(resultado.getInt("tipoproductocodigo"));
            producto.setTipoDeProducto(tipoProducto);
            producto.setProductoEstado(resultado.getString("productoestado"));
            listaProducto.add(producto);
        }

        resultado.close();
        return listaProducto;
    }

    public List<Producto> mostrarTodos() throws SQLException {

        ResultSet resultado;
        String sentenciaSQL;
        List<Producto> listaProducto = new ArrayList<>();
        sentenciaSQL = "Select  p.productocodigo, p.productonombre, p.productodescripcion, p.productoprecio, p.productostock, p.productofecharegistro, p.tipoproductocodigo, p.productoestado FROM producto p inner join tipoproducto tp  on p.tipoproductocodigo=tp.tipoproductocodigo where p.productoestado='A' order by p.productocodigo";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            Producto producto = new Producto();
            producto.setProductoCodigo(resultado.getInt("productocodigo"));
            producto.setProductoNombre(resultado.getString("productonombre"));
            producto.setProductoDescripcion(resultado.getString("productodescripcion"));
            producto.setProductoPrecio(resultado.getDouble("productoprecio"));
            producto.setProdcutoStock(resultado.getInt("productostock"));
            producto.setProductoFechaRegistro(resultado.getDate("productofecharegistro"));
            TipoProductoDAOPostgre tipoProductoDAOPostgre = new TipoProductoDAOPostgre(gestorJDBC);
            TipoProducto tipoProducto = tipoProductoDAOPostgre.buscarPorCodigo(resultado.getInt("tipoproductocodigo"));
            producto.setTipoDeProducto(tipoProducto);
            producto.setProductoEstado(resultado.getString("productoestado"));
            listaProducto.add(producto);
        }
        resultado.close();
        return listaProducto;
    }

    public int actualizarStock(Producto producto) throws Exception {
        String sentenciaSQL = "UPDATE producto SET productostock=? WHERE productocodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setDouble(1, producto.getProdcutoStock());
        sentencia.setInt(2, producto.getProductoCodigo());
        return sentencia.executeUpdate();
    }

    public int modificar(Producto producto) throws SQLException {
        System.out.println(producto.toString());
        String sentenciaSQL = "UPDATE producto SET productonombre=?, productodescripcion=?, productoprecio=?, productostock=?, productofecharegistro=?, tipoproductocodigo=?, productoestado=? WHERE productocodigo=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, producto.getProductoNombre());
        sentencia.setString(2, producto.getProductoDescripcion());
        sentencia.setDouble(3, producto.getProductoPrecio());
        sentencia.setInt(4, producto.getProdcutoStock());
        sentencia.setDate(5, producto.getProductoFechaRegistro());
        sentencia.setInt(6, producto.getTipoDeProducto().getTipoProductoCodigo());
        sentencia.setString(7, producto.getProductoEstado());
        sentencia.setInt(8, producto.getProductoCodigo());
        return sentencia.executeUpdate();
    }

    public int eliminar(Producto producto) throws Exception {
        System.out.println(producto.toString());
        String sentenciaSQL = "DELETE FROM producto WHERE productocodigo=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, producto.getProductoCodigo());
        return sentencia.executeUpdate();

    }

    

}
