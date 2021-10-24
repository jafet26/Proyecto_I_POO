package controlador;

import dao.EscuelaDAO;
import java.awt.HeadlessException;
import logicadenegocios.Escuela;
import vista.RegistrarEscuela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.JOptionPane;

/**
 * Abstraccion de la clase ControladorEscuela 
 * Para utilizar las funcionalidades de implementacion de las Escuelas del sistema
 * @author Daniel Vaglio Fallas & Jafet Chavarria Moreno
 * @version Proyecto Programado I 
 */
public class ControladorEscuela implements ActionListener {
  public RegistrarEscuela vistaRegistroEscuela;
  public Escuela escuela;
  public EscuelaDAO dao;
  
  /**
   * Metodo Constructor
   * @param pVistaRegistroEscuela despliega la vista de interaccion en el registro de escuelas
   * @param pEscuela el objeto de escuela
   */
  public ControladorEscuela(RegistrarEscuela pVistaRegistroEscuela, Escuela pEscuela) {
    vistaRegistroEscuela = pVistaRegistroEscuela;
    escuela = pEscuela;
    dao = new EscuelaDAO();
        
    this.vistaRegistroEscuela.btnRegistrar.addActionListener(this);
    this.vistaRegistroEscuela.btnVolver.addActionListener(this);
    this.vistaRegistroEscuela.btnLimpiar.addActionListener(this);
  }
  
  /**
   * Metodo que recibe y ejecuta una opcion 
   * @param e recibe la opcion accionada por un boton
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistroEscuela.btnRegistrar) {
        agregarEscuela();
    }
    if (e.getSource() == vistaRegistroEscuela.btnLimpiar) {
        limpiarCampos();
    }
    if (e.getSource() == vistaRegistroEscuela.btnVolver) {
      this.vistaRegistroEscuela.setVisible(false);
    }
  }
  
  /**
   * Metodo que agrega una Escuela o Area Academica
   */
  public void agregarEscuela() {
    try{
      String codigoEscuela = vistaRegistroEscuela.txtCodigo.getText();
      String nombreEscuela = vistaRegistroEscuela.txtNombre.getText();
      String resul = dao.registrarEscuela(codigoEscuela, nombreEscuela);
      if (resul != null) {
        JOptionPane.showMessageDialog(null,resul); 
      } else {
        JOptionPane.showMessageDialog(vistaRegistroEscuela, "Ha sido posible registrar la escuela "
            + nombreEscuela + " exitosamente");
        }
    } catch (HeadlessException ex) {
      Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Metodo que limpia los campos de texto
   */
  public void limpiarCampos() {
    vistaRegistroEscuela.txtNombre.setText("");
    vistaRegistroEscuela.txtCodigo.setText("");
  }
}
