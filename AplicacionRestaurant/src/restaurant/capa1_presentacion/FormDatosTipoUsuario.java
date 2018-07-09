/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import restaurant.capa1_presentacion.util.DesktopNotify;
import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarTipoUsuarioServicio;
import restaurant.capa3_dominio.TipoUsuario;
import rojerusan.RSAnimation;

/**
 *
 * @author INGENIERIA
 */
public class FormDatosTipoUsuario extends javax.swing.JDialog {

    /**
     * Creates new form FormDatosTipoUsuario
     */
    private int x, y;
    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private TipoUsuario tipoUsuario;
    private int tipo_accion;
    private GestionarTipoUsuarioServicio gestionarTipoUsuarioServicio;

    public FormDatosTipoUsuario(JDialog owner) throws Exception {
        super(owner, true);
        initComponents();
        RSAnimation.setMoverIzquierda(1050, 900, 15, 3, this);
        gestionarTipoUsuarioServicio = new GestionarTipoUsuarioServicio();
        tipo_accion = ACCION_CREAR;
        tipoUsuario = new TipoUsuario();
        this.setLocationRelativeTo(null);
        txtCodigo.setText(String.valueOf(gestionarTipoUsuarioServicio.obtenerUltimoCodigo() + 1));
    }

    public FormDatosTipoUsuario(JDialog owner, TipoUsuario tipoUsuario) throws Exception {
        super(owner, true);
        initComponents();
        RSAnimation.setMoverIzquierda(1050, 900, 15, 3, this);
        gestionarTipoUsuarioServicio = new GestionarTipoUsuarioServicio();
        this.tipoUsuario = tipoUsuario;
        tipo_accion = ACCION_MODIFICAR;
        tipoUsuario = new TipoUsuario();
        this.setLocationRelativeTo(null);
        llenarDatosTextos();
    }

    private void llenarDatosTextos() {
        txtCodigo.setText(String.valueOf(tipoUsuario.getTipoUsuarioCodigo()));
        txtNombre.setText(String.valueOf(tipoUsuario.getTipoUsuarioNombre()));
        txtDescripcion.setText(String.valueOf(tipoUsuario.getTipoUsuarioDescripcion()));
        if (tipoUsuario.getTipoUsuarioEstado().equals(TipoUsuario.ESTADO_ACTIVO)) {
            cboEstado.setSelectedIndex(0);
        } else {
            cboEstado.setSelectedIndex(1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnCerrar2 = new rojerusan.RSButtonMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtCodigo = new rojeru_san.RSMTextFull();
        txtNombre = new rojeru_san.RSMTextFull();
        txtDescripcion = new rojeru_san.RSMTextFull();
        rSLabelImage1 = new rojerusan.RSLabelImage();
        rSLabelImage2 = new rojerusan.RSLabelImage();
        rSLabelImage3 = new rojerusan.RSLabelImage();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        cboEstado = new rojerusan.RSComboMetro();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new rojeru_san.RSButton();
        btnGurdar = new rojeru_san.RSButton();

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(68, 138, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(68, 138, 255));
        jPanel1.setForeground(new java.awt.Color(68, 138, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 40));

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
        jLabel1.setText("Datos de Tipo de Usurio ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(btnCerrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 336, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        jPanel4.setBorder(dropShadowBorder2);

        txtCodigo.setEnabled(false);
        txtCodigo.setPlaceholder("CÓDIGO");
        txtCodigo.setSoloNumeros(true);

        txtNombre.setPlaceholder("NOMBRE");
        txtNombre.setSoloLetras(true);

        txtDescripcion.setPlaceholder("DESCRIPCIÓN");

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/estaditipoproducto.png"))); // NOI18N

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/tipouser.png"))); // NOI18N

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/tipouser.png"))); // NOI18N

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/clientecodigo.png"))); // NOI18N

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO", " " }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 320, 300));

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
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 150, 46));

        btnGurdar.setBackground(new java.awt.Color(255, 255, 255));
        btnGurdar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/savetipoproducto.png"))); // NOI18N
        btnGurdar.setText("Guardar");
        btnGurdar.setColorHover(new java.awt.Color(253, 173, 1));
        btnGurdar.setColorText(new java.awt.Color(68, 138, 255));
        btnGurdar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGurdarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGurdar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 46));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 251, 336, 187));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);

    }//GEN-LAST:event_formMouseDragged

    private void btnCerrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrar2ActionPerformed

    private void btnGurdarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGurdarActionPerformed
        tipoUsuario.setTipoUsuarioCodigo(Integer.parseInt(txtCodigo.getText()));
        tipoUsuario.setTipoUsuarioNombre(txtNombre.getText());
        tipoUsuario.setTipoUsuarioDescripcion(txtDescripcion.getText());
        if (cboEstado.getSelectedItem().toString().equals("ACTIVO")) {
            tipoUsuario.setTipoUsuarioEstado(TipoUsuario.ESTADO_ACTIVO);
        } else if (cboEstado.getSelectedItem().toString().equals("INACTIVO")) {
            tipoUsuario.setTipoUsuarioEstado(TipoUsuario.ESTADO_INACTIVO);
        }
        gestionarTipoUsuarioServicio = new GestionarTipoUsuarioServicio();
        int registros_afectados;
        if (tipo_accion == ACCION_CREAR) {
            try {
                registros_afectados = gestionarTipoUsuarioServicio.crearTipoUsuario(tipoUsuario);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeCreacion(this);
                                   DesktopNotify.showDesktopMessage("FiveCod software", "Usted Acaba crear un nuevo Tipo de Usuario", 7);

                    this.dispose(); // se cierra la ventana
                } else {
                    Mensaje.mostrarAdvertenciaDeCreacion(this);
                }
            } catch (Exception e) {
                Mensaje.mostrarErrorDeCreacion(this);
            }
        } else {
            try {
                registros_afectados = gestionarTipoUsuarioServicio.modificarTipoUsuario(tipoUsuario);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeActualizacion(this);
                    this.dispose(); // se cierra la ventana
                } else {
                    Mensaje.mostrarAdvertenciaDeActualizacion(this);
                }
            } catch (Exception e) {
                Mensaje.mostrarErrorDeActualizacion(this);
            }
        }
    }//GEN-LAST:event_btnGurdarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnCancelar;
    private rojerusan.RSButtonMetro btnCerrar2;
    private rojeru_san.RSButton btnGurdar;
    private rojerusan.RSComboMetro cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private rojerusan.RSLabelImage rSLabelImage1;
    private rojerusan.RSLabelImage rSLabelImage2;
    private rojerusan.RSLabelImage rSLabelImage3;
    private rojerusan.RSLabelImage rSLabelImage4;
    private rojeru_san.RSMTextFull txtCodigo;
    private rojeru_san.RSMTextFull txtDescripcion;
    private rojeru_san.RSMTextFull txtNombre;
    // End of variables declaration//GEN-END:variables
}
