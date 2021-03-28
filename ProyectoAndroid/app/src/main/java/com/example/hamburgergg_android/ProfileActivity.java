package com.example.hamburgergg_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.hamburgergg_android.Modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private static Producto producto;
    List<Producto> messages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView nameTxt = findViewById(R.id.nameTextView);
        TextView precio = findViewById(R.id.precio);

        nameTxt.setText("xD");
    }
}