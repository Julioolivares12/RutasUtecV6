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

import Clogica.RutasUtecBD;
import Clogica.Session;
import DatosDB.RutasUtecDB;

public class Login extends AppCompatActivity
{

    private EditText txtusuario,txtpass;
    private Button btnLogin;
    private TextView txtregistro;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtusuario = (EditText)findViewById(R.id.txtusuaio);
        txtpass = (EditText)findViewById(R.id.txtpass);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        txtregistro=(TextView)findViewById(R.id.txtregistro);

        txtregistro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new  Intent(getApplicationContext(),Registro.class);
                startActivity(i);
            }
        });
    }
    public void ingresar(View view)
    {
        RutasUtecDB rutasUtecDB = new RutasUtecDB(this);
        SQLiteDatabase db = rutasUtecDB.getWritableDatabase();
        String usuario=txtusuario.getText().toString();
        String pass = txtpass.getText().toString();

        Cursor fila = db.rawQuery("select usuario,pass from usuarios where usuario='" + usuario + "'and pass ='" + pass + "'", null);
        //pregunto si el cursor tiene un valor
        if(fila.moveToFirst()==true)
        {
            //capturo los valores del cursor
            String usu = fila.getString(0);
            String pas = fila.getString(1);
            //pregunto si los datos ingresados son iguales
            if (usuario.equals(usu)&&pass.equals(pas)){
                //si son iguales pasa al manu
                Intent intent = new  Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"usuario o password incorrecto",Toast.LENGTH_SHORT).show();
            }
        }


        }
    }

