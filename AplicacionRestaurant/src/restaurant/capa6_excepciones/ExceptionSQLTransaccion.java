/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa6_excepciones;


/**
 *
 * @author INGENIERIA
 */
public class ExceptionSQLTransaccion extends Exception {

   private final String MENSAJE_DE_USUARIO="No se pudo iniciar la transaccion.\n"
            + "Intente en otro momento o cosulte con el administrador";
    
    
   
    public ExceptionSQLTransaccion(Throwable causa) {
        super(causa);
    }

    @Override
    public String getMessage() {
        return MENSAJE_DE_USUARIO; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
