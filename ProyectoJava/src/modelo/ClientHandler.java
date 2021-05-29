/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Vista.VerPedidos;
import com.AutoBurger.app.Modelo.Pedido;
import com.AutoBurger.app.Modelo.Producto;
import com.AutoBurger.app.Modelo.Menu;
import controlador.GestionPedido;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author DavidGG
 */
public class ClientHandler extends Thread {

    DataInputStream dataIn;
    DataOutputStream dataOut;
    Socket socket;
    Pedido pedidoRecibido;

    public ClientHandler(Socket socket, DataInputStream dataIn, DataOutputStream dataOut, Pedido pedidoRecibido) {
        this.socket = socket;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
        this.pedidoRecibido = pedidoRecibido;
    }

    @Override
    public void run() {
        String received;
        String toReturn;

        try {
            //añadido
            ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());

            
            JPanel panel = new JPanel();
            panel.setBackground(Color.gray);

            JTextArea datosPedido = new JTextArea(4, 14);
            String total = "";
            System.out.println(pedidoRecibido.toString());
            for (Object alimento : pedidoRecibido.getCuenta()) {
                if (alimento instanceof Producto) {
                    System.out.println(alimento.toString());
                    total += ((Producto) alimento).getNombre() + "\n";
                } else if (alimento instanceof Menu) {
                    System.out.println(alimento.toString());
                    total += ((Menu) alimento).getNombre() + "\n";
                }

            }
            datosPedido.setText(total);
            datosPedido.setEditable(false);
            JButton b2 = new JButton("Pedido Listo");
            b2.setBounds(100, 100, 80, 30);
            b2.setBackground(Color.green);
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        out.writeObject(pedidoRecibido);
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
            panel.add(b2, BorderLayout.SOUTH);

            VerPedidos.panelContent.add(panel);
            VerPedidos.panelContent.repaint();
            VerPedidos.panelContent.revalidate();

        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }

}
