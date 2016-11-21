/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;
import java.sql.*;
/**
 *
 * @author zoiloreyes
 */
public class Driver {
    public static void main(String[] args){
        try{
            getConnection();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
   
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/agenda";
            String username = "root";
            String password = "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
            } catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
        return null;
        
        }
    
}
