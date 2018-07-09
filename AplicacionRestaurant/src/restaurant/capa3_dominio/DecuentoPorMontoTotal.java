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
public class DecuentoPorMontoTotal implements IDescuento {

    @Override
    public double calcularDescuento(Pedido pedido) {
        double descuento = 0;
        if (pedido.calcularPrecioTotal()> 120) {
            descuento = pedido.calcularPrecioTotal()* 0.08;
        }
        return descuento;
    }
}
