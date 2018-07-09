/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import java.util.List;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;
import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarClienteServicio;
import restaurant.capa2_aplicacion.GestionarTipoProductoServicio;
import restaurant.capa3_dominio.TipoProducto;

/**
 *
 * @author INGENIERIA
 */
public class FormGestionarTipoProducto extends javax.swing.JDialog {

    private TipoProducto tipoProducto;
    private List<TipoProducto> listaTipoProducto;
    private GestionarTipoProductoServicio gestionarTipoProductoServicio;
    private FormDatosTipoProducto formDatosTipoProducto;

    public FormGestionarTipoProducto(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        gestionarTipoProductoServicio = new GestionarTipoProductoServicio();
        listaTipoProducto = gestionarTipoProductoServicio.mostrarTipoProductos();

        inicializarTabla();
        obtenerDatosTabla();
        inabilitarBotones(true);
    }

    private void inicializarTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        tabla.agregarColumna(new Columna("Descripcion", "java.lang.String"));
        tabla.agregarColumna(new Columna("Estado", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaTipoProductos.setModel(modeloTabla);

    }

    private void obtenerDatosTabla() {
        Fila filaTabla;

        try {
            ModeloTabla modeloTabla = (ModeloTabla) tablaTipoProductos.getModel();
            modeloTabla.eliminarTotalFilas();
            for (TipoProducto tipoProducto : listaTipoProducto) {
                filaTabla = new Fila();
                filaTabla.agregarValorCelda(tipoProducto.getTipoProductoCodigo());
                filaTabla.agregarValorCelda(tipoProducto.getTipoProductoNombre());
                filaTabla.agregarValorCelda(tipoProducto.getTipoProductoDescripcion());
                filaTabla.agregarValorCelda(tipoProducto.getTipoProductoEstado());

                modeloTabla.agregarFila(filaTabla);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }

    private void inabilitarBotones(boolean v) {
        btnCancelar.setEnabled(v);
        btnCrear.setEnabled(v);
        btnEliminar.setEnabled(!v);
        btnModificar.setEnabled(!v);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        rSPanelImage4 = new rojerusan.RSPanelImage();
        btnCrear = new rojeru_san.RSButton();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new rojeru_san.RSButton();
        btnEliminar = new rojeru_san.RSButton();
        btnCancelar = new rojeru_san.RSButton();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rSButtonMetro5 = new rojerusan.RSButtonMetro();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        txtBuscar = new org.jdesktop.swingx.JXSearchField();
        btnBuscar = new rojeru_san.RSButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTipoProductos = new rojerusan.RSTableMetro();

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(68, 138, 255)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(68, 138, 255));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel1.setBorder(dropShadowBorder1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(68, 138, 255)));

        rSPanelImage4.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelImage4.setImagen(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/logo.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage4Layout = new javax.swing.GroupLayout(rSPanelImage4);
        rSPanelImage4.setLayout(rSPanelImage4Layout);
        rSPanelImage4Layout.setHorizontalGroup(
            rSPanelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rSPanelImage4Layout.setVerticalGroup(
            rSPanelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnCrear.setBackground(new java.awt.Color(68, 138, 255));
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/crear.png"))); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setColorHover(new java.awt.Color(253, 173, 1));
        btnCrear.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCrear.setIconTextGap(0);
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Menu de Opciones");

        btnModificar.setBackground(new java.awt.Color(68, 138, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setColorHover(new java.awt.Color(253, 173, 1));
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnModificar.setIconTextGap(0);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(68, 138, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setColorHover(new java.awt.Color(253, 173, 1));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminar.setIconTextGap(0);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(68, 138, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(253, 173, 1));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.setIconTextGap(0);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        rSLabelHora1.setForeground(new java.awt.Color(68, 138, 255));
        rSLabelHora1.setFont(new java.awt.Font("Roboto Bold", 1, 10)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(68, 138, 255)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Mantenedor Gestionar Tipo Producto");

        rSButtonMetro5.setBackground(new java.awt.Color(204, 0, 0));
        rSButtonMetro5.setText("X");
        rSButtonMetro5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rSButtonMetro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jXLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel6.setText("Nombre del Tipo Producto:");
        jXLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(68, 138, 255)));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setPrompt("Digite nombre del tipo de producto...");
        txtBuscar.setSearchMode(null);

        btnBuscar.setBackground(new java.awt.Color(68, 138, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/buscardatos.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setColorHover(new java.awt.Color(253, 173, 1));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        jPanel7.setBorder(dropShadowBorder2);

        tablaTipoProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaTipoProductos.setAltoHead(30);
        tablaTipoProductos.setColorBackgoundHead(new java.awt.Color(68, 138, 255));
        tablaTipoProductos.setColorSelBackgound(new java.awt.Color(253, 173, 1));
        tablaTipoProductos.setGrosorBordeFilas(0);
        tablaTipoProductos.setGrosorBordeHead(0);
        tablaTipoProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaTipoProductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTipoProductos);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro5ActionPerformed
        dispose();
    }//GEN-LAST:event_rSButtonMetro5ActionPerformed

    private void tablaTipoProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTipoProductosMousePressed
        int fila = tablaTipoProductos.getSelectedRow();
        String codigo = tablaTipoProductos.getValueAt(fila, 0).toString();
        try {
            tipoProducto = gestionarTipoProductoServicio.buscarPorCodigo(Integer.parseInt(codigo.trim()));
            inabilitarBotones(false);

        } catch (Exception e) {
            Mensaje.mostrarErrorSistema(this);
        }
    }//GEN-LAST:event_tablaTipoProductosMousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_formMouseDragged

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            FormDatosTipoProducto h = new FormDatosTipoProducto(this);
            h.setVisible(true);
            listaTipoProducto = gestionarTipoProductoServicio.mostrarTipoProductos();
            obtenerDatosTabla();
            inabilitarBotones(true);
        } catch (Exception e) {
            Mensaje.mostrarFilaNoExiste(this);
        }


    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            formDatosTipoProducto = new FormDatosTipoProducto(this, tipoProducto);
            formDatosTipoProducto.setVisible(true);
            listaTipoProducto = gestionarTipoProductoServicio.mostrarTipoProductos();
            obtenerDatosTabla();
            tipoProducto = null;
            inabilitarBotones(true);
        } catch (Exception e) {
            Mensaje.mostrarFilaNoExiste(this);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (!txtBuscar.getText().equals("")) {
                tipoProducto = null;
                listaTipoProducto = gestionarTipoProductoServicio.buscarPorNombre(txtBuscar.getText().trim());
                obtenerDatosTabla();
                txtBuscar.setText("");
            } else {
                tipoProducto = null;
                listaTipoProducto = gestionarTipoProductoServicio.mostrarTipoProductos();
                obtenerDatosTabla();
                txtBuscar.setText("");
            }

        } catch (Exception ex) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tipoProducto != null) {
            if (!Mensaje.mostrarPreguntaDeEliminacion(this)) {
                return;
            }

            try {
                int registros_afectados = gestionarTipoProductoServicio.eliminarTipoProducto(tipoProducto);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeEliminacion(this);
                    tipoProducto = null;
                    listaTipoProducto = gestionarTipoProductoServicio.mostrarTipoProductos();
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
    int x, y;
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnBuscar;
    private rojeru_san.RSButton btnCancelar;
    private rojeru_san.RSButton btnCrear;
    private rojeru_san.RSButton btnEliminar;
    private rojeru_san.RSButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private rojerusan.RSButtonMetro rSButtonMetro5;
    private rojeru_san.RSLabelHora rSLabelHora1;
    private rojerusan.RSPanelImage rSPanelImage4;
    private rojerusan.RSTableMetro tablaTipoProductos;
    private org.jdesktop.swingx.JXSearchField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
