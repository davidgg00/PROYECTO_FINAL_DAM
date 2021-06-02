package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author DavidGG
 * @version 1.0
 */
public class OpcionesHistorialPedidos extends javax.swing.JFrame {

    /**
     * Constructor de la clase que ejecuta el método para iniciar la GUI y pone
     * un fondo transparente al wrapperContent
     */
    public OpcionesHistorialPedidos() {
        initComponents();
        wrapperContent.setBackground(new Color(181, 97, 54, 240));
    }

    @SuppressWarnings("unchecked")
    /**
     * Método que inicia toda la GUI
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "/imagenes/back_opcMenus.jpg");  
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
        wrapperContent = new javax.swing.JPanel();
        fechaFin = new javax.swing.JTextField();
        fechaInicio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etIdPedido = new javax.swing.JTextField();
        btnPedidoEspecifico = new javax.swing.JButton();
        btnHistorialPedidos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Opciones Historial Pedidos");
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

        jLabel5.setText("Fecha Fin");

        jLabel4.setText("Fecha Inicio");

        jLabel3.setText("IdPedido");

        btnPedidoEspecifico.setText("Ver Pedido Específico");
        btnPedidoEspecifico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoEspecificoActionPerformed(evt);
            }
        });

        btnHistorialPedidos.setText("Ver historial Pedidos");
        btnHistorialPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialPedidosActionPerformed(evt);
            }
        });

        jLabel9.setText("Dejar vacío si quiere ver historial completo");

        javax.swing.GroupLayout wrapperContentLayout = new javax.swing.GroupLayout(wrapperContent);
        wrapperContent.setLayout(wrapperContentLayout);
        wrapperContentLayout.setHorizontalGroup(
            wrapperContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wrapperContentLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(wrapperContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wrapperContentLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(wrapperContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(wrapperContentLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(etIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(wrapperContentLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel3))
                            .addComponent(btnPedidoEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(wrapperContentLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(wrapperContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnHistorialPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(wrapperContentLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel5))
                    .addGroup(wrapperContentLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4))
                    .addComponent(jLabel9))
                .addGap(104, 104, 104))
        );
        wrapperContentLayout.setVerticalGroup(
            wrapperContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHistorialPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btnPedidoEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContentLayout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addComponent(wrapperContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(wrapperContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jPanel1.add(panelContent, java.awt.BorderLayout.CENTER);

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
     * Método que al hacer click en el boton de marcha atrás, cierra la ventana
     * actual.
     *
     * @param evt
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * Al hacer click en ver historial de pedidos muestra historial de pedidos.
     * Si hay unas fechas introducidas, entre ese periodo de fechas, sino
     * historial completo.
     *
     * @param evt
     */
    private void btnHistorialPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialPedidosActionPerformed

        Connection conectar = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/hamburgueseria", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion de la base de datos");
        }
        try {
            Statement sentencia = conectar.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el objeto sentencia");
        }

        try {
            String rutaInforme = "reportes\\ReporteHamburgueseria.jasper";
            Map parametros = new HashMap();
            String strFechaInicio = "2000/01/01", strFechaFin = "2500/01/01";
            if (!fechaInicio.getText().isEmpty() && !fechaFin.getText().isEmpty()) {
                if (fechaInicio.getText().matches("\\d{4}-\\d{2}-\\d{2}") && fechaFin.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
                    strFechaInicio = fechaInicio.getText().toString();
                    strFechaFin = fechaFin.getText().toString();
                } else {
                    JOptionPane.showMessageDialog(null, "El formato de fecha tiene que ser YYYY-MM-DD");
                    return;
                }

            }

            parametros.put("FECHAINI", strFechaInicio);
            parametros.put("FECHAFIN", strFechaFin);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros, conectar);

            JasperViewer ventanavisor = new JasperViewer(informe, false);
            ventanavisor.setTitle("Historial Pedidos");
            ventanavisor.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "error fatgal");
            e.printStackTrace();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No existen pedidos con ese intervalo de fechas");
        }


    }//GEN-LAST:event_btnHistorialPedidosActionPerformed

    /**
     * Método para ver el informe de los datos de un pedido en específico. Se le
     * especifica el id del pedido
     *
     * @param evt
     */
    private void btnPedidoEspecificoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoEspecificoActionPerformed
        Connection conectar = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/hamburgueseria", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion de la base de datos");
        }
        try {
            Statement sentencia = conectar.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el objeto sentencia");
        }

        try {
            String rutaInforme = "reportes\\ReportPedidoHamburgueseria.jasper";
            Map parametros = new HashMap();

            if (!etIdPedido.getText().isEmpty() && Integer.parseInt(etIdPedido.getText().toString()) > 0) {
                parametros.put("IDPEDIDO", etIdPedido.getText().toString());
                JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros, conectar);

                JasperViewer ventanavisor = new JasperViewer(informe, false);
                ventanavisor.setTitle("Historial Pedidos");
                ventanavisor.setVisible(true);;
            } else {
                JOptionPane.showMessageDialog(null, "El campo IDPEDIDO es necesario y debe de ser númerico (y positivo)");
            }

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "error fatal al cargar el .jasper");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo IDPEDIDO ha de ser numérico");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No existe pedido con ese ID");
        }
    }//GEN-LAST:event_btnPedidoEspecificoActionPerformed

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
            java.util.logging.Logger.getLogger(OpcionesHistorialPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcionesHistorialPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcionesHistorialPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcionesHistorialPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpcionesHistorialPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorialPedidos;
    private javax.swing.JButton btnPedidoEspecifico;
    private javax.swing.JTextField etIdPedido;
    private javax.swing.JTextField fechaFin;
    private javax.swing.JTextField fechaInicio;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel wrapperContent;
    // End of variables declaration//GEN-END:variables
}
