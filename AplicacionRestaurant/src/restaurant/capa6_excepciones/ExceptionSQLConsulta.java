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
public class ExceptionSQLConsulta extends Exception {
  private final String MENSAJE_DE_USUARIO="No se pudo ejecutar la consulta.\n"
            + "Intente en otro momento o cosulte con el administrador";
    
    
    public ExceptionSQLConsulta(Throwable causa) {
        super(causa);
    }


  @Override
    public String getMessage() {
        return MENSAJE_DE_USUARIO;
    }

}
