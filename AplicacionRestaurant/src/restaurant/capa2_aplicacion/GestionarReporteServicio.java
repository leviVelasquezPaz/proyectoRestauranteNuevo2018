/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa2_aplicacion;

import net.sf.jasperreports.engine.JasperPrint;
import restaurant.capa3_dominio.Mesa;
import restaurant.capa4_persistencia.GestorJDBC;
import restaurant.capa4_persistencia.GestorJDBCPostgre;
import restaurant.capa4_persistencia.GenerarReporteDAOPostgre;

/**
 *
 * @author Antonio AB
 */
public class GestionarReporteServicio {
    
    private GestorJDBC gestorJDBC;
    private GenerarReporteDAOPostgre generarReporteDAOPostgre;
    
    public GestionarReporteServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        generarReporteDAOPostgre = new GenerarReporteDAOPostgre(gestorJDBC);
    }
    
    public JasperPrint mostrartReporte() throws Exception {
        gestorJDBC.abrirConexion();
        JasperPrint print = generarReporteDAOPostgre.reporteCliente();
        gestorJDBC.cerrarConexion();
        return print;
    }
    
    public JasperPrint mostrarRegistroPedido(Mesa mesa) throws Exception {
        gestorJDBC.abrirConexion();
        JasperPrint print = generarReporteDAOPostgre.reporteRegistroPedido(mesa);
        gestorJDBC.cerrarConexion();
        return print;
    }
}
