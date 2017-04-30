package DatosDB;

import android.provider.BaseColumns;

/**
 * Created by julio on 30/04/17.
 */

public class TipoUsuarioContract {
    public static abstract class TipoUsuarioEntry implements BaseColumns{
        public static String Table_name="tipoUsuario";
        public static String id="idusuario";
        public static String tipo="tipo";
    }
}
