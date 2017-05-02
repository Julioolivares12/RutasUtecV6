package DatosDB;

/**
 * Created by julio on 5/1/17.
 * modelo para la clase rutas
 */

public class Rutas  {
    private int idruta;
    private String ruta;
    private int idtipoRuta;

    public Rutas(int idruta,String ruta,int idtipoRuta){
        this.idruta=idruta;
        this.ruta=ruta;
        this.idtipoRuta=idtipoRuta;
    }
    public int getIdruta(){
        return idruta;
    }
    public String getRuta(){
        return ruta;
    }
    public int getIdtipoRuta(){
        return idtipoRuta;
    }
}
