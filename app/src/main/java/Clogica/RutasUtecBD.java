package Clogica;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by julio on 27/04/2017.
 * esta clase es para la base de datos con sqlite
 */

public class RutasUtecBD extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="RutasUtecDB.db";
    public static final String tablausuarios ="usuario";
    public static final String id_usuario="id";
    public static final String email="email";
    public static final String usuario="usuairo";
    public static final String pass="pass";
    public static final String id_tipo="id_tipo";

    //variables para la tabla tipo usuario
    public static final String idtipo="idtipo";
    public static final String tipo="tipo";


    public RutasUtecBD(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table usuarios()");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
