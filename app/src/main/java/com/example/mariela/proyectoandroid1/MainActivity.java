package com.example.mariela.proyectoandroid1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtUsuario;
    private EditText txtPassword;
    private Button btnEnviar;
    private TextView txtResultado;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        txtUsuario=(EditText)findViewById(R.id.txtUser);
        txtPassword=(EditText)findViewById(R.id.txtPass);
        btnEnviar=(Button)findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String campo_usuario = txtUsuario.getText().toString();
        String campo_password = txtPassword.getText().toString();
        if (campo_usuario.equals("") || campo_password.equals("") || campo_usuario == null || campo_password == null)
        {
            Toast.makeText(getApplicationContext(),"Ingrese Usuario y Contraseña",Toast.LENGTH_SHORT).show();
        }
        else if (campo_usuario.compareTo("mheredia") == 0 && campo_password.compareTo("12345678") == 0){
            Intent a=new Intent(context,MenuPrincipal.class);
            String[] datos=new String[2];
            datos[0]=txtUsuario.getText().toString();
            datos[1]=txtPassword.getText().toString();
            a.putExtra("datos_usuario", datos);
            startActivity(a);
            //Toast.makeText(getApplicationContext(),"Login exitoso",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Usuario o Contraseña inválidos",Toast.LENGTH_SHORT).show();
    }
}
