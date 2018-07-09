/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import restaurant.capa1_presentacion.util.DesktopNotify;
import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarUsuarioServicio;
import restaurant.capa3_dominio.TipoUsuario;

import restaurant.capa3_dominio.Usuario;
import rojerusan.RSAnimation;

/**
 *
 * @author Antonio AB
 */
public class FormDatosUsuario extends javax.swing.JDialog {

    private String TIPO_MASCULINO = "MASCULINO";
    private String TIPO_FEMENINO = "FEMENINO";
    private String TIPO_ACTIVO = "ACTIVO";
    private String TIPO_INACTIVO = "INACTIVO";
    private int x, y;
    private GestionarUsuarioServicio gestionarUsuarioServicio;
    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion;
    private Usuario usuario;

    private List<TipoUsuario> listaTipoUsuario = new ArrayList<>();

    public FormDatosUsuario(JDialog owner) throws Exception {
        super(owner, true);
        initComponents();
        RSAnimation.setMoverIzquierda(1050, 900, 15, 3, this);
        usuario = new Usuario();
        tipo_accion = ACCION_CREAR;
        gestionarUsuarioServicio = new GestionarUsuarioServicio();
        listaTipoUsuario = gestionarUsuarioServicio.mostrarTiposUsuarios();
        this.setLocationRelativeTo(null);
        txtCodigo.setText(String.valueOf(gestionarUsuarioServicio.obtenerUltimoCodigo() + 1));
        cargarTipoUsuario();

    }

    public FormDatosUsuario(JDialog owner, Usuario usuario) throws Exception {
        super(owner, true);
        initComponents();
        RSAnimation.setMoverIzquierda(1050, 900, 15, 3, this);
        this.usuario = usuario;
        tipo_accion = ACCION_MODIFICAR;
        gestionarUsuarioServicio = new GestionarUsuarioServicio();
        listaTipoUsuario = gestionarUsuarioServicio.mostrarTiposUsuarios();
        this.setLocationRelativeTo(null);
        cargarTipoUsuario();
        llenarCampos();

    }

    void cargarTipoUsuario() {
        cboTipoUsuario.removeAllItems();
        for (TipoUsuario tipoUsuario : listaTipoUsuario) {
            cboTipoUsuario.addItem(tipoUsuario.getTipoUsuarioNombre());
        }

    }

    private TipoUsuario obtenerTipoUsuario(String nombre) {
        TipoUsuario tipoUsuarioUax = null;
        for (TipoUsuario tipoUsuario : listaTipoUsuario) {
            if (tipoUsuario.getTipoUsuarioNombre().equals(nombre)) {
                tipoUsuarioUax = tipoUsuario;

            }
        }
        return tipoUsuarioUax;
    }

    private void llenarCampos() {
        txtCodigo.setText(String.valueOf(usuario.getUsuarioCodigo()));
        txtApellidoMaterno.setText(usuario.getUsuarioMaterno());
        txtApellidoPaterno.setText(usuario.getUsuarioPaterno());
        txtNombreUsuario.setText(usuario.getUsuarioNombre());
        txtDni.setText(usuario.getUsuarioDni());
        txtPassword.setText(usuario.getUsuarioPassword());

        cboTipoUsuario.setSelectedItem(usuario.getTipoUsuario().getTipoUsuarioNombre());

        if (usuario.getUsuarioSexo().equals(Usuario.GENERO_MASCULINO)) {
            cboGenero.setSelectedIndex(0);
        } else {
            cboGenero.setSelectedIndex(1);
        }

        if (usuario.getUsuarioEstado().equals(Usuario.ESTADO_ACTIVO)) {
            cboEstado.setSelectedIndex(0);
        } else {
            cboEstado.setSelectedIndex(1);
        }
        ;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        rSPanelsSlider2 = new rojerusan.RSPanelsSlider();
        btnCerrar2 = new rojerusan.RSButtonMetro();
        jLabel1 = new javax.swing.JLabel();
        rSPanelsSlider4 = new rojerusan.RSPanelsSlider();
        txtCodigo = new rojeru_san.RSMTextFull();
        txtApellidoPaterno = new rojeru_san.RSMTextFull();
        txtApellidoMaterno = new rojeru_san.RSMTextFull();
        txtNombreUsuario = new rojeru_san.RSMTextFull();
        txtDni = new rojeru_san.RSMTextFull();
        txtPassword = new rojeru_san.RSMTextFull();
        cboGenero = new rojerusan.RSComboMetro();
        cboEstado = new rojerusan.RSComboMetro();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        rSLabelImage5 = new rojerusan.RSLabelImage();
        rSLabelImage6 = new rojerusan.RSLabelImage();
        rSLabelImage7 = new rojerusan.RSLabelImage();
        rSLabelImage8 = new rojerusan.RSLabelImage();
        rSLabelImage9 = new rojerusan.RSLabelImage();
        rSLabelImage10 = new rojerusan.RSLabelImage();
        rSLabelImage11 = new rojerusan.RSLabelImage();
        cboTipoUsuario = new rojerusan.RSComboMetro();
        rSLabelImage12 = new rojerusan.RSLabelImage();
        rSPanelsSlider3 = new rojerusan.RSPanelsSlider();
        btnCancelar = new rojeru_san.RSButton();
        btnGuardar = new rojeru_san.RSButton();

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

        rSPanelsSlider1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelsSlider1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(68, 138, 255)));
        rSPanelsSlider1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelsSlider2.setBackground(new java.awt.Color(68, 138, 255));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Datos del Usuario");

        javax.swing.GroupLayout rSPanelsSlider2Layout = new javax.swing.GroupLayout(rSPanelsSlider2);
        rSPanelsSlider2.setLayout(rSPanelsSlider2Layout);
        rSPanelsSlider2Layout.setHorizontalGroup(
            rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelsSlider2Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addComponent(btnCerrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        rSPanelsSlider2Layout.setVerticalGroup(
            rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelsSlider2Layout.createSequentialGroup()
                .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(rSPanelsSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 334, -1));

        rSPanelsSlider4.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        rSPanelsSlider4.setBorder(dropShadowBorder2);

        txtCodigo.setEnabled(false);
        txtCodigo.setPlaceholder("CÓDIGO");

        txtApellidoPaterno.setPlaceholder("APELLIDO PATERNO");
        txtApellidoPaterno.setSoloLetras(true);

        txtApellidoMaterno.setPlaceholder("APELLIDO MATERNO");
        txtApellidoMaterno.setSoloLetras(true);

        txtNombreUsuario.setPlaceholder("NOMBRE");
        txtNombreUsuario.setSoloLetras(true);

        txtDni.setPlaceholder("DNI");
        txtDni.setSoloNumeros(true);
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        txtPassword.setPlaceholder("PASSWORD");

        cboGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO", " " }));

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO", " " }));

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/nombremozo.png"))); // NOI18N

        rSLabelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/codigotipoproducto.png"))); // NOI18N

        rSLabelImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/mozorestaurant.png"))); // NOI18N

        rSLabelImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/nombremozo.png"))); // NOI18N

        rSLabelImage8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/genero.png"))); // NOI18N

        rSLabelImage9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/dnimozo.png"))); // NOI18N

        rSLabelImage10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/pas.png"))); // NOI18N

        rSLabelImage11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/estaditipoproducto.png"))); // NOI18N

        cboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", " " }));

        rSLabelImage12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/tipouser.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelsSlider4Layout = new javax.swing.GroupLayout(rSPanelsSlider4);
        rSPanelsSlider4.setLayout(rSPanelsSlider4Layout);
        rSPanelsSlider4Layout.setHorizontalGroup(
            rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelsSlider4Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelsSlider4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelsSlider4Layout.createSequentialGroup()
                        .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rSPanelsSlider4Layout.createSequentialGroup()
                        .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rSLabelImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelsSlider4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(rSPanelsSlider4Layout.createSequentialGroup()
                        .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        rSPanelsSlider4Layout.setVerticalGroup(
            rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelsSlider4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelsSlider4Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelsSlider4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSLabelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTipoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelsSlider4Layout.createSequentialGroup()
                        .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelsSlider4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelsSlider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(rSPanelsSlider4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 51, 310, 500));

        rSPanelsSlider3.setBackground(new java.awt.Color(68, 138, 255));
        rSPanelsSlider3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rSPanelsSlider3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/cancelripoprudcto.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(253, 173, 1));
        btnCancelar.setColorText(new java.awt.Color(68, 138, 255));
        rSPanelsSlider3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 150, 45));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/savetipoproducto.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setColorHover(new java.awt.Color(253, 173, 1));
        btnGuardar.setColorText(new java.awt.Color(68, 138, 255));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        rSPanelsSlider3.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 45));

        rSPanelsSlider1.add(rSPanelsSlider3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 296, 334, 333));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        usuario.setUsuarioCodigo(Integer.parseInt(txtCodigo.getText()));
        usuario.setUsuarioNombre(txtNombreUsuario.getText());
        usuario.setUsuarioPaterno(txtApellidoPaterno.getText());
        usuario.setUsuarioMaterno(txtApellidoMaterno.getText());
        usuario.setUsuarioDni(txtDni.getText());
        usuario.setUsuarioPassword(txtPassword.getText());
        usuario.setTipoUsuario(obtenerTipoUsuario(cboTipoUsuario.getSelectedItem().toString()));
        if (cboGenero.getSelectedItem().toString().equals(TIPO_MASCULINO)) {
            usuario.setUsuarioSexo(Usuario.GENERO_MASCULINO);
        } else if (cboGenero.getSelectedItem().toString().equals(TIPO_FEMENINO)) {
            usuario.setUsuarioSexo(Usuario.GENERO_FEMENINO);
        }
        if (cboEstado.getSelectedItem().toString().equals(TIPO_ACTIVO)) {
            usuario.setUsuarioEstado(Usuario.ESTADO_ACTIVO);
        } else if (cboEstado.getSelectedItem().toString().equals(TIPO_INACTIVO)) {
            usuario.setUsuarioEstado(Usuario.ESTADO_INACTIVO);
        }
        int registros_afectados;
        if (tipo_accion == ACCION_CREAR) {
            try {
                registros_afectados = gestionarUsuarioServicio.guardarUsuario(usuario);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeCreacion(this);
                    DesktopNotify.showDesktopMessage("FiveCod software", "Usted Acaba crear un nuevo Usuario", 7);

                    this.dispose();
                } else {
                    Mensaje.mostrarAdvertenciaDeCreacion(this);
                }

            } catch (Exception e) {
                Mensaje.mostrarErrorDeCreacion(this);

            }
        } else if (tipo_accion == ACCION_MODIFICAR) {
            try {
                registros_afectados = gestionarUsuarioServicio.modificarUsuario(usuario);
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
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        String patron_de_entrada = "0123456789";
        if (txtDni.getText().length() == 8
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnCancelar;
    private rojerusan.RSButtonMetro btnCerrar2;
    private rojeru_san.RSButton btnGuardar;
    private rojerusan.RSComboMetro cboEstado;
    private rojerusan.RSComboMetro cboGenero;
    private rojerusan.RSComboMetro cboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private rojerusan.RSLabelImage rSLabelImage10;
    private rojerusan.RSLabelImage rSLabelImage11;
    private rojerusan.RSLabelImage rSLabelImage12;
    private rojerusan.RSLabelImage rSLabelImage4;
    private rojerusan.RSLabelImage rSLabelImage5;
    private rojerusan.RSLabelImage rSLabelImage6;
    private rojerusan.RSLabelImage rSLabelImage7;
    private rojerusan.RSLabelImage rSLabelImage8;
    private rojerusan.RSLabelImage rSLabelImage9;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private rojerusan.RSPanelsSlider rSPanelsSlider2;
    private rojerusan.RSPanelsSlider rSPanelsSlider3;
    private rojerusan.RSPanelsSlider rSPanelsSlider4;
    private rojeru_san.RSMTextFull txtApellidoMaterno;
    private rojeru_san.RSMTextFull txtApellidoPaterno;
    private rojeru_san.RSMTextFull txtCodigo;
    private rojeru_san.RSMTextFull txtDni;
    private rojeru_san.RSMTextFull txtNombreUsuario;
    private rojeru_san.RSMTextFull txtPassword;
    // End of variables declaration//GEN-END:variables
}
