package com.AutoBurger.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.AutoBurger.app.Controlador.GestionPedidos;
import com.AutoBurger.app.Modelo.Pedido;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class EsperarComida extends AppCompatActivity {
    TextView numeroPedidoLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esperar_comida);

        numeroPedidoLabel = (TextView) findViewById(R.id.labelPedidoNumero);

        //Recibimos parametros
        Bundle bundle = getIntent().getExtras();
        int numeroPedido = Integer.parseInt(bundle.get("pedidoNumero").toString());
        final Pedido pedido = (Pedido) bundle.get("pedido");

        numeroPedidoLabel.setText(String.format("%03d", numeroPedido));


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //Hacemos el envío por socket
                EnviarSocket enviar = new EnviarSocket();

                try {
                    Gson gson = new Gson();
                    String json = gson.toJson(pedido);
                    Pedido pedidoRecibido = enviar.execute(json).get();

                    if (pedidoRecibido != null) {
                        if (pedidoRecibido.getId() != -99){
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            //deprecated in API 26
                            v.vibrate(500);
                        }

                        new AlertDialog.Builder(EsperarComida.this)
                                .setTitle("TU PEDIDO ESTA LISTO")
                                .setMessage("VE A POR EL!")

                                // Specifying a listener allows you to take an action before dismissing the dialog.
                                // The dialog is automatically dismissed when a dialog button is clicked.
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(EsperarComida.this, MainActivity.class);
                                        finish();
                                        startActivity(intent);
                                    }
                                })

                                // A null listener allows the button to dismiss the dialog and take no further action
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                        } else {
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    do {
                                        try {
                                            TimeUnit.SECONDS.sleep(5);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("comprobando si el pedido pagado ya está completado...");
                                    }while (!GestionPedidos.pedidoCompletado(pedido.getId(), getApplicationContext()));
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            new AlertDialog.Builder(EsperarComida.this)
                                                    .setTitle("TU PEDIDO ESTa LISTO")
                                                    .setMessage("VE A POR EL!")

                                                    // Specifying a listener allows you to take an action before dismissing the dialog.
                                                    // The dialog is automatically dismissed when a dialog button is clicked.
                                                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Intent intent = new Intent(EsperarComida.this, MainActivity.class);
                                                            finish();
                                                            startActivity(intent);
                                                        }
                                                    })

                                                    // A null listener allows the button to dismiss the dialog and take no further action
                                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                                    .show();
                                        }
                                    });
                                }
                            });
                            thread.start();
                        }
                    } else {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println(GestionPedidos.borrarPedido(pedido.getId(), getApplicationContext()));
                            }
                        });
                        thread.start();
                        new AlertDialog.Builder(EsperarComida.this)
                                .setTitle("ERROR")
                                .setMessage("no se ha podido conectar con el servidor, hable con los responsables del restaurante")

                                // Specifying a listener allows you to take an action before dismissing the dialog.
                                // The dialog is automatically dismissed when a dialog button is clicked.
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(EsperarComida.this, ActivityCartaAlimentos.class);
                                        intent.putExtra("pedido",pedido);
                                        finish();
                                        startActivity(intent);
                                    }
                                })

                                // A null listener allows the button to dismiss the dialog and take no further action
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }, 5000);


    }

}