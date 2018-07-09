/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import restaurant.capa1_presentacion.util.Mensaje;
import restaurant.capa2_aplicacion.GestionarReporteServicio;
import restaurant.capa2_aplicacion.RegistrarPedidoServicio;
import restaurant.capa3_dominio.Cliente;
import restaurant.capa3_dominio.FabricaEstrategiaDescuento;
import restaurant.capa3_dominio.IniciarSesion;
import restaurant.capa3_dominio.LineaPedido;
import restaurant.capa3_dominio.Mesa;
import restaurant.capa3_dominio.Usuario;
import restaurant.capa3_dominio.Pedido;
import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;

/**
 *
 * @author Antonio AB
 */
public class FormRegistrarPedido extends javax.swing.JDialog {
    
    private int x, y;
    public static Cliente cliente = null;
    public static Usuario usuario = null;
    public static Mesa mesa = null;
    private Producto producto = null;
    private Pedido pedido = null;
    private GestionarReporteServicio gestionarReporteServicio;
    private TipoProducto tipoProductoSeleccionado;
    private List<Producto> listaProductoUaxiliar = new ArrayList<Producto>();
    private List<Producto> listaProductoCompleto = new ArrayList<Producto>();
    private List<TipoProducto> listaTipoProducto = new ArrayList<TipoProducto>();
    
    private RegistrarPedidoServicio registrarPedidoServicio;
    private FormGestionarUsuario formGestionarUsuario;
    private FormGestionarMesaPanoramica formGestionarMesa;
    
    private final int ACCION_CREAR = 1;
    private final int ACCION_IMPRIMIR = 2;
    private int tipo_accion;
    
    private boolean verificarComponentes = false;
    
    public FormRegistrarPedido(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.cliente = null;
        this.usuario = null;
        this.mesa = null;
        this.producto = null;        
        tipo_accion = ACCION_CREAR;
        pedido = new Pedido();
        this.usuario = IniciarSesion.getUsuario();
        btnImprimir.setVisible(false);
        txtDniMozo.setText(usuario.getUsuarioDni());
        lblNombreMozo.setText(usuario.getUsuarioNombre());
        registrarPedidoServicio = new RegistrarPedidoServicio();
        pedido.setPedidoCodigo(registrarPedidoServicio.obtenerUltimoCodigo() + 1);
        FabricaEstrategiaDescuento fabricaEstrategia = FabricaEstrategiaDescuento.crearInstancia();
        pedido.setEstrategiaDescuento(fabricaEstrategia.crearEstrategiaDescuento());
        llenarComboboxTipoProducto();
        inicializarTablaLineaPedido();
        inicializarTablaProducto();
        panelOpcionesLineaPedido.setVisible(false);
        
    }
    
    public FormRegistrarPedido(java.awt.Frame parent, boolean modal, Mesa mesa) throws Exception {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.mesa = mesa;
        gestionarReporteServicio = new GestionarReporteServicio();
        tipo_accion = ACCION_IMPRIMIR;
        registrarPedidoServicio = new RegistrarPedidoServicio();
        pedido = registrarPedidoServicio.buscarPedidoPorMesa(mesa);
        FabricaEstrategiaDescuento fabricaEstrategia = FabricaEstrategiaDescuento.crearInstancia();
        pedido.setEstrategiaDescuento(fabricaEstrategia.crearEstrategiaDescuento());
        txtDniCliente.setText(pedido.getCliente().getClienteDni());
        txtDniMozo.setText(pedido.getUsuario().getUsuarioDni());
        txtMesa.setText("" + mesa.getMesaNumero());
        this.cliente = pedido.getCliente();
        this.usuario = pedido.getUsuario();
        llenarComboboxTipoProducto();
        inicializarTablaLineaPedido();
        inicializarTablaProducto();
        llenarTablaLineaPedido();
        inabiliarAccionImprimir(false);
    }
    
    void inabiliarAccionImprimir(boolean estado) {
        tablaPedidos.setEnabled(estado);
        tablaPrdocutos.setEnabled(estado);
        cbxTipoProducto.setEnabled(estado);
        tablaPedidos.setEnabled(estado);
        tablaPedidos.setEnabled(estado);
        btnBuscarCliente.setEnabled(estado);
        btnBuscarMesa.setEnabled(estado);
        panelOpcionesLineaPedido.setVisible(estado);
        btnRegistrar.setVisible(estado);
        
    }
    
    private void llenarComboboxTipoProducto() {
        try {
            cbxTipoProducto.removeAllItems();
            listaTipoProducto = registrarPedidoServicio.mostrarTipoProducto();
            for (TipoProducto tipoProducto : listaTipoProducto) {
                cbxTipoProducto.addItem(tipoProducto.getTipoProductoNombre());
            }
        } catch (Exception e) {
            Mensaje.mostrarErrorSistema(this);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Metodos ">  
    private void limpiarCampos() {
        txtFechaRegistro.setText("");
        
        producto = null;
        txtTotalProdcutosLista.setText("");
        txtPrecioTotal.setText("");
        txtPagoTotal.setText("");
        txtDescuento.setText("");
        
    }
    
    private void inicializarPedido() {
        cliente = null;
        mesa = null;
        usuario = null;
        producto = null;
    }
    
    private int devolverTipoProducto(String nombre) {
        int codigo = -1;
        try {
            for (TipoProducto tipoProducto : listaTipoProducto) {
                if (tipoProducto.getTipoProductoNombre().equals(nombre)) {
                    codigo = tipoProducto.getTipoProductoCodigo();
                }
            }
            return codigo;
        } catch (Exception e) {
            Mensaje.mostrarErrorSistema(this);
        }
        return codigo;
    }
    
    private void llenarTablaProductos(int codigo) {
        try {
            listaProductoUaxiliar = registrarPedidoServicio.buscarPorTipoProducto(codigo);
            Fila filaTabla;
            ModeloTabla modeloTabla = (ModeloTabla) tablaPrdocutos.getModel();
            modeloTabla.eliminarTotalFilas();
            if (listaProductoUaxiliar.size() == 0) {
                Mensaje.mostrarAdvertencia(this, "No hay productos registrados ");
            } else {
                for (Producto producto : listaProductoUaxiliar) {
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
        }
        
    }
    
    private void inicializarTablaLineaPedido() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Producto", "java.lang.String"));
        tabla.agregarColumna(new Columna("Precio", "java.lang.Double"));
        tabla.agregarColumna(new Columna("cantidad", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Total", "java.lang.Integer"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaPedidos.setModel(modeloTabla);
    }
    
    private void inicializarTablaProducto() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Producto", "java.lang.String"));
        tabla.agregarColumna(new Columna("Precio", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Stock", "java.lang.Integer"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaPrdocutos.setModel(modeloTabla);
    }
    
    private void estadoBotonRegistro(boolean estado) {
        btnRegistrar.setEnabled(estado);
    }
    
    private void limpiarTablaLineaPedido() {
        ModeloTabla modelo = (ModeloTabla) tablaPedidos.getModel();
        modelo.eliminarTotalFilas();
    }
    
    private void limpiarTablaProductos() {
        ModeloTabla modelo = (ModeloTabla) tablaPrdocutos.getModel();
        modelo.eliminarTotalFilas();
    }
    
    void llenarTablaLineaPedido() {
        
        DecimalFormat df = new DecimalFormat("#.00");
        ModeloTabla modeloTabla = (ModeloTabla) tablaPedidos.getModel();
        Fila filaTabla;
        modeloTabla.eliminarTotalFilas();
        if (pedido.getListaLineaPedido().size() == 0) {
            Mensaje.mostrarAdvertencia(this, "No hay productos en el pedido");
        } else {
            for (LineaPedido lineaPedido : pedido.getListaLineaPedido()) {
                filaTabla = new Fila();
                filaTabla.agregarValorCelda(lineaPedido.getProducto().getProductoCodigo());
                filaTabla.agregarValorCelda(lineaPedido.getProducto().getProductoNombre());
                filaTabla.agregarValorCelda(lineaPedido.getProducto().getProductoPrecio());
                filaTabla.agregarValorCelda(lineaPedido.getCantidad());
                filaTabla.agregarValorCelda(lineaPedido.calcularSubTotal());
                modeloTabla.agregarFila(filaTabla);
            }
            modeloTabla.refrescarDatos();
            txtPrecioTotal.setText(String.valueOf(df.format(pedido.calcularPrecioTotal())));
            txtDescuento.setText(String.valueOf(df.format(pedido.CalcularDescuento())));
            txtPagoTotal.setText(String.valueOf(df.format(pedido.calculartPago())));
            txtTotalProdcutosLista.setText(String.valueOf(pedido.calcularTotalLineaPedido()));
        }
        
    }

// </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rSButtonMetro5 = new rojerusan.RSButtonMetro();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        txtFechaRegistro = new javax.swing.JLabel();
        etiiCodigo6 = new javax.swing.JLabel();
        rSButtonPane1 = new rojerusan.RSButtonPane();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtDniCliente = new rojerusan.RSMetroTextFullPlaceHolder();
        btnBuscarCliente = new rojerusan.RSButtonHover();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtDniMozo = new rojerusan.RSMetroTextFullPlaceHolder();
        etiiCodigo3 = new javax.swing.JLabel();
        txtMesa = new rojerusan.RSMetroTextFullPlaceHolder();
        btnBuscarMesa = new rojerusan.RSButtonHover();
        lblNombreMozo = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        etiiCodigo5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaPrdocutos = new rojerusan.RSTableMetro();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrar = new rojerusan.RSButtonHover();
        btnCancelar = new rojerusan.RSButtonHover();
        btnImprimir = new rojerusan.RSButtonHover();
        panelSumas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotalProdcutosLista = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtPagoTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioTotal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        cbxTipoProducto = new javax.swing.JComboBox<>();
        etiiCodigo8 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaPedidos = new rojerusan.RSTableMetro();
        panelOpcionesLineaPedido = new javax.swing.JPanel();
        btnEliminarLineaVenta = new rojerusan.RSButtonCircle();
        btnRestarLineaventa = new rojerusan.RSButtonCircle();
        btnSumarLineaVenta = new rojerusan.RSButtonCircle();

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        rSPanelsSlider1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelsSlider1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(68, 138, 255)));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(68, 138, 255)));
        jPanel1.setPreferredSize(new java.awt.Dimension(336, 45));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registro de Pedido");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(68, 138, 255)));

        rSButtonMetro5.setBackground(new java.awt.Color(204, 0, 0));
        rSButtonMetro5.setText("X");
        rSButtonMetro5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rSButtonMetro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro5ActionPerformed(evt);
            }
        });

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/logo.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        txtFechaRegistro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFechaRegistro.setText("Fecha Actual");

        etiiCodigo6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        etiiCodigo6.setText("Fecha Pedido:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiiCodigo6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaRegistro)
                            .addComponent(etiiCodigo6))
                        .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSButtonPane1.setBackground(new java.awt.Color(240, 240, 240));
        rSButtonPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(68, 138, 255)));
        rSButtonPane1.setColorHover(new java.awt.Color(240, 240, 240));
        rSButtonPane1.setColorNormal(new java.awt.Color(240, 240, 240));

        jXLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/dni.png"))); // NOI18N
        jXLabel2.setText("DNI Cliente:");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtDniCliente.setForeground(new java.awt.Color(0, 0, 0));
        txtDniCliente.setToolTipText("");
        txtDniCliente.setAutoscrolls(false);
        txtDniCliente.setBorderColor(new java.awt.Color(68, 138, 255));
        txtDniCliente.setBotonColor(new java.awt.Color(68, 138, 255));
        txtDniCliente.setEnabled(false);
        txtDniCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDniCliente.setPlaceholder("N° DNI del Cliente......");
        txtDniCliente.setSoloNumeros(true);

        btnBuscarCliente.setBackground(new java.awt.Color(68, 138, 255));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/buscardatos.png"))); // NOI18N
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.setColorHover(new java.awt.Color(253, 173, 1));
        btnBuscarCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jXLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/dni.png"))); // NOI18N
        jXLabel4.setText("DNI Mozo:");
        jXLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtDniMozo.setForeground(new java.awt.Color(0, 0, 0));
        txtDniMozo.setBorderColor(new java.awt.Color(68, 138, 255));
        txtDniMozo.setBotonColor(new java.awt.Color(68, 138, 255));
        txtDniMozo.setEnabled(false);
        txtDniMozo.setPlaceholder("N° DNI del Mozo......");
        txtDniMozo.setSoloNumeros(true);
        txtDniMozo.setxDarkIcon(true);

        etiiCodigo3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiiCodigo3.setText("Mesa:");

        txtMesa.setForeground(new java.awt.Color(0, 0, 0));
        txtMesa.setBorderColor(new java.awt.Color(68, 138, 255));
        txtMesa.setBotonColor(new java.awt.Color(68, 138, 255));
        txtMesa.setEnabled(false);
        txtMesa.setPlaceholder("Digite el N° de Mesa...");
        txtMesa.setSoloNumeros(true);

        btnBuscarMesa.setBackground(new java.awt.Color(68, 138, 255));
        btnBuscarMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/buscardatos.png"))); // NOI18N
        btnBuscarMesa.setText("Buscar");
        btnBuscarMesa.setColorHover(new java.awt.Color(253, 173, 1));
        btnBuscarMesa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMesaActionPerformed(evt);
            }
        });

        lblNombreMozo.setText("Nombre:");

        lblNombreCliente.setText("Nombre:");

        javax.swing.GroupLayout rSButtonPane1Layout = new javax.swing.GroupLayout(rSButtonPane1);
        rSButtonPane1.setLayout(rSButtonPane1Layout);
        rSButtonPane1Layout.setHorizontalGroup(
            rSButtonPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSButtonPane1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDniMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiiCodigo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSButtonPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombreMozo)
                .addGap(474, 474, 474))
            .addGroup(rSButtonPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(rSButtonPane1Layout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(lblNombreCliente)
                    .addContainerGap(886, Short.MAX_VALUE)))
        );
        rSButtonPane1Layout.setVerticalGroup(
            rSButtonPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSButtonPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rSButtonPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiiCodigo3)
                    .addComponent(txtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lblNombreMozo)
                .addContainerGap())
            .addGroup(rSButtonPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSButtonPane1Layout.createSequentialGroup()
                    .addContainerGap(71, Short.MAX_VALUE)
                    .addComponent(lblNombreCliente)
                    .addContainerGap()))
        );

        etiiCodigo5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiiCodigo5.setText("Lista productos ");

        tablaPrdocutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Título 2", "Título 3"
            }
        ));
        tablaPrdocutos.setAltoHead(30);
        tablaPrdocutos.setColorBackgoundHead(new java.awt.Color(68, 138, 255));
        tablaPrdocutos.setColorSelBackgound(new java.awt.Color(253, 173, 1));
        tablaPrdocutos.setGrosorBordeFilas(0);
        tablaPrdocutos.setGrosorBordeHead(0);
        tablaPrdocutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaPrdocutosMousePressed(evt);
            }
        });
        jScrollPane7.setViewportView(tablaPrdocutos);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(68, 138, 255)));

        btnRegistrar.setBackground(new java.awt.Color(68, 138, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/savetipoproducto.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setColorHover(new java.awt.Color(253, 173, 1));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
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

        btnImprimir.setBackground(new java.awt.Color(68, 138, 255));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa5_imagenes/imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setColorHover(new java.awt.Color(253, 173, 1));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSumas.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(68, 138, 255));
        dropShadowBorder1.setShadowSize(4);
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        panelSumas.setBorder(dropShadowBorder1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cantidad productos :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Pago Total : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Descuento :");

        txtTotalProdcutosLista.setBackground(new java.awt.Color(68, 138, 255));
        txtTotalProdcutosLista.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotalProdcutosLista.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalProdcutosLista.setEnabled(false);

        txtDescuento.setBackground(new java.awt.Color(68, 138, 255));
        txtDescuento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(255, 255, 255));
        txtDescuento.setEnabled(false);

        txtPagoTotal.setBackground(new java.awt.Color(68, 138, 255));
        txtPagoTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPagoTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtPagoTotal.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Precio Total :");

        txtPrecioTotal.setBackground(new java.awt.Color(68, 138, 255));
        txtPrecioTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrecioTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecioTotal.setEnabled(false);

        javax.swing.GroupLayout panelSumasLayout = new javax.swing.GroupLayout(panelSumas);
        panelSumas.setLayout(panelSumasLayout);
        panelSumasLayout.setHorizontalGroup(
            panelSumasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSumasLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(panelSumasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSumasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescuento)
                    .addComponent(txtPagoTotal)
                    .addComponent(txtPrecioTotal)
                    .addComponent(txtTotalProdcutosLista, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSumasLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel4});

        panelSumasLayout.setVerticalGroup(
            panelSumasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSumasLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelSumasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSumasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalProdcutosLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSumasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSumasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPagoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelSumasLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel4});

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(68, 138, 255)));

        jXLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel6.setText("Tipo Producto:");
        jXLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cbxTipoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbxTipoProductoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbxTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbxTipoProducto, jXLabel6});

        etiiCodigo8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiiCodigo8.setText("Lista de Pedido del Cliente");

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Título 2", "Título 3"
            }
        ));
        tablaPedidos.setAltoHead(30);
        tablaPedidos.setColorBackgoundHead(new java.awt.Color(68, 138, 255));
        tablaPedidos.setColorSelBackgound(new java.awt.Color(253, 173, 1));
        tablaPedidos.setGrosorBordeFilas(0);
        tablaPedidos.setGrosorBordeHead(0);
        tablaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaPedidosMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(tablaPedidos);

        panelOpcionesLineaPedido.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcionesLineaPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelOpcionesLineaPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btnEliminarLineaVenta.setBackground(new java.awt.Color(68, 138, 255));
        btnEliminarLineaVenta.setText("x");
        btnEliminarLineaVenta.setColorHover(new java.awt.Color(253, 173, 1));
        btnEliminarLineaVenta.setColorText(new java.awt.Color(204, 0, 51));
        btnEliminarLineaVenta.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnEliminarLineaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLineaVentaActionPerformed(evt);
            }
        });

        btnRestarLineaventa.setBackground(new java.awt.Color(68, 138, 255));
        btnRestarLineaventa.setText("-");
        btnRestarLineaventa.setColorHover(new java.awt.Color(253, 173, 1));
        btnRestarLineaventa.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnRestarLineaventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarLineaventaActionPerformed(evt);
            }
        });

        btnSumarLineaVenta.setBackground(new java.awt.Color(68, 138, 255));
        btnSumarLineaVenta.setText("+");
        btnSumarLineaVenta.setColorHover(new java.awt.Color(253, 173, 1));
        btnSumarLineaVenta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSumarLineaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarLineaVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLineaPedidoLayout = new javax.swing.GroupLayout(panelOpcionesLineaPedido);
        panelOpcionesLineaPedido.setLayout(panelOpcionesLineaPedidoLayout);
        panelOpcionesLineaPedidoLayout.setHorizontalGroup(
            panelOpcionesLineaPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLineaPedidoLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btnSumarLineaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRestarLineaventa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarLineaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelOpcionesLineaPedidoLayout.setVerticalGroup(
            panelOpcionesLineaPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLineaPedidoLayout.createSequentialGroup()
                .addGroup(panelOpcionesLineaPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestarLineaventa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSumarLineaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarLineaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rSPanelsSlider1Layout = new javax.swing.GroupLayout(rSPanelsSlider1);
        rSPanelsSlider1.setLayout(rSPanelsSlider1Layout);
        rSPanelsSlider1Layout.setHorizontalGroup(
            rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                .addGroup(rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(etiiCodigo5)
                        .addGap(321, 321, 321)
                        .addComponent(etiiCodigo8))
                    .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                        .addGroup(rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelSumas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelOpcionesLineaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelsSlider1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(rSButtonPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
        );
        rSPanelsSlider1Layout.setVerticalGroup(
            rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rSButtonPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiiCodigo5)
                    .addComponent(etiiCodigo8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                        .addGroup(rSPanelsSlider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelsSlider1Layout.createSequentialGroup()
                        .addComponent(panelOpcionesLineaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(panelSumas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        java.util.Date sistemaFech = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        this.txtFechaRegistro.setText(formato.format(sistemaFech));
    }//GEN-LAST:event_formWindowOpened
    
    private void limpiarTodosLosCampos() {
        try {
            pedido.limpiarListaLineaPedido();
            listaProductoCompleto = registrarPedidoServicio.mostrarProducto();
            limpiarTablaLineaPedido();
            limpiarTablaProductos();
            limpiarCampos();
            
        } catch (Exception e) {
            Mensaje.mostrarErrorSistema(this);
        }
        
    }

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_formMouseDragged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (tipo_accion == ACCION_IMPRIMIR) {
            this.dispose();
        } else {
            limpiarTodosLosCampos();
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int registros_afectados = 0;
        // Date fecha = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        txtFechaRegistro.setText(format.format(java.sql.Date.valueOf(LocalDate.now())));
        if (cliente != null) {
            if (mesa != null) {
                if (usuario != null) {
                    pedido.setImporte(pedido.calculartPago());
                    pedido.setCliente(cliente);
                    pedido.setMesa(mesa);
                    pedido.setUsuario(usuario);
                    pedido.setPedidoEstado(Pedido.ESTADO_ACTIVO);
                    if (pedido.getListaLineaPedido().size() > 0) {
                        try {
                            RegistrarPedidoServicio pedidoServicio = new RegistrarPedidoServicio();
                            registros_afectados = pedidoServicio.crearPedido(pedido);
                            if (registros_afectados == 1) {
                                Mensaje.mostrarAfirmacionDeCreacion(this);
                                inicializarPedido();
                                limpiarCampos();
                                limpiarTablaLineaPedido();
                                limpiarTodosLosCampos();
                                this.dispose();
                            } else {
                                Mensaje.mostrarErrorDeCreacion(this);
                            }
                        } catch (Exception e) {
                            Mensaje.mostrarFilaNoExiste(this);
                        }
                    } else {
                        Mensaje.mostrarAdvertencia(this, "No hubo producto seleccionador ");
                    }
                    
                } else {
                    
                    Mensaje.mostrarAdvertencia(this, "falta seleccionar el usuario");
                    
                }
            } else {
                Mensaje.mostrarAdvertencia(this, "falta seleccionar la mesa");
                
            }
        } else {
            Mensaje.mostrarAdvertencia(this, "falta seleccionar el cliente");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        FormGestionarCliente formulariocliente = new FormGestionarCliente(null, true, FormGestionarCliente.TIPO_MOZO);
        formulariocliente.setVisible(true);
        cliente = formulariocliente.clienteSeleccionado;
        if (cliente != null) {
            txtDniCliente.setText("" + cliente.getClienteDni());
            lblNombreCliente.setText("" + cliente.getClienteNombre());
        }
        

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void rSButtonMetro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_rSButtonMetro5ActionPerformed
    

    private void tablaPrdocutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPrdocutosMousePressed
        
        int fila = tablaPrdocutos.getSelectedRow();
        String codigo = tablaPrdocutos.getValueAt(fila, 0).toString();
        try {
            
            producto = registrarPedidoServicio.buscarProductoCodigo(Integer.parseInt(codigo));
            
            if (producto != null) {
                if (pedido.agregarLineaPedido(1, producto)) {
                    llenarTablaLineaPedido();
                    
                    llenarTablaProductos(devolverTipoProducto(cbxTipoProducto.getSelectedItem().toString()));
                    estadoBotonRegistro(true);
                    panelOpcionesLineaPedido.setVisible(false);
                } else {
                    Mensaje.mostrarAdvertencia(this, "No hay suficientes stock");
                    
                }
            }
        } catch (Exception e) {
        }
        

    }//GEN-LAST:event_tablaPrdocutosMousePressed

    private void cbxTipoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTipoProductoKeyTyped
        
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (cliente != null) {
                if (mesa != null) {
                    llenarTablaProductos(devolverTipoProducto(cbxTipoProducto.getSelectedItem().toString()));
                    panelOpcionesLineaPedido.setVisible(false);
                } else {
                    Mensaje.mostrarAdvertencia(this, "falta seleccionar mesa");
                }
                
            } else {
                Mensaje.mostrarAdvertencia(this, "Falta seleccionar el cliente");
            }
            
        }
    }//GEN-LAST:event_cbxTipoProductoKeyTyped
    String cantidadLineaPedido = "";
    int fila;
    private void tablaPedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPedidosMousePressed
        try {
            fila = tablaPedidos.getSelectedRow();
            String codigo = tablaPedidos.getValueAt(fila, 0).toString();
            
            producto = registrarPedidoServicio.buscarProductoCodigo(Integer.parseInt(codigo));
            panelOpcionesLineaPedido.setVisible(true);
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_tablaPedidosMousePressed

    private void btnSumarLineaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarLineaVentaActionPerformed
        if (producto != null) {
            cantidadLineaPedido = tablaPedidos.getValueAt(fila, 3).toString();
            int cantidad = Integer.parseInt(cantidadLineaPedido) + 1;
            if (pedido.modificarLineaPedido(cantidad, producto)) {
                llenarTablaLineaPedido();
            } else {
                Mensaje.mostrarAdvertencia(this, "No hay suficiente stock ");
                
            }
        }

    }//GEN-LAST:event_btnSumarLineaVentaActionPerformed

    private void btnRestarLineaventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarLineaventaActionPerformed
        if (producto != null) {
            cantidadLineaPedido = tablaPedidos.getValueAt(fila, 3).toString();
            int cantidad = Integer.parseInt(cantidadLineaPedido) - 1;
            if (cantidad == 0) {
                Mensaje.mostrarAdvertencia(this, "NO se puede tener un pedido igual a 0");
            } else {
                if (pedido.modificarLineaPedido(cantidad, producto)) {
                    llenarTablaLineaPedido();
                } else {
                    Mensaje.mostrarAdvertencia(this, "No hay suficiente stock ");
                    
                }
            }
            
        }
    }//GEN-LAST:event_btnRestarLineaventaActionPerformed

    private void btnEliminarLineaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLineaVentaActionPerformed
        if (Mensaje.mostrarPreguntaDeEliminacion(this)) {
            if (pedido.eliminarLineaPedido(producto)) {
                Mensaje.mostrarAfirmacionDeEliminacion(this);
                llenarTablaLineaPedido();
            } else {
                Mensaje.mostrarErrorDeEliminacion(this);
                
            }
        }
    }//GEN-LAST:event_btnEliminarLineaVentaActionPerformed

    private void btnBuscarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMesaActionPerformed
        try {
            FormGestionarMesaPanoramica formGestionarMesaPanoramica = new FormGestionarMesaPanoramica(null, true, FormGestionarMesaPanoramica.DE_PEDIDO);
            formGestionarMesaPanoramica.setVisible(true);
            mesa = formGestionarMesaPanoramica.mesaSeleccionada;
            if (mesa != null) {
                txtMesa.setText("" + mesa.getMesaPiso());
            }
        } catch (Exception e) {
            
        }
        

    }//GEN-LAST:event_btnBuscarMesaActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {            
            JasperPrint print = gestionarReporteServicio.mostrarRegistroPedido(mesa);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte Pedido");
            this.setVisible(false);
            view.setVisible(true);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnBuscarCliente;
    private rojerusan.RSButtonHover btnBuscarMesa;
    private rojerusan.RSButtonHover btnCancelar;
    private rojerusan.RSButtonCircle btnEliminarLineaVenta;
    private rojerusan.RSButtonHover btnImprimir;
    private rojerusan.RSButtonHover btnRegistrar;
    private rojerusan.RSButtonCircle btnRestarLineaventa;
    private rojerusan.RSButtonCircle btnSumarLineaVenta;
    private javax.swing.JComboBox<String> cbxTipoProducto;
    private javax.swing.JLabel etiiCodigo3;
    private javax.swing.JLabel etiiCodigo5;
    private javax.swing.JLabel etiiCodigo6;
    private javax.swing.JLabel etiiCodigo8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombreMozo;
    private javax.swing.JPanel panelOpcionesLineaPedido;
    private javax.swing.JPanel panelSumas;
    private rojerusan.RSButtonMetro rSButtonMetro5;
    private rojerusan.RSButtonPane rSButtonPane1;
    private rojeru_san.RSLabelHora rSLabelHora1;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private rojerusan.RSTableMetro tablaPedidos;
    private rojerusan.RSTableMetro tablaPrdocutos;
    private javax.swing.JTextField txtDescuento;
    private rojerusan.RSMetroTextFullPlaceHolder txtDniCliente;
    private rojerusan.RSMetroTextFullPlaceHolder txtDniMozo;
    private javax.swing.JLabel txtFechaRegistro;
    private rojerusan.RSMetroTextFullPlaceHolder txtMesa;
    private javax.swing.JTextField txtPagoTotal;
    private javax.swing.JTextField txtPrecioTotal;
    private javax.swing.JTextField txtTotalProdcutosLista;
    // End of variables declaration//GEN-END:variables
}
