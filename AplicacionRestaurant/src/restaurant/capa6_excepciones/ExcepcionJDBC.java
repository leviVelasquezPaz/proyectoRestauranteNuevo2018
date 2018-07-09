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
public class ExcepcionJDBC extends Exception {

    private final String MENSAJE_DE_USUARIO="Ocurrio un error de conexion a datos.\n"
            + "Intente en otro momento o cosulte con el administrador";
    
    
    
        
    public ExcepcionJDBC(Throwable causa) {
        super(causa);
    }

    @Override
    public String getMessage() {
        return MENSAJE_DE_USUARIO;
    }
    
    
  
}
