package model;

/**
 * Created by julio on 5/4/17.
 */

public class usuarios {
    private int id;
    private String usuario;
    private String pass;
    private String email;
    private int idtipousu;

    public int getId(){
        return id;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getEmail(){
        return email;
    }
    public String getPass(){
        return email;
    }
    public int getIdtipousu(){
        return idtipousu;
    }

    public void setId(int id){
        this.id=id;
    }
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPass(String pass){
        this.pass=pass;
    }
    public void setIdtipousu(int idtipousu){
        this.idtipousu=idtipousu;
    }
}
