/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author zoiloreyes
 */
public class main {
       public static void main(String[] args){
           Imagen img = new Imagen();
           JLabel jl = img.getRoundImage("https://scontent.fsdq1-2.fna.fbcdn.net/v/t1.0-9/13726819_1384734751537534_600549842287347911_n.jpg?oh=506b2c2092105b7a7aa62096afdf2f72&oe=58BB87C1",300,300,100);
           JFrame jf = new JFrame();
           jf.getContentPane().add(jl, BorderLayout.CENTER);
           jf.setSize(300, 300);
           jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           jf.setVisible(true);
       }
}
