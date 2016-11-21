/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author zoiloreyes
 */
public class Contacto extends javax.swing.JPanel {
    private JLabel imglbl;
    private Imagen imgclass;
    private String nombre;
    private String apellido;
    private String lugar;
    private String telefono;
    private String correo;
    private String url;
    private int id_contacto;
    private JLabel img1;
    private EditFrame ef;
    private CreateContacto cc;
    private ShowContact sc;
    private Agenda mother;
    /**
     * Creates new form Contacto
     */
    public Contacto(String nombre, String apellido, String lugar, String telefono,String correo, String url, int id_contacto,Agenda mother) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.lugar = lugar;
        this.telefono = telefono;
        this.correo = correo;
        this.url = url;
        this.id_contacto = id_contacto;
        this.mother = mother;
        imgclass = new Imagen();
        //lblApellido.setText(apellido);
        //lblNombre.setText(nombre);
        //lblImagen = imgclass.getRoundImage(imagen, 50, 50, 10);
        if(telefono == null){
            
        }else if(telefono.length() == 10){
                String output = String.format("(%s) %s-%s", telefono.substring(0,3),
                        telefono.substring(3,6),telefono.substring(6,10));
                this.telefono = output;


            }
        
        imgclass = new Imagen();
        img1 = imgclass.getRoundImage(url, 50, 50, 6);
        initComponents();
        
        
     
        
        
        //imgclass = new Imagen();
        //imgclass.getRoundImage(imagen,50,50,10);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(100, 50));
        setMinimumSize(new java.awt.Dimension(100, 50));
        setPreferredSize(new java.awt.Dimension(200, 60));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        lblNombre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText(this.nombre + " " + this.apellido);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(lblNombre, gridBagConstraints);

        lblTelefono.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(153, 153, 153));
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTelefono.setText(this.telefono);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(lblTelefono, gridBagConstraints);

        lblImagen.setText("jLabel1");
        lblImagen = this.img1;
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(lblImagen, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
       setBackground(new java.awt.Color(236, 255, 255));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
       setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
      if(this.id_contacto == -1){
          ef = new EditFrame();
          cc = new CreateContacto(ef,mother);
          ef.add(cc);
          ef.setVisible(true);
          ef.revalidate();
      }else{
          ef = new EditFrame();
          sc = new ShowContact(this.nombre,this.apellido,this.lugar,this.telefono,this.correo,this.url,this.id_contacto,ef,mother);
          
          ef.add(sc);
          ef.setVisible(true);
          ef.revalidate();
      }
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
         setBackground(new java.awt.Color(102, 153, 255));
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
       setBackground(new java.awt.Color(236, 255, 255));
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    // End of variables declaration//GEN-END:variables
}
