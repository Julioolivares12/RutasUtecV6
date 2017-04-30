package DatosDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import DatosDB.UsuariosContract;

/**
 * Created by julio on 30/04/17.
 */

public class RutasUtecDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="rutasUTEC.db";

    public RutasUtecDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //con esta parte de codigo creo la tabla para los usuarios
        db.execSQL("CREATE TABLE "+ UsuariosContract.UsuariosEntry.Table_name+"("
                + UsuariosContract.UsuariosEntry.idusu+"INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UsuariosContract.UsuariosEntry.usuario+"TEXT NOT NULL,"
                + UsuariosContract.UsuariosEntry.correo+"TEXT NOT NULL,"
                + UsuariosContract.UsuariosEntry.pass+"TEXT NOT NULL,"
                + UsuariosContract.UsuariosEntry.idtipousu+"INTEGER NOT NULL"
                + "UNIQUE ("+ UsuariosContract.UsuariosEntry.idusu+"))"
        );
        db.execSQL("CREATE TABLE "+TipoUsuarioContract.TipoUsuarioEntry.Table_name+"("
        + TipoUsuarioContract.TipoUsuarioEntry.id+"INTEGER PRIMARY KEY AUTOINCREMENT,"
        + TipoUsuarioContract.TipoUsuarioEntry.tipo+"TEXT NOT NULL"
        +"UNIQUE ("+ TipoUsuarioContract.TipoUsuarioEntry.id+"))"
        );
        //insertando datos a un campo de la tabla tipo
        ContentValues tipousu = new ContentValues();
        tipousu.put(TipoUsuarioContract.TipoUsuarioEntry.tipo,"admin");
        //insertando un usuario para prueba
        ContentValues values = new ContentValues();
        values.put(UsuariosContract.UsuariosEntry.usuario,"julio");
        values.put(UsuariosContract.UsuariosEntry.correo,"julioolivares90@gmail.com");
        values.put(UsuariosContract.UsuariosEntry.pass,"123");
        values.put(UsuariosContract.UsuariosEntry.idtipousu,1);

        db.insert(TipoUsuarioContract.TipoUsuarioEntry.Table_name,null,tipousu);
        db.insert(UsuariosContract.UsuariosEntry.Table_name,null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
