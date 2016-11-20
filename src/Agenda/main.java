/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author zoiloreyes
 */
public class main {
       public static void main(String[] args){
           try {
               /*Imagen img = new Imagen();
               JLabel jl = img.getRoundImage("https://scontent.fsdq1-2.fna.fbcdn.net/v/t1.0-9/13726819_1384734751537534_600549842287347911_n.jpg?oh=506b2c2092105b7a7aa62096afdf2f72&oe=58BB87C1",300,300,100);
               JFrame jf = new JFrame();
               jf.getContentPane().add(jl, BorderLayout.CENTER);
               jf.setSize(300, 300);
               jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               jf.setVisible(true); */
               JFrame jf = new JFrame();
               ContactoCRUD cc = new ContactoCRUD();
               ResultSet res = cc.getContactoFull();
               ListaContacto ls = new ListaContacto();
               while (res.next()){
                   int id_contacto = res.getInt(1);
                   String nombre = res.getString(2);
                   String apellido = res.getString(3);
                   String lugar = res.getString(4);
                   String telefono = res.getString(5);
                   String correo = res.getString(6);
                   String imagen = res.getString(7);
               
                   
                   Contacto c = new Contacto(nombre, apellido, lugar, telefono, correo, imagen, id_contacto);
                   ls.add(c);
               }
               
               jf.setVisible(true);
               
           } catch (SQLException ex) {
               Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
}
