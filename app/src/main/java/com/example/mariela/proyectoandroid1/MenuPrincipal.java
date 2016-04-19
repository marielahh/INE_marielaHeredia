package com.example.mariela.proyectoandroid1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {

    private TextView txtUserL;
    private ImageView productos;
    private ImageView clientes;
    private ImageView pedidos;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        txtUserL = (TextView)findViewById(R.id.txtUserL);
        productos = (ImageView)findViewById(R.id.imgProd);
        clientes = (ImageView)findViewById(R.id.imgCli);
        pedidos = (ImageView)findViewById(R.id.imgPed);
        productos.setOnClickListener(this);
        clientes.setOnClickListener(this);
        pedidos.setOnClickListener(this);

        Intent b = getIntent();
        String[] datos_recibidos = new String[2];
        datos_recibidos = b.getStringArrayExtra("datos_usuario");
        txtUserL.setText("Hola "+ datos_recibidos[0]+"!");

        Toast.makeText(this, "Bienvenido " + datos_recibidos[0], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgProd:
                Intent a = new Intent(this,Productos.class);
                startActivity(a);
            break;
            case R.id.imgCli:
                Intent b = new Intent(this,Usuarios.class);
                startActivity(b);
            break;
            case R.id.imgPed:
                Toast.makeText(this, "Pedidos en proceso... ", Toast.LENGTH_SHORT).show();
            break;
        }

    }
    public void cerrarsesion(View v){
        Intent ab = new Intent(this,Productos.class);
        startActivity(ab);
    }

}
