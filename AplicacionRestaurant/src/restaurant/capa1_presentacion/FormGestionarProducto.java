/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import restaurant.capa1_presentacion.util.ConfiguradorDeTabla;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.spi.RegisterableService;
import javax.swing.JOptionPane;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;
import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarProductoServicio;
import restaurant.capa2_aplicacion.RegistrarPedidoServicio;
import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;

/**
 *
 * @author Antonio AB
 */
public class FormGestionarProducto extends javax.swing.JDialog {

    private GestionarProductoServicio gestionarProductoServicio;
    public Producto productoSeleccionado;
    private FormDatosProducto formDatosProducto;
    private List<TipoProducto> listaTipoProducto = new ArrayList<>();
    private List<Producto> listaProducto = new ArrayList<>();

    public FormGestionarProducto(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        gestionarProductoServicio = new GestionarProductoServicio();
        listaProducto = gestionarProductoServicio.mostrarProducto();
        listaTipoProducto = gestionarProductoServicio.mostrarTiposProductos();
        inicializarTabla();
        obtenerDatosTabla();

        inabilitarBotones(true);
        cargarComboboxTipoProducto();
    }

    private void inicializarTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Producto", "java.lang.String"));
        tabla.agregarColumna(new Columna("Precio", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Stock", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Tipo producto", "java.lang.String"));
        tabla.agregarColumna(new Columna("Estado", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaProductos.setModel(modeloTabla);

    }

    private void inabilitarBotones(Boolean v) {
        btnCancelar.setEnabled(v);
        btnCrear.setEnabled(v);
        btnEliminar.setEnabled(!v);
        btnModificar.setEnabled(!v);
    }

    void cargarComboboxTipoProducto() {
        cbxTipoProducto.removeAllItems();
        for (TipoProducto tipoProducto : listaTipoProducto) {
            cbxTipoProducto.addItem(tipoProducto.getTipoProductoNombre());
        }

    }

    int devolverIdTipoProducto(String nombre) {
        int codigo = -1;
        for (TipoProducto tipoProducto : listaTipoProducto) {
            if (tipoProducto.getTipoProductoNombre().equals(nombre)) {
                codigo = tipoProducto.getTipoProductoCodigo();
            }
        }
        return codigo;
    }

    private void obtenerDatosTabla() {
        Fila filaTabla;
        try {

            ModeloTabla modeloTabla = (ModeloTabla) tablaProductos.getModel();
            modeloTabla.eliminarTotalFilas();
            if (listaProducto.size() == 0) {
                JOptionPane.showMessageDialog(null, "No hay productos registrados ");
            } else {
                for (Producto producto : listaProducto) {
                    filaTabla = new Fila();
                    filaTabla.agregarValorCelda(producto.getProductoCodigo());
                    filaTabla.agregarValorCelda(producto.getProductoNombre());
                    filaTabla.agregarValorCelda(producto.getProductoPrecio());
                    filaTabla.agregarValorCelda(producto.getProdcutoStock());
                    filaTabla.agregarValorCelda(producto.getTipoDeProducto().getTipoProductoNombre());
                    filaTabla.agregarValorCelda(producto.getProductoEstado());
                    modeloTabla.agregarFila(filaTabla);
                }
                modeloTabla.refrescarDatos();
            }

        } catch (Exception e) {
            Mensaje.mostrarErrorSistema(this);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCrear = new rojeru_san.RSButton();
        btnCancelar = new rojeru_san.RSButton();
        btnModificar = new rojeru_san.RSButton();
        btnEliminar = new rojeru_san.RSButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new rojerusan.RSTableMetro();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        btnBuscar = new rojerusan.RSButtonIconI();
        txtBuscar = new org.jdesktop.swingx.JXSearchField();
        jPanel5 = new javax.swing.JPanel();
        rSButtonMetro5 = new rojerusan.RSButtonMetro();
        jLabel2 = new javax.swing.JLabel();
        cbxTipoProducto = new rojerusan.RSComboMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("“SOFTWARE DE RESTAURANT CON DISEÑO ARQUITECTURAL N-CAPAS”");
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(68, 138, 255));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel2.setBorder(dropShadowBorder1);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Menu de Opciones");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(68, 138, 255)));

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(btnCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShadowColor(new java.awt.Color(0, 200, 81));
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        jPanel4.setBorder(dropShadowBorder2);

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProductos.setAltoHead(30);
        tablaProductos.setColorBackgoundHead(new java.awt.Color(68, 138, 255));
        tablaProductos.setColorSelBackgound(new java.awt.Color(253, 173, 1));
        tablaProductos.setGrosorBordeFilas(0);
        tablaProductos.setGrosorBordeHead(0);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        jXLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel6.setText("Nombre del Producto:");
        jXLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(68, 138, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/buscardatos.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setColorHover(new java.awt.Color(253, 173, 1));
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(68, 138, 255)));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setLayoutStyle(null);
        txtBuscar.setName(""); // NOI18N
        txtBuscar.setPrompt("Digite nombre del producto....");
        txtBuscar.setSearchMode(null);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(68, 138, 255)));

        rSButtonMetro5.setBackground(new java.awt.Color(204, 0, 0));
        rSButtonMetro5.setText("X");
        rSButtonMetro5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rSButtonMetro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setText("Mantenedor de Gestionar Producto");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(182, 182, 182)
                .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        cbxTipoProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", " ", " ", " ", " ", " " }));
        cbxTipoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbxTipoProductoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(cbxTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed
        int fila = tablaProductos.getSelectedRow();
        String codigo = tablaProductos.getValueAt(fila, 0).toString();
        GestionarProductoServicio gestionarProductoServicio = new GestionarProductoServicio();
        try {
            productoSeleccionado = gestionarProductoServicio.buscarProductoCodigo(Integer.parseInt(codigo.trim()));
            inabilitarBotones(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tablaProductosMousePressed

    private void rSButtonMetro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro5ActionPerformed
        dispose();
    }//GEN-LAST:event_rSButtonMetro5ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (!txtBuscar.getText().equals("")) {
                listaProducto = null;
                listaProducto = gestionarProductoServicio.buscarProductoPorNombre(txtBuscar.getText().trim());
                obtenerDatosTabla();
                txtBuscar.setText("");
            } else {
                listaProducto = null;
                listaProducto = gestionarProductoServicio.mostrarProducto();
                obtenerDatosTabla();
                txtBuscar.setText("");
            }

        } catch (Exception ex) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_formMouseDragged

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            FormDatosProducto h = new FormDatosProducto(this);
            h.setVisible(true);
            listaProducto = gestionarProductoServicio.mostrarProducto();
            obtenerDatosTabla();
            inabilitarBotones(true);
        } catch (Exception e) {
            Mensaje.mostrarFilaNoExiste(this);
        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            formDatosProducto = new FormDatosProducto(this, productoSeleccionado);
            formDatosProducto.setVisible(true);
            listaProducto = gestionarProductoServicio.mostrarProducto();
            obtenerDatosTabla();
            productoSeleccionado = null;
            inabilitarBotones(true);
        } catch (Exception e) {
            Mensaje.mostrarFilaNoExiste(this);
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (productoSeleccionado != null) {
            if (!Mensaje.mostrarPreguntaDeEliminacion(this)) {
                return;
            }
            try {
                int registros_afectados = gestionarProductoServicio.eliminarProducto(productoSeleccionado);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeEliminacion(this);
                    listaProducto = gestionarProductoServicio.mostrarProducto();
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

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped


    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        inabilitarBotones(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxTipoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTipoProductoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                int codigoTipoProducto = devolverIdTipoProducto(cbxTipoProducto.getSelectedItem().toString());
                listaProducto = gestionarProductoServicio.mostrarPorTipoProducto(codigoTipoProducto);
                obtenerDatosTabla();
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(this, "Error ");
            }

        }
    }//GEN-LAST:event_cbxTipoProductoKeyTyped
    int x, y;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI btnBuscar;
    private rojeru_san.RSButton btnCancelar;
    private rojeru_san.RSButton btnCrear;
    private rojeru_san.RSButton btnEliminar;
    private rojeru_san.RSButton btnModificar;
    private rojerusan.RSComboMetro cbxTipoProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private rojerusan.RSButtonMetro rSButtonMetro5;
    private rojeru_san.RSLabelHora rSLabelHora1;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSTableMetro tablaProductos;
    private org.jdesktop.swingx.JXSearchField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
