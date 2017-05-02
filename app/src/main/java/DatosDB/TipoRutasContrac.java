package DatosDB;

import android.provider.BaseColumns;

/**
 * Created by julio on 5/1/17.
 */

public class TipoRutasContrac {
    public static abstract class TipoRutasEntry implements BaseColumns{
        public static final String Table_name="tipoRutas";
        public static final String idtipoRuta="idtipoRuta";
        public static final String tipoRuta="tipoRuta";
    }
}
