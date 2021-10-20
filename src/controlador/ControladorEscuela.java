/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import proyecto_i_poo.Conexion;
import dao.EscuelaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logicadenegocios.Escuela;
import vista.RegistrarEscuela;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.Date;
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ControladorEscuela implements ActionListener {
  public RegistrarEscuela vistaRegistroEscuela;
  //public RegistrarEscuela vistaRegistroEscuela = new RegistrarEscuela();
  public Escuela escuela;
  //public EscuelaDAO dao = new EscuelaDAO();
  public EscuelaDAO dao;
  
  //constructor
  //public ControladorEscuela(RegistrarEscuela pVistaRegistroEscuela, Escuela pEscuela, EscuelaDAO pModelo) {
  public ControladorEscuela(RegistrarEscuela pVistaRegistroEscuela, Escuela pEscuela) {
    vistaRegistroEscuela = pVistaRegistroEscuela;
    //dao = pModelo;
    escuela = pEscuela;
    dao = new EscuelaDAO();
        
    this.vistaRegistroEscuela.btnRegistrar.addActionListener(this);
    this.vistaRegistroEscuela.btnVolver.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistroEscuela.btnRegistrar) {
        try {
            agregarEscuela();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (e.getSource() == vistaRegistroEscuela.btnVolver) {
        this.vistaRegistroEscuela.setVisible(false);
    }
}
  
  public void agregarEscuela() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      
      try{
          String codigoEscuela = vistaRegistroEscuela.txtCodigo.getText();
          String nombreEscuela = vistaRegistroEscuela.txtNombre.getText();
          String resul = dao.registrarEscuela(codigoEscuela, nombreEscuela);
          if (resul != null) {
              //vistaRegistroEscuela.setVisible(false);
              JOptionPane.showMessageDialog(null,resul); 
              //vistaRegistroEscuela.setVisible(true);
          } else {
              JOptionPane.showMessageDialog(vistaRegistroEscuela, "Ha sido posible registrar la escuela");
          }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  

}
