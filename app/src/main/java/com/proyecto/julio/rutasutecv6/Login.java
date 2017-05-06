package com.proyecto.julio.rutasutecv6;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sql.DatabaseHelper;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText txtusuario, txtpass;
    private Button btnLogin;
    private TextView txtregistro;
    private Cursor fila;
    SQLiteDatabase db;

    //DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
   // SQLiteDatabase db =databaseHelper.getWritableDatabase();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtusuario = (EditText) findViewById(R.id.txtusuaio);
        txtpass = (EditText) findViewById(R.id.txtpass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtregistro = (TextView) findViewById(R.id.txtregistro);

        btnLogin.setOnClickListener(this);
        txtregistro.setOnClickListener(this);

        DatabaseHelper databaseHelper = new DatabaseHelper(this,"rutasUtec",null,1);
        db=databaseHelper.getWritableDatabase();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnLogin:
                String usuario = txtusuario.getText().toString();
                String pass = txtpass.getText().toString();

                fila=db.rawQuery("select usuario , pass from usuarios where usuario='"+usuario+"'and pass='"+pass+"'",null);
                if (fila.moveToFirst()==true){
                    String usu =fila.getString(0);
                    String pa = fila.getString(1);
                    if (usuario.equals(usu)&&pass.equals(pa)){

                        txtusuario.setText("");
                        txtpass.setText("");
                        Intent menu = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(menu);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"usuario o pass incorrectos",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"no se encontro el usuario",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.txtregistro:
                Intent i = new Intent(getApplicationContext(), Registro.class);
                startActivity(i);
                break;
        }
    }
}