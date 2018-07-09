/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa3_dominio;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import restaurant.capa1_presentacion.FormMenu;

/**
 *
 * @author Levi
 */
public class IniciarSesion {

    private static JFrame iniciarSesion;
    private static Usuario usuario;

    private IniciarSesion() {
    }

    public static JFrame crearInicioSesion() {
        if (iniciarSesion == null) {
            iniciarSesion = new FormMenu();
        }
        return iniciarSesion;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        if (IniciarSesion.usuario == null) {
            IniciarSesion.usuario = usuario;
        }
    }

}
