/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.agenda.to;

/**
 *
 * @author hikaru
 */
public class UsuarioTo {
    private int id_usuario; //Ojo con el tipo
    private String usuario, password;
    private PersonaTo persona;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonaTo getPersona() {
        return persona;
    }

    public void setPersona(PersonaTo persona) {
        this.persona = persona;
    }
    
    
}
