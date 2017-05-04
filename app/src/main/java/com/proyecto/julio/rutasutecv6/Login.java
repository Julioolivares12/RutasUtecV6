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
import DatosDB.RutasUtecDB;
import DatosDB.usuarios;
import Clogica.RutasUtecBD;
import Clogica.Session;
import DatosDB.RutasUtecDB;

public class Login extends AppCompatActivity {

    private EditText txtusuario, txtpass;
    private Button btnLogin;
    private TextView txtregistro;
    RutasUtecDB rutasUtecDB = new RutasUtecDB(this);
    SQLiteDatabase db = rutasUtecDB.getWritableDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtusuario = (EditText) findViewById(R.id.txtusuaio);
        txtpass = (EditText) findViewById(R.id.txtpass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtregistro = (TextView) findViewById(R.id.txtregistro);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = txtusuario.getText().toString();
                String pass = txtpass.getText().toString();
                int id=checkUsu(new usuarios(usuario,pass));
                if (id==-1){
                    Toast.makeText(getApplicationContext(),"usuario no existe",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"usuario existe",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }

            }
        });
        rutasUtecDB.addusuario(new usuarios("julio","123"));
        rutasUtecDB.addusuario(new usuarios("roberto","1234"));

        txtregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Registro.class);
                startActivity(i);
            }
        });
    }
    public int checkUsu(usuarios usuarios){
        return rutasUtecDB.checkuser(usuarios);
    }


}