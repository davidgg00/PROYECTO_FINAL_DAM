/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import modelo.ClientHandler;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import controlador.GestionPedido;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import modelo.Pedido;
import test.WrapLayout;
import utilidades.Constantes;

/**
 * @author DavidGG
 * @version 1.0
 */
public class VerPedidos extends javax.swing.JFrame {

    static String mensaje = "";

    /**
     * Constructor de la clase que ejecuta el método que inicia la GUI y obtiene
     * todos los pedidos antiguos si los hay
     */
    public VerPedidos() {
        initComponents();
        panelContent.setLayout(new WrapLayout(0));
        panelContentPadre.setHorizontalScrollBar(null);
        getPedidosAntiguos();
    }

    /**
     * Método que abre el serversocket
     */
    public static void abrirServerSocket() {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(Constantes.puertoSocket);
        } catch (IOException ex) {
            Logger.getLogger(VerPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
            Socket socket = null;
            //Se acepta el nuevo cliente y se crea un hilo para mandarlo en segundo plano
            //para seguir aceptando nuevos pedidos 
            try {
                Gson gson = new Gson();
                socket = serverSocket.accept();
  
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String json = (String) dis.readUTF();
                Pedido cuentaRecibida = gson.fromJson(json, Pedido.class);

                Thread nuevoHilo = new ClientHandler(socket, new DataInputStream(socket.getInputStream()), new DataOutputStream(socket.getOutputStream()), cuentaRecibida);

                nuevoHilo.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método que inicia toda la GUI
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPedidos = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/background_pedidosPendientes.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        panelHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelContentPadre = new javax.swing.JScrollPane();
        panelContent = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    "imagenes/background_pedidosPendientes.jpg");  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPedidos.setMaximumSize(new java.awt.Dimension(800, 500));
        panelPedidos.setMinimumSize(new java.awt.Dimension(800, 500));
        panelPedidos.setPreferredSize(new java.awt.Dimension(800, 500));
        panelPedidos.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(130, 93, 46));
        panelHeader.setPreferredSize(new java.awt.Dimension(786, 84));
        panelHeader.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pedidos Pendientes");
        jLabel6.setMinimumSize(null);
        panelHeader.add(jLabel6, java.awt.BorderLayout.CENTER);

        jButton1.setIcon(new javax.swing.ImageIcon("imagenes/goback.png"));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelHeader.add(jButton1, java.awt.BorderLayout.EAST);

        panelPedidos.add(panelHeader, java.awt.BorderLayout.NORTH);

        panelContent.setMaximumSize(new java.awt.Dimension(10, 10));
        panelContentPadre.setViewportView(panelContent);

        panelPedidos.add(panelContentPadre, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelPedidos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerPedidos().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JPanel panelContent;
    public static javax.swing.JScrollPane panelContentPadre;
    private javax.swing.JPanel panelHeader;
    public static javax.swing.JPanel panelPedidos;
    // End of variables declaration//GEN-END:variables

    /**
     * Método que busca los pedidos antiguos que al cerrarse el serversocket se
     * quedaron pendientes Para mostrarlos en la GUI y volver a prepararlos y
     * ponerlos como listo
     */
    private void getPedidosAntiguos() {
        JsonArray jsonArrayPedidos = GestionPedido.getPedidosPendientes();

        for (int i = 0; i < jsonArrayPedidos.size(); i++) {
            System.out.println(jsonArrayPedidos.get(i).getAsJsonObject().get("pedido").toString());
            JPanel panel = new JPanel();
            panel.setBackground(Color.gray);

            Pedido pedidoAntiguo = new Pedido(Integer.parseInt(jsonArrayPedidos.get(i).getAsJsonObject().get("id").toString().replace("\"", "")), jsonArrayPedidos.get(i).getAsJsonObject().get("email_cliente").toString(), Double.parseDouble(jsonArrayPedidos.get(i).getAsJsonObject().get("total_a_pagar").toString().replace("\"", "")));
            JTextArea datosPedido = new JTextArea(4, 14);
            datosPedido.setEditable(false);
            datosPedido.setText(jsonArrayPedidos.get(i).getAsJsonObject().get("pedido").toString().replace("\"", "").replace(",", "\n"));
            String email_cliente = jsonArrayPedidos.get(i).getAsJsonObject().get("email_cliente").toString().replace("\"", "");
            String nPedido = jsonArrayPedidos.get(i).getAsJsonObject().get("pedidoNumero").toString().replace("\"", "");
            JButton buttonDatosCliente = new JButton("Datos Cliente");
            buttonDatosCliente.setBounds(100, 100, 80, 30);
            buttonDatosCliente.setBackground(Color.orange);
            buttonDatosCliente.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, email_cliente.equalsIgnoreCase("invitado@invitado.com") ? "Sesión Invitado \n NºPedido: " + nPedido : email_cliente + "\n NºPedido: " + nPedido);
                }

            });

            JButton b2 = new JButton("Pedido Listo");
            b2.setBounds(100, 100, 80, 30);
            b2.setBackground(Color.green);
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    b2.getParent().hide();
                    GestionPedido.entregado(pedidoAntiguo);
                }

            });
            JScrollPane scroll = new JScrollPane(datosPedido);
            panel.setLayout(new BorderLayout());
            panel.add(scroll, BorderLayout.NORTH);
            panel.add(buttonDatosCliente, BorderLayout.CENTER);
            panel.add(b2, BorderLayout.SOUTH);

            VerPedidos.panelContent.add(panel);
            VerPedidos.panelContent.repaint();
            VerPedidos.panelContent.revalidate();

        }
    }
}
