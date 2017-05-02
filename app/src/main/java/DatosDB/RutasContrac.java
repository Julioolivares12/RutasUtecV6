package DatosDB;

import android.provider.BaseColumns;

/**
 * Created by julio on 5/1/17.
 */

public class RutasContrac {
    public static abstract class RutasEntry implements BaseColumns{
        public static final String Table_Name="rutas";
        public static final String idruta = "idruta";
        public static final String idtipoRuta="idtipoRuta";
    }
}
