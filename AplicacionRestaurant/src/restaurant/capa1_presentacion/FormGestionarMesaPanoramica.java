/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarMesaServicio;
import restaurant.capa3_dominio.Mesa;
import rojerusan.RSButtonMetro;

/**
 *
 * @author Levi
 */
public class FormGestionarMesaPanoramica extends javax.swing.JDialog {

    private GestionarMesaServicio gestionarMesaServicio;
    List<Mesa> listaMesa;
    Mesa mesaSeleccionada;
    public static String DE_PRINCIPAL = "DE_PRINCIPAL";
    public static String DE_PEDIDO = "DE_PEDIDO";
    private static String TIPO_ACCION = "";

    private String estadomesa = "";

    public FormGestionarMesaPanoramica(java.awt.Frame parent, boolean modal, String tipoUsuario) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        TIPO_ACCION = tipoUsuario;
        gestionarMesaServicio = new GestionarMesaServicio();
        listaMesa = gestionarMesaServicio.mostrarMesas();
        crearComponentesDeLasMesas();

    }

    private void crearComponentesDeLasMesas() {
        panelDeEscroll.setLayout(new GridLayout(20, 20, 10, 10));
        panelDeEscroll.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        JPanel panelVerticalComponente;
        JButton label;
        rojeru_san.RSButton btnOpcionesEstado;
        JLabel lblTituloEstado;

        JPanel panelImagenes;
        RSButtonMetro btnOpcioneModificar;
        JLabel lblimagen;
        JPanel panelDescripciones;
        JLabel lblDescripcionCapacidad;
        JLabel lblTituloCapacidad;
        JLabel lblTituloNombre;
        JLabel lblDesacripcionNumero;
        JLabel lblDescripcionPiso;
        JLabel lblTituloPiso;
        JPanel panelContenedor;
        int contado = 0;
        Mesa mesa;

        try {
            for (int i = 0; i < 100; i++) {
                if (i <= listaMesa.size() - 1) {
                    mesa = new Mesa();
                    mesa = listaMesa.get(i);
                    btnOpcionesEstado = new rojeru_san.RSButton();
                    btnOpcioneModificar = new RSButtonMetro();
                    if (mesa.getMesaEstado().equals(Mesa.ESTADO_DISPONIBLE)) {
                        btnOpcionesEstado.setText("DISPONIBLE");
                        btnOpcionesEstado.setEnabled(true);
                        btnOpcioneModificar.setVisible(false);
                    } else if (mesa.getMesaEstado().equals(Mesa.ESTADO_OCUPADO)) {
                        btnOpcionesEstado.setText("OCUPADO");
                        // btnOpcionesEstado.setEnabled(false);
                        btnOpcionesEstado.setBackground(Color.red);
                    } else if (mesa.getMesaEstado().equals(Mesa.ESTADO_RESERVADA)) {
                        btnOpcionesEstado.setText("RESERVADA");
                        btnOpcionesEstado.setEnabled(false);
                        btnOpcioneModificar.setVisible(true);
                    }

                    panelContenedor = new JPanel();
                    panelVerticalComponente = new JPanel(new GridLayout(2, 1));

                    lblimagen = new JLabel();
                    panelImagenes = new JPanel(new FlowLayout());

                    panelDescripciones = new JPanel();

                    lblDescripcionCapacidad = new JLabel();
                    lblTituloCapacidad = new JLabel();
                    lblTituloNombre = new JLabel();
                    lblDesacripcionNumero = new JLabel();
                    lblDescripcionPiso = new JLabel();
                    lblTituloPiso = new JLabel();

                    lblTituloEstado = new JLabel();
                    lblTituloEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                    lblTituloEstado.setText("Estado: ");
                    btnOpcioneModificar.setBackground(new java.awt.Color(255, 255, 255));
                    btnOpcioneModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/lapiz.png"))); // NOI18N
                    btnOpcioneModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                    btnOpcioneModificar.addActionListener(new opcionesBotonesModificar(mesa, this));

                    lblimagen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                    lblimagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    lblimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/mesa.png")));

                    javax.swing.GroupLayout panelImagenesLayout = new javax.swing.GroupLayout(panelImagenes);
                    panelImagenes.setLayout(panelImagenesLayout);
                    panelImagenesLayout.setHorizontalGroup(
                            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelImagenesLayout.createSequentialGroup()
                                            .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnOpcioneModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    );

                    panelImagenesLayout.setVerticalGroup(
                            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelImagenesLayout.createSequentialGroup()
                                            .addComponent(btnOpcioneModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(105, 105, 105))
                    );
                    panelImagenes.add(lblimagen);
                    panelImagenes.add(btnOpcioneModificar);
                    panelDescripciones.setBackground(new java.awt.Color(102, 255, 255));

                    lblDescripcionCapacidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                    lblDescripcionCapacidad.setForeground(new java.awt.Color(0, 51, 204));
                    lblDescripcionCapacidad.setText("" + mesa.getMesaCapacidad());

                    lblTituloCapacidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                    lblTituloCapacidad.setText("Capacidad:");

                    lblTituloNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                    lblTituloNombre.setText("Numero:");

                    lblDesacripcionNumero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                    lblDesacripcionNumero.setForeground(new java.awt.Color(0, 51, 204));
                    lblDesacripcionNumero.setText(""+mesa.getMesaNumero());

                    lblDescripcionPiso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                    lblDescripcionPiso.setForeground(new java.awt.Color(0, 51, 204));
                    lblDescripcionPiso.setText(""+mesa.getMesaPiso());

                    lblTituloPiso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                    lblTituloPiso.setText("Piso:");

                    btnOpcionesEstado.setBackground(new java.awt.Color(255, 255, 255));

                    btnOpcionesEstado.setColorHover(new java.awt.Color(229, 57, 53));
                    btnOpcionesEstado.setColorText(new java.awt.Color(68, 138, 255));
                    btnOpcionesEstado.addActionListener(new opcionesBotonesEstado(mesa, this));

                    javax.swing.GroupLayout panelDescripcionesLayout = new javax.swing.GroupLayout(panelDescripciones);
                    panelDescripciones.setLayout(panelDescripcionesLayout);
                    panelDescripcionesLayout.setHorizontalGroup(
                            panelDescripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDescripcionesLayout.createSequentialGroup()
                                            .addGroup(panelDescripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblTituloCapacidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblTituloNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblTituloPiso, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelDescripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lblDescripcionCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblDesacripcionNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblDescripcionPiso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            //
                                            .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDescripcionesLayout.createSequentialGroup()
                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnOpcionesEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap())
                    );
                    panelDescripcionesLayout.setVerticalGroup(
                            panelDescripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDescripcionesLayout.createSequentialGroup()
                                            .addGroup(panelDescripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lblTituloCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblDescripcionCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelDescripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lblTituloNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblDesacripcionNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelDescripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lblTituloPiso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblDescripcionPiso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(18, 18, 18)
                                            .addComponent(btnOpcionesEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27))
                    );
                    panelVerticalComponente.add(panelImagenes);
                    panelVerticalComponente.add(panelDescripciones);

                    panelDeEscroll.add(panelVerticalComponente);
                    contado++;
                } else {
                    panelDeEscroll.add(new JButton("Mesa " + i + " no disponible"));
                    contado++;
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public class opcionesBotonesModificar implements ActionListener {

        Mesa mesa;
        // Object objeto;
        JDialog dialogo;

        public opcionesBotonesModificar(Mesa mesa, JDialog dialog) {
            this.mesa = mesa;
            this.dialogo = dialog;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (mesa.getMesaEstado().equals(Mesa.ESTADO_RESERVADA)) {
                try {
                    dialogo.dispose();
                    FormDatosMesa formDatosMesa = new FormDatosMesa(null, mesa);
                    formDatosMesa.setVisible(true);

                    panelDeEscroll.removeAll();
                    crearComponentesDeLasMesas();

                } catch (Exception ex) {
                    Mensaje.mostrarErrorSistema(null);
                }
            }

        }

    }

    public class opcionesBotonesEstado implements ActionListener {

        Mesa mesa;
        Object objeto;
        JDialog dialogo;

        public opcionesBotonesEstado(Mesa mesa, JDialog dialog) {
            this.mesa = mesa;
            this.dialogo = dialog;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (mesa.getMesaEstado().equals(Mesa.ESTADO_OCUPADO)) {
                try {
                    if (TIPO_ACCION == DE_PRINCIPAL) {
                        FormRegistrarPedido j = new FormRegistrarPedido(null, true, mesa);
                        j.setVisible(true);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            } else if (mesa.getMesaEstado().equals(Mesa.ESTADO_DISPONIBLE)) {
                if (TIPO_ACCION == DE_PEDIDO) {
                    mesaSeleccionada = mesa;
                    dialogo.dispose();
                }

            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanel = new javax.swing.JScrollPane();
        panelDeEscroll = new javax.swing.JPanel();
        rSButtonMetro5 = new rojerusan.RSButtonMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        panelDeEscroll.setBackground(new java.awt.Color(255, 255, 255));
        panelDeEscroll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        scrollPanel.setViewportView(panelDeEscroll);

        rSButtonMetro5.setBackground(new java.awt.Color(204, 0, 0));
        rSButtonMetro5.setText("X");
        rSButtonMetro5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rSButtonMetro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
int x, y;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_formMouseDragged

    private void rSButtonMetro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro5ActionPerformed
        this.dispose();
        mesaSeleccionada = null;
    }//GEN-LAST:event_rSButtonMetro5ActionPerformed
//
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormGestionMesa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormGestionMesa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormGestionMesa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormGestionMesa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                FormGestionMesa1 dialog = new FormGestionMesa1(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelDeEscroll;
    private rojerusan.RSButtonMetro rSButtonMetro5;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
