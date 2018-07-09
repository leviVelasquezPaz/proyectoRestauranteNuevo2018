/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;
import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarUsuarioServicio;
import restaurant.capa3_dominio.Usuario;

/**
 *
 * @author Antonio AB
 */
public class FormGestionarUsuario extends javax.swing.JDialog {

    private List<Usuario> listaUsuario = new ArrayList<Usuario>();
    private GestionarUsuarioServicio gestionarUsuarioServicio;
    public static Usuario usuarioSeleccionado;
    private FormDatosUsuario formDatosUsuario;
    public static String TIPO_SELECCION_PEDIDO = "DESDE PEDIDO";
    public static String TIPO_SELECCION_REGISTRO = "DESDE REGISTRO";
    private String TIPO_SELECCION = "";
    private int x, y;

    public FormGestionarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        usuarioSeleccionado = new Usuario();
        gestionarUsuarioServicio = new GestionarUsuarioServicio();
        listaUsuario = gestionarUsuarioServicio.mostrarUsuarios();
        inicializarTabla();
        obtenerDatosTabla();
        inabilitarBotones(true);
    }

    private void inicializarTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre completo", "java.lang.String"));
//        tabla.agregarColumna(new Columna("Paterno", "java.lang.String"));
//        tabla.agregarColumna(new Columna("Materno", "java.lang.String"));
        tabla.agregarColumna(new Columna("DNI", "java.lang.String"));
        tabla.agregarColumna(new Columna("Genero", "java.lang.String"));
        tabla.agregarColumna(new Columna("Password", "java.lang.String"));
        tabla.agregarColumna(new Columna("Estado", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaUsuario.setModel(modeloTabla);
    }

    private void obtenerDatosTabla() {
        Fila filaTabla;
        try {
            ModeloTabla modeloTabla = (ModeloTabla) tablaUsuario.getModel();
            modeloTabla.eliminarTotalFilas();
            if (listaUsuario.size() == 0) {
                JOptionPane.showMessageDialog(null, "No hay usuarios registrados ");
            } else {
                for (Usuario usuario : listaUsuario) {
                    filaTabla = new Fila();
                    filaTabla.agregarValorCelda(usuario.getUsuarioCodigo());
                    filaTabla.agregarValorCelda(usuario.getUsuarioNombre() + " " + usuario.getUsuarioPaterno() + " " + usuario.getUsuarioMaterno());
//                    filaTabla.agregarValorCelda(usuario.getUsuarioPaterno());
//                    filaTabla.agregarValorCelda(usuario.getUsuarioMaterno());
                    filaTabla.agregarValorCelda(usuario.getUsuarioDni());
                    filaTabla.agregarValorCelda(usuario.getUsuarioSexo());
                    filaTabla.agregarValorCelda(usuario.getUsuarioPassword());
                    filaTabla.agregarValorCelda(usuario.getUsuarioEstado());
                    modeloTabla.agregarFila(filaTabla);
                }
                modeloTabla.refrescarDatos();
            }

        } catch (Exception e) {
            Mensaje.mostrarErrorSistema(this);
        }

    }

    private void inabilitarBotones(Boolean v) {

        btnCrear.setEnabled(v);
        btnEliminar.setEnabled(!v);
        btnModificar.setEnabled(!v);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojerusan.RSTableMetro();
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        jPanel2 = new javax.swing.JPanel();
        btnCrear = new rojeru_san.RSButton();
        btnCancelar = new rojeru_san.RSButton();
        btnModificar = new rojeru_san.RSButton();
        btnEliminar = new rojeru_san.RSButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        rSPanelsSlider2 = new rojerusan.RSPanelsSlider();
        btnCerrar = new rojerusan.RSButtonMetro();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
        btnCrear1 = new rojeru_san.RSButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuario = new rojerusan.RSTableMetro();

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(rSTableMetro1);

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
        rSPanelsSlider1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 138, 255), 2));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(0, 199, 80));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel2.setBorder(dropShadowBorder1);

        btnCrear.setBackground(new java.awt.Color(68, 138, 255));
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/crear.png"))); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setColorHover(new java.awt.Color(253, 173, 1));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(68, 138, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(253, 173, 1));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(68, 138, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setColorHover(new java.awt.Color(253, 173, 1));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(68, 138, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setColorHover(new java.awt.Color(253, 173, 1));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Menu de Opciones");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(68, 138, 255)));

        rSPanelImage1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/logo.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        rSLabelHora1.setForeground(new java.awt.Color(68, 138, 255));
        rSLabelHora1.setFont(new java.awt.Font("Roboto Bold", 1, 10)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        rSPanelsSlider2.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelsSlider2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(68, 138, 255)));

        btnCerrar.setBackground(new java.awt.Color(255, 0, 51));
        btnCerrar.setText("X");
        btnCerrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnCerrar.setGrosorLinea(3);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mantenedor de Gestionar Usuario");

        javax.swing.GroupLayout rSPanelsSlider2Layout = new javax.swing.GroupLayout(rSPanelsSlider2);
        rSPanelsSlider2.setLayout(rSPanelsSlider2Layout);
        rSPanelsSlider2Layout.setHorizontalGroup(
            rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelsSlider2Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        rSPanelsSlider2Layout.setVerticalGroup(
            rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelsSlider2Layout.createSequentialGroup()
                .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("N° del Usuario:");

        jXSearchField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(68, 138, 255)));
        jXSearchField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jXSearchField1.setToolTipText("Digite N° de DNI del Usuario");
        jXSearchField1.setPrompt("Digite N° de DNI del Mozo");

        btnCrear1.setBackground(new java.awt.Color(68, 138, 255));
        btnCrear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/buscardatos.png"))); // NOI18N
        btnCrear1.setText("Buscar");
        btnCrear1.setColorHover(new java.awt.Color(253, 173, 1));

        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaUsuario.setAltoHead(35);
        tablaUsuario.setColorBackgoundHead(new java.awt.Color(68, 138, 255));
        tablaUsuario.setColorSelBackgound(new java.awt.Color(253, 173, 1));
        tablaUsuario.setGrosorBordeFilas(0);
        tablaUsuario.setGrosorBordeHead(0);
        tablaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaUsuarioMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaUsuario);

        javax.swing.GroupLayout rSPanelsSlider1Layout = new javax.swing.GroupLayout(rSPanelsSlider1);
        rSPanelsSlider1.setLayout(rSPanelsSlider1Layout);
        rSPanelsSlider1Layout.setHorizontalGroup(
            rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSPanelsSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                        .addGroup(rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelsSlider1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCrear1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(13, 13, 13))))
        );
        rSPanelsSlider1Layout.setVerticalGroup(
            rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                .addComponent(rSPanelsSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jXSearchField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCrear1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            FormDatosUsuario f = new FormDatosUsuario(this);
            f.setVisible(true);
            listaUsuario = gestionarUsuarioServicio.mostrarUsuarios();
            obtenerDatosTabla();
            usuarioSeleccionado = null;
            inabilitarBotones(true);

        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            formDatosUsuario = new FormDatosUsuario(this, usuarioSeleccionado);
            formDatosUsuario.setVisible(true);
            listaUsuario = gestionarUsuarioServicio.mostrarUsuarios();
            obtenerDatosTabla();
            usuarioSeleccionado = null;
            inabilitarBotones(true);
        } catch (Exception e) {
            Mensaje.mostrarFilaNoExiste(this);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tablaUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuarioMousePressed
        int fila = tablaUsuario.getSelectedRow();
        String codigo = tablaUsuario.getValueAt(fila, 0).toString();
        try {
            usuarioSeleccionado = gestionarUsuarioServicio.buscarUsuarioPorCodigo(Integer.parseInt(codigo.trim()));
            if (TIPO_SELECCION == TIPO_SELECCION_PEDIDO) {
                FormRegistrarPedido.usuario = usuarioSeleccionado;
                this.dispose();
            } else {
                inabilitarBotones(false);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tablaUsuarioMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (usuarioSeleccionado != null) {
            if (!Mensaje.mostrarPreguntaDeEliminacion(this)) {
                return;
            }

            try {
                int registros_afectados = gestionarUsuarioServicio.eliminarUsuario(usuarioSeleccionado);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeEliminacion(this);
                    listaUsuario = gestionarUsuarioServicio.mostrarUsuarios();
                    obtenerDatosTabla();
                    inabilitarBotones(true);
                } else {
                    Mensaje.mostrarAdvertenciaDeEliminacion(this);
                }

            } catch (Exception e) {
                Mensaje.mostrarErrorDeEliminacion(this);
            }
        } else {
            Mensaje.mostrarErrorSistema(this);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        inabilitarBotones(true);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnCancelar;
    private rojerusan.RSButtonMetro btnCerrar;
    private rojeru_san.RSButton btnCrear;
    private rojeru_san.RSButton btnCrear1;
    private rojeru_san.RSButton btnEliminar;
    private rojeru_san.RSButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXSearchField jXSearchField1;
    private rojeru_san.RSLabelHora rSLabelHora1;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private rojerusan.RSPanelsSlider rSPanelsSlider2;
    private rojerusan.RSTableMetro rSTableMetro1;
    private rojerusan.RSTableMetro tablaUsuario;
    // End of variables declaration//GEN-END:variables
}
