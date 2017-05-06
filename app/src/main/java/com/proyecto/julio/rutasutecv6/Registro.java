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



import sql.DatabaseHelper;

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


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                String usu = txtusuario.getText().toString();
                String email = txtemail.getText().toString();
                String pass = txtpassword.getText().toString();

                db.execSQL("insert into usuarios (usuario,email,pass,idtipousu) values('"+usu+"','"+email+"','"+pass+"',2)");
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
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
