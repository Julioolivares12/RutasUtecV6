package Clogica;

import java.util.ArrayList;

/**
 * Created by julio on 20/04/2017.
 */

public class AlmacenarDatos {
    private ArrayList Nombre = new ArrayList();
    private ArrayList Apellido = new ArrayList();
    private ArrayList fecha = new ArrayList();
    private ArrayList email = new ArrayList();
    private ArrayList Password = new ArrayList();
    private ArrayList Usuario = new ArrayList();

    public void guardar(String n,String a,String f,String e,String p,String usu){
        Nombre.add(n);
        Apellido.add(a);
        fecha.add(f);
        email.add(e);
        Password.add(p);
        Usuario.add(usu);
    }

    public ArrayList Rnombres(){
        return Nombre;
    }
    public ArrayList Apellidos(){
        return Apellido;
    }
    public ArrayList Usuario(){
        return Usuario;
    }
    public ArrayList Telefono(){
        return fecha;
    }
    public ArrayList Direccion(){
        return email;
    }
    public ArrayList Password(){
        return Password;
    }
}
