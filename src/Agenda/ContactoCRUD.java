/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author zoiloreyes
 */
public class ContactoCRUD {
    private Connection conn;
    private ResultSet rs;
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
        System.out.println("Insertado");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void close(){
        try{
         conn.close();
        }catch(SQLException e){
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
    public ResultSet getSearchedPattern(String name, String pattern){
        try{
        conn = Driver.getConnection();
        
        String sql = "Select * FROM contacto WHERE "+ name + " LIKE ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, "%"+pattern+"%");
        System.out.println(stm);
        ResultSet result = stm.executeQuery();
            return result;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    public ResultSet getContactoFull(){
        try{
        conn = Driver.getConnection();
        String sql = "Select * FROM contacto ORDER BY nombre";
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
        String sql = "UPDATE contacto SET nombre=?, apellido=?, lugar_trabajo=?, telefono=?, correo=?, imagen=? WHERE id_contacto=?";
        
        PreparedStatement prst = conn.prepareStatement(sql);
        prst.setString(1, nombre);
        prst.setString(2, apellido);
        prst.setString(3, lugar);
        prst.setString(4, telefono);
        prst.setString(5, correo);
        prst.setString(6, imagen);
        prst.setInt(7, id_contacto);
        
        int rowsInserted = prst.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteContacto(int id_contacto){
        try{
            conn = Driver.getConnection();
            String sql = "DELETE FROM contacto WHERE id_contacto=?";
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
    
    public String[] getColumns(){
        try{
            ArrayList<String> columns = new ArrayList<String>();
            conn = Driver.getConnection();
            
            if(conn != null){
                DatabaseMetaData dbmd = conn.getMetaData();
                rs = dbmd.getColumns(null, null, "contacto", "%");
                
                while(rs.next()){
                    columns.add(rs.getString("COLUMN_NAME"));
                }
                columns.remove(0);
                String[] result = columns.toArray(new String[columns.size()]);
                return result;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
