package Vista;

import controlador.GestionIngrediente;
import controlador.Validar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Ingrediente;

/**
 * @author DavidGG
 * @version 1.0
 */
public class OpcionesIngredientes extends javax.swing.JFrame {

    private static Ingrediente ingredienteSeleccionado;
    private static ArrayList<Ingrediente> ingredientes;

    /**
     * Constructor de la clase que ejecuta el método que inicia la GUI y obtiene
     * todos los ingredientes y los añade a los jcombobox
     */
    public OpcionesIngredientes() {
        initComponents();

        ingredientes = GestionIngrediente.getAll();
        elegirIngrediente_editar.removeAllItems();
        elegirIngrediente_borrar.removeAllItems();
        for (Ingrediente ingrediente : ingredientes) {
            elegirIngrediente_editar.addItem(ingrediente.getNombre());
            elegirIngrediente_borrar.addItem(ingrediente.getNombre());
        }

        panelFormularioBI.setBackground(new Color(181, 97, 54, 240));
        panelFormularioCI.setBackground(new Color(181, 97, 54, 240));
        panelFormularioEI.setBackground(new Color(181, 97, 54, 240));
    }

    /**
     * Método que inicia toda la GUI
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogCreaIngrediente = new javax.swing.JDialog();
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
        javax.swing.JPanel panelContentCI = new JPanel() {        public void paintComponent(Graphics g) {          Image img = Toolkit.getDefaultToolkit().getImage(          "imagenes/back_opcHamburguesas.jpg");          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);          }        };
        panelFormularioCI = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEnviarCrearIngrediente = new javax.swing.JButton();
        etNombre_crearIngrediente = new javax.swing.JTextField();
        dialogEditarIngrediente = new javax.swing.JDialog();
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
        javax.swing.JPanel panelContentEI = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelFormularioEI = new javax.swing.JPanel();
        etNombre_editarIngrediente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        elegirIngrediente_editar = new javax.swing.JComboBox<>();
        btnEnviarEditarIngrediente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dialogBorrarIngrediente = new javax.swing.JDialog();
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
        javax.swing.JPanel panelContentBI = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcHamburguesas.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelFormularioBI = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnEnviarBorrarIngrediente = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        etNombre_borrarIngrediente = new javax.swing.JTextField();
        elegirIngrediente_borrar = new javax.swing.JComboBox<>();
        jPanel1 = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcMenus.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        panelContent = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/back_opcIngredientes.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        btnCrearIngrediente = new javax.swing.JButton();
        btnBorrarIngrediente = new javax.swing.JButton();
        btnEditarIngredinte = new javax.swing.JButton();

        dialogCreaIngrediente.setMinimumSize(null);
        dialogCreaIngrediente.setResizable(false);
        dialogCreaIngrediente.setSize(new java.awt.Dimension(700, 700));

        jPanel3.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel3.setLayout(new java.awt.BorderLayout());

        panelHeader1.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader1.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Crear Ingrediente");
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

        panelContentCI.setBackground(new java.awt.Color(181, 97, 54));
        panelContentCI.setMaximumSize(new java.awt.Dimension(500, 600));
        panelContentCI.setPreferredSize(new java.awt.Dimension(500, 600));

        jLabel1.setText("Nombre:");

        btnEnviarCrearIngrediente.setText("Añadir Ingrediente");
        btnEnviarCrearIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCrearIngredienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioCILayout = new javax.swing.GroupLayout(panelFormularioCI);
        panelFormularioCI.setLayout(panelFormularioCILayout);
        panelFormularioCILayout.setHorizontalGroup(
            panelFormularioCILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioCILayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(etNombre_crearIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(panelFormularioCILayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnEnviarCrearIngrediente)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelFormularioCILayout.setVerticalGroup(
            panelFormularioCILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioCILayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panelFormularioCILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etNombre_crearIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129)
                .addComponent(btnEnviarCrearIngrediente)
                .addGap(202, 202, 202))
        );

        javax.swing.GroupLayout panelContentCILayout = new javax.swing.GroupLayout(panelContentCI);
        panelContentCI.setLayout(panelContentCILayout);
        panelContentCILayout.setHorizontalGroup(
            panelContentCILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentCILayout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(panelFormularioCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
        );
        panelContentCILayout.setVerticalGroup(
            panelContentCILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentCILayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(panelFormularioCI, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        jPanel3.add(panelContentCI, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout dialogCreaIngredienteLayout = new javax.swing.GroupLayout(dialogCreaIngrediente.getContentPane());
        dialogCreaIngrediente.getContentPane().setLayout(dialogCreaIngredienteLayout);
        dialogCreaIngredienteLayout.setHorizontalGroup(
            dialogCreaIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dialogCreaIngredienteLayout.setVerticalGroup(
            dialogCreaIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dialogEditarIngrediente.setMinimumSize(null);
        dialogEditarIngrediente.setResizable(false);
        dialogEditarIngrediente.setSize(new java.awt.Dimension(700, 700));

        jPanel4.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel4.setLayout(new java.awt.BorderLayout());

        panelHeader2.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader2.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Editar Ingrediente");
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

        panelContentEI.setBackground(new java.awt.Color(181, 97, 54));
        panelContentEI.setMaximumSize(new java.awt.Dimension(500, 600));

        jLabel12.setText("Nombre:");

        elegirIngrediente_editar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                elegirIngrediente_editarItemStateChanged(evt);
            }
        });

        btnEnviarEditarIngrediente.setText("Editar Ingrediente");
        btnEnviarEditarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarEditarIngredienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingrediente:");

        javax.swing.GroupLayout panelFormularioEILayout = new javax.swing.GroupLayout(panelFormularioEI);
        panelFormularioEI.setLayout(panelFormularioEILayout);
        panelFormularioEILayout.setHorizontalGroup(
            panelFormularioEILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioEILayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelFormularioEILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormularioEILayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(elegirIngrediente_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFormularioEILayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(etNombre_editarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioEILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnviarEditarIngrediente)
                .addGap(138, 138, 138))
        );
        panelFormularioEILayout.setVerticalGroup(
            panelFormularioEILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioEILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioEILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elegirIngrediente_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelFormularioEILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etNombre_editarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(126, 126, 126)
                .addComponent(btnEnviarEditarIngrediente)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout panelContentEILayout = new javax.swing.GroupLayout(panelContentEI);
        panelContentEI.setLayout(panelContentEILayout);
        panelContentEILayout.setHorizontalGroup(
            panelContentEILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentEILayout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(panelFormularioEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        panelContentEILayout.setVerticalGroup(
            panelContentEILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentEILayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(panelFormularioEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );

        jPanel4.add(panelContentEI, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout dialogEditarIngredienteLayout = new javax.swing.GroupLayout(dialogEditarIngrediente.getContentPane());
        dialogEditarIngrediente.getContentPane().setLayout(dialogEditarIngredienteLayout);
        dialogEditarIngredienteLayout.setHorizontalGroup(
            dialogEditarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogEditarIngredienteLayout.setVerticalGroup(
            dialogEditarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogBorrarIngrediente.setMinimumSize(null);
        dialogBorrarIngrediente.setResizable(false);
        dialogBorrarIngrediente.setSize(new java.awt.Dimension(700, 700));

        jPanel6.setLayout(new java.awt.BorderLayout());

        panelHeader3.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader3.setLayout(new java.awt.BorderLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Borrar Ingrediente");
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

        panelContentBI.setBackground(new java.awt.Color(181, 97, 54));
        panelContentBI.setPreferredSize(new java.awt.Dimension(609, 603));

        jLabel14.setText("Ingrediente:");

        btnEnviarBorrarIngrediente.setText("Borrar Ingrediente");
        btnEnviarBorrarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarBorrarIngredienteActionPerformed(evt);
            }
        });

        jLabel21.setText("Nombre:");

        etNombre_borrarIngrediente.setEditable(false);

        elegirIngrediente_borrar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                elegirIngrediente_borrarItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioBILayout = new javax.swing.GroupLayout(panelFormularioBI);
        panelFormularioBI.setLayout(panelFormularioBILayout);
        panelFormularioBILayout.setHorizontalGroup(
            panelFormularioBILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioBILayout.createSequentialGroup()
                .addGroup(panelFormularioBILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioBILayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel21))
                    .addGroup(panelFormularioBILayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(panelFormularioBILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(elegirIngrediente_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etNombre_borrarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioBILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnviarBorrarIngrediente)
                .addGap(124, 124, 124))
        );
        panelFormularioBILayout.setVerticalGroup(
            panelFormularioBILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioBILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioBILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elegirIngrediente_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(panelFormularioBILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(etNombre_borrarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(btnEnviarBorrarIngrediente)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout panelContentBILayout = new javax.swing.GroupLayout(panelContentBI);
        panelContentBI.setLayout(panelContentBILayout);
        panelContentBILayout.setHorizontalGroup(
            panelContentBILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentBILayout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(panelFormularioBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        panelContentBILayout.setVerticalGroup(
            panelContentBILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentBILayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(panelFormularioBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        jPanel6.add(panelContentBI, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout dialogBorrarIngredienteLayout = new javax.swing.GroupLayout(dialogBorrarIngrediente.getContentPane());
        dialogBorrarIngrediente.getContentPane().setLayout(dialogBorrarIngredienteLayout);
        dialogBorrarIngredienteLayout.setHorizontalGroup(
            dialogBorrarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogBorrarIngredienteLayout.setVerticalGroup(
            dialogBorrarIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogBorrarIngredienteLayout.createSequentialGroup()
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
        jLabel6.setText("Opciones Ingredientes");
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

        btnCrearIngrediente.setBackground(new java.awt.Color(171, 167, 111));
        btnCrearIngrediente.setText("Crear Ingrediente");
        btnCrearIngrediente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearIngredienteActionPerformed(evt);
            }
        });

        btnBorrarIngrediente.setBackground(new java.awt.Color(171, 167, 111));
        btnBorrarIngrediente.setText("Borrar Ingrediente");
        btnBorrarIngrediente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBorrarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarIngredienteActionPerformed(evt);
            }
        });

        btnEditarIngredinte.setBackground(new java.awt.Color(171, 167, 111));
        btnEditarIngredinte.setText("Editar Ingrediente");
        btnEditarIngredinte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarIngredinte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarIngredinteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarIngredinte, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(270, 270, 270))
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnCrearIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnEditarIngredinte, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btnBorrarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jPanel1.add(panelContent, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
     * Método que al hacer click abre el JDialog de crear ingredientes
     *
     * @param evt
     */
    private void btnCrearIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearIngredienteActionPerformed
        this.dispose();
        dialogCreaIngrediente.pack();
        dialogCreaIngrediente.setVisible(true);
        dialogCreaIngrediente.setLocationRelativeTo(null);
        dialogCreaIngrediente.setSize(700, 700);
    }//GEN-LAST:event_btnCrearIngredienteActionPerformed

    /**
     * Método que al hacer click abre el JDialog de borrar ingredientes
     *
     * @param evt
     */
    private void btnBorrarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarIngredienteActionPerformed
        this.dispose();
        dialogBorrarIngrediente.pack();
        dialogBorrarIngrediente.setVisible(true);
        dialogBorrarIngrediente.setLocationRelativeTo(null);
        dialogBorrarIngrediente.setSize(700, 700);
    }//GEN-LAST:event_btnBorrarIngredienteActionPerformed

    /**
     * Método que al hacer click abre el JDialog de editar ingredientes
     *
     * @param evt
     */
    private void btnEditarIngredinteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarIngredinteActionPerformed
        this.dispose();
        dialogEditarIngrediente.pack();
        dialogEditarIngrediente.setVisible(true);
        dialogEditarIngrediente.setLocationRelativeTo(null);
        dialogEditarIngrediente.setSize(700, 700);
    }//GEN-LAST:event_btnEditarIngredinteActionPerformed

    /**
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dialogCreaIngrediente.setVisible(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * Método que crea un nuevo ingrediente al hacer click en botón
     *
     * @param evt
     */
    private void btnEnviarCrearIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCrearIngredienteActionPerformed

        String error = "";
        if (!Validar.nombreCorrecto(etNombre_crearIngrediente.getText())) {
            error += "El nombre no es correcto \n";
        }

        if (error.isEmpty()) {
            boolean resultado = GestionIngrediente.add(etNombre_crearIngrediente.getText());

            if (resultado) {
                JOptionPane.showMessageDialog(null, "Ingrediente insertado correctamente");
                //obtenemos todos los ingredientes (con el nuevo incluido), y lo añadimos a los combobox
                ingredientes = GestionIngrediente.getAll();
                elegirIngrediente_borrar.removeAllItems();
                elegirIngrediente_editar.removeAllItems();
                for (Ingrediente ingrediente : ingredientes) {
                    elegirIngrediente_editar.addItem(ingrediente.getNombre());
                    elegirIngrediente_borrar.addItem(ingrediente.getNombre());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de inserción");
            }
        } else {
            JOptionPane.showMessageDialog(null, error);
        }

    }//GEN-LAST:event_btnEnviarCrearIngredienteActionPerformed

    /**
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dialogEditarIngrediente.setVisible(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Método que al seleccionar otro ingrediente en el combobox, actualizamos
     * los datos en la GUI
     *
     * @param evt
     */
    private void elegirIngrediente_editarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_elegirIngrediente_editarItemStateChanged
        if (elegirIngrediente_editar.getItemCount() > 0 && evt.getStateChange() == ItemEvent.SELECTED) {
            ingredienteSeleccionado = ingredientes.get(elegirIngrediente_editar.getSelectedIndex());
            etNombre_editarIngrediente.setText(ingredienteSeleccionado.getNombre());
        }

    }//GEN-LAST:event_elegirIngrediente_editarItemStateChanged

    /**
     * Método que edita ingrediente al hacer click en botón
     *
     * @param evt
     */
    private void btnEnviarEditarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarEditarIngredienteActionPerformed
        if (elegirIngrediente_editar.getSelectedIndex() >= 0) {
            String error = "";

            if (!Validar.nombreCorrecto(etNombre_editarIngrediente.getText())) {
                error += "El nombre no es correcto \n";
            }

            if (ingredienteSeleccionado.getNombre().equalsIgnoreCase(etNombre_editarIngrediente.getText())) {
                error += "¡No has modificado el ingrediente!";
            }

            if (error.isEmpty()) {

                int joption = 0;
                boolean resultado = false;
                //Vamos a comprobar si el ingrediente editado coincide con otro, para poner una advertencia.
                for (Ingrediente ingrediente : ingredientes) {
                    if (etNombre_editarIngrediente.getText().equalsIgnoreCase(ingrediente.getNombre())) {
                        joption = JOptionPane.showConfirmDialog(null,
                                "¡Cuidado! Ya hay un ingrediente con el mismo nombre y podría crear conflictos... ¿Desea continuar?", null, JOptionPane.YES_NO_OPTION);
                    }
                }

                if (joption == JOptionPane.YES_OPTION) {
                    resultado = GestionIngrediente.editar(ingredienteSeleccionado.getId(), etNombre_editarIngrediente.getText());
                }

                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Ingrediente editado correctamente");
                    //Obtenemos de nuevo todos los ingredientes para tenerlos actualizados
                    ingredientes = GestionIngrediente.getAll();
                    elegirIngrediente_editar.removeAllItems();
                    elegirIngrediente_borrar.removeAllItems();
                    for (Ingrediente ingrediente : ingredientes) {
                        elegirIngrediente_editar.addItem(ingrediente.getNombre());
                        elegirIngrediente_borrar.addItem(ingrediente.getNombre());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error no hay seleccionado ningún menú.");
        }
    }//GEN-LAST:event_btnEnviarEditarIngredienteActionPerformed

    /**
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dialogBorrarIngrediente.setVisible(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Método que borra el ingrediente seleccionado al hacer click en botón
     *
     * @param evt
     */
    private void btnEnviarBorrarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarBorrarIngredienteActionPerformed
        boolean resultado = GestionIngrediente.borrar(ingredienteSeleccionado.getId());
        //Si la ejecución de añadir el producto con sus ingredientes es correcta.
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Ingrediente borrado correctamente");
            elegirIngrediente_editar.removeAllItems();
            elegirIngrediente_borrar.removeAllItems();
            ingredientes = GestionIngrediente.getAll();
            for (Ingrediente ingrediente : ingredientes) {
                elegirIngrediente_editar.addItem(ingrediente.getNombre());
                elegirIngrediente_borrar.addItem(ingrediente.getNombre());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error de borrado");
        }

    }//GEN-LAST:event_btnEnviarBorrarIngredienteActionPerformed

    /**
     * Método que actualiza el ingredienteactual al hacer click en otro
     * ingrediente en el combobox
     *
     * @param evt
     */
    private void elegirIngrediente_borrarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_elegirIngrediente_borrarItemStateChanged
        if (elegirIngrediente_borrar.getItemCount() > 0 && evt.getStateChange() == ItemEvent.SELECTED) {
            ingredienteSeleccionado = ingredientes.get(elegirIngrediente_borrar.getSelectedIndex());
            etNombre_borrarIngrediente.setText(ingredienteSeleccionado.getNombre());
        }
    }//GEN-LAST:event_elegirIngrediente_borrarItemStateChanged

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
            java.util.logging.Logger.getLogger(OpcionesIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcionesIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcionesIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcionesIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpcionesIngredientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarIngrediente;
    private javax.swing.JButton btnCrearIngrediente;
    private javax.swing.JButton btnEditarIngredinte;
    private javax.swing.JButton btnEnviarBorrarIngrediente;
    private javax.swing.JButton btnEnviarCrearIngrediente;
    private javax.swing.JButton btnEnviarEditarIngrediente;
    private javax.swing.JDialog dialogBorrarIngrediente;
    private javax.swing.JDialog dialogCreaIngrediente;
    private javax.swing.JDialog dialogEditarIngrediente;
    private javax.swing.JComboBox<String> elegirIngrediente_borrar;
    private javax.swing.JComboBox<String> elegirIngrediente_editar;
    private javax.swing.JTextField etNombre_borrarIngrediente;
    private javax.swing.JTextField etNombre_crearIngrediente;
    private javax.swing.JTextField etNombre_editarIngrediente;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelFormularioBI;
    private javax.swing.JPanel panelFormularioCI;
    private javax.swing.JPanel panelFormularioEI;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHeader1;
    private javax.swing.JPanel panelHeader2;
    private javax.swing.JPanel panelHeader3;
    // End of variables declaration//GEN-END:variables
}
