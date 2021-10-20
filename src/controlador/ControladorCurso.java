
package controlador;

import dao.CursoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logicadenegocios.Curso;
import vista.RegistrarCurso;

/**
 *
 * @author USUARIO
 */
public class ControladorCurso implements ActionListener {
  
  public RegistrarCurso vistaRegistroCurso;
  public Curso curso;
  public CursoDAO dao;
  
  //constructor
  public ControladorCurso(RegistrarCurso pVistaRegistroCurso, Curso pCurso) {
      
    vistaRegistroCurso = pVistaRegistroCurso;
    curso = pCurso;
    dao = new CursoDAO();
        
    this.vistaRegistroCurso.btnRegistrar.addActionListener(this);
    this.vistaRegistroCurso.btnVolver.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistroCurso.btnRegistrar) {
        try {
            agregarCurso();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (e.getSource() == vistaRegistroCurso.btnVolver) {
        this.vistaRegistroCurso.setVisible(false);
    }
}
  
  public void agregarCurso() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      
      try{
          String codigoCurso = vistaRegistroCurso.txtCodigoCurso.getText();
          String nombreCurso = vistaRegistroCurso.txtNombreCurso.getText();
          //int horasLectivas = Integer.parseInt(vistaRegistroCurso.cbxHorasLectivas.getSelectedItem().toString());
          //int cantidadCreditos = Integer.parseInt(vistaRegistroCurso.cbxCreditos.getSelectedItem().toString());
          int horasLectivas = Integer.parseInt(vistaRegistroCurso.txtHorasLectivas.getText());
          int cantidadCreditos = Integer.parseInt(vistaRegistroCurso.txtCreditos.getText());
          int numeroPlanEstudioCurso = Integer.parseInt(vistaRegistroCurso.txtCodigoPlanDeEstudios.getText());
          //int numeroPlanEstudioCurso = Integer.parseInt(vistaRegistroCurso.cbxCreditos.getSelectedItem().toString());
          int numeroBloqueSemestral = Integer.parseInt(vistaRegistroCurso.txtBloqueSemestral.getText());
          String codigoEscuela = vistaRegistroCurso.cbxEscuelas.getSelectedItem().toString();
          String resul = dao.registrarCurso(codigoCurso, nombreCurso, horasLectivas, cantidadCreditos,
                  numeroPlanEstudioCurso,numeroBloqueSemestral,codigoEscuela );
          if (resul != null) {
              //vistaRegistroEscuela.setVisible(false);
              JOptionPane.showMessageDialog(null,resul); 
              //vistaRegistroEscuela.setVisible(true);
          } else {
              JOptionPane.showMessageDialog(vistaRegistroCurso, "Ha sido posible registrar la escuela");
          }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  

  /*public void volverMenu() {
      vistaRegistroCurso.volverMenu();
  }*/
}
