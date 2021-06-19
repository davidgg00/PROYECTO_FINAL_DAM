package Vista;

import controlador.GestionFTP;
import controlador.GestionIngrediente;
import controlador.GestionProducto;
import controlador.Validar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 * Constructor de la clase que ejecuta el método que inicia la GUI y obtiene
 * todos los menús junto a sus productos y los añade a los jcombobox
 */
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Ingrediente;
import modelo.Producto;

/**
 * @author DavidGG
 * @version 1.0
 */
public class OpcionesProducto extends javax.swing.JFrame {

    private static ArrayList<Ingrediente> ingredientes = GestionIngrediente.getAll();
    private static ArrayList<Producto> productos;
    private static Producto productoSeleccionado;

    /**
     * Constructor de la clase que ejecuta el método que inicia la GUI y obtiene
     * todos los productos junto a sus ingredientes y los añade a los jcombobox
     */
    public OpcionesProducto() {
        initComponents();
        setLocationRelativeTo(null);
        productos = GestionProducto.getAll();
        for (Producto producto : productos) {
            elegirProduc.addItem(producto.getNombre() + "," + producto.getPrecio() + "€");
            elegirProduc_borrar.addItem(producto.getNombre() + "," + producto.getPrecio() + "€");

        }
        DefaultListModel modelo = new DefaultListModel();
        for (Ingrediente ingrediente : ingredientes) {
            modelo.addElement(ingrediente.getNombre());
        }
        listaIngredientes.setModel(modelo);
        listaIngredientes1.setModel(modelo);

        ArrayList<Integer> selecs = new ArrayList<>();

        int contador = 0;
        for (int i = 0; i < ingredientes.size(); i++) {
            try {
                if (productoSeleccionado != null && productoSeleccionado.getTipo().equalsIgnoreCase("Hamburguesa")) {
                    if (ingredientes.get(i).getId() == productoSeleccionado.getIngredientes().get(contador).getId()) {
                        selecs.add(i);
                        contador++;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
            }

        }
        listaIngredientes1.setSelectedIndices(selecs.stream().mapToInt(i -> i).toArray());

        panelFormularioCP.setBackground(new Color(181, 97, 54, 240));
        panelFormularioEP.setBackground(new Color(181, 97, 54, 240));
        panelFormularioBP.setBackground(new Color(181, 97, 54, 240));
    }

    /**
     * Método que inicia toda la GUI
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogCrearProducto = new javax.swing.JDialog();
        jPanel3 = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelHeader1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        javax.swing.JPanel panelContentCP = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelFormularioCP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        etPrecio = new javax.swing.JTextField();
        etNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaIngredientes = new javax.swing.JList<>();
        btnEnviar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etTipoProducto = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        btnSubirImagen_addproducto = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        dialogEditarProducto = new javax.swing.JDialog();
        jPanel4 = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelHeader2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        javax.swing.JPanel panelContentEP = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelFormularioEP = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaIngredientes1 = new javax.swing.JList<>();
        btnSubirImagen_edProducto = new javax.swing.JButton();
        etPrecio_ep = new javax.swing.JTextField();
        elegirProduc = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        btnEnviarEditarProducto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblImagen_ed = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        etNombre_ep = new javax.swing.JTextField();
        dialogBorrarProducto = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        panelHeader3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        javax.swing.JPanel panelContentBP = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelFormularioBP = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnBorrarEditarProducto = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        elegirProduc_borrar = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaDatosProducto_borrar = new javax.swing.JTextArea();
        lblImagen_borrarProducto = new javax.swing.JLabel();
        subirImagenaddProducto = new javax.swing.JFileChooser();
        subirImagenedProducto = new javax.swing.JFileChooser();
        jPanel1 = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcProductos.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelBotones = new JPanel() {        public void paintComponent(Graphics g) {          Image img = Toolkit.getDefaultToolkit().getImage(          "imagenes/back_opcProductos.jpg");          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);          }        };
        btnBorrarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnCrearProducto = new javax.swing.JButton();

        dialogCrearProducto.setMinimumSize(null);
        dialogCrearProducto.setResizable(false);
        dialogCrearProducto.setSize(new java.awt.Dimension(700, 700));

        jPanel3.setLayout(new java.awt.BorderLayout());

        panelHeader1.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader1.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Crear Productos");
        panelHeader1.add(jLabel7, java.awt.BorderLayout.CENTER);

        jButton2.setIcon(new javax.swing.ImageIcon("imagenes/goback.png"));
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelHeader1.add(jButton2, java.awt.BorderLayout.LINE_END);

        jPanel3.add(panelHeader1, java.awt.BorderLayout.PAGE_START);

        panelContentCP.setBackground(new java.awt.Color(181, 97, 54));
        panelContentCP.setMaximumSize(null);

        jLabel1.setText("Nombre:");

        jLabel3.setText("Precio:");

        jLabel4.setText("Ingredientes:");

        listaIngredientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaIngredientes);

        btnEnviar.setText("Añadir Producto");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jLabel5.setText("€");

        jLabel2.setText("Tipo:");

        etTipoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hamburguesa", "Bebida", "Patatas" }));
        etTipoProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                etTipoProductoItemStateChanged(evt);
            }
        });

        jLabel17.setText("Imagen:");

        btnSubirImagen_addproducto.setText("Seleccionar fich..");
        btnSubirImagen_addproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirImagen_addproductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioCPLayout = new javax.swing.GroupLayout(panelFormularioCP);
        panelFormularioCP.setLayout(panelFormularioCPLayout);
        panelFormularioCPLayout.setHorizontalGroup(
            panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioCPLayout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(btnEnviar)
                .addGap(124, 124, 124))
            .addGroup(panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFormularioCPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                    .addGroup(panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFormularioCPLayout.createSequentialGroup()
                            .addComponent(etPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addGroup(panelFormularioCPLayout.createSequentialGroup()
                            .addGroup(panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(etNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSubirImagen_addproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(etTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelFormularioCPLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(35, 35, 35)))
                    .addContainerGap()))
        );
        panelFormularioCPLayout.setVerticalGroup(
            panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioCPLayout.createSequentialGroup()
                .addContainerGap(417, Short.MAX_VALUE)
                .addComponent(btnEnviar)
                .addGap(29, 29, 29))
            .addGroup(panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFormularioCPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(etPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(etTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFormularioCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFormularioCPLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel17))
                        .addGroup(panelFormularioCPLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(btnSubirImagen_addproducto)))
                    .addGap(18, 18, 18)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(70, 70, 70)))
        );

        javax.swing.GroupLayout panelContentCPLayout = new javax.swing.GroupLayout(panelContentCP);
        panelContentCP.setLayout(panelContentCPLayout);
        panelContentCPLayout.setHorizontalGroup(
            panelContentCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentCPLayout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(panelFormularioCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        panelContentCPLayout.setVerticalGroup(
            panelContentCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentCPLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panelFormularioCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jPanel3.add(panelContentCP, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout dialogCrearProductoLayout = new javax.swing.GroupLayout(dialogCrearProducto.getContentPane());
        dialogCrearProducto.getContentPane().setLayout(dialogCrearProductoLayout);
        dialogCrearProductoLayout.setHorizontalGroup(
            dialogCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogCrearProductoLayout.setVerticalGroup(
            dialogCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogEditarProducto.setMinimumSize(null);
        dialogEditarProducto.setModal(true);
        dialogEditarProducto.setResizable(false);
        dialogEditarProducto.setSize(new java.awt.Dimension(700, 700));

        jPanel4.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel4.setLayout(new java.awt.BorderLayout());

        panelHeader2.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader2.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Editar Productos");
        panelHeader2.add(jLabel8, java.awt.BorderLayout.CENTER);

        jButton3.setIcon(new javax.swing.ImageIcon("imagenes/goback.png"));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelHeader2.add(jButton3, java.awt.BorderLayout.LINE_END);

        jPanel4.add(panelHeader2, java.awt.BorderLayout.PAGE_START);

        panelContentEP.setBackground(new java.awt.Color(181, 97, 54));
        panelContentEP.setMaximumSize(null);
        panelContentEP.setPreferredSize(new java.awt.Dimension(626, 500));

        jScrollPane2.setViewportView(listaIngredientes1);

        btnSubirImagen_edProducto.setText("Elegir Imagen");
        btnSubirImagen_edProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirImagen_edProductoActionPerformed(evt);
            }
        });

        elegirProduc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                elegirProducItemStateChanged(evt);
            }
        });

        jLabel12.setText("€");

        btnEnviarEditarProducto.setText("Editar Producto");
        btnEnviarEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarEditarProductoActionPerformed(evt);
            }
        });

        jLabel10.setText("Precio:");

        jLabel11.setText("Ingredientes:");

        jLabel9.setText("Nombre:");

        jLabel13.setText("Imagen");

        jLabel14.setText("Elegir Producto:");

        javax.swing.GroupLayout panelFormularioEPLayout = new javax.swing.GroupLayout(panelFormularioEP);
        panelFormularioEP.setLayout(panelFormularioEPLayout);
        panelFormularioEPLayout.setHorizontalGroup(
            panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioEPLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioEPLayout.createSequentialGroup()
                        .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elegirProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormularioEPLayout.createSequentialGroup()
                                    .addComponent(etPrecio_ep, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(etNombre_ep, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioEPLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubirImagen_edProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelFormularioEPLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblImagen_ed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90))))
            .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioEPLayout.createSequentialGroup()
                    .addContainerGap(144, Short.MAX_VALUE)
                    .addComponent(btnEnviarEditarProducto)
                    .addGap(122, 122, 122)))
        );
        panelFormularioEPLayout.setVerticalGroup(
            panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioEPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elegirProduc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etNombre_ep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(etPrecio_ep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubirImagen_edProducto)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImagen_ed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(panelFormularioEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFormularioEPLayout.createSequentialGroup()
                    .addContainerGap(476, Short.MAX_VALUE)
                    .addComponent(btnEnviarEditarProducto)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout panelContentEPLayout = new javax.swing.GroupLayout(panelContentEP);
        panelContentEP.setLayout(panelContentEPLayout);
        panelContentEPLayout.setHorizontalGroup(
            panelContentEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentEPLayout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(panelFormularioEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        panelContentEPLayout.setVerticalGroup(
            panelContentEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentEPLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelFormularioEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jPanel4.add(panelContentEP, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout dialogEditarProductoLayout = new javax.swing.GroupLayout(dialogEditarProducto.getContentPane());
        dialogEditarProducto.getContentPane().setLayout(dialogEditarProductoLayout);
        dialogEditarProductoLayout.setHorizontalGroup(
            dialogEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogEditarProductoLayout.setVerticalGroup(
            dialogEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogBorrarProducto.setMinimumSize(null);
        dialogBorrarProducto.setResizable(false);
        dialogBorrarProducto.setSize(new java.awt.Dimension(700, 700));

        jPanel6.setLayout(new java.awt.BorderLayout());

        panelHeader3.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader3.setLayout(new java.awt.BorderLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Borrar Productos");
        panelHeader3.add(jLabel15, java.awt.BorderLayout.CENTER);

        jButton4.setIcon(new javax.swing.ImageIcon("imagenes/goback.png"));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelHeader3.add(jButton4, java.awt.BorderLayout.LINE_END);

        jPanel6.add(panelHeader3, java.awt.BorderLayout.PAGE_START);

        panelContentBP.setBackground(new java.awt.Color(181, 97, 54));
        panelContentBP.setPreferredSize(new java.awt.Dimension(390, 521));

        jLabel16.setText("Datos:");

        btnBorrarEditarProducto.setText("Borrar Producto");
        btnBorrarEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarEditarProductoActionPerformed(evt);
            }
        });

        jLabel20.setText("Elegir Producto:");

        elegirProduc_borrar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                elegirProduc_borrarItemStateChanged(evt);
            }
        });

        jLabel21.setText("Imagen");

        listaDatosProducto_borrar.setEditable(false);
        listaDatosProducto_borrar.setColumns(20);
        listaDatosProducto_borrar.setRows(5);
        jScrollPane4.setViewportView(listaDatosProducto_borrar);

        javax.swing.GroupLayout panelFormularioBPLayout = new javax.swing.GroupLayout(panelFormularioBP);
        panelFormularioBP.setLayout(panelFormularioBPLayout);
        panelFormularioBPLayout.setHorizontalGroup(
            panelFormularioBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioBPLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelFormularioBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGroup(panelFormularioBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioBPLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(panelFormularioBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBorrarEditarProducto)
                            .addComponent(lblImagen_borrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelFormularioBPLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(panelFormularioBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioBPLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 64, Short.MAX_VALUE)
                    .addComponent(elegirProduc_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(46, 46, 46)))
        );
        panelFormularioBPLayout.setVerticalGroup(
            panelFormularioBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioBPLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(panelFormularioBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelFormularioBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioBPLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioBPLayout.createSequentialGroup()
                        .addComponent(lblImagen_borrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnBorrarEditarProducto)
                        .addGap(19, 19, 19))))
            .addGroup(panelFormularioBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFormularioBPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelFormularioBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(elegirProduc_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(402, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelContentBPLayout = new javax.swing.GroupLayout(panelContentBP);
        panelContentBP.setLayout(panelContentBPLayout);
        panelContentBPLayout.setHorizontalGroup(
            panelContentBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentBPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelFormularioBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        panelContentBPLayout.setVerticalGroup(
            panelContentBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentBPLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panelFormularioBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        jPanel6.add(panelContentBP, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout dialogBorrarProductoLayout = new javax.swing.GroupLayout(dialogBorrarProducto.getContentPane());
        dialogBorrarProducto.getContentPane().setLayout(dialogBorrarProductoLayout);
        dialogBorrarProductoLayout.setHorizontalGroup(
            dialogBorrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogBorrarProductoLayout.setVerticalGroup(
            dialogBorrarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(null);
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Opciones Productos");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelHeader.add(jLabel6, java.awt.BorderLayout.CENTER);

        jButton1.setIcon(new javax.swing.ImageIcon("imagenes/goback.png"));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelHeader.add(jButton1, java.awt.BorderLayout.LINE_END);

        jPanel1.add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelBotones.setPreferredSize(new java.awt.Dimension(875, 521));

        btnBorrarProducto.setBackground(new java.awt.Color(171, 167, 111));
        btnBorrarProducto.setText("Borrar Producto");
        btnBorrarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBorrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoActionPerformed(evt);
            }
        });

        btnEditarProducto.setBackground(new java.awt.Color(171, 167, 111));
        btnEditarProducto.setText("Editar Producto");
        btnEditarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        btnCrearProducto.setBackground(new java.awt.Color(171, 167, 111));
        btnCrearProducto.setText("Crear Producto");
        btnCrearProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btnBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jPanel1.add(panelBotones, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que al hacer click abre el JDialog de crear producto
     *
     * @param evt
     */
    private void btnCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProductoActionPerformed
        this.dispose();
        dialogCrearProducto.pack();
        dialogCrearProducto.setLocationRelativeTo(null);
        dialogCrearProducto.setVisible(true);
        dialogCrearProducto.setSize(700, 700);

    }//GEN-LAST:event_btnCrearProductoActionPerformed

    /**
     * Método que al hacer click abre el JDialog de editar producto
     *
     * @param evt
     */
    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        this.dispose();
        dialogEditarProducto.pack();
        dialogEditarProducto.setLocationRelativeTo(null);
        dialogEditarProducto.setVisible(true);

        dialogEditarProducto.setSize(700, 700);

    }//GEN-LAST:event_btnEditarProductoActionPerformed

    /**
     * Método que al hacer click abre el JDialog de borrar producto
     *
     * @param evt
     */
    private void btnBorrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoActionPerformed
        this.dispose();
        dialogBorrarProducto.pack();
        dialogBorrarProducto.setLocationRelativeTo(null);
        dialogBorrarProducto.setVisible(true);

        dialogBorrarProducto.setSize(700, 700);

    }//GEN-LAST:event_btnBorrarProductoActionPerformed

    /**
     * Método que crea un producto al hacer click en botón
     *
     * @param evt
     */
    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        String error = "";
        if (!Validar.nombreCorrecto(etNombre.getText())) {
            error += "El nombre no es correcto \n";
        }

        if (!Validar.precioCorrecto(etPrecio.getText())) {
            error += "El precio no es correcto \n";
        }

        try {
            String rutalocal = subirImagenaddProducto.getSelectedFile().toString();
            if (!Validar.imagenCorrecta(rutalocal)) {
                error += "La extensión de la imagen no es la correcta. (Tiene que ser JPG,JPEG o PNG) \n";
            }
        } catch (NullPointerException e) {
            error += "¡Debes seleccionar un fichero! \n";
        }

        if (etTipoProducto.getSelectedItem().toString().equalsIgnoreCase("Hamburguesa") && listaIngredientes.getSelectedIndices().length == 0) {
            error += "Las hamburguesas deben tener algun ingrediene mínimo \n";
        }

        for (Producto producto : productos) {
            if (etNombre.getText().toString().equalsIgnoreCase(producto.getNombre())) {
                error += "Ese nombre producto ya existe. Prueba con otro";
            }
        }

        if (error.isEmpty()) {
            //Creamos un arraylist con los ingredientes seleccionados y los añadimos
            ArrayList<Ingrediente> ingredientesSel = new ArrayList<>();
            int[] listaIngredientesSelInd = listaIngredientes.getSelectedIndices();
            for (int i = 0; i < listaIngredientesSelInd.length; i++) {
                ingredientesSel.add(ingredientes.get(listaIngredientesSelInd[i]));
            }

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String rutalocal = subirImagenaddProducto.getSelectedFile().toString();
            System.out.println(sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4));
            boolean resultado = GestionFTP.subir(rutalocal, sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4));

            if (resultado) {
                resultado = GestionProducto.add(new Producto(etNombre.getText(), Double.parseDouble(etPrecio.getText().toString()), sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4), etTipoProducto.getSelectedItem().toString(), ingredientesSel));
            } else {
                error += "Error al seleccionar la imagen";
            }

            //Si la ejecución de añadir el producto con sus ingredientes es correcta.
            if (resultado) {
                productos = GestionProducto.getAll();
                elegirProduc.removeAllItems();
                elegirProduc_borrar.removeAllItems();
                for (Producto producto : productos) {
                    elegirProduc.addItem(producto.getNombre());
                    elegirProduc_borrar.addItem(producto.getNombre());
                }
                JOptionPane.showMessageDialog(null, "Producto insertado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error de inserción");
            }

        } else {
            JOptionPane.showMessageDialog(null, error);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    /**
     * Método que al cambiar el valor del tipo del producto en el formulario de
     * crear producto, permite añadir ingredientes o no (si es hamburguesa si)
     *
     * @param evt
     */
    private void etTipoProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_etTipoProductoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (!etTipoProducto.getSelectedItem().toString().equalsIgnoreCase("Hamburguesa")) {
                listaIngredientes.clearSelection();
                listaIngredientes.setEnabled(false);
            } else {
                if (!listaIngredientes.isEnabled()) {
                    listaIngredientes.setEnabled(true);
                }
            }

        }

    }//GEN-LAST:event_etTipoProductoItemStateChanged

    /**
     * Método que edita un producto al hacer click en botón
     *
     * @param evt
     */
    private void btnEnviarEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarEditarProductoActionPerformed
        String error = "";
        if (elegirProduc.getSelectedIndex() >= 0) {
            if (!Validar.nombreCorrecto(etNombre_ep.getText())) {
                error += "Nombre incorrecto \n";
            }

            if (!Validar.precioCorrecto(etPrecio_ep.getText())) {
                error += "Precio incorrecto \n";
            }

            if (subirImagenedProducto.getSelectedFile() != null && !Validar.imagenCorrecta(subirImagenedProducto.getSelectedFile().getAbsolutePath())) {
                error += "Extension de imagen incorrecta \n";
            }

            if (productoSeleccionado.getTipo().equals("Hamburguesa") && listaIngredientes1.getSelectedIndices().length == 0) {
                error += "La hamburguesa debe de tener un ingrediente minimo";
            }

            for (Producto producto : productos) {
                if (!productoSeleccionado.getNombre().equalsIgnoreCase(etNombre_ep.getText().toString()) && producto.getNombre().equalsIgnoreCase(etNombre_ep.getText().toString())) {
                    error += "Error, ya existe un producto con ese nombre \n";
                }
            }

            if (error.isEmpty()) {

                ArrayList<Ingrediente> ingredientesSel = new ArrayList<>();

                if (productoSeleccionado.getTipo().equalsIgnoreCase("Hamburguesa")) {

                    int[] listaIngredientesSelInd = listaIngredientes1.getSelectedIndices();

                    for (int i = 0; i < listaIngredientesSelInd.length; i++) {
                        ingredientesSel.add(ingredientes.get(listaIngredientesSelInd[i]));
                    }
                    //borramos todos los ingredientes que hay actualmente
                    GestionProducto.borrarTodosIngredientes(productoSeleccionado.getId());

                }

                boolean resultado = false;
                if (subirImagenedProducto.getSelectedFile() != null) {
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String rutalocal = subirImagenedProducto.getSelectedFile().toString();

                    //Subimos la nueva imagen y borramos la antigua imagen del servidor
                    GestionFTP.subir(rutalocal, sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4));

                    GestionFTP.borrar(productoSeleccionado.getRuta_img());

                    resultado = GestionProducto.editar(new Producto(productoSeleccionado.getId(), etNombre_ep.getText(), Double.parseDouble(etPrecio_ep.getText()), sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4), productoSeleccionado.getTipo(), ingredientesSel));
                } else {
                    resultado = GestionProducto.editar(new Producto(productoSeleccionado.getId(), etNombre_ep.getText(), Double.parseDouble(etPrecio_ep.getText()), null, productoSeleccionado.getTipo(), ingredientesSel));
                }

                //Si no se ha generado ningun error, mostramos joptionpane y actualizamos los productos actuales
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Producto editado correctamente");
                    productos = GestionProducto.getAll();
                    elegirProduc.removeAllItems();
                    elegirProduc_borrar.removeAllItems();
                    for (Producto producto : productos) {
                        elegirProduc.addItem(producto.getNombre());
                        elegirProduc_borrar.addItem(producto.getNombre());
                    }
                    elegirProduc.setSelectedIndex(0);
                    elegirProduc.setSelectedIndex(1);
                    elegirProduc.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Error de inserción");
                }
            } else {
                JOptionPane.showMessageDialog(null, error);
            }
        }

    }//GEN-LAST:event_btnEnviarEditarProductoActionPerformed

    /**
     * Método que al seleccionar otro producto en el combobox, actualizamos los
     * datos en la GUI (editar producto)
     *
     * @param evt
     */
    private void elegirProducItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_elegirProducItemStateChanged
        //Si hay algun en el combobox y se hace click para cambiar
        if (elegirProduc.getItemCount() > 0) {
            productoSeleccionado = productos.get(elegirProduc.getSelectedIndex());
            //Si es hamburguesa, habrá que seleccionar los ingredientes
            if (productoSeleccionado.getTipo().equalsIgnoreCase("Hamburguesa")) {
                listaIngredientes1.setEnabled(true);
                if (productoSeleccionado != null) {
                    //Seleccionamos los ingredientes que tiene la hamburguesa en el momento
                    listaIngredientes1.clearSelection();
                    //Array que contendrá los indices de los ingredientes que están seleccionados en la bbdd
                    ArrayList<Integer> selecs = new ArrayList<>();
                    int contador = 0;
                    for (int i = 0; i < ingredientes.size(); i++) {
                        try {
                            if (contador < productoSeleccionado.getIngredientes().size() && ingredientes.get(i).getId() == productoSeleccionado.getIngredientes().get(contador).getId()) {
                                selecs.add(i);
                                contador++;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                    listaIngredientes1.setSelectedIndices(selecs.stream().mapToInt(i -> i).toArray());
                    System.out.println("--------------");
                    System.out.println(selecs.toString());
                    System.out.println(listaIngredientes1.getSelectedIndices().length);
                    System.out.println("--------------");
                    etNombre_ep.setText(productoSeleccionado.getNombre());
                    etPrecio_ep.setText(String.valueOf(productoSeleccionado.getPrecio()));
                    selecs.clear();
                }
            } else {
                listaIngredientes1.clearSelection();
                listaIngredientes1.setEnabled(false);
                etNombre_ep.setText(productoSeleccionado.getNombre());
                etPrecio_ep.setText(String.valueOf(productoSeleccionado.getPrecio()));
            }

            URL url;
            BufferedImage image = null;
            try {
                url = new URL("https://autoburger.000webhostapp.com/imagenesProductos/" + productoSeleccionado.getRuta_img());
                image = ImageIO.read(url);
                Image image_escalada = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            lblImagen_ed.setIcon(new ImageIcon(image_escalada));
            } catch (MalformedURLException ex) {
                Logger.getLogger(OpcionesProducto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            lblImagen_ed.setIcon(new ImageIcon("imagenes/imagen_no_encontrada.png"));
            }
            
        }
    }//GEN-LAST:event_elegirProducItemStateChanged

    /**
     * Método que al seleccionar otro menú en el combobox, actualizamos los
     * datos en la GUI (borrar producto)
     *
     * @param evt
     */
    private void elegirProduc_borrarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_elegirProduc_borrarItemStateChanged
        if (elegirProduc_borrar.getItemCount() > 0 && evt.getStateChange() == ItemEvent.SELECTED) {
            listaDatosProducto_borrar.removeAll();
            productoSeleccionado = productos.get(elegirProduc_borrar.getSelectedIndex());
            if (productoSeleccionado.getTipo().equalsIgnoreCase("Hamburguesa")) {
                listaIngredientes1.setEnabled(true);
                if (productoSeleccionado != null) {
                    listaIngredientes1.clearSelection();
                    ArrayList<Integer> selecs = new ArrayList<>();
                    if (ingredientes.size() != 0) {
                        int contador = 0;
                        for (int i = 0; i < ingredientes.size(); i++) {
                            try {
                                if (ingredientes.get(i).getId() == productoSeleccionado.getIngredientes().get(contador).getId()) {
                                    selecs.add(i);
                                    contador++;
                                }
                            } catch (IndexOutOfBoundsException e) {
                            }

                        }
                    }
                    selecs.clear();
                }
            } else {
                listaIngredientes1.clearSelection();
                listaIngredientes1.setEnabled(false);
                listaDatosProducto_borrar.setText(productoSeleccionado.getNombre() + "," + productoSeleccionado.getTipo() + "," + productoSeleccionado.getPrecio());
            }

            URL url;
            BufferedImage image = null;
            try {
                System.out.println(productoSeleccionado.toString());
                url = new URL("https://autoburger.000webhostapp.com/imagenesProductos/" + productoSeleccionado.getRuta_img());
                image = ImageIO.read(url);
                Image image_escalada = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            lblImagen_borrarProducto.setIcon(new ImageIcon(image_escalada));
            listaDatosProducto_borrar.setText(productoSeleccionado.getNombre() + "\n" + productoSeleccionado.getTipo() + "\n" + productoSeleccionado.getPrecio());
            } catch (MalformedURLException ex) {
                Logger.getLogger(OpcionesProducto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                 lblImagen_borrarProducto.setIcon(new ImageIcon("imagenes/imagen_no_encontrada.png"));
            }
            
        }


    }//GEN-LAST:event_elegirProduc_borrarItemStateChanged

    /**
     * Método que borra producto al hacer click en botón
     *
     * @param evt
     */
    private void btnBorrarEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarEditarProductoActionPerformed

        GestionFTP.borrar(productoSeleccionado.getRuta_img());
        boolean resultado = GestionProducto.remove(productoSeleccionado.getId());
        //Si la ejecución de añadir el producto con sus ingredientes es correcta.
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Producto borrado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error de borrado");
        }
        productos = GestionProducto.getAll();
        elegirProduc.removeAllItems();
        elegirProduc_borrar.removeAllItems();
        for (Producto producto : productos) {
            elegirProduc.addItem(producto.getNombre());
            elegirProduc_borrar.addItem(producto.getNombre());
        }
        elegirProduc_borrar.setSelectedIndex(0);
    }//GEN-LAST:event_btnBorrarEditarProductoActionPerformed

    /**
     * Método que previsualiza la imagen a subir (en crear producto)
     *
     * @param evt
     */
    private void btnSubirImagen_addproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirImagen_addproductoActionPerformed
        int resp = subirImagenaddProducto.showOpenDialog(this);

        if (resp == JFileChooser.APPROVE_OPTION) {

            File file = subirImagenaddProducto.getSelectedFile();
            if (Validar.imagenCorrecta(file.getAbsolutePath())) {
                BufferedImage bi;
                try {
                    // display the image in a Jlabel
                    bi = ImageIO.read(file);
                    Image image_escalada = bi.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                    lblImagen.setIcon(new ImageIcon(image_escalada));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error, selecciona una imagen con extensión correcta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se pulsó la opcion Cancelar");
        }
    }//GEN-LAST:event_btnSubirImagen_addproductoActionPerformed

    /**
     * Método que previsualiza la imagen a subir (en editar producto)
     *
     * @param evt
     */
    private void btnSubirImagen_edProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirImagen_edProductoActionPerformed
        int resp = subirImagenedProducto.showOpenDialog(this);

        if (resp == JFileChooser.APPROVE_OPTION) {
            File file = subirImagenedProducto.getSelectedFile();
            if (Validar.imagenCorrecta(subirImagenedProducto.getSelectedFile().getAbsolutePath())) {
                BufferedImage bi;
                try {
                    // display the image in a Jlabel
                    bi = ImageIO.read(file);
                    Image image_escalada = bi.getScaledInstance(lblImagen_ed.getWidth(), lblImagen_ed.getHeight(), Image.SCALE_SMOOTH);
                    lblImagen_ed.setIcon(new ImageIcon(image_escalada));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error, selecciona una imagen con extensión correcta");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Se pulsó la opcion Cancelar");
        }
    }//GEN-LAST:event_btnSubirImagen_edProductoActionPerformed

    /**
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dialogCrearProducto.setVisible(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dialogEditarProducto.setVisible(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dialogBorrarProducto.setVisible(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OpcionesProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcionesProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcionesProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcionesProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpcionesProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarEditarProducto;
    private javax.swing.JButton btnBorrarProducto;
    private javax.swing.JButton btnCrearProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnEnviarEditarProducto;
    private javax.swing.JButton btnSubirImagen_addproducto;
    private javax.swing.JButton btnSubirImagen_edProducto;
    private javax.swing.JDialog dialogBorrarProducto;
    private javax.swing.JDialog dialogCrearProducto;
    private javax.swing.JDialog dialogEditarProducto;
    private javax.swing.JComboBox<String> elegirProduc;
    private javax.swing.JComboBox<String> elegirProduc_borrar;
    private javax.swing.JTextField etNombre;
    private javax.swing.JTextField etNombre_ep;
    private javax.swing.JTextField etPrecio;
    private javax.swing.JTextField etPrecio_ep;
    private javax.swing.JComboBox<String> etTipoProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblImagen_borrarProducto;
    private javax.swing.JLabel lblImagen_ed;
    private javax.swing.JTextArea listaDatosProducto_borrar;
    private javax.swing.JList<String> listaIngredientes;
    private javax.swing.JList<String> listaIngredientes1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelFormularioBP;
    private javax.swing.JPanel panelFormularioCP;
    private javax.swing.JPanel panelFormularioEP;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHeader1;
    private javax.swing.JPanel panelHeader2;
    private javax.swing.JPanel panelHeader3;
    private javax.swing.JFileChooser subirImagenaddProducto;
    private javax.swing.JFileChooser subirImagenedProducto;
    // End of variables declaration//GEN-END:variables
}
