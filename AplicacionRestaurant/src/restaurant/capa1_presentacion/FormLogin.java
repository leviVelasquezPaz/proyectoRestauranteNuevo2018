/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import java.util.Timer;
import javax.swing.JFrame;
import restaurant.capa1_presentacion.util.AWTUtilitiesFC;
import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarUsuarioServicio;
import restaurant.capa3_dominio.IniciarSesion;
import restaurant.capa3_dominio.Usuario;
import rojeru_san.RSPanelsSlider;

/**
 *
 * @author Antonio AB
 */
public class FormLogin extends javax.swing.JFrame {

    private int x, y;

    GestionarUsuarioServicio gestionarUsuarioServicio;
    //public static Usuario usuario;

    public FormLogin() {
        this.setUndecorated(true);
        initComponents();
        AWTUtilitiesFC.setOpaque(this, false);
        this.setLocationRelativeTo(null);
        gestionarUsuarioServicio = new GestionarUsuarioServicio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow2 = new rojeru_san.RSPanelShadow();
        fiveCodPanelGradiente1 = new fivecodpanelgradiente.FiveCodPanelGradiente();
        jLabel5 = new javax.swing.JLabel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        btnCerrar = new rojerusan.RSButtonMetro();
        txtDni = new rojeru_san.RSMTextFull();
        txtContraseña = new rojeru_san.RSMPassView();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        rSLabelImage5 = new rojerusan.RSLabelImage();
        btnSalir = new rojerusan.RSButtonHover();
        btnLogin = new rojerusan.RSButtonHover();
        jSeparator3 = new javax.swing.JSeparator();
        labelMetroICM4 = new com.icm.components.metro.LabelMetroICM();
        jSeparator4 = new javax.swing.JSeparator();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        pnlSliderFiveCodSoft = new rojerusan.RSPanelsSlider();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSLabelImage2 = new rojerusan.RSLabelImage();
        rSLabelImage3 = new rojerusan.RSLabelImage();
        jLabel3 = new javax.swing.JLabel();
        rSLabelImage1 = new rojerusan.RSLabelImage();
        jLabel4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblFechaActual1 = new javax.swing.JLabel();
        lblFechaActual = new javax.swing.JLabel();
        pnSaliderUsuario = new rojerusan.RSPanelsSlider();
        pnlFiveCod = new javax.swing.JPanel();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        labelMetroICM1 = new com.icm.components.metro.LabelMetroICM();
        rSLabelImage7 = new rojerusan.RSLabelImage();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlUsuario = new javax.swing.JPanel();
        labelMetroICM2 = new com.icm.components.metro.LabelMetroICM();
        lblNombreUsuario = new javax.swing.JLabel();
        rSProgressCircleAnimated1 = new rojerusan.RSProgressCircleAnimated();
        labelMetroICM3 = new com.icm.components.metro.LabelMetroICM();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fiveCodPanelGradiente1.setColorPrimario(new java.awt.Color(255, 187, 51));
        fiveCodPanelGradiente1.setColorSecundario(new java.awt.Color(0, 153, 204));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BIENVENIDO AL SISTEMA");

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/sistea.png"))); // NOI18N

        btnCerrar.setBackground(new java.awt.Color(255, 68, 68));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        btnCerrar.setBorder(dropShadowBorder1);
        btnCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrar.setText("X");
        btnCerrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnCerrar.setGrosorLinea(4);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setIconTextGap(0);
        btnCerrar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelImage1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelImage1Layout.createSequentialGroup()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 92, Short.MAX_VALUE))
        );

        txtDni.setText("73531482");
        txtDni.setPlaceholder("INGRESE USUARIO...");
        txtDni.setSoloNumeros(true);
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        txtContraseña.setText("123");
        txtContraseña.setPlaceholder("INGRESE CONTRASEÑA...");

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/login.png"))); // NOI18N

        rSLabelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/lock.png"))); // NOI18N

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setBorder(null);
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/sinup.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setColorHover(new java.awt.Color(253, 173, 1));
        btnSalir.setColorText(new java.awt.Color(0, 0, 0));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setBorder(null);
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/singing.png"))); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.setColorHover(new java.awt.Color(253, 173, 1));
        btnLogin.setColorText(new java.awt.Color(0, 0, 0));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        labelMetroICM4.setForeground(new java.awt.Color(255, 255, 255));
        labelMetroICM4.setText("LOGIN");
        labelMetroICM4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout fiveCodPanelGradiente1Layout = new javax.swing.GroupLayout(fiveCodPanelGradiente1);
        fiveCodPanelGradiente1.setLayout(fiveCodPanelGradiente1Layout);
        fiveCodPanelGradiente1Layout.setHorizontalGroup(
            fiveCodPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                .addGroup(fiveCodPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(labelMetroICM4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addComponent(jSeparator4)
            .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                .addGroup(fiveCodPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(fiveCodPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        fiveCodPanelGradiente1Layout.setVerticalGroup(
            fiveCodPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMetroICM4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fiveCodPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(fiveCodPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fiveCodPanelGradiente1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fiveCodPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rSPanelShadow2Layout = new javax.swing.GroupLayout(rSPanelShadow2);
        rSPanelShadow2.setLayout(rSPanelShadow2Layout);
        rSPanelShadow2Layout.setHorizontalGroup(
            rSPanelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fiveCodPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rSPanelShadow2Layout.setVerticalGroup(
            rSPanelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fiveCodPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(rSPanelShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -1, 300, 430));

        rSPanelShadow1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                rSPanelShadow1MouseDragged(evt);
            }
        });
        rSPanelShadow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rSPanelShadow1MousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlSliderFiveCodSoft.setName("pnlSliderFiveCodSoft"); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("FiveCod Software");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("974265233-926557678");

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/logintelefono.png"))); // NOI18N

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/logingmail.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("fivecods@gmail.com");

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/logingoogle.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("www.fivecod.com");

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(35, 114, 194));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Versión 1.0");

        lblFechaActual1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lblFechaActual1.setForeground(new java.awt.Color(35, 114, 194));
        lblFechaActual1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaActual1.setText("FiveCod Software 2018");

        lblFechaActual.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lblFechaActual.setForeground(new java.awt.Color(35, 114, 194));
        lblFechaActual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaActual.setText("© Derechos reservados ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel2))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel4))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechaActual)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel24))
                                    .addComponent(lblFechaActual1))
                                .addGap(10, 10, 10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFechaActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFechaActual1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSliderFiveCodSoft.add(jPanel2, "card2");

        pnSaliderUsuario.setName("pnSaliderUsuario"); // NOI18N

        pnlFiveCod.setBackground(new java.awt.Color(255, 255, 255));
        pnlFiveCod.setName("pnlFiveCod"); // NOI18N

        labelMetroICM1.setText("Hora:");
        labelMetroICM1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        rSLabelImage7.setBackground(new java.awt.Color(255, 255, 255));
        rSLabelImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/logo.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("UCV - 2018 - I");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Jornada de Investigacion ");

        javax.swing.GroupLayout pnlFiveCodLayout = new javax.swing.GroupLayout(pnlFiveCod);
        pnlFiveCod.setLayout(pnlFiveCodLayout);
        pnlFiveCodLayout.setHorizontalGroup(
            pnlFiveCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiveCodLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlFiveCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(pnlFiveCodLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFiveCodLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(pnlFiveCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFiveCodLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(labelMetroICM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        pnlFiveCodLayout.setVerticalGroup(
            pnlFiveCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiveCodLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiveCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFiveCodLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(labelMetroICM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pnSaliderUsuario.add(pnlFiveCod, "card2");

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShadowSize(4);
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        pnlUsuario.setBorder(dropShadowBorder2);
        pnlUsuario.setName("pnlUsuario"); // NOI18N

        labelMetroICM2.setText("BIENVENIDO ");
        labelMetroICM2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreUsuario.setText("USUARIO");

        rSProgressCircleAnimated1.setBackground(new java.awt.Color(0, 200, 81));
        rSProgressCircleAnimated1.setForeground(new java.awt.Color(255, 204, 0));
        rSProgressCircleAnimated1.setVelocidad(20);

        labelMetroICM3.setText("Espere un Momento......");
        labelMetroICM3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlUsuarioLayout = new javax.swing.GroupLayout(pnlUsuario);
        pnlUsuario.setLayout(pnlUsuarioLayout);
        pnlUsuarioLayout.setHorizontalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSProgressCircleAnimated1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlUsuarioLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelMetroICM3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreUsuario)
                    .addComponent(labelMetroICM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        pnlUsuarioLayout.setVerticalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelMetroICM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSProgressCircleAnimated1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMetroICM3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnSaliderUsuario.add(pnlUsuario, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlSliderFiveCodSoft, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                .addComponent(pnSaliderUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSliderFiveCodSoft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnSaliderUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(rSPanelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 750, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void rSPanelShadow1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelShadow1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_rSPanelShadow1MousePressed

    private void rSPanelShadow1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelShadow1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_rSPanelShadow1MouseDragged
    Timer timer = null;
    int contador = 32;
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
               try {

            TimerTask timertask;
            String dni = txtDni.getText().trim();
            String password = txtContraseña.getText();
            Usuario usuario = gestionarUsuarioServicio.verificarUsuario(dni, password);
            if (usuario != null) {
                btnLogin.setEnabled(true);
                btnSalir.setEnabled(false);
                pnSaliderUsuario.slidPanel(5, pnlUsuario, rojerusan.RSPanelsSlider.direct.Right);
                lblNombreUsuario.setText(usuario.getUsuarioNombre());
                timer = new Timer();
                class mitimer extends TimerTask {

                    JFrame a;

                    public mitimer(JFrame form) {
                        a = form;
                    }

                    @Override
                    public void run() {
                        try {
                            if (contador == 300) {
                                timer.cancel();                                
                                a.dispose();
                                IniciarSesion.setUsuario(usuario);
                                JFrame principal = IniciarSesion.crearInicioSesion();
                                principal.setVisible(true);

                            }
                            contador++;

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }

                    }

                }

                timer.schedule(new mitimer(this), 0, 2);

            } else {
                Mensaje.mostrarAdvertencia(null, "Usuario incorrecto");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (!btnSalir.isSelected()) {
            btnSalir.setSelected(true);
            btnLogin.setSelected(false);
            pnSaliderUsuario.slidPanel(5, pnlFiveCod, rojerusan.RSPanelsSlider.direct.Right);
        }

    }//GEN-LAST:event_btnSalirActionPerformed

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
//            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormLogin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro btnCerrar;
    private rojerusan.RSButtonHover btnLogin;
    private rojerusan.RSButtonHover btnSalir;
    private fivecodpanelgradiente.FiveCodPanelGradiente fiveCodPanelGradiente1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private com.icm.components.metro.LabelMetroICM labelMetroICM1;
    private com.icm.components.metro.LabelMetroICM labelMetroICM2;
    private com.icm.components.metro.LabelMetroICM labelMetroICM3;
    private com.icm.components.metro.LabelMetroICM labelMetroICM4;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel lblFechaActual1;
    private javax.swing.JLabel lblNombreUsuario;
    private rojerusan.RSPanelsSlider pnSaliderUsuario;
    private javax.swing.JPanel pnlFiveCod;
    private rojerusan.RSPanelsSlider pnlSliderFiveCodSoft;
    private javax.swing.JPanel pnlUsuario;
    private rojeru_san.RSLabelHora rSLabelHora1;
    private rojerusan.RSLabelImage rSLabelImage1;
    private rojerusan.RSLabelImage rSLabelImage2;
    private rojerusan.RSLabelImage rSLabelImage3;
    private rojerusan.RSLabelImage rSLabelImage4;
    private rojerusan.RSLabelImage rSLabelImage5;
    private rojerusan.RSLabelImage rSLabelImage7;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private rojeru_san.RSPanelShadow rSPanelShadow2;
    private rojerusan.RSProgressCircleAnimated rSProgressCircleAnimated1;
    private rojeru_san.RSMPassView txtContraseña;
    private rojeru_san.RSMTextFull txtDni;
    // End of variables declaration//GEN-END:variables
}
