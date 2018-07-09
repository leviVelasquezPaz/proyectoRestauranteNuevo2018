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
public class Usuario {

    private int usuarioCodigo;
    private String usuarioPaterno;
    private String usuarioMaterno;
    private String usuarioNombre;
    private String usuarioSexo;
    private String usuarioDni;
    private String usuarioPassword;
    private String usuarioEstado;
    private TipoUsuario tipoUsuario;
    public static final String ESTADO_ACTIVO = "A";
    public static final String ESTADO_INACTIVO = "I";
    public static final String GENERO_MASCULINO = "M";
    public static final String GENERO_FEMENINO = "F";

    public Usuario() {
    }

    public Usuario(int usuarioCodigo, String usuarioPaterno, String usuarioMaterno, String usuarioNombre, String usuarioSexo, String usuarioDni, String usuarioPassword, String usuarioEstado, TipoUsuario tipoUsuario) {
        this.usuarioCodigo = usuarioCodigo;
        this.usuarioPaterno = usuarioPaterno;
        this.usuarioMaterno = usuarioMaterno;
        this.usuarioNombre = usuarioNombre;
        this.usuarioSexo = usuarioSexo;
        this.usuarioDni = usuarioDni;
        this.usuarioPassword = usuarioPassword;
        this.usuarioEstado = usuarioEstado;
        this.tipoUsuario = tipoUsuario;
    }

    public int getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(int usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }

    public String getUsuarioPaterno() {
        return usuarioPaterno;
    }

    public void setUsuarioPaterno(String usuarioPaterno) {
        this.usuarioPaterno = usuarioPaterno;
    }

    public String getUsuarioMaterno() {
        return usuarioMaterno;
    }

    public void setUsuarioMaterno(String usuarioMaterno) {
        this.usuarioMaterno = usuarioMaterno;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioSexo() {
        return usuarioSexo;
    }

    public void setUsuarioSexo(String usuarioSexo) {
        this.usuarioSexo = usuarioSexo;
    }

    public String getUsuarioDni() {
        return usuarioDni;
    }

    public void setUsuarioDni(String usuarioDni) {
        this.usuarioDni = usuarioDni;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public String getUsuarioEstado() {
        return usuarioEstado;
    }

    public void setUsuarioEstado(String usuarioEstado) {
        this.usuarioEstado = usuarioEstado;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
