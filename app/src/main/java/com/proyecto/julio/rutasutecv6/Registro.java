package com.proyecto.julio.rutasutecv6;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Clogica.AlmacenarDatos;

public class Registro extends AppCompatActivity {

    private EditText txtnombre,txtapellido,txtusuario,txtfechanac,txtpassword,txtemail;
    private Button btnRegistrar,btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtnombre = (EditText)findViewById(R.id.txtnombre);
        txtapellido = (EditText)findViewById(R.id.txtapellido);
        txtusuario = (EditText)findViewById(R.id.txtusuaio);
        txtfechanac = (EditText)findViewById(R.id.txtfecha);
        txtpassword = (EditText)findViewById(R.id.txtpass);
        txtemail = (EditText)findViewById(R.id.txtemail);

        btnRegistrar=(Button)findViewById(R.id.btnResgistrar);
        btnCancelar=(Button)findViewById(R.id.btnCancelar);

        final AlmacenarDatos almacenarDatos = new AlmacenarDatos();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom,ape,usu,fec,pass,email;
                nom=txtnombre.getText().toString();
                ape=txtnombre.getText().toString();
                usu=txtnombre.getText().toString();
                fec=txtnombre.getText().toString();
                pass=txtnombre.getText().toString();
                email=txtnombre.getText().toString();
                almacenarDatos.guardar(nom,ape,fec,email,pass,usu);
                Snackbar.make(v, "datos almacenados", Snackbar.LENGTH_LONG)
                        .setAction("presiona si quieres ir a login", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(getApplicationContext(),Login.class);
                                startActivity(i);
                            }
                        }).show();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salir = new Intent(getApplicationContext(),Login.class);
                startActivity(salir);
            }
        });
    }
}
