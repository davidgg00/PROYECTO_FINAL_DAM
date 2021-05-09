package com.AutoBurger.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.TextView;

import com.AutoBurger.app.Modelo.Pedido;

import java.util.concurrent.ExecutionException;

public class EsperarComida extends AppCompatActivity {
    TextView numeroPedidoLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esperar_comida);

        numeroPedidoLabel = (TextView)findViewById(R.id.labelPedidoNumero);

        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        int numeroPedido = Integer.parseInt(bundle.get("pedidoNumero").toString());
        final Pedido pedido = (Pedido) bundle.get("pedido");

        numeroPedidoLabel.setText(String.format("%03d", numeroPedido));


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //Hacemos el envío por socket
                EnviarSocket enviar = new EnviarSocket();

                try {
                    if (!enviar.execute(pedido).get().toString().isEmpty()){
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            //deprecated in API 26
                            v.vibrate(500);
                        }

                        new AlertDialog.Builder(EsperarComida.this)
                                .setTitle("TU PEDIDO ESTÁ LISTO")
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


                    }else {
                        System.out.println("elseee");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, 5000);


    }

}