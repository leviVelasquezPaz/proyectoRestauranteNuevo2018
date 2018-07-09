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
import restaurant.capa3_dominio.TipoProducto;

/**
 *
 * @author Antonio AB
 */
public class TipoProductoDAOPostgre {

    GestorJDBC gestorJDBC;

    public TipoProductoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public List<TipoProducto> buscarPorNombre(String nombre) throws SQLException {
        ArrayList<TipoProducto> tipoProductos = new ArrayList();
        TipoProducto tipoProducto;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "select tipoproductocodigo, tipoproductonombre, tipoproductodescripcion, tipoproductoestado"
                + " from tipoproducto where tipoproductonombre like '%" + nombre + "%' order by tipoproductonombre";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            tipoProducto = new TipoProducto();
            tipoProducto.setTipoProductoCodigo(resultado.getInt("tipoproductocodigo"));
            tipoProducto.setTipoProductoNombre(resultado.getString("tipoproductonombre"));
            tipoProducto.setTipoProductoDescripcion(resultado.getString("tipoproductodescripcion"));
            tipoProducto.setTipoProductoEstado(resultado.getString("tipoproductoestado"));

            tipoProductos.add(tipoProducto);
        }
        resultado.close();
        return tipoProductos;
    }

    public TipoProducto buscarPorCodigo(int tipoProductoCodigo) throws SQLException {
        TipoProducto tipoProducto = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT * FROM tipoproducto where tipoproductocodigo= " + tipoProductoCodigo;

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            tipoProducto = new TipoProducto();
            tipoProducto.setTipoProductoCodigo(resultado.getInt("tipoproductocodigo"));
            tipoProducto.setTipoProductoNombre(resultado.getString("tipoproductonombre"));
            tipoProducto.setTipoProductoDescripcion(resultado.getString("tipoproductodescripcion"));
            tipoProducto.setTipoProductoEstado(resultado.getString("tipoproductoestado"));

        }
        resultado.close();
        return tipoProducto;
    }

    public List<TipoProducto> mostrar() throws SQLException {

        List<TipoProducto> listaProductos = new ArrayList<>();
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "select tipoproductocodigo, tipoproductonombre, tipoproductodescripcion, tipoproductoestado from tipoproducto where tipoproductoestado='A' order by tipoproductocodigo";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            TipoProducto tipoProducto = new TipoProducto();
            tipoProducto.setTipoProductoCodigo(resultado.getInt("tipoproductocodigo"));
            tipoProducto.setTipoProductoNombre(resultado.getString("tipoproductonombre"));
            tipoProducto.setTipoProductoDescripcion(resultado.getString("tipoproductodescripcion"));
            tipoProducto.setTipoProductoEstado(resultado.getString("tipoproductoestado"));
            listaProductos.add(tipoProducto);
        }
        resultado.close();
        return listaProductos;
    }

    public int ingresar(TipoProducto tipoProducto) throws SQLException {
        String sentenciaSQL = "INSERT INTO tipoproducto(tipoproductocodigo, tipoproductonombre, tipoproductodescripcion, tipoproductoestado)VALUES (?, ?, ?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, tipoProducto.getTipoProductoCodigo());
        sentencia.setString(2, tipoProducto.getTipoProductoNombre());
        sentencia.setString(3, tipoProducto.getTipoProductoDescripcion());
        sentencia.setString(4, tipoProducto.getTipoProductoEstado());
        return sentencia.executeUpdate();
    }

    public int modificar(TipoProducto tipoProducto) throws SQLException {
        String sentenciaSQL = "update tipoproducto set tipoproductonombre = ?, tipoproductodescripcion = ?, tipoproductoestado = ? "
                + "where tipoproductocodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, tipoProducto.getTipoProductoNombre());
        sentencia.setString(2, tipoProducto.getTipoProductoDescripcion());
        sentencia.setString(3, tipoProducto.getTipoProductoEstado());
        sentencia.setInt(4, tipoProducto.getTipoProductoCodigo());
        return sentencia.executeUpdate();
    }

    public int eliminar(TipoProducto tipoProducto) throws SQLException {
        String sentenciaSQL = "delete from tipoproducto where tipoproductocodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, tipoProducto.getTipoProductoCodigo());
        return sentencia.executeUpdate();
    }

    public int obtenerUltimoCodigo() throws Exception {
        ResultSet resultado;
        String sentenciaSQL;
        int ultimoCodigo = 0;
        sentenciaSQL = "Select max(tipoproductocodigo) as codigo FROM tipoproducto ";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {

            ultimoCodigo = resultado.getInt("codigo");
        }
        resultado.close();
        return ultimoCodigo;
    }

}
