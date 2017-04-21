package Clogica;

import java.util.ArrayList;

/**
 * Created by julio on 20/04/2017.
 */

public class AlmacenarDatos {
    private ArrayList Nombre = new ArrayList();
    private ArrayList Apellido = new ArrayList();
    private ArrayList Telefono = new ArrayList();
    private ArrayList Direccion = new ArrayList();
    private ArrayList Password = new ArrayList();
    private ArrayList Usuario = new ArrayList();

    public void guardar(String n,String a,String t,String d,String p,String usu){
        Nombre.add(n);
        Apellido.add(a);
        Telefono.add(t);
        Direccion.add(d);
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
        return Telefono;
    }
    public ArrayList Direccion(){
        return Direccion;
    }
    public ArrayList Password(){
        return Password;
    }
}
