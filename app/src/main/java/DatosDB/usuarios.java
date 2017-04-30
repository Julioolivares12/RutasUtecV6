package DatosDB;

/**
 * Created by julio on 30/04/17.
 * clase modelo para lam tabla de usuarios
 */

public class usuarios {
    private int idusuario;
    private String usuario;
    private String correo;
    private String pass;

    private int idtipousu;
    usuarios(int idusuario,String usuario,String correo,String pass ,int idtipousu){
        this.idusuario=idusuario;
        this.usuario=usuario;
        this.correo=correo;
        this.pass=pass;
        this.idtipousu=idtipousu;
    }
    public int getIdusuario(){
        return idusuario;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getCorreo(){
        return correo;
    }
    public String getPass(){
        return pass;
    }
    public int getIdtipousu(){
        return idtipousu;
    }
}
