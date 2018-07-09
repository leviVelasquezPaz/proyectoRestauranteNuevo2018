/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.postgresql.jdbc2.optional.SimpleDataSource;
import restaurant.capa1_presentacion.util.DesktopNotify;
import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarProductoServicio;

import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;

import rojerusan.RSAnimation;

/**
 *
 * @author GRUPO
 */
public class FormDatosProducto extends javax.swing.JDialog {

    private int x, y;
    private GestionarProductoServicio gestionarProductoServicio;
    private List<TipoProducto> listaProductos;
    private Producto producto;
    private SimpleDateFormat format;
    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion;

    public FormDatosProducto(JDialog owner) throws Exception {
        super(owner, true);
        initComponents();
        RSAnimation.setMoverIzquierda(1050, 900, 15, 3, this);
        producto = new Producto();
        tipo_accion = ACCION_CREAR;
        gestionarProductoServicio = new GestionarProductoServicio();
        this.setLocationRelativeTo(null);
        inicializadores();
        txtCodigo.setText(String.valueOf(gestionarProductoServicio.obtenerUltimoCodigo() + 1));

    }

    public FormDatosProducto(JDialog owner, Producto producto) throws Exception {
        super(owner, true);
        initComponents();
        RSAnimation.setMoverIzquierda(1050, 900, 15, 3, this);
        this.producto = producto;
        tipo_accion = ACCION_MODIFICAR;
        gestionarProductoServicio = new GestionarProductoServicio();
        this.setLocationRelativeTo(null);
        llenarListasTipoProductos();
        llenarCampos();

    }

    private void llenarCampos() {
        txtCodigo.setText(String.valueOf(producto.getProductoCodigo()));
        txtNombre.setText(String.valueOf(producto.getProductoNombre()));
        txtDescripcion.setText(String.valueOf(producto.getProductoDescripcion()));

        txtStock.setText(String.valueOf(producto.getProdcutoStock()));
        cboTipoProducto.setSelectedItem(producto.getTipoDeProducto().getTipoProductoNombre());
        lblFechaRegistro.setText(String.valueOf(producto.getProductoFechaRegistro()));
        if (producto.getTipoDeProducto().getTipoProductoNombre().equals("Entradas")) {
            txtPrecio.setEnabled(false);
        }
        txtPrecio.setText(String.valueOf(producto.getProductoPrecio()));
        if (producto.getProductoEstado().equals(Producto.ESTADO_ACTIVO)) {
            cboEstado.setSelectedIndex(0);
        } else {
            cboEstado.setSelectedIndex(1);
        }
    }

    private void inicializadores() {
        try {
            this.tipo_accion = ACCION_CREAR;
            format = new SimpleDateFormat("dd-MM-yyyy");
            lblFechaRegistro.setText(format.format(java.sql.Date.valueOf(LocalDate.now())));
            llenarListasTipoProductos();
        } catch (Exception e) {

        }
    }

    private TipoProducto buscarTipoProducto(String nombreTipoProducto) {
        TipoProducto auxTipoProducto = null;
        for (TipoProducto tipoProducto : listaProductos) {
            if (nombreTipoProducto.equals(tipoProducto.getTipoProductoNombre().trim())) {
                auxTipoProducto = tipoProducto;
            }
        }
        return auxTipoProducto;
    }

    //METODOS 
    private void llenarListasTipoProductos() throws Exception {
        cboTipoProducto.removeAllItems();
        listaProductos = gestionarProductoServicio.mostrarTiposProductos();
        for (TipoProducto tipoProducto : listaProductos) {
            cboTipoProducto.addItem(tipoProducto.getTipoProductoNombre());
        }
        cboTipoProducto.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCerrar2 = new rojerusan.RSButtonMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtNombre = new rojeru_san.RSMTextFull();
        txtDescripcion = new rojeru_san.RSMTextFull();
        txtPrecio = new rojeru_san.RSMTextFull();
        txtStock = new rojeru_san.RSMTextFull();
        lblFechaRegistro = new rojeru_san.RSMTextFull();
        txtCodigo = new rojeru_san.RSMTextFull();
        cboEstado = new rojerusan.RSComboMetro();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        rSLabelImage3 = new rojerusan.RSLabelImage();
        rSLabelImage5 = new rojerusan.RSLabelImage();
        rSLabelImage6 = new rojerusan.RSLabelImage();
        rSLabelImage7 = new rojerusan.RSLabelImage();
        rSLabelImage9 = new rojerusan.RSLabelImage();
        rSLabelImage10 = new rojerusan.RSLabelImage();
        rSLabelImage8 = new rojerusan.RSLabelImage();
        cboTipoProducto = new rojerusan.RSComboMetro();
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
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(110, 110, 110)
                .addComponent(btnCerrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        txtNombre.setPlaceholder("NOMBRE");
        txtNombre.setSoloLetras(true);

        txtDescripcion.setPlaceholder("DESCRIPCIÓN");

        txtPrecio.setPlaceholder("PRECIO");
        txtPrecio.setSoloNumeros(true);

        txtStock.setPlaceholder("STOCK");
        txtStock.setSoloNumeros(true);

        lblFechaRegistro.setEnabled(false);
        lblFechaRegistro.setPlaceholder("FECHA REGISTRO");

        txtCodigo.setEnabled(false);
        txtCodigo.setPlaceholder("CÓDIGO");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/codigotipoproducto.png"))); // NOI18N

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/nombretipoproducto.png"))); // NOI18N

        rSLabelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/nombretipoproducto.png"))); // NOI18N

        rSLabelImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/precioproducto.png"))); // NOI18N

        rSLabelImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/stockproducto.png"))); // NOI18N

        rSLabelImage9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/fechaproducto.png"))); // NOI18N

        rSLabelImage10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/estaditipoproducto.png"))); // NOI18N

        rSLabelImage8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/productotipo.png"))); // NOI18N

        cboTipoProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", " ", " ", " ", " ", " " }));
        cboTipoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cboTipoProductoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage10, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage9, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage7, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage6, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rSLabelImage8, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSLabelImage10, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 38, 380, 450));

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
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 150, 46));

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
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 150, 46));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 307, 410, 257));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 414, 565));

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

        producto.setProductoNombre(txtNombre.getText());
        producto.setProductoDescripcion(txtDescripcion.getText().toString());
        producto.setProdcutoStock(Integer.parseInt(txtStock.getText().toString()));
        producto.setProductoCodigo(Integer.parseInt(txtCodigo.getText()));
        producto.setTipoDeProducto(buscarTipoProducto(cboTipoProducto.getSelectedItem().toString()));
        producto.setProductoPrecio(Double.parseDouble(txtPrecio.getText().toString()));
        if (cboEstado.getSelectedItem().toString().equals("ACTIVO")) {
            producto.setProductoEstado(Producto.ESTADO_ACTIVO);
        } else if (cboEstado.getSelectedItem().toString().equals("INACTIVO")) {
            producto.setProductoEstado(Producto.ESTADO_INACTIVO);
        }
//        Date productpfechaRegistro = null;
//        productpfechaRegistro = Date.valueOf(LocalDate.now());
        int registros_afectados;
        if (tipo_accion == ACCION_CREAR) {
            try {
                registros_afectados = gestionarProductoServicio.guardarProducto(producto);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeCreacion(this);
                    DesktopNotify.showDesktopMessage("FiveCod software", "Usted Acaba crear un nuevo Producto", 7);

                    this.dispose();
                } else {
                    Mensaje.mostrarAdvertenciaDeCreacion(this);
                }

            } catch (Exception e) {
                Mensaje.mostrarErrorDeCreacion(this);

            }
        } else if (tipo_accion == ACCION_MODIFICAR) {
            try {
                registros_afectados = gestionarProductoServicio.modificarProducto(producto);
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
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cboTipoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboTipoProductoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (cboTipoProducto.getSelectedItem().equals("Entradas")) {
                txtPrecio.setEnabled(false);
                txtPrecio.setText("" + 0);
            } else {
                txtPrecio.setText("");
                txtPrecio.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cboTipoProductoKeyTyped

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnAgregar;
    private rojeru_san.RSButton btnCancelar;
    private rojerusan.RSButtonMetro btnCerrar2;
    private rojerusan.RSComboMetro cboEstado;
    private rojerusan.RSComboMetro cboTipoProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private rojeru_san.RSMTextFull lblFechaRegistro;
    private rojerusan.RSLabelImage rSLabelImage10;
    private rojerusan.RSLabelImage rSLabelImage3;
    private rojerusan.RSLabelImage rSLabelImage4;
    private rojerusan.RSLabelImage rSLabelImage5;
    private rojerusan.RSLabelImage rSLabelImage6;
    private rojerusan.RSLabelImage rSLabelImage7;
    private rojerusan.RSLabelImage rSLabelImage8;
    private rojerusan.RSLabelImage rSLabelImage9;
    private rojeru_san.RSMTextFull txtCodigo;
    private rojeru_san.RSMTextFull txtDescripcion;
    private rojeru_san.RSMTextFull txtNombre;
    private rojeru_san.RSMTextFull txtPrecio;
    private rojeru_san.RSMTextFull txtStock;
    // End of variables declaration//GEN-END:variables
}
