package Vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author DavidGG
 * @version 1.0
 */
public class Principal extends javax.swing.JFrame {

    VerPedidos m;

    /**
     * Constructor de la clase que ejecuta el método que inicia la GUI, abre el
     * servidor socket para recibir pedidos al momento y carga algunos datos del
     * configuracion.properties
     */
    public Principal(boolean abrirSocket) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Hamburguesería GG");

        m = new VerPedidos();
        if (abrirSocket) {
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                @Override
                public void run() {
                    VerPedidos.abrirServerSocket();
                }
            }, 1000
            );
        }
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/logo2.png"));

    }
    
    /**
     * Método que inicia toda la GUI
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPadre = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/background_2.png");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnVerPedidos = new javax.swing.JButton();
        btnOpcMenus = new javax.swing.JButton();
        btnOpcProductos = new javax.swing.JButton();
        btnHistorialPedidos = new javax.swing.JButton();
        btnOpcIngredientes = new javax.swing.JButton();
        btnCopiaSeguridad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 615));
        setResizable(false);

        panelPadre.setMinimumSize(new java.awt.Dimension(1014, 728));
        panelPadre.setPreferredSize(new java.awt.Dimension(1014, 728));

        panelHeader.setBackground(new java.awt.Color(130, 93, 46));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("AJUSTES HAMBURGUESERÍA");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(jLabel6)
                .addContainerGap(390, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnVerPedidos.setBackground(new java.awt.Color(171, 167, 111));
        btnVerPedidos.setText("Ver Pedidos");
        btnVerPedidos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosActionPerformed(evt);
            }
        });
        btnVerPedidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnVerPedidosKeyPressed(evt);
            }
        });

        btnOpcMenus.setBackground(new java.awt.Color(171, 167, 111));
        btnOpcMenus.setText("Opciones Menús");
        btnOpcMenus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOpcMenus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcMenusActionPerformed(evt);
            }
        });

        btnOpcProductos.setBackground(new java.awt.Color(171, 167, 111));
        btnOpcProductos.setText("Opciones Producto");
        btnOpcProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOpcProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcProductosActionPerformed(evt);
            }
        });

        btnHistorialPedidos.setBackground(new java.awt.Color(171, 167, 111));
        btnHistorialPedidos.setText("Historial de Pedidos");
        btnHistorialPedidos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHistorialPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialPedidosActionPerformed(evt);
            }
        });

        btnOpcIngredientes.setBackground(new java.awt.Color(171, 167, 111));
        btnOpcIngredientes.setText("Opciones Ingredientes");
        btnOpcIngredientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOpcIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcIngredientesActionPerformed(evt);
            }
        });

        btnCopiaSeguridad.setBackground(new java.awt.Color(171, 167, 111));
        btnCopiaSeguridad.setText("Copia de Seguridad");
        btnCopiaSeguridad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCopiaSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiaSeguridadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPadreLayout = new javax.swing.GroupLayout(panelPadre);
        panelPadre.setLayout(panelPadreLayout);
        panelPadreLayout.setHorizontalGroup(
            panelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPadreLayout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelPadreLayout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addGroup(panelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCopiaSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpcIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHistorialPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpcMenus, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPadreLayout.setVerticalGroup(
            panelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPadreLayout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnVerPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOpcIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOpcMenus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOpcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistorialPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCopiaSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPadre, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPadre, javax.swing.GroupLayout.PREFERRED_SIZE, 678, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que al hacer click pone como visible "Ver Pedidos"
     *
     * @param evt
     */
    private void btnVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosActionPerformed
        m.setVisible(true);
        m.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnVerPedidosActionPerformed

    /**
     * Método que al hacer click abre la GUI de la clase de OpcionesMenu
     *
     * @param evt
     */
    private void btnOpcMenusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcMenusActionPerformed
        OpcionesMenus opcMenu = new OpcionesMenus();
        opcMenu.setVisible(true);
        opcMenu.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnOpcMenusActionPerformed

    /**
     * Método que al hacer click abre la GUI de la clase de OpcionesProductos
     *
     * @param evt
     */
    private void btnOpcProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcProductosActionPerformed
        OpcionesProducto opcProd = new OpcionesProducto();
        opcProd.setVisible(true);
        opcProd.setLocationRelativeTo(null);
        //setVisible(false);
    }//GEN-LAST:event_btnOpcProductosActionPerformed

    /**
     * Método que al hacer click abre la GUI de la clase de
     * OpcionesHistorialPedidos
     *
     * @param evt
     */
    private void btnHistorialPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialPedidosActionPerformed
        OpcionesHistorialPedidos opcHistorial = new OpcionesHistorialPedidos();
        opcHistorial.setVisible(true);
        opcHistorial.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHistorialPedidosActionPerformed

    /**
     * Método que al hacer click abre la GUI de la clase de OpcionesIngredientes
     *
     * @param evt
     */
    private void btnOpcIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcIngredientesActionPerformed
        OpcionesIngredientes opcIngr = new OpcionesIngredientes();
        opcIngr.setVisible(true);
        opcIngr.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnOpcIngredientesActionPerformed

    /**
     * Método que al hacer click te permite crear copia de seguridad,
     * restaurarla o ver fecha de la última copia
     *
     * @param evt
     */
    private void btnCopiaSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiaSeguridadActionPerformed

        //Mostramos JOptionPane
        String[] options = new String[]{"Fecha última copia seguridad", "Realizar copia de seguridad", "Cancelar"};
        int response = JOptionPane.showOptionDialog(null, "Puedes realizar copias de seguridad de la base de datos.\nSolo se guardan los datos, las fotos no.", "COPIA DE SEGURIDAD",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        //Dependiendo del botón que se pulse
        switch (response) {
            case 0:
                JOptionPane.showMessageDialog(this, new Date(new File("../sql/hamburgueseria.sql").lastModified()), "FECHA ÚLTIMA COPIA SEGURIDAD BBDD", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                try {
                Process p = Runtime.getRuntime().exec("mysqldump.exe -u root --database hamburgueseria");
                InputStream is = p.getInputStream();//Pedimos la entrada
                FileOutputStream fos = new FileOutputStream("../sql/hamburgueseria.sql");
                byte[] buffer = new byte[1000];

                int leido = is.read(buffer);
                while (leido > 0) {
                    fos.write(buffer, 0, leido);
                    leido = is.read(buffer);
                }
                fos.close();
                JOptionPane.showMessageDialog(this, "Copia de seguridad realizada correctamente", "Copia de Seguridad", JOptionPane.PLAIN_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();

            }
            break;
            case 2:
//                int reply = JOptionPane.showConfirmDialog(this, "¿Desea realizar la copia de seguridad?\n Una vez hecha no puede dar marcha atrás.", "ATENCIÓN", JOptionPane.YES_NO_OPTION);
//                if (reply == JOptionPane.YES_OPTION) {
//                    File scriptFile = new File("../sql/hamburgueseria.sql");
//
//                    BufferedReader entrada = null;
//                    try {
//                        entrada = new BufferedReader(new FileReader(scriptFile));
//                    } catch (FileNotFoundException e) {
//                        JOptionPane.showMessageDialog(this, "No hay una copia de seguridad hecha", "ERROR AL IMPORTAR LA COPIA DE SEGURIDAD", JOptionPane.ERROR_MESSAGE);
//                    }
//                    String linea = null;
//                    StringBuilder stringBuilder = new StringBuilder();
//                    String salto = System.getProperty("line.separator");
//                    try {
//                        while ((linea = entrada.readLine()) != null) {
//                            stringBuilder.append(linea);
//                            stringBuilder.append(salto);
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    String consulta = stringBuilder.toString();
//                    System.out.println(consulta);
//
//                    try {
//                        Class.forName("com.mysql.jdbc.Driver");
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        Connection connmysql = (Connection) DriverManager
//                                .getConnection("jdbc:mysql://localhost/hamburgueseria?allowMultiQueries=true", "root", "");
//                        Statement sents = connmysql.createStatement();
//                        int res = sents.executeUpdate(consulta);
//                        JOptionPane.showMessageDialog(this, "Copia de seguridad importada correctamente.");
//                        connmysql.close();
//                        sents.close();
//                    } catch (SQLException e) {
//                        JOptionPane.showMessageDialog(this, "Error en la ejecución SQL del archivo", "Archivo corrupto", JOptionPane.ERROR_MESSAGE);
//                        e.printStackTrace();
//                    }
//                }

                break;
        }
    }//GEN-LAST:event_btnCopiaSeguridadActionPerformed

    private void btnVerPedidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnVerPedidosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            btnVerPedidos.doClick();
        }
    }//GEN-LAST:event_btnVerPedidosKeyPressed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal(true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopiaSeguridad;
    private javax.swing.JButton btnHistorialPedidos;
    private javax.swing.JButton btnOpcIngredientes;
    private javax.swing.JButton btnOpcMenus;
    private javax.swing.JButton btnOpcProductos;
    private javax.swing.JButton btnVerPedidos;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelPadre;
    // End of variables declaration//GEN-END:variables
}
