/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa3_dominio;

import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio AB
 */
public class Pedido {
    
    private int pedidoCodigo;
    private Double importe;
    private Usuario usuario;
    private Mesa mesa;
    private Cliente cliente;
    private Date pedidoFecha;
    private String pedidoEstado;
    
    private List<LineaPedido> listaLineaPedido;
    public static final String ESTADO_ACTIVO = "A";
    public static final String ESTADO_INACTIVO = "I";
    private IDescuento estrategiaDescuento;
    
    public Pedido() {
        listaLineaPedido = new ArrayList<>();
        this.pedidoFecha = Date.valueOf(LocalDate.now());
    }
    
    public Pedido(int pedidoCodigo, Double importe, Usuario usuario, Mesa mesa, Cliente cliente, Date pedidoFecha, String pedidoEstado) {
        this.pedidoCodigo = pedidoCodigo;
        this.importe = importe;
        this.usuario = usuario;
        this.mesa = mesa;
        this.cliente = cliente;
        this.pedidoFecha = pedidoFecha;
        this.pedidoEstado = pedidoEstado;
        listaLineaPedido = new ArrayList<>();
    }
    
    public int getPedidoCodigo() {
        return pedidoCodigo;
    }
    
    public void setPedidoCodigo(int pedidoCodigo) {
        this.pedidoCodigo = pedidoCodigo;
    }
    
    public Double getImporte() {
        return importe;
    }
    
    public void setImporte(Double importe) {
        this.importe = importe;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Mesa getMesa() {
        return mesa;
    }
    
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Date getPedidoFecha() {
        return pedidoFecha;
    }
    
    public void setPedidoFecha(Date pedidoFecha) {
        this.pedidoFecha = pedidoFecha;
    }
    
    public String getPedidoEstado() {
        return pedidoEstado;
    }
    
    public void setPedidoEstado(String pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
    }
    
    public List<LineaPedido> getListaLineaPedido() {
        return listaLineaPedido;
    }
    
    public void setListaLineaPedido(List<LineaPedido> listaLineaPedido) {
        this.listaLineaPedido = listaLineaPedido;
    }
    
    public void setEstrategiaDescuento(IDescuento estrategiaDescuento) {
        this.estrategiaDescuento = estrategiaDescuento;
    }

    ///reglas de negocion
    public LineaPedido getUltimaLineaPedido() {
        return listaLineaPedido.get(listaLineaPedido.size() - 1);
    }
    
    public void limpiarListaLineaPedido() {
        listaLineaPedido.clear();
    }
    
    public int obtenerIndiceProductoLineaPedido(Producto producto) {
        int valor = -1;
        int contador = 0;
        for (LineaPedido lineaPedido : listaLineaPedido) {
            if (lineaPedido.getProducto().getProductoCodigo() == producto.getProductoCodigo()) {
                valor = contador;
            }
            contador++;
        }
        return valor;
    }
    
    public boolean modificarLineaPedido(int cantidad, Producto producto) {
        if (producto.stockDisponible(cantidad)) {
            int numeroAfectado = obtenerIndiceProductoLineaPedido(producto);
            if (numeroAfectado != -1) {
                listaLineaPedido.get(numeroAfectado).setCantidad(cantidad);
            }
            return true;
        } else {
            return false;
        }
    }
    
    public boolean eliminarLineaPedido(Producto producto) {
        
        int numeroAfectado = obtenerIndiceProductoLineaPedido(producto);
        if (numeroAfectado != -1) {
            listaLineaPedido.remove(numeroAfectado);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean agregarLineaPedido(int cantidad, Producto producto) {
        if (producto.stockDisponible(cantidad)) {
            LineaPedido lineaPedido = new LineaPedido();
            lineaPedido.setCantidad(cantidad);
            lineaPedido.setProducto(producto);
            lineaPedido.setPedido(this);
            lineaPedido.setEstado(LineaPedido.ESTADO_ACTIVO);            
            int numeroAfectado = obtenerIndiceProductoLineaPedido(producto);
            if (numeroAfectado != -1) {
                listaLineaPedido.set(numeroAfectado, lineaPedido);
            } else {
                listaLineaPedido.add(lineaPedido);
            }
            return true;
        } else {
            return false;
        }
        
    }
    
    public int calcularTotalLineaPedido() {
        return listaLineaPedido.size();
    }
    
    public double calcularPrecioTotal() {
        double total = 0;
        for (LineaPedido lineaPedido : listaLineaPedido) {
            total += lineaPedido.calcularSubTotal();
        }
        return total;
    }
    
    public double CalcularDescuento() {
        return estrategiaDescuento.calcularDescuento(this);
    }
    
    public double calculartPago() {
        return calcularPrecioTotal() - CalcularDescuento();
    }
}
