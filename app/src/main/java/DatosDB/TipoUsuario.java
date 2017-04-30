package DatosDB;

/**
 * Created by julio on 30/04/17.
 * modelo para la tabla de tipos de usuario
 */

public class TipoUsuario {
    private int idTipo;
    private String tipo;

    TipoUsuario(int id,String tipo){
        this.idTipo=id;
        this.tipo=tipo;
    }

    public int getIdTipo(){
        return idTipo;
    }
    public String getTipo(){
        return tipo;
    }

}
