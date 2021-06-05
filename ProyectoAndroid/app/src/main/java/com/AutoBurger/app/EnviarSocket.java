package com.AutoBurger.app;

import android.os.AsyncTask;

import com.AutoBurger.app.Modelo.Pedido;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
/**
 *
 * @author DavidGG
 * @version 1.0
 */
public class EnviarSocket extends AsyncTask<String, String,Pedido> {

    Socket s;
    PrintWriter pw;
    String pedido;

    /**
     * Método que ejecuta en segundo plano la espera del socket de confirmación de pedido terminado
     * @param Voids
     * @return
     */
    @Override
    protected Pedido doInBackground(String... Voids) {
        System.out.println("doinbackground ejecutandose");
        Pedido pedidoobj;
        pedido = Voids[0];
        Boolean fin = false;
        String json;
        Pedido cuentareturn = null;
        Gson gson = new Gson();
        try {
            s = new Socket();
            s.connect(new InetSocketAddress("192.168.1.23",8000), 5000);

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(pedido);
            //TENGO QUE HACER ESTO
            pedidoobj = gson.fromJson(pedido, Pedido.class);

            do {
                System.out.println("Tu cuenta es: " + pedido);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                System.out.println("entro do_while");
                json = (String)dis.readUTF();
                cuentareturn = gson.fromJson(json, Pedido.class);
                System.out.println("a: " + cuentareturn.toString());
            } while (cuentareturn.getId() != pedidoobj.getId() || cuentareturn == null);
            System.out.println(cuentareturn.getId() != pedidoobj.getId());
            System.out.println(cuentareturn == null);
            //objectInput.close();
            System.out.println("adios");
            //hasta aqui
            // s.close();
        } catch(SocketTimeoutException s){
            return null;
        }catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            try {
                s.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            cuentareturn = new Pedido();
            cuentareturn.setId(-99);
            return cuentareturn;

        }

        return cuentareturn;
    }

}

