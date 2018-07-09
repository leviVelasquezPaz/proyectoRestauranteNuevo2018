/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa3_dominio;

import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio AB
 */
public class Producto {

    private int productoCodigo;
    private String productoNombre;
    private String productoDescripcion;
    private double productoPrecio;
    private int productoStock;
    private TipoProducto tipoDeProducto;
    private Date productoFechaRegistro;
    private String productoEstado;
    public static final String ESTADO_ACTIVO = "A";
    public static final String ESTADO_INACTIVO = "I";

    public Producto() {
        this.productoFechaRegistro = Date.valueOf(LocalDate.now());
    }

    public Producto(int productoCodigo, String productoNombre, String productoDescripcion, double productoPrecio, int productoStock, TipoProducto tipoDeProducto, Date productoFechaRegistro, String productoEstado) {
        this.productoCodigo = productoCodigo;
        this.productoNombre = productoNombre;
        this.productoDescripcion = productoDescripcion;
        this.productoPrecio = productoPrecio;
        this.productoStock = productoStock;
        this.tipoDeProducto = tipoDeProducto;
        this.productoFechaRegistro = productoFechaRegistro;
        this.productoEstado = productoEstado;
    }

    public int getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(int productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public String getProductoDescripcion() {
        return productoDescripcion;
    }

    public void setProductoDescripcion(String productoDescripcion) {
        this.productoDescripcion = productoDescripcion;
    }

    public double getProductoPrecio() {
        return productoPrecio;
    }

    public void setProductoPrecio(double productoPrecio) {
        this.productoPrecio = productoPrecio;
    }

    public int getProdcutoStock() {
        return productoStock;
    }

    public void setProdcutoStock(int prodcutoStock) {
        this.productoStock = prodcutoStock;
    }

    public TipoProducto getTipoDeProducto() {
        return tipoDeProducto;
    }

    public void setTipoDeProducto(TipoProducto tipoDeProducto) {
        this.tipoDeProducto = tipoDeProducto;
    }

    public Date getProductoFechaRegistro() {
        return productoFechaRegistro;
    }

    public void setProductoFechaRegistro(Date productoFechaRegistro) {
        this.productoFechaRegistro = productoFechaRegistro;
    }

    public String getProductoEstado() {
        return productoEstado;
    }

    public void setProductoEstado(String productoEstado) {
        this.productoEstado = productoEstado;
    }

    // Reglas del Negocio 
    public void restarStock(int cantidad) {
       
        productoStock = (productoStock - cantidad);
     
    }

    public void sumarStock(int cantidad) {
        productoStock = productoStock + cantidad;
    }

    public boolean stockDisponible(int cantidad) {
       

        return (productoStock >= cantidad);
    }

    @Override
    public String toString() {
        return "Producto{" + "productoCodigo=" + productoCodigo + ", productoNombre=" + productoNombre + ", productoDescripcion=" + productoDescripcion + ", productoPrecio=" + productoPrecio + ", productoStock=" + productoStock + ", tipoDeProducto=" + tipoDeProducto + ", productoFechaRegistro=" + productoFechaRegistro + ", productoEstado=" + productoEstado + '}';
    }

}
