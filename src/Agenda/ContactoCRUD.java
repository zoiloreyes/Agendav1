/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author zoiloreyes
 */
public class ContactoCRUD {
    private Connection conn;
    public void insertContacto(String nombre, String apellido, String lugar, String telefono,String correo, String imagen){
        try{
        conn = Driver.getConnection();
        String sql = "INSERT INTO contacto(nombre, apellido, lugar_trabajo, telefono, correo, imagen) VALUES(?,?,?,?,?,?)";
        
        PreparedStatement prst = conn.prepareStatement(sql);
        prst.setString(1, nombre);
        prst.setString(2, apellido);
        prst.setString(3, lugar);
        prst.setString(4, telefono);
        prst.setString(5, correo);
        prst.setString(6, imagen);
        
        int rowsInserted = prst.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public ResultSet getSpecContacto(int id_contacto){
        try{
        conn = Driver.getConnection();
        String sql = "Select * FROM contacto WHERE id_contacto=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id_contacto);
        ResultSet result = stm.executeQuery(sql);
            return result;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public ResultSet getContactoFull(){
        try{
        conn = Driver.getConnection();
        String sql = "Select * FROM contacto";
        Statement stm = conn.createStatement();
        ResultSet result = stm.executeQuery(sql);
            return result;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void updateContacto(String nombre, String apellido, String lugar, String telefono,String correo, String imagen, int id_contacto){
        try{
        conn = Driver.getConnection();
        String sql = "UPDATE contacto SET nombre=?, apellido=?, lugar_trabajo=?, telefono=?, correo=?, imagen=? where id_contacto=?";
        
        PreparedStatement prst = conn.prepareStatement(sql);
        prst.setString(1, nombre);
        prst.setString(2, apellido);
        prst.setString(3, lugar);
        prst.setString(4, telefono);
        prst.setString(5, correo);
        prst.setString(5, imagen);
        prst.setInt(6, id_contacto);
        
        int rowsInserted = prst.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteContacto(int id_contacto){
        try{
            conn = Driver.getConnection();
            String sql = "DELETE FROM contacto WHERE username=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id_contacto);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
        }catch(Exception e){
           System.out.println(e.getMessage());
        }
    }
}
