/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa4_persistencia;

import java.io.File;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.view.JasperViewer;
import restaurant.capa3_dominio.Mesa;

/**
 *
 * @author Antonio AB
 */
public class GenerarReporteDAOPostgre {

    GestorJDBC gestorJDBC;

    public GenerarReporteDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;

    }

    public JasperPrint reporteCliente() {
        JasperPrint print = null;
        try {
            Map p = new HashMap();

            JasperReport jasperReport = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/restaurant/capa7_reportes/RptReporteCliente.jrxml");
            //(JasperReport) JRLoader.loadObject("/src/restaurant/capa7_reportes/RptReporteCliente.jrxml");
            print = JasperFillManager.fillReport(jasperReport, p, gestorJDBC.getConnection());
//            JasperViewer view = new JasperViewer(print, false);
//            view.setTitle("Reporte de Cliente");
//            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostarr Reporte" + e.getMessage());
        }
        return print;
    }

    public JasperPrint reporteRegistroPedido(Mesa mesa) {
        JasperPrint print = null;
        try {
            Map p = new HashMap();
            p.put("mesacodigo", mesa.getMesaCodigo());
            
            JasperReport jasperReport = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/restaurant/capa7_reportes/RptRegistroPedido.jrxml");
            //(JasperReport) JRLoader.loadObject("/src/restaurant/capa7_reportes/RptReporteCliente.jrxml");
            print = JasperFillManager.fillReport(jasperReport, p, gestorJDBC.getConnection());
//            JasperViewer view = new JasperViewer(print, false);
//            view.setTitle("Reporte de Cliente");
//            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostarr Reporte" + e.getMessage());
        }
        return print;
    }

}
