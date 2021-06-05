package modelo;

import Vista.VerPedidos;
import com.google.gson.Gson;
import controlador.GestionPedido;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author DavidGG
 * @version 1.0
 */
public class ClientHandler extends Thread {

    DataInputStream dataIn;
    DataOutputStream dataOut;
    Socket socket;
    Pedido pedidoRecibido;

    /**
     * Constructor
     *
     * @param socket
     * @param dataIn
     * @param dataOut
     * @param pedidoRecibido
     */
    public ClientHandler(Socket socket, DataInputStream dataIn, DataOutputStream dataOut, Pedido pedidoRecibido) {
        this.socket = socket;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
        this.pedidoRecibido = pedidoRecibido;
    }

    /**
     * Método que al arrancar el hilo, añade el pedido en la vista "VerPedidos"
     */
    @Override
    public void run() {
        String received;
        String toReturn;

        try {
            dataOut = new DataOutputStream(this.socket.getOutputStream());

            JPanel panel = new JPanel();
            panel.setBackground(Color.gray);

            JTextArea datosPedido = new JTextArea(4, 14);
            String total = "";
            for (Object alimento : pedidoRecibido.getCuenta()) {
                int l = alimento.toString().indexOf("nombre=");
                int x = alimento.toString().indexOf(",", l);
                total += alimento.toString().substring(l + 7, x) + "\n";
            }
            datosPedido.setText(total);
            datosPedido.setEditable(false);
            String email_cliente = pedidoRecibido.getEmail_cliente();
            int nPedido = pedidoRecibido.getPedidoNumero();
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
                    try {
                        Gson gson = new Gson();
                        String json = gson.toJson(pedidoRecibido);

                        dataOut.writeUTF(json);
                        socket.close();
                        dataIn.close();
                        dataOut.close();
                        b2.getParent().hide();
                        GestionPedido.entregado(pedidoRecibido);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
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

        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }

}
