package DatosDB;

/**
 * Created by julio on 5/1/17.
 */

public class TipoRutas {
    private int idtipoRuta ;
    private String tipoRuta;

    public TipoRutas(int idtipoRuta,String tipoRuta){
        this.idtipoRuta=idtipoRuta;
        this.tipoRuta=tipoRuta;
    }
    public int getIdtipoRuta(){
        return idtipoRuta;
    }
    public String getTipoRuta(){
        return tipoRuta;
    }
}
