/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hikaru
 */
public class Conexion {
    public static Connection Conectar(){
        try {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(""
                  + "jdbc:mysql://localhost:3306/db_agenda","root","123456");
            System.out.println("Conexión abierta");
          return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión " + e.getMessage());
              return null;
        }   
    }
    
    public static void Cerrar(Connection con){
        try {
            System.out.println("Conexión cerrada");
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión");
        }
    }
    
}
