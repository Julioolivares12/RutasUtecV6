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
import android.widget.Switch;
import android.widget.Toast;



import sql.DatabaseHelper;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText txtusuario,txtpassword,txtemail;
    private Button btnRegistrar,btnCancelar;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        txtusuario = (EditText)findViewById(R.id.txtusuaio);

        txtpassword = (EditText)findViewById(R.id.txtpass);
        txtemail = (EditText)findViewById(R.id.txtemail);

        btnRegistrar=(Button)findViewById(R.id.btnResgistrar);
        btnCancelar=(Button)findViewById(R.id.btnCancelar);

        btnRegistrar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnResgistrar:
                String usu = txtusuario.getText().toString();
                String email = txtemail.getText().toString();
                String pass = txtpassword.getText().toString();

                db.execSQL("insert into usuarios (usuario,email,pass,idtipousu) values('"+usu+"','"+email+"','"+pass+"',2)");
                db.close();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCancelar:
                Intent salir = new Intent(getApplicationContext(),Login.class);
                startActivity(salir);
                break;
        }
    }
}
