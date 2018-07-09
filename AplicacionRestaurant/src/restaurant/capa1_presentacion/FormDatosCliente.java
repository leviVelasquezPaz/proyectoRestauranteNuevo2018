/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JDialog;
import restaurant.capa1_presentacion.util.DesktopNotify;

import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarClienteServicio;
import restaurant.capa3_dominio.Cliente;
import rojerusan.RSAnimation;

/**
 *
 * @author Antonio AB
 */
public class FormDatosCliente extends javax.swing.JDialog {

    private int x, y;
    private GestionarClienteServicio gestionarClienteServicio;
    private List<Cliente> listaCliente;
    private SimpleDateFormat format;
    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion;
    private Cliente cliente;

    public FormDatosCliente(JDialog owner) throws Exception {
        super(owner, true);
        initComponents();
        RSAnimation.setMoverIzquierda(1050, 900, 15, 4, this);
        cliente = new Cliente();
        tipo_accion = ACCION_CREAR;
        gestionarClienteServicio = new GestionarClienteServicio();
        this.setLocationRelativeTo(null);
        txtCodigo.setText(String.valueOf(gestionarClienteServicio.obtenerUltimoCodigo() + 1));
    }

    public FormDatosCliente(JDialog owner, Cliente cliente) throws Exception {
        super(owner, true);
        initComponents();
        RSAnimation.setMoverIzquierda(1050, 900, 15, 4, this);
        this.cliente = cliente;
        tipo_accion = ACCION_MODIFICAR;
        gestionarClienteServicio = new GestionarClienteServicio();
        this.setLocationRelativeTo(null);

        llenarCampos();

    }

    private void llenarCampos() {
        txtCodigo.setText(String.valueOf(cliente.getClienteCodigo()));
        txtNombre.setText(cliente.getClienteNombre());
        txtApellidoPaterno.setText(cliente.getClientePaterno());
        txtApellidoMatero.setText(cliente.getClienteMaterno());
        txtDni.setText(cliente.getClienteDni());
        if (cliente.getClienteEstado().equals(cliente.ESTADO_ACTIVO)) {
            cboEstado.setSelectedIndex(0);
        } else {
            cboEstado.setSelectedIndex(1);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCerrar = new rojerusan.RSButtonMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtCodigo = new rojeru_san.RSMTextFull();
        txtNombre = new rojeru_san.RSMTextFull();
        txtApellidoPaterno = new rojeru_san.RSMTextFull();
        txtApellidoMatero = new rojeru_san.RSMTextFull();
        txtDni = new rojeru_san.RSMTextFull();
        cboEstado = new rojerusan.RSComboMetro();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        rSLabelImage5 = new rojerusan.RSLabelImage();
        rSLabelImage6 = new rojerusan.RSLabelImage();
        rSLabelImage7 = new rojerusan.RSLabelImage();
        rSLabelImage8 = new rojerusan.RSLabelImage();
        rSLabelImage9 = new rojerusan.RSLabelImage();
        jPanel3 = new javax.swing.JPanel();
        btnGurdar = new rojeru_san.RSButton();
        btnCancelar = new rojeru_san.RSButton();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(68, 138, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(68, 138, 255));

        btnCerrar.setBackground(new java.awt.Color(204, 0, 0));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        btnCerrar.setBorder(dropShadowBorder1);
        btnCerrar.setText("X");
        btnCerrar.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnCerrar.setGrosorLinea(4);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setIconTextGap(0);
        btnCerrar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Datos del Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addGap(85, 85, 85)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 370, 35));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShadowColor(new java.awt.Color(0, 200, 81));
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        jPanel4.setBorder(dropShadowBorder2);

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder3.setShadowColor(new java.awt.Color(0, 200, 81));
        dropShadowBorder3.setShowLeftShadow(true);
        dropShadowBorder3.setShowTopShadow(true);
        txtCodigo.setBorder(dropShadowBorder3);
        txtCodigo.setForeground(new java.awt.Color(68, 138, 255));
        txtCodigo.setBordeColorFocus(new java.awt.Color(68, 138, 255));
        txtCodigo.setBotonColor(new java.awt.Color(0, 200, 81));
        txtCodigo.setEnabled(false);
        txtCodigo.setPlaceholder("CÓDIGO");

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder4 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder4.setShowLeftShadow(true);
        dropShadowBorder4.setShowTopShadow(true);
        txtNombre.setBorder(dropShadowBorder4);
        txtNombre.setForeground(new java.awt.Color(68, 138, 255));
        txtNombre.setBordeColorFocus(new java.awt.Color(68, 138, 255));
        txtNombre.setBotonColor(new java.awt.Color(0, 200, 81));
        txtNombre.setPlaceholder("NOMBRE");
        txtNombre.setSoloLetras(true);

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder5 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder5.setShowLeftShadow(true);
        dropShadowBorder5.setShowTopShadow(true);
        txtApellidoPaterno.setBorder(dropShadowBorder5);
        txtApellidoPaterno.setForeground(new java.awt.Color(68, 138, 255));
        txtApellidoPaterno.setBordeColorFocus(new java.awt.Color(68, 138, 255));
        txtApellidoPaterno.setBotonColor(new java.awt.Color(0, 200, 81));
        txtApellidoPaterno.setPlaceholder("APELLIDO PATERNO");
        txtApellidoPaterno.setSoloLetras(true);

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder6 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder6.setShowLeftShadow(true);
        dropShadowBorder6.setShowTopShadow(true);
        txtApellidoMatero.setBorder(dropShadowBorder6);
        txtApellidoMatero.setForeground(new java.awt.Color(68, 138, 255));
        txtApellidoMatero.setBordeColorFocus(new java.awt.Color(68, 138, 255));
        txtApellidoMatero.setBotonColor(new java.awt.Color(0, 200, 81));
        txtApellidoMatero.setPlaceholder("APELLIDO MATERNO");
        txtApellidoMatero.setSoloLetras(true);

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder7 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder7.setShowLeftShadow(true);
        dropShadowBorder7.setShowTopShadow(true);
        txtDni.setBorder(dropShadowBorder7);
        txtDni.setForeground(new java.awt.Color(68, 138, 255));
        txtDni.setBordeColorFocus(new java.awt.Color(68, 138, 255));
        txtDni.setBotonColor(new java.awt.Color(0, 200, 81));
        txtDni.setPlaceholder("DNI");
        txtDni.setSoloNumeros(true);
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));
        cboEstado.setColorArrow(new java.awt.Color(68, 138, 255));
        cboEstado.setColorBorde(new java.awt.Color(68, 138, 255));
        cboEstado.setColorFondo(new java.awt.Color(68, 138, 255));

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/clientecodigo.png"))); // NOI18N

        rSLabelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/clientenombre.png"))); // NOI18N

        rSLabelImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/clientenombre.png"))); // NOI18N

        rSLabelImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/dnimozo.png"))); // NOI18N

        rSLabelImage8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/clientenombre.png"))); // NOI18N

        rSLabelImage9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/estaditipoproducto.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoMatero, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(txtDni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSLabelImage5, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidoMatero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 43, 347, 380));

        jPanel3.setBackground(new java.awt.Color(68, 138, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(btnGurdar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 45));

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
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 150, 45));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 315, 367, 186));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_formMouseDragged

    private void btnGurdarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGurdarActionPerformed

        cliente.setClienteCodigo(Integer.parseInt(txtCodigo.getText()));
        cliente.setClienteNombre(txtNombre.getText());
        cliente.setClientePaterno(txtApellidoPaterno.getText().toString());
        cliente.setClienteMaterno(txtApellidoMatero.getText().toString());
        cliente.setClienteDni(txtDni.getText().toString());
        if (cboEstado.getSelectedItem().toString().equals("ACTIVO")) {
            cliente.setClienteEstado(Cliente.ESTADO_ACTIVO);
        } else if (cboEstado.getSelectedItem().toString().equals("INACTIVO")) {
            cliente.setClienteEstado(Cliente.ESTADO_INACTIVO);
        }
        int registros_afectados;
        if (tipo_accion == ACCION_CREAR) {
            try {
                registros_afectados = gestionarClienteServicio.guardarCliente(cliente);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeCreacion(this);
                    DesktopNotify.showDesktopMessage("FiveCod software", "Usted Acaba crear un nuevo Cliente", 7);
                    this.dispose();
                } else {
                    Mensaje.mostrarAdvertenciaDeCreacion(this);
                }

            } catch (Exception e) {
                Mensaje.mostrarErrorDeCreacion(this);

            }
        } else if (tipo_accion == ACCION_MODIFICAR) {
            try {
                registros_afectados = gestionarClienteServicio.modificarCliente(cliente);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeActualizacion(this);
                    this.dispose();
                } else {
                    Mensaje.mostrarAdvertenciaDeActualizacion(this);
                }

            } catch (Exception e) {
                Mensaje.mostrarErrorDeActualizacion(this);
            }
        }
    }//GEN-LAST:event_btnGurdarActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        String patron_de_entrada = "0123456789";
        if (txtDni.getText().length() == 8
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnCancelar;
    private rojerusan.RSButtonMetro btnCerrar;
    private rojeru_san.RSButton btnGurdar;
    private rojerusan.RSComboMetro cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private rojerusan.RSLabelImage rSLabelImage4;
    private rojerusan.RSLabelImage rSLabelImage5;
    private rojerusan.RSLabelImage rSLabelImage6;
    private rojerusan.RSLabelImage rSLabelImage7;
    private rojerusan.RSLabelImage rSLabelImage8;
    private rojerusan.RSLabelImage rSLabelImage9;
    private rojeru_san.RSMTextFull txtApellidoMatero;
    private rojeru_san.RSMTextFull txtApellidoPaterno;
    private rojeru_san.RSMTextFull txtCodigo;
    private rojeru_san.RSMTextFull txtDni;
    private rojeru_san.RSMTextFull txtNombre;
    // End of variables declaration//GEN-END:variables
}
