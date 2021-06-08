package Vista;

import controlador.GestionFTP;
import controlador.GestionMenu;
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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Menu;
import modelo.Producto;

/**
 * @author DavidGG
 * @version 1.0
 */
public class OpcionesMenus extends javax.swing.JFrame {

    private static ArrayList<Menu> menus;
    private static ArrayList<Producto> productos;
    private static Menu menuSeleccionado;

    /**
     * Constructor de la clase que ejecuta el método que inicia la GUI y obtiene
     * todos los menús junto a sus productos y los añade a los jcombobox
     */
    public OpcionesMenus() {
        initComponents();

        productos = GestionProducto.getAll();
        DefaultListModel modelo = new DefaultListModel();
        for (Producto producto : productos) {
            modelo.addElement(producto.getNombre());
        }
        listaProductos_crearmenu.setModel(modelo);

        menus = GestionMenu.getAll();
        for (Menu menu : menus) {
            elegirMenu_editar.addItem(menu.getNombre() + "-" + menu.getId());
            elegirMenu_borrar.addItem(menu.getNombre() + "-" + menu.getId());
        }
        listaProductos_crearmenu.setModel(modelo);

        modelo = new DefaultListModel();
        for (Producto producto : productos) {
            modelo.addElement(producto.getNombre());
        }
        listaProductos_editarMenu.setModel(modelo);
        listaProductos_borrarMenu.setModel(modelo);

        ArrayList<Integer> selecs = new ArrayList<>();
        if (menus.size() > 0) {
            menuSeleccionado = menus.get(elegirMenu_editar.getSelectedIndex());
        }

        int contador = 0;
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).getId() == menuSeleccionado.getId()) {
                for (int j = 0; j < menus.get(i).getProductos().size(); j++) {
                    for (int k = 0; k < menuSeleccionado.getProductos().size(); k++) {
                        if (menus.get(i).getProductos().get(j).getId() == menuSeleccionado.getProductos().get(k).getId()) {
                            for (int l = 0; l < productos.size(); l++) {
                                if (productos.get(l).getId() == menus.get(i).getProductos().get(j).getId()) {
                                    selecs.add(l);
                                }
                            }

                        }
                    }
                }
            }
        }
        if (menuSeleccionado != null) {
            listaProductos_editarMenu.setSelectedIndices(selecs.stream().mapToInt(i -> i).toArray());
            listaProductos_borrarMenu.setSelectedIndices(selecs.stream().mapToInt(i -> i).toArray());
            etNombre_borrarMenu.setText(menuSeleccionado.getNombre());
            etPrecio_borrarMenu.setText(String.valueOf(menuSeleccionado.getPrecio()));
        }

        panelFormularioCM.setBackground(new Color(181, 97, 54, 240));
        panelFormularioBM.setBackground(new Color(181, 97, 54, 240));
        panelFormularioEM.setBackground(new Color(181, 97, 54, 240));
    }

    /**
     * Método que inicia toda la GUI
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogCrearMenu = new javax.swing.JDialog();
        jPanel3 = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelHeader1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        javax.swing.JPanel panelContentCM = new JPanel() {        public void paintComponent(Graphics g) {          Image img = Toolkit.getDefaultToolkit().getImage(          "imagenes/back_opcHamburguesas.jpg");          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);          }        };
        panelFormularioCM = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos_crearmenu = new javax.swing.JList<>();
        btnEnviarCrearMenu = new javax.swing.JButton();
        etNombre_crearmenu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        etPrecio_crearMenu = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnSubirImagen_addMenu = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        dialogEditarMenu = new javax.swing.JDialog();
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
        javax.swing.JPanel panelContentEM = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelFormularioEM = new javax.swing.JPanel();
        etNombre_editarMenu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        elegirMenu_editar = new javax.swing.JComboBox<>();
        lblImagen_editarMenu = new javax.swing.JLabel();
        btnSubirImagen_editarMenu = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProductos_editarMenu = new javax.swing.JList<>();
        btnEnviarEditarMenu = new javax.swing.JButton();
        etPrecio_editarMenu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dialogBorrarMenu = new javax.swing.JDialog();
        jPanel6 = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelHeader3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        javax.swing.JPanel panelContentBM = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelFormularioBM = new javax.swing.JPanel();
        etPrecio_borrarMenu = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnEnviarBorrarMenu = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaProductos_borrarMenu = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        etNombre_borrarMenu = new javax.swing.JTextField();
        elegirMenu_borrar = new javax.swing.JComboBox<>();
        lblImagen_borrarMenu = new javax.swing.JLabel();
        subirImagenCrearMenu = new javax.swing.JFileChooser();
        subirImagenEditarMenu = new javax.swing.JFileChooser();
        javax.swing.JPanel jPanel1 = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcMenus.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel8 = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcMenus.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        btnCrearMenu = new javax.swing.JButton();
        btnBorrarMenu = new javax.swing.JButton();
        btnEditarMenu = new javax.swing.JButton();

        dialogCrearMenu.setMinimumSize(null);
        dialogCrearMenu.setResizable(false);
        dialogCrearMenu.setSize(new java.awt.Dimension(700, 700));

        jPanel3.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel3.setLayout(new java.awt.BorderLayout());

        panelHeader1.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader1.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Crear Menú");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelHeader1.add(jLabel7, java.awt.BorderLayout.CENTER);

        jButton5.setIcon(new javax.swing.ImageIcon("imagenes/goback.png"));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panelHeader1.add(jButton5, java.awt.BorderLayout.LINE_END);

        jPanel3.add(panelHeader1, java.awt.BorderLayout.PAGE_START);

        panelContentCM.setBackground(new java.awt.Color(181, 97, 54));
        panelContentCM.setMaximumSize(new java.awt.Dimension(500, 600));
        panelContentCM.setPreferredSize(new java.awt.Dimension(500, 600));

        jLabel1.setText("Nombre:");

        jLabel3.setText("Precio:");

        jLabel5.setText("€");

        listaProductos_crearmenu.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaProductos_crearmenu);

        btnEnviarCrearMenu.setText("Añadir Menu");
        btnEnviarCrearMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCrearMenuActionPerformed(evt);
            }
        });

        jLabel4.setText("Productos:");

        jLabel17.setText("Imagen:");

        btnSubirImagen_addMenu.setText("Seleccionar fich..");
        btnSubirImagen_addMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirImagen_addMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioCMLayout = new javax.swing.GroupLayout(panelFormularioCM);
        panelFormularioCM.setLayout(panelFormularioCMLayout);
        panelFormularioCMLayout.setHorizontalGroup(
            panelFormularioCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioCMLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
            .addGroup(panelFormularioCMLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(panelFormularioCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(panelFormularioCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnviarCrearMenu)
                    .addComponent(btnSubirImagen_addMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormularioCMLayout.createSequentialGroup()
                        .addComponent(etPrecio_crearMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etNombre_crearmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        panelFormularioCMLayout.setVerticalGroup(
            panelFormularioCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioCMLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelFormularioCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etNombre_crearmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(panelFormularioCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etPrecio_crearMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(panelFormularioCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormularioCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubirImagen_addMenu)
                    .addComponent(jLabel17))
                .addGap(26, 26, 26)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnEnviarCrearMenu)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelContentCMLayout = new javax.swing.GroupLayout(panelContentCM);
        panelContentCM.setLayout(panelContentCMLayout);
        panelContentCMLayout.setHorizontalGroup(
            panelContentCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentCMLayout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addComponent(panelFormularioCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        panelContentCMLayout.setVerticalGroup(
            panelContentCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentCMLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panelFormularioCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jPanel3.add(panelContentCM, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout dialogCrearMenuLayout = new javax.swing.GroupLayout(dialogCrearMenu.getContentPane());
        dialogCrearMenu.getContentPane().setLayout(dialogCrearMenuLayout);
        dialogCrearMenuLayout.setHorizontalGroup(
            dialogCrearMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dialogCrearMenuLayout.setVerticalGroup(
            dialogCrearMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dialogEditarMenu.setMinimumSize(null);
        dialogEditarMenu.setResizable(false);
        dialogEditarMenu.setSize(new java.awt.Dimension(700, 700));

        jPanel4.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel4.setLayout(new java.awt.BorderLayout());

        panelHeader2.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader2.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Editar Menú");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelHeader2.add(jLabel8, java.awt.BorderLayout.CENTER);

        jButton3.setIcon(new javax.swing.ImageIcon("imagenes/goback.png"));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelHeader2.add(jButton3, java.awt.BorderLayout.LINE_END);

        jPanel4.add(panelHeader2, java.awt.BorderLayout.PAGE_START);

        panelContentEM.setBackground(new java.awt.Color(181, 97, 54));
        panelContentEM.setMaximumSize(new java.awt.Dimension(500, 600));

        jLabel12.setText("Nombre:");

        elegirMenu_editar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                elegirMenu_editarItemStateChanged(evt);
            }
        });

        btnSubirImagen_editarMenu.setText("Seleccionar fich..");
        btnSubirImagen_editarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirImagen_editarMenuActionPerformed(evt);
            }
        });

        jLabel11.setText("€");

        jLabel18.setText("Imagen:");

        jScrollPane2.setViewportView(listaProductos_editarMenu);

        btnEnviarEditarMenu.setText("Editar Menu");
        btnEnviarEditarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarEditarMenuActionPerformed(evt);
            }
        });

        jLabel10.setText("Productos:");

        jLabel9.setText("Precio:");

        jLabel2.setText("Menu:");

        javax.swing.GroupLayout panelFormularioEMLayout = new javax.swing.GroupLayout(panelFormularioEM);
        panelFormularioEM.setLayout(panelFormularioEMLayout);
        panelFormularioEMLayout.setHorizontalGroup(
            panelFormularioEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioEMLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelFormularioEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormularioEMLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(elegirMenu_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(panelFormularioEMLayout.createSequentialGroup()
                        .addGroup(panelFormularioEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(panelFormularioEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormularioEMLayout.createSequentialGroup()
                                .addComponent(etPrecio_editarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(etNombre_editarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirImagen_editarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImagen_editarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(72, 72, 72))
            .addGroup(panelFormularioEMLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btnEnviarEditarMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFormularioEMLayout.setVerticalGroup(
            panelFormularioEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioEMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioEMLayout.createSequentialGroup()
                        .addGroup(panelFormularioEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(elegirMenu_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelFormularioEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etNombre_editarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(7, 7, 7)
                        .addGroup(panelFormularioEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etPrecio_editarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormularioEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btnSubirImagen_editarMenu))
                    .addGroup(panelFormularioEMLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel18)))
                .addGap(13, 13, 13)
                .addComponent(lblImagen_editarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviarEditarMenu)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout panelContentEMLayout = new javax.swing.GroupLayout(panelContentEM);
        panelContentEM.setLayout(panelContentEMLayout);
        panelContentEMLayout.setHorizontalGroup(
            panelContentEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentEMLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(panelFormularioEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        panelContentEMLayout.setVerticalGroup(
            panelContentEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentEMLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelFormularioEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel4.add(panelContentEM, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout dialogEditarMenuLayout = new javax.swing.GroupLayout(dialogEditarMenu.getContentPane());
        dialogEditarMenu.getContentPane().setLayout(dialogEditarMenuLayout);
        dialogEditarMenuLayout.setHorizontalGroup(
            dialogEditarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogEditarMenuLayout.setVerticalGroup(
            dialogEditarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogBorrarMenu.setMinimumSize(null);
        dialogBorrarMenu.setResizable(false);
        dialogBorrarMenu.setSize(new java.awt.Dimension(700, 700));

        jPanel6.setLayout(new java.awt.BorderLayout());

        panelHeader3.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader3.setLayout(new java.awt.BorderLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Borrar Menú");
        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelHeader3.add(jLabel13, java.awt.BorderLayout.CENTER);

        jButton4.setIcon(new javax.swing.ImageIcon("imagenes/goback.png"));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelHeader3.add(jButton4, java.awt.BorderLayout.LINE_END);

        jPanel6.add(panelHeader3, java.awt.BorderLayout.PAGE_START);

        panelContentBM.setBackground(new java.awt.Color(181, 97, 54));
        panelContentBM.setPreferredSize(new java.awt.Dimension(609, 603));

        etPrecio_borrarMenu.setEditable(false);

        jLabel14.setText("Menu:");

        btnEnviarBorrarMenu.setText("Borrar Menu");
        btnEnviarBorrarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarBorrarMenuActionPerformed(evt);
            }
        });

        jLabel16.setText("Productos:");

        jLabel21.setText("Nombre:");

        jLabel20.setText("Imagen:");

        listaProductos_borrarMenu.setEnabled(false);
        jScrollPane3.setViewportView(listaProductos_borrarMenu);

        jLabel19.setText("€");

        jLabel15.setText("Precio:");

        etNombre_borrarMenu.setEditable(false);

        elegirMenu_borrar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                elegirMenu_borrarItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioBMLayout = new javax.swing.GroupLayout(panelFormularioBM);
        panelFormularioBM.setLayout(panelFormularioBMLayout);
        panelFormularioBMLayout.setHorizontalGroup(
            panelFormularioBMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioBMLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(panelFormularioBMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel15))
                .addGap(36, 36, 36)
                .addGroup(panelFormularioBMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagen_borrarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elegirMenu_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etNombre_borrarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormularioBMLayout.createSequentialGroup()
                        .addComponent(etPrecio_borrarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioBMLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnviarBorrarMenu)
                .addGap(140, 140, 140))
        );
        panelFormularioBMLayout.setVerticalGroup(
            panelFormularioBMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioBMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioBMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elegirMenu_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(panelFormularioBMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(etNombre_borrarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelFormularioBMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etPrecio_borrarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel15))
                .addGap(39, 39, 39)
                .addGroup(panelFormularioBMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(5, 5, 5)
                .addComponent(lblImagen_borrarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnEnviarBorrarMenu)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout panelContentBMLayout = new javax.swing.GroupLayout(panelContentBM);
        panelContentBM.setLayout(panelContentBMLayout);
        panelContentBMLayout.setHorizontalGroup(
            panelContentBMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentBMLayout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addComponent(panelFormularioBM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        panelContentBMLayout.setVerticalGroup(
            panelContentBMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentBMLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelFormularioBM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel6.add(panelContentBM, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout dialogBorrarMenuLayout = new javax.swing.GroupLayout(dialogBorrarMenu.getContentPane());
        dialogBorrarMenu.getContentPane().setLayout(dialogBorrarMenuLayout);
        dialogBorrarMenuLayout.setHorizontalGroup(
            dialogBorrarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogBorrarMenuLayout.setVerticalGroup(
            dialogBorrarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogBorrarMenuLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Opciones Menús");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelHeader.add(jLabel6, java.awt.BorderLayout.CENTER);

        jButton6.setIcon(new javax.swing.ImageIcon("imagenes/goback.png"));
        jButton6.setMaximumSize(new java.awt.Dimension(50, 47));
        jButton6.setMinimumSize(new java.awt.Dimension(50, 47));
        jButton6.setPreferredSize(new java.awt.Dimension(100, 47));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panelHeader.add(jButton6, java.awt.BorderLayout.LINE_END);

        jPanel1.add(panelHeader, java.awt.BorderLayout.PAGE_START);

        btnCrearMenu.setBackground(new java.awt.Color(171, 167, 111));
        btnCrearMenu.setText("Crear Menu");
        btnCrearMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMenuActionPerformed(evt);
            }
        });

        btnBorrarMenu.setBackground(new java.awt.Color(171, 167, 111));
        btnBorrarMenu.setText("Borrar Menu");
        btnBorrarMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBorrarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarMenuActionPerformed(evt);
            }
        });

        btnEditarMenu.setBackground(new java.awt.Color(171, 167, 111));
        btnEditarMenu.setText("Editar Menu");
        btnEditarMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(270, 270, 270))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnCrearMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnEditarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btnBorrarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que al hacer click abre el JDialog de crear menú
     *
     * @param evt
     */
    private void btnCrearMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMenuActionPerformed
        this.dispose();
        dialogCrearMenu.pack();
        dialogCrearMenu.setVisible(true);
        dialogCrearMenu.setLocationRelativeTo(null);
        dialogCrearMenu.setSize(700, 700);
    }//GEN-LAST:event_btnCrearMenuActionPerformed

    /**
     * Método que al hacer click abre el JDialog de editar menú
     *
     * @param evt
     */
    private void btnEditarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMenuActionPerformed
        this.dispose();
        dialogEditarMenu.pack();
        dialogEditarMenu.setVisible(true);
        dialogEditarMenu.setLocationRelativeTo(null);
        dialogEditarMenu.setSize(700, 700);
    }//GEN-LAST:event_btnEditarMenuActionPerformed

    /**
     * Método que al hacer click abre el JDialog de borrar menú
     *
     * @param evt
     */
    private void btnBorrarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarMenuActionPerformed
        this.dispose();
        dialogBorrarMenu.pack();
        dialogBorrarMenu.setVisible(true);
        dialogBorrarMenu.setLocationRelativeTo(null);
        dialogBorrarMenu.setSize(700, 700);
    }//GEN-LAST:event_btnBorrarMenuActionPerformed

    /**
     * Método que edita un menú al hacer click en botón
     *
     * @param evt
     */
    private void btnEnviarEditarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarEditarMenuActionPerformed
        if (elegirMenu_editar.getSelectedIndex() >= 0) {
            String error = "";

            if (!Validar.nombreCorrecto(etNombre_editarMenu.getText())) {
                error += "El nombre no es correcto \n";
            }

            if (!Validar.precioCorrecto(etPrecio_editarMenu.getText())) {
                error += "El precio no es correcto \n";
            }

            try {
                if (subirImagenEditarMenu.getSelectedFiles().length != 0) {
                    String rutalocal = subirImagenEditarMenu.getSelectedFile().toString();
                    if (!Validar.imagenCorrecta(rutalocal)) {
                        error += "La extensión de la imagen no es la correcta. (Tiene que ser JPG,JPEG o PNG) \n";
                    }
                }

            } catch (NullPointerException e) {
                error += "¡Debes seleccionar un fichero! \n";
            }

            if (listaProductos_editarMenu.getSelectedIndices().length == 0) {
                error += "Las hamburguesas deben tener algun ingrediene mínimo \n";
            }

            for (Menu menu : menus) {
                if (!menuSeleccionado.getNombre().equalsIgnoreCase(etNombre_editarMenu.getText().toString()) && menu.getNombre().equalsIgnoreCase(etNombre_editarMenu.getText().toString())) {
                    error += "Error, ya existe un menú con ese nombre \n";
                }
            }

            ArrayList<Producto> productosSel = new ArrayList<>();

            int[] listaMenuSelInd = listaProductos_editarMenu.getSelectedIndices();

            for (int i = 0; i < listaMenuSelInd.length; i++) {
                productosSel.add(productos.get(listaMenuSelInd[i]));
            }

            if (error.isEmpty()) {
                GestionMenu.borrarTodosProductos(menuSeleccionado.getId());
                boolean resultado = false;
                
                //Si se ha seleccionado una imagen, se borra la antigua y se sube la nueva
                if (subirImagenEditarMenu.getSelectedFiles().length != 0) {
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String rutalocal = subirImagenEditarMenu.getSelectedFile().toString();
                    System.out.println(sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4));
                    GestionFTP.subir(rutalocal, sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4));
                    //new Producto(productoSeleccionado.getId(), etNombre_ep.getText(), Double.parseDouble(etPrecio_ep.getText()), sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4), productoSeleccionado.getTipo(), ingredientesSel)
                    resultado = GestionMenu.editar(new Menu(menuSeleccionado.getId(), etNombre_editarMenu.getText().toString(), Double.parseDouble(etPrecio_editarMenu.getText().toString()), sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4), productosSel));
                } else {
                    resultado = GestionMenu.editar(new Menu(menuSeleccionado.getId(), etNombre_editarMenu.getText().toString(), Double.parseDouble(etPrecio_editarMenu.getText().toString()), null, productosSel));
                }

                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Menu editado correctamente");
                    productos = GestionProducto.getAll();
                    elegirMenu_editar.removeAllItems();
                    for (Menu menu : menus) {
                        elegirMenu_editar.addItem(menu.getNombre() + "-" + menu.getId());
                    }
                    DefaultListModel modelo = new DefaultListModel();
                    modelo = new DefaultListModel();
                    for (Producto producto : productos) {
                        modelo.addElement(producto.getNombre());
                    }
                    listaProductos_editarMenu.setModel(modelo);
                    menus = GestionMenu.getAll();
                    elegirMenu_borrar.removeAllItems();
                    elegirMenu_editar.removeAllItems();
                    for (Menu menu : menus) {
                        elegirMenu_borrar.addItem(menu.getNombre());
                        elegirMenu_editar.addItem(menu.getNombre());
                    }
                    ArrayList<Integer> selecs = new ArrayList<>();
                    menuSeleccionado = menus.get(elegirMenu_editar.getSelectedIndex());
                    int contador = 0;
                    for (int i = 0; i < menus.size(); i++) {
                        if (menus.get(i).getId() == menuSeleccionado.getId()) {
                            for (int j = 0; j < menus.get(i).getProductos().size(); j++) {
                                for (int k = 0; k < menuSeleccionado.getProductos().size(); k++) {
                                    if (menus.get(i).getProductos().get(j).getId() == menuSeleccionado.getProductos().get(k).getId()) {
                                        for (int l = 0; l < productos.size(); l++) {
                                            if (productos.get(l).getId() == menus.get(i).getProductos().get(j).getId()) {
                                                selecs.add(l);
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                    listaProductos_editarMenu.setSelectedIndices(selecs.stream().mapToInt(i -> i).toArray());
                } else {
                    JOptionPane.showMessageDialog(null, "Error de inserción");
                }
            } else {
                JOptionPane.showMessageDialog(null, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error no hay seleccionado ningún menú.");
        }
    }//GEN-LAST:event_btnEnviarEditarMenuActionPerformed

    /**
     * Método que previsualiza la imagen a subir (en editar menu)
     *
     * @param evt
     */
    private void btnSubirImagen_editarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirImagen_editarMenuActionPerformed
        int resp = subirImagenEditarMenu.showOpenDialog(this);

        if (resp == JFileChooser.APPROVE_OPTION) {
            File file = subirImagenEditarMenu.getSelectedFile();
            BufferedImage bi;
            try {
                // display the image in a Jlabel
                bi = ImageIO.read(file);
                Image image_escalada = bi.getScaledInstance(lblImagen_editarMenu.getWidth(), lblImagen_editarMenu.getHeight(), Image.SCALE_SMOOTH);
                lblImagen_editarMenu.setIcon(new ImageIcon(image_escalada));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se pulsó la opcion Cancelar");
        }
    }//GEN-LAST:event_btnSubirImagen_editarMenuActionPerformed

    /**
     * Método que al seleccionar otro menú en el combobox, actualizamos los
     * datos en la GUI
     *
     * @param evt
     */
    private void elegirMenu_editarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_elegirMenu_editarItemStateChanged
        if (elegirMenu_editar.getItemCount() > 0) {
            menuSeleccionado = menus.get(elegirMenu_editar.getSelectedIndex());
            if (evt.getStateChange() == ItemEvent.SELECTED && menuSeleccionado != null) {
                listaProductos_editarMenu.clearSelection();

                ArrayList<Integer> selecs = new ArrayList<>();
                for (int i = 0; i < menus.size(); i++) {
                    if (menus.get(i).getId() == menuSeleccionado.getId()) {
                        for (int j = 0; j < menus.get(i).getProductos().size(); j++) {
                            for (int k = 0; k < menuSeleccionado.getProductos().size(); k++) {
                                if (menus.get(i).getProductos().get(j).getId() == menuSeleccionado.getProductos().get(k).getId()) {
                                    for (int l = 0; l < productos.size(); l++) {
                                        if (productos.get(l).getId() == menus.get(i).getProductos().get(j).getId()) {
                                            selecs.add(l);
                                        }
                                    }

                                }
                            }
                        }
                    }
                }

                URL url;
                BufferedImage image = null;
                try {
                    url = new URL("https://autoburger.000webhostapp.com/imagenesProductos/" + menuSeleccionado.getRuta_img());
                    image = ImageIO.read(url);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(OpcionesProducto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(OpcionesProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
                Image image_escalada = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                lblImagen_editarMenu.setIcon(new ImageIcon(image_escalada));

                listaProductos_editarMenu.setSelectedIndices(selecs.stream().mapToInt(i -> i).toArray());
                etNombre_editarMenu.setText(menuSeleccionado.getNombre());
                etPrecio_editarMenu.setText(String.valueOf(menuSeleccionado.getPrecio()));

            }
        }
    }//GEN-LAST:event_elegirMenu_editarItemStateChanged

    /**
     * Método que borra menú al hacer click en botón
     *
     * @param evt
     */
    private void btnEnviarBorrarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarBorrarMenuActionPerformed
        boolean resultado = GestionMenu.remove(menuSeleccionado.getId());
        //Si la ejecución de añadir el producto con sus ingredientes es correcta.
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Menu borrado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error de borrado");
        }
        elegirMenu_borrar.removeAllItems();

        menus = GestionMenu.getAll();
        for (Menu menu : menus) {
            elegirMenu_borrar.addItem(menu.getNombre() + "-" + menu.getId());
        }
    }//GEN-LAST:event_btnEnviarBorrarMenuActionPerformed

    /**
     * Método que al seleccionar otro menú en el combobox, actualizamos los
     * datos en la GUI (borrar menu)
     *
     * @param evt
     */
    private void elegirMenu_borrarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_elegirMenu_borrarItemStateChanged
        if (elegirMenu_borrar.getItemCount() > 0) {
            menuSeleccionado = menus.get(elegirMenu_borrar.getSelectedIndex());
            if (evt.getStateChange() == ItemEvent.SELECTED && menuSeleccionado != null) {
                listaProductos_borrarMenu.clearSelection();

                ArrayList<Integer> selecs = new ArrayList<>();
                for (int i = 0; i < menus.size(); i++) {
                    if (menus.get(i).getId() == menuSeleccionado.getId()) {
                        for (int j = 0; j < menus.get(i).getProductos().size(); j++) {
                            for (int k = 0; k < menuSeleccionado.getProductos().size(); k++) {
                                if (menus.get(i).getProductos().get(j).getId() == menuSeleccionado.getProductos().get(k).getId()) {
                                    for (int l = 0; l < productos.size(); l++) {
                                        if (productos.get(l).getId() == menus.get(i).getProductos().get(j).getId()) {
                                            selecs.add(l);
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
                URL url;
                BufferedImage image = null;
                try {
                    url = new URL("https://autoburger.000webhostapp.com/imagenesProductos/" + menuSeleccionado.getRuta_img());
                    image = ImageIO.read(url);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(OpcionesProducto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(OpcionesProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
                Image image_escalada = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                lblImagen_borrarMenu.setIcon(new ImageIcon(image_escalada));
                listaProductos_borrarMenu.setSelectedIndices(selecs.stream().mapToInt(i -> i).toArray());
                etNombre_borrarMenu.setText(menuSeleccionado.getNombre());
                etPrecio_borrarMenu.setText(String.valueOf(menuSeleccionado.getPrecio()));

            }
        }
    }//GEN-LAST:event_elegirMenu_borrarItemStateChanged

    /**
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dialogEditarMenu.setVisible(false);
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
        dialogBorrarMenu.setVisible(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * Método que previsualiza la imagen a subir en la GUI (crear menú)
     *
     * @param evt
     */
    private void btnSubirImagen_addMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirImagen_addMenuActionPerformed
        int resp = subirImagenCrearMenu.showOpenDialog(this);

        if (resp == JFileChooser.APPROVE_OPTION) {
            File file = subirImagenCrearMenu.getSelectedFile();
            BufferedImage bi;
            try {
                bi = ImageIO.read(file);
                Image image_escalada = bi.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(image_escalada));
            } catch (NullPointerException ep) {
                JOptionPane.showMessageDialog(null, "Error.El archivo seleccionado no es una imagen.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error.El archivo seleccionado no es una imagen.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se pulsó la opcion Cancelar");
        }
    }//GEN-LAST:event_btnSubirImagen_addMenuActionPerformed

    /**
     * Método que crea un nuevo menú al hacer click en botón
     *
     * @param evt
     */
    private void btnEnviarCrearMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCrearMenuActionPerformed

        String error = "";
        if (!Validar.nombreCorrecto(etNombre_crearmenu.getText())) {
            error += "El nombre no es correcto \n";
        }

        if (!Validar.precioCorrecto(etPrecio_crearMenu.getText())) {
            error += "El precio no es correcto \n";
        }

        try {
            String rutalocal = subirImagenCrearMenu.getSelectedFile().toString();
            if (!Validar.imagenCorrecta(rutalocal)) {
                error += "La extensión de la imagen no es la correcta. (Tiene que ser JPG,JPEG o PNG) \n";
            }
        } catch (NullPointerException e) {
            error += "¡Debes seleccionar un fichero! \n";
        }

        if (listaProductos_crearmenu.getSelectedIndices().length <= 1) {
            error += "El menú deben tener dos alimentos como mínimo \n";
        }

        for (Menu menu : menus) {
            if (etNombre_crearmenu.getText().toString().equalsIgnoreCase(menu.getNombre())) {
                error += "Error, ya existe un menú con ese nombre \n";
            }
        }

        if (error.isEmpty()) {
            //Creamos un arraylist con los productos seleccionados y los añadimos
            ArrayList<Producto> productosSel = new ArrayList<>();
            int[] listaProductosSelInd = listaProductos_crearmenu.getSelectedIndices();
            for (int i = 0; i < listaProductosSelInd.length; i++) {
                productosSel.add(productos.get(listaProductosSelInd[i]));
            }

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String rutalocal = subirImagenCrearMenu.getSelectedFile().toString();
            GestionFTP.subir(rutalocal, sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4));

            boolean resultado = GestionMenu.add(new Menu(etNombre_crearmenu.getText(), Double.parseDouble(etPrecio_crearMenu.getText().toString()), sdf1.format(timestamp) + rutalocal.substring(rutalocal.length() - 4), productosSel));
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Menu insertado correctamente");
                //Obtenemos de nuevo todos los menú para tenerlos actualizados
                menus = GestionMenu.getAll();
                elegirMenu_borrar.removeAllItems();
                elegirMenu_editar.removeAllItems();
                for (Menu menu : menus) {
                    elegirMenu_borrar.addItem(menu.getNombre());
                    elegirMenu_editar.addItem(menu.getNombre());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de inserción");
            }
        } else {
            JOptionPane.showMessageDialog(null, error);
        }


    }//GEN-LAST:event_btnEnviarCrearMenuActionPerformed

    /**
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dialogCrearMenu.setVisible(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(OpcionesMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcionesMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcionesMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcionesMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpcionesMenus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarMenu;
    private javax.swing.JButton btnCrearMenu;
    private javax.swing.JButton btnEditarMenu;
    private javax.swing.JButton btnEnviarBorrarMenu;
    private javax.swing.JButton btnEnviarCrearMenu;
    private javax.swing.JButton btnEnviarEditarMenu;
    private javax.swing.JButton btnSubirImagen_addMenu;
    private javax.swing.JButton btnSubirImagen_editarMenu;
    private javax.swing.JDialog dialogBorrarMenu;
    private javax.swing.JDialog dialogCrearMenu;
    private javax.swing.JDialog dialogEditarMenu;
    private javax.swing.JComboBox<String> elegirMenu_borrar;
    private javax.swing.JComboBox<String> elegirMenu_editar;
    private javax.swing.JTextField etNombre_borrarMenu;
    private javax.swing.JTextField etNombre_crearmenu;
    private javax.swing.JTextField etNombre_editarMenu;
    private javax.swing.JTextField etPrecio_borrarMenu;
    private javax.swing.JTextField etPrecio_crearMenu;
    private javax.swing.JTextField etPrecio_editarMenu;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblImagen_borrarMenu;
    private javax.swing.JLabel lblImagen_editarMenu;
    private javax.swing.JList<String> listaProductos_borrarMenu;
    private javax.swing.JList<String> listaProductos_crearmenu;
    private javax.swing.JList<String> listaProductos_editarMenu;
    private javax.swing.JPanel panelFormularioBM;
    private javax.swing.JPanel panelFormularioCM;
    private javax.swing.JPanel panelFormularioEM;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHeader1;
    private javax.swing.JPanel panelHeader2;
    private javax.swing.JPanel panelHeader3;
    private javax.swing.JFileChooser subirImagenCrearMenu;
    private javax.swing.JFileChooser subirImagenEditarMenu;
    // End of variables declaration//GEN-END:variables
}
