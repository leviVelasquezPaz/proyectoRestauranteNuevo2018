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
public class FabricaEstrategiaDescuento {

    private static FabricaEstrategiaDescuento fabricaEstrategiaDescuento;
 //   private static IDescuento estrategiaDescuento;

    private FabricaEstrategiaDescuento() {

    }

    public static FabricaEstrategiaDescuento crearInstancia() {
        if (fabricaEstrategiaDescuento == null) {
            fabricaEstrategiaDescuento = new FabricaEstrategiaDescuento();
        }

        return fabricaEstrategiaDescuento;

    }

    public IDescuento crearEstrategiaDescuento() {        
        return new DecuentoPorMontoTotal();        
//        if (estrategiaDescuento != null) {
//            estrategiaDescuento = new DecuentoPorMontoTotal();
//        }
//        return estrategiaDescuento;

    }
}
