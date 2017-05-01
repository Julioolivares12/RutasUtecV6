package com.proyecto.julio.rutasutecv6;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Clogica.AlmacenarDatos;
import DatosDB.RutasUtecDB;

public class Registro extends AppCompatActivity {

    private EditText txtusuario,txtpassword,txtemail;
    private Button btnRegistrar,btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        txtusuario = (EditText)findViewById(R.id.txtusuaio);

        txtpassword = (EditText)findViewById(R.id.txtpass);
        txtemail = (EditText)findViewById(R.id.txtemail);

        btnRegistrar=(Button)findViewById(R.id.btnResgistrar);
        btnCancelar=(Button)findViewById(R.id.btnCancelar);

        /*final AlmacenarDatos almacenarDatos = new AlmacenarDatos();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom,ape,usu,fec,pass,email;
                nom=txtnombre.getText().toString();
                ape=txtapellido.getText().toString();
                usu=txtusuario.getText().toString();
                fec=txtfechanac.getText().toString();
                pass=txtpassword.getText().toString();
                email=txtemail.getText().toString();
                almacenarDatos.guardar(nom,ape,fec,email,pass,usu);
                Snackbar.make(v, "datos almacenados", Snackbar.LENGTH_LONG)
                        .setAction(" quieres ir a login", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(getApplicationContext(),Login.class);
                                startActivity(i);
                            }
                        }).show();
            }
        });*/
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salir = new Intent(getApplicationContext(),Login.class);
                startActivity(salir);
            }
        });
    }
    public void registrar(View view){
        RutasUtecDB rutasUtecDB = new RutasUtecDB(this);
        SQLiteDatabase db = rutasUtecDB.getWritableDatabase();
        String usu = txtusuario.getText().toString();
        String email = txtemail.getText().toString();
        String pass = txtpassword.getText().toString();
        ContentValues values = new ContentValues();
        values.put("usuario",usu);
        values.put("correo",email);
        values.put("pass",pass);

        db.insert("usuarios",null,values);
        db.close();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
