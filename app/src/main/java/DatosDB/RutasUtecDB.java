package DatosDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import DatosDB.UsuariosContract;

/**
 * Created by julio on 30/04/17.
 */

public class RutasUtecDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="rutasUTEC.db";

    private static final String table_usuario="usuarios";
    private static final String user_id="idusuario";
    private static final String user_usuario="usuario";
    private static final String user_email="correo";
    private static final String user_idtipo="idtipousu";
    private static final String user_pass="pass";

    public RutasUtecDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //nuevo codigo para crear la tabla de usuarios
        String Create_tabla_usuarios="CREATE "+table_usuario+"("+user_id
                +"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                user_usuario+"TEXT,"+
                user_email+"TEXT,"
                +user_pass+"TEXT"
                +user_idtipo+"INTEGER ";
        db.execSQL(Create_tabla_usuarios);


        /*
        //qui creo la tabla para los usuarios
        db.execSQL("CREATE TABLE "+ UsuariosContract.UsuariosEntry.Table_name+"("
                + UsuariosContract.UsuariosEntry.idusu+"INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UsuariosContract.UsuariosEntry.usuario+"TEXT NOT NULL,"
                + UsuariosContract.UsuariosEntry.correo+"TEXT NOT NULL,"
                + UsuariosContract.UsuariosEntry.pass+"TEXT NOT NULL,"
                + UsuariosContract.UsuariosEntry.idtipousu+"INTEGER NOT NULL"
                + "UNIQUE ("+ UsuariosContract.UsuariosEntry.idusu+"))"
        );
        //aqui creo la clase tipo usuario
        db.execSQL("CREATE TABLE "+TipoUsuarioContract.TipoUsuarioEntry.Table_name+"("
        + TipoUsuarioContract.TipoUsuarioEntry.id+"INTEGER PRIMARY KEY AUTOINCREMENT,"
        + TipoUsuarioContract.TipoUsuarioEntry.tipo+"TEXT NOT NULL"
        +"UNIQUE ("+ TipoUsuarioContract.TipoUsuarioEntry.id+"))"
        );
        //aqui creo la tabla para tipo rutas
        db.execSQL("CREATE TABLE"+ TipoUsuarioContract.TipoUsuarioEntry.Table_name+"("
        + TipoRutasContrac.TipoRutasEntry.idtipoRuta+"INTEGER PRIMARY KEY AUTOINCREMENT,"
        + TipoRutasContrac.TipoRutasEntry.tipoRuta+"TEXT NOT NULL"
        +"UNIQUE ("+TipoRutasContrac.TipoRutasEntry.idtipoRuta+"))"
        );
        //creando la tabla para rutas

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
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+table_usuario);
        onCreate(db);
    }
    public void addusuario(usuarios usuarios){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(user_usuario,usuarios.getUsuario());
        contentValues.put(user_email,usuarios.getCorreo());
        contentValues.put(user_idtipo,usuarios.getIdtipousu());
        contentValues.put(user_pass,usuarios.getPass());
        db.insert(table_usuario,null,contentValues);
        db.close();
    }
    public int checkuser(usuarios usuarios){
        int id=-1;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT idusuario FROM usuarios WHERE usuario=? AND pass=?",new String[]{usuarios.getUsuario(),usuarios.getPass()});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            id=cursor.getInt(0);
            cursor.close();
        }
        return id;
    }
}
