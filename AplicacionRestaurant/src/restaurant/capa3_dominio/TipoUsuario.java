/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa3_dominio;

/**
 *
 * @author Antonio AB
 */
public class TipoUsuario {

    private int tipoUsuarioCodigo;
    private String tipoUsuarioNombre;
    private String tipoUsuarioDescripcion;
    private String tipoUsuarioEstado;
    public static final String Tipo_administrador = "ADMINISTRADOR";
    public static final String Tipo_mozo = "MOZO";
    public static final String ESTADO_ACTIVO = "A";
    public static final String ESTADO_INACTIVO = "I";

    public TipoUsuario() {
    }

    public TipoUsuario(int tipoUsuarioCodigo, String tipoUsuarioNombre, String tipoUsuarioDescripcion, String tipoUsuarioEstado) {
        this.tipoUsuarioCodigo = tipoUsuarioCodigo;
        this.tipoUsuarioNombre = tipoUsuarioNombre;
        this.tipoUsuarioDescripcion = tipoUsuarioDescripcion;
        this.tipoUsuarioEstado = tipoUsuarioEstado;
    }

    public int getTipoUsuarioCodigo() {
        return tipoUsuarioCodigo;
    }

    public void setTipoUsuarioCodigo(int tipoUsuarioCodigo) {
        this.tipoUsuarioCodigo = tipoUsuarioCodigo;
    }

    public String getTipoUsuarioNombre() {
        return tipoUsuarioNombre;
    }

    public void setTipoUsuarioNombre(String tipoUsuarioNombre) {
        this.tipoUsuarioNombre = tipoUsuarioNombre;
    }

    public String getTipoUsuarioDescripcion() {
        return tipoUsuarioDescripcion;
    }

    public void setTipoUsuarioDescripcion(String tipoUsuarioDescripcion) {
        this.tipoUsuarioDescripcion = tipoUsuarioDescripcion;
    }

    public String getTipoUsuarioEstado() {
        return tipoUsuarioEstado;
    }

    public void setTipoUsuarioEstado(String tipoUsuarioEstado) {
        this.tipoUsuarioEstado = tipoUsuarioEstado;
    }

}
