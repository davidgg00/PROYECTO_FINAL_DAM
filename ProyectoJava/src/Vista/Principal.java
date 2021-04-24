/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author DavidGG
 */
public class Principal extends javax.swing.JFrame {
VerPedidos m;
    /**
     * Creates new form Principal
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
        },
                1000
        );
        }
        
    }

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Hamburguesería GG");

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                VerPedidos.abrirServerSocket();
            }
        },
                1000
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPadre = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    Principal.class.getResource("/imagenes/background_2.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnVerPedidos = new javax.swing.JButton();
        btnOpcMenus = new javax.swing.JButton();
        btnOpcProductos = new javax.swing.JButton();
        btnHistorialPedidos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 615));

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

        javax.swing.GroupLayout panelPadreLayout = new javax.swing.GroupLayout(panelPadre);
        panelPadre.setLayout(panelPadreLayout);
        panelPadreLayout.setHorizontalGroup(
            panelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPadreLayout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelPadreLayout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addGroup(panelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHistorialPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(btnOpcProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpcMenus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPadreLayout.setVerticalGroup(
            panelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPadreLayout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnVerPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnOpcMenus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnOpcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnHistorialPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPadre, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPadre, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosActionPerformed
        // TODO add your handling code here:
        m.setVisible(true);
        m.setLocationRelativeTo(null);
        //etVisible(false);
    }//GEN-LAST:event_btnVerPedidosActionPerformed

    private void btnOpcMenusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcMenusActionPerformed
        // TODO add your handling code here:
        OpcionesMenus opcMenu = new OpcionesMenus();
        opcMenu.setVisible(true);
        opcMenu.setLocationRelativeTo(null);
        //setVisible(false);
    }//GEN-LAST:event_btnOpcMenusActionPerformed

    private void btnOpcProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcProductosActionPerformed
        // TODO add your handling code here:
        OpcionesProducto opcProd = new OpcionesProducto();
        opcProd.setVisible(true);
        opcProd.setLocationRelativeTo(null);
        //setVisible(false);
    }//GEN-LAST:event_btnOpcProductosActionPerformed

    private void btnHistorialPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialPedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorialPedidosActionPerformed

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
    private javax.swing.JButton btnHistorialPedidos;
    private javax.swing.JButton btnOpcMenus;
    private javax.swing.JButton btnOpcProductos;
    private javax.swing.JButton btnVerPedidos;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelPadre;
    // End of variables declaration//GEN-END:variables
}
