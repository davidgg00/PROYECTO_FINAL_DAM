package com.example.hamburgergg_android;

import android.os.AsyncTask;

import com.example.hamburgergg_android.Modelo.Pedido;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EnviarSocket extends AsyncTask<Pedido, Pedido,Pedido> {

    Socket s;
    DataOutputStream dtr;
    PrintWriter pw;
    Pedido pedido;

    @Override
    protected Pedido doInBackground(Pedido... Voids) {
        System.out.println("doinbackground ejecutandose");
        pedido = Voids[0];
        Boolean fin = false;
        Pedido cuentareturn = null;
        try {
            s = new Socket("192.168.1.23",8000);
            OutputStream outputStream = s.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(pedido);

            do {
                System.out.println("Tu cuenta es: " + pedido.getId());
                ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream());
                System.out.println("entro do_while");
                cuentareturn = (Pedido) objectInput.readObject();
            } while (cuentareturn.getId() != pedido.getId() || cuentareturn == null);
            //objectInput.close();
            System.out.println("adios");
            //hasta aqui
            // s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cuentareturn;
    }

}

