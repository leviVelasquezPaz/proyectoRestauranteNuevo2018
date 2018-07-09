/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa3_dominio;

/**
 *
 * @author INGENIERIA
 */
public class DescuentoPorLineDeVenta implements IDescuento {

    @Override
    public double calcularDescuento(Pedido pedido) {
        double descuento = 0;
        for (LineaPedido lineaPedido : pedido.getListaLineaPedido()) {
            if (lineaPedido.calcularSubTotal() > 70) {
                descuento += lineaPedido.calcularSubTotal() * 0.06;

            }
        }
        return descuento;
    }
}
