package sql;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import model.usuarios;

/**
 * Created by julio on 5/4/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    //version de la base de datos
    private static final int DATABASE_VERSION=1;

    //nombre de la base de datos
    private static final String DATABASE_NAME="rutasUtec.sql";

    //nombre de la tabla
    private static final String TABLA_USUARIO="usuarios";
    //nombre de las columnas de la base de datos
    private static final String COLUMNA_USUARIO_ID="id";
    private static final String COLUMMNA_USUARIO="usuario";
    private static final String COLUMMNA_EMAIL="correo";
    private static final String COLUMMNA_PASS="pass";
    private static final String COLUMMNA_ID_TIPO_USU="idtipousu";

    private String CREAR_TABLA_USUARIO="CREATE TABLE "
            +TABLA_USUARIO
            +"("+COLUMNA_USUARIO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COLUMMNA_USUARIO+" TEXT,"
            +COLUMMNA_EMAIL +" TEXT,"
            +COLUMMNA_PASS +" TEXT,"
            +COLUMMNA_ID_TIPO_USU+" INTEGER"+")";
    private String DROP_TABLA_USUARIO=" DROP TABLE IF EXISTS "+TABLA_USUARIO;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARIO);
       db.execSQL("insert into usuarios values (1,'julio','julioolivares90@gmail.com','123',1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLA_USUARIO);
        onCreate(db);
    }
    public void addUsuario(usuarios usuarios){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMMNA_USUARIO,usuarios.getUsuario());
        contentValues.put(COLUMMNA_EMAIL,usuarios.getEmail());
        contentValues.put(COLUMMNA_PASS,usuarios.getPass());
        contentValues.put(COLUMMNA_ID_TIPO_USU, usuarios.getIdtipousu());

        db.insert(TABLA_USUARIO,null,contentValues);
        db.close();
    }
    public List<usuarios>getalluser(){
        String[]columns = {
          COLUMNA_USUARIO_ID,COLUMMNA_USUARIO,COLUMMNA_EMAIL,COLUMMNA_PASS,COLUMMNA_ID_TIPO_USU
        };
        String sortOrder = COLUMMNA_USUARIO + "ASC";
        List<usuarios>usuariosList = new ArrayList<usuarios>();

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query(TABLA_USUARIO,
                columns,
                null,
                null,
                null,
                null,
                sortOrder
                );
        if(cursor.moveToFirst()){
            do {
                usuarios usuarios = new usuarios();
                usuarios.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMNA_USUARIO_ID))));
                usuarios.setUsuario(cursor.getString(cursor.getColumnIndex(COLUMMNA_USUARIO)));
                usuarios.setUsuario(cursor.getString(cursor.getColumnIndex(COLUMMNA_EMAIL)));
                usuarios.setPass(cursor.getString(cursor.getColumnIndex(COLUMMNA_PASS)));
                usuarios.setIdtipousu(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMMNA_ID_TIPO_USU))));
                //agregando el usuario a la lista
                usuariosList.add(usuarios);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return usuariosList;
    }
    //metodo para actualizar usuario
    public void updateUser(usuarios usuarios){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMMNA_USUARIO,usuarios.getUsuario());
        values.put(COLUMMNA_EMAIL,usuarios.getEmail());
        values.put(COLUMMNA_PASS,usuarios.getPass());

        db.update(TABLA_USUARIO,values,COLUMNA_USUARIO_ID+"=?",new String[]{String.valueOf(usuarios.getId())});
        db.close();
    }
    public void deleteUser(usuarios usuarios){
        SQLiteDatabase db = this.getWritableDatabase();
        //borra un usuario
        db.delete(TABLA_USUARIO,COLUMNA_USUARIO_ID+"=?",new String[]{String.valueOf(usuarios.getId())});
        db.close();
    }
    public boolean checkUser(String email){
        String[] colums = {
          COLUMNA_USUARIO_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COLUMMNA_EMAIL+"=?";

        String[] selectionArgs ={email};

        Cursor cursor = db.query(TABLA_USUARIO,
                colums,
                selection,
                selectionArgs,null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        if(cursorCount>0){
            return true;
        }
        return false;
    }
    public boolean checkUser(String email,String pass){
        String[] columns = {
          COLUMNA_USUARIO_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // criterio de seleccion
        String selection = COLUMMNA_EMAIL+"=?"+"AND"+COLUMMNA_PASS+"=?";
        String[] selectionArgs={email,pass};

        Cursor cursor = db.query(TABLA_USUARIO,
                columns,
                selection,selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount>0){
            return true;
        }
        return false;
    }
}
