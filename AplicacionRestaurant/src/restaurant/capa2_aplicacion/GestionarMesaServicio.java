/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa2_aplicacion;

import java.util.List;
import javax.swing.JOptionPane;
import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa3_dominio.Mesa;
import restaurant.capa4_persistencia.GestorJDBC;
import restaurant.capa4_persistencia.GestorJDBCPostgre;
import restaurant.capa4_persistencia.MesaDAOPostgre;

/**
 *
 * @author Levi
 */
public class GestionarMesaServicio {

    private GestorJDBC gestorJDBC;
    private MesaDAOPostgre mesaDAOPostgre;

    public GestionarMesaServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        mesaDAOPostgre = new MesaDAOPostgre(gestorJDBC);
    }

    public int guardarMesa(Mesa mesa) throws Exception {
        int numerosAfecatdos = 0;
        List<Mesa> listaMesa = mostrarMesas();
        for (Mesa mesas : listaMesa) {
            if (mesas.getMesaNumero() == mesa.getMesaNumero()) {
                numerosAfecatdos = 2;                
            }
        }
        
        if(numerosAfecatdos!=2){
            gestorJDBC.abrirConexion();
            numerosAfecatdos = mesaDAOPostgre.ingresar(mesa);
            gestorJDBC.cerrarConexion();  
        }

        return numerosAfecatdos;
    }

    public int obtenerUltimoCodigo() throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = mesaDAOPostgre.obtenerUltimoCodigo();
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

    public int modificarMesa(Mesa mesa) throws Exception {
        gestorJDBC.abrirConexion();
        int ultimoCodigo = mesaDAOPostgre.modificar(mesa);
        gestorJDBC.cerrarConexion();
        return ultimoCodigo;
    }

    public List<Mesa> mostrarMesas() {
        List<Mesa> listaProducto = null;
        try {
            gestorJDBC.abrirConexion();
            listaProducto = mesaDAOPostgre.mostrarTodosLasMesas();
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            Mensaje.mostrarErrorSistema(null);
        }
        return listaProducto;

    }

    public Mesa buscarMesaPorCodigo(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        Mesa mesa = mesaDAOPostgre.buscarCodigo(codigo);
        gestorJDBC.cerrarConexion();
        return mesa;

    }

    public int eliminarMesa(Mesa mesaSeleccionado) throws Exception {
        int numeroAfectados = 0;
        gestorJDBC.abrirConexion();
        numeroAfectados = mesaDAOPostgre.eliminar(mesaSeleccionado);
        gestorJDBC.cerrarConexion();
        return numeroAfectados;

    }
}
