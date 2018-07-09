package restaurant.capa1_presentacion.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import restaurant.capa4_persistencia.GestorJDBC;

/**
 * Data provider for excel
 *
 * @author angel
 */
public final class FakeDataProvider {

    GestorJDBC gestorJDBC;
    ResultSet st;

    public FakeDataProvider(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;

    }

    public static PreparedStatement ps;

    /**
     * Return the columns name for the table
     */
    public static List<String> getTableHeaders() {
        List<String> tableHeader = new ArrayList<String>();
        //TITULOS DE LAS COLUMNAS
        tableHeader.add("Codigo");
        tableHeader.add("Apellido Paterno");
        tableHeader.add("Apellido Materno");
        tableHeader.add("Nombre");
        tableHeader.add("N° de Documento");
        tableHeader.add("Estado");
        return tableHeader;
    }

    /**
     * Return values for the table
     *
     * @param numberOfRows Number of rows we want to receive
     *
     * @return Values
     */
    public List<List<String>> getTableContent(int numberOfRows) {
        try {
            if (numberOfRows <= 0) {
                throw new IllegalArgumentException("The number of rows must be a positive integer");
            }

            List<List<String>> tableContent = new ArrayList<List<String>>();

            String SQL = "select * from cliente";
            st = gestorJDBC.ejecutarConsulta(SQL);

            int i = 0;
            List<String> row = null;
            while (st.next()) {
                tableContent.add(row = new ArrayList<String>());

                row.add(st.getString("clientecodigo"));
                row.add(st.getString("clientepaterno"));
                row.add(st.getString("clientematerno"));
                row.add(st.getString("clientenombre"));
                row.add(st.getString("clientedni"));
                row.add(st.getString("clienteestado"));

                i++;
            }
            return tableContent;
        } catch (SQLException ex) {
            Logger.getLogger(FakeDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
