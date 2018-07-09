/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import restaurant.capa1_presentacion.util.DesktopNotify;

import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarMesaServicio;

import restaurant.capa3_dominio.Mesa;
import restaurant.capa3_dominio.Producto;
import rojerusan.RSAnimation;

/**
 *
 * @author GRUPO
 */
public class FormDatosMesa extends javax.swing.JDialog {

    private int x, y;
    private GestionarMesaServicio gestionarMesaServicio;
    private Mesa mesa;
    private SimpleDateFormat format;

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion;

    public FormDatosMesa(JDialog owner) throws Exception {
        super(owner, true);
        initComponents();
        RSAnimation.setMoverIzquierda(1050, 900, 15, 3, this);
        mesa = new Mesa();
        tipo_accion = ACCION_CREAR;
        gestionarMesaServicio = new GestionarMesaServicio();
        this.setLocationRelativeTo(null);
        txtCodigo.setText(String.valueOf(gestionarMesaServicio.obtenerUltimoCodigo() + 1));

    }

    public FormDatosMesa(JDialog owner, Mesa mesa) throws Exception {
        super(owner, true);
        initComponents();
        RSAnimation.setMoverIzquierda(1050, 900, 15, 3, this);
        this.mesa = mesa;
        tipo_accion = ACCION_MODIFICAR;
        gestionarMesaServicio = new GestionarMesaServicio();
        this.setLocationRelativeTo(null);
        llenarCampos();

    }

    private void llenarCampos() {
        txtCodigo.setText(String.valueOf(mesa.getMesaCodigo()));
        txtCapacidad.setText(String.valueOf(mesa.getMesaCapacidad()));
        txtNumeroMesa.setText(String.valueOf(mesa.getMesaNumero()));
        txtPiso.setText(String.valueOf(mesa.getMesaPiso()));
        if (mesa.getMesaEstado().equals(Producto.ESTADO_ACTIVO)) {
            cboEstado.setSelectedIndex(0);
        } else {
            cboEstado.setSelectedIndex(1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCerrar2 = new rojerusan.RSButtonMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtCapacidad = new rojeru_san.RSMTextFull();
        txtNumeroMesa = new rojeru_san.RSMTextFull();
        txtPiso = new rojeru_san.RSMTextFull();
        txtCodigo = new rojeru_san.RSMTextFull();
        cboEstado = new rojerusan.RSComboMetro();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        rSLabelImage3 = new rojerusan.RSLabelImage();
        rSLabelImage5 = new rojerusan.RSLabelImage();
        rSLabelImage6 = new rojerusan.RSLabelImage();
        rSLabelImage10 = new rojerusan.RSLabelImage();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new rojeru_san.RSButton();
        btnAgregar = new rojeru_san.RSButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(68, 138, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(68, 138, 255));

        btnCerrar2.setBackground(new java.awt.Color(204, 0, 0));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        btnCerrar2.setBorder(dropShadowBorder1);
        btnCerrar2.setText("X");
        btnCerrar2.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnCerrar2.setGrosorLinea(4);
        btnCerrar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar2.setIconTextGap(0);
        btnCerrar2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCerrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Datos del Producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addComponent(btnCerrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 410, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setCornerSize(15);
        dropShadowBorder2.setShadowColor(new java.awt.Color(68, 138, 255));
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        jPanel4.setBorder(dropShadowBorder2);
        jPanel4.setPreferredSize(new java.awt.Dimension(392, 440));

        txtCapacidad.setPlaceholder("CAPACIDAD MESA");
        txtCapacidad.setSoloNumeros(true);

        txtNumeroMesa.setPlaceholder("NUMERO DE MESA");
        txtNumeroMesa.setSoloNumeros(true);

        txtPiso.setPlaceholder("PISO ");
        txtPiso.setSoloNumeros(true);

        txtCodigo.setEnabled(false);
        txtCodigo.setPlaceholder("CÓDIGO");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DISPONIBLE", "RESERVADA", "OCUPADA" }));

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/codigotipoproducto.png"))); // NOI18N

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/mesacapacidadc.png"))); // NOI18N

        rSLabelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/numeromesa.png"))); // NOI18N

        rSLabelImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/floor.png"))); // NOI18N

        rSLabelImage10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/estaditipoproducto.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage10, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage6, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSLabelImage10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 300, 300));

        jPanel3.setBackground(new java.awt.Color(68, 138, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/cancelripoprudcto.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(253, 173, 1));
        btnCancelar.setColorText(new java.awt.Color(68, 138, 255));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 150, 46));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/savetipoproducto.png"))); // NOI18N
        btnAgregar.setText("Guardar");
        btnAgregar.setColorHover(new java.awt.Color(253, 173, 1));
        btnAgregar.setColorText(new java.awt.Color(68, 138, 255));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 46));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 307, 346, 131));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrar2ActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_formMouseDragged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        mesa.setMesaCodigo(Integer.parseInt(txtCodigo.getText()));
        mesa.setMesaCapacidad(Integer.parseInt(txtCapacidad.getText()));
        mesa.setMesaNumero(Integer.parseInt(txtNumeroMesa.getText().toString()));
        mesa.setMesaPiso(Integer.parseInt(txtPiso.getText().toString()));

        if (cboEstado.getSelectedItem().toString().equals("DISPONIBLE")) {
            mesa.setMesaEstado(Mesa.ESTADO_DISPONIBLE);
        } else if (cboEstado.getSelectedItem().toString().equals("RESERVADA")) {
            mesa.setMesaEstado(Mesa.ESTADO_RESERVADA);
        } else if (cboEstado.getSelectedItem().toString().equals("OCUPADA")) {
            mesa.setMesaEstado(Mesa.ESTADO_OCUPADO);
        }
        int registros_afectados;
        if (tipo_accion == ACCION_CREAR) {
            try {
                registros_afectados = gestionarMesaServicio.guardarMesa(mesa);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeCreacion(this);
                    DesktopNotify.showDesktopMessage("FiveCod software", "Usted Acaba de Crear Nuevos Datos De una Mesa", 7);

                    this.dispose();
                } else if (registros_afectados == 0) {
                    Mensaje.mostrarAdvertenciaDeCreacion(this);
                } else if (registros_afectados == 2) {
                    Mensaje.mostrarAdvertencia(null, "Ya existe el numero de mesa");
                }

            } catch (Exception e) {
                // Mensaje.mostrarErrorDeCreacion(this);
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else if (tipo_accion == ACCION_MODIFICAR) {
            try {
                registros_afectados = gestionarMesaServicio.modificarMesa(mesa);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeActualizacion(this);
                    this.dispose();
                } else if (registros_afectados == 0) {
                    Mensaje.mostrarAdvertenciaDeActualizacion(this);
                } else if (registros_afectados == 2) {
                    Mensaje.mostrarAdvertencia(null, "Ya existe el numero de msas");
                }

            } catch (Exception e) {
                Mensaje.mostrarErrorDeActualizacion(this);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnAgregar;
    private rojeru_san.RSButton btnCancelar;
    private rojerusan.RSButtonMetro btnCerrar2;
    private rojerusan.RSComboMetro cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private rojerusan.RSLabelImage rSLabelImage10;
    private rojerusan.RSLabelImage rSLabelImage3;
    private rojerusan.RSLabelImage rSLabelImage4;
    private rojerusan.RSLabelImage rSLabelImage5;
    private rojerusan.RSLabelImage rSLabelImage6;
    private rojeru_san.RSMTextFull txtCapacidad;
    private rojeru_san.RSMTextFull txtCodigo;
    private rojeru_san.RSMTextFull txtNumeroMesa;
    private rojeru_san.RSMTextFull txtPiso;
    // End of variables declaration//GEN-END:variables
}
