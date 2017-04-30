package DatosDB;

import android.provider.BaseColumns;

/**
 * Created by julio on 30/04/17.
 */

public class UsuariosContract {
    public static abstract class UsuariosEntry implements BaseColumns {
        public static final String Table_name="usuarios";
        public static final String idusu = "idusu";
        public static final String usuario="usuario";
        public static final String correo="correo";
        public static final String pass="pass";
        public static final String idtipousu="idtipousu";

    }
}
