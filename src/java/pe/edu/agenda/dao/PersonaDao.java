/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.agenda.to.PersonaTo;
import pe.edu.agenda.util.Conexion;

/**
 *
 * @author hikaru
 */
public class PersonaDao {
    private final Connection con;
    
    public PersonaDao(){
        con = Conexion.Conectar();
    }

    public List<PersonaTo> listarPersona(){
        List<PersonaTo> lista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from persona");
            while (rs.next()) {
                PersonaTo to = new PersonaTo();
                to.setId_persona(rs.getInt("id_persona"));
                to.setNombres(rs.getString("nombres"));
                to.setApellidos(rs.getString("apellidos"));
                to.setCelular(rs.getString("celular"));
                to.setDni(rs.getString("dni"));
                lista.add(to);
            }
        } catch (Exception e) {
            System.out.println("Error al listar "+e.getMessage());
        }
        return lista;
    }    
    
    public void crearPersona(PersonaTo to){
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("insert into persona (nombres, apellidos, celular, "
                    + "email, telefono, dni, direccion, fecha) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, to.getNombres());
            ps.setString(2, to.getApellidos());
            ps.setString(3, to.getCelular());
            ps.setString(4, to.getEmail());
            ps.setString(5, to.getTelefono());
            ps.setString(6, to.getDni());
            ps.setString(7, to.getDireccion());
            ps.setDate(8, (Date) to.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear persona "+e.getMessage());
        }
    }
    
    public PersonaTo buscarPersona(int id) {
        PersonaTo per = new PersonaTo();
        try {
            PreparedStatement ps = con.prepareStatement("select * from persona where id_persona=?");
            ps.setInt(1, id);            
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                per.setId_persona(rs.getInt("id_persona"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setCelular(rs.getString("celular"));
                per.setDni(rs.getString("dni"));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar "+e.getMessage());
        } 
        return per;
    }
    
    public void actualizarPersona(PersonaTo to){
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update persona set nombres=?, apellidos=?, celular=?, "
                    + "email=?, telefono=?, dni=?, direccion=?, fecha=? where id_persona=?");//probar sin fecha
            ps.setInt(9, to.getId_persona());
            ps.setString(1, to.getNombres());
            ps.setString(2, to.getApellidos());
            ps.setString(3, to.getCelular());
            ps.setString(4, to.getEmail());
            ps.setString(5, to.getTelefono());
            ps.setString(6, to.getDni());
            ps.setString(7, to.getDireccion());
            ps.setDate(8, (Date) to.getFecha());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar"+e.getMessage());
        }
    }
        
    public void eliminarPersona(int id){
        try {
            PreparedStatement ps = con.prepareStatement("delete from persona where id_persona=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Objeto eliminado");
        } catch (Exception e) {
            System.out.println("Error al eliminar persona "+e.getMessage());
        }
    }    

}
