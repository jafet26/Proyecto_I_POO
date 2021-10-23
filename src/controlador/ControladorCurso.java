
package controlador;

import dao.CursoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logicadenegocios.Curso;
import vista.AsignarCursoRequisito;
import vista.EliminarCurso;
import vista.EliminarCursoDePlan;
import vista.EliminarRequisitoCurso;
import vista.RegistrarCurso;

/**
 *
 * @author USUARIO
 */
public class ControladorCurso implements ActionListener {
  
  public RegistrarCurso vistaRegistroCurso = new RegistrarCurso();
  public AsignarCursoRequisito vistaAsignarCursoRequisito = new AsignarCursoRequisito();
  public EliminarRequisitoCurso vistaEliminarRequisitoCurso = new EliminarRequisitoCurso();
  public EliminarCursoDePlan vistaEliminarCursoDePlan = new EliminarCursoDePlan();
  public EliminarCurso vistaEliminarCurso = new EliminarCurso();
  public Curso curso;
  public CursoDAO dao;
  public ResultSet rs;
  public JTable tabla;
  
  //constructor
  public ControladorCurso(RegistrarCurso pVistaRegistroCurso, Curso pCurso) {
      
    vistaRegistroCurso = pVistaRegistroCurso;
    curso = pCurso;
    dao = new CursoDAO();
        
    this.vistaRegistroCurso.btnRegistrar.addActionListener(this);
    this.vistaRegistroCurso.btnVolver.addActionListener(this);
  }
  
  public ControladorCurso(AsignarCursoRequisito pVistaAsignarCursoRequisito, Curso pCurso) {

    vistaAsignarCursoRequisito = pVistaAsignarCursoRequisito;
    curso = pCurso;
    dao = new CursoDAO();

    this.vistaAsignarCursoRequisito.btnRegistrarRequisito.addActionListener(this);
    this.vistaAsignarCursoRequisito.btnRegistrarCorrequisito.addActionListener(this);
    this.vistaAsignarCursoRequisito.btnVolver.addActionListener(this);

  }
  
  public ControladorCurso(EliminarRequisitoCurso pVistaEliminarRequisitoCurso, CursoDAO pModelo) {
    
    vistaEliminarRequisitoCurso = pVistaEliminarRequisitoCurso;
    dao = pModelo;
    
    this.vistaEliminarRequisitoCurso.btnBuscar.addActionListener(this);
    this.vistaEliminarRequisitoCurso.btnEliminarRequisito.addActionListener(this);
    this.vistaEliminarRequisitoCurso.btnVolver.addActionListener(this);
  }
  
  public ControladorCurso(EliminarCursoDePlan pVistaEliminarCursoDePlan, CursoDAO pModelo) {
    
    vistaEliminarCursoDePlan = pVistaEliminarCursoDePlan;
    dao = pModelo;
    
    this.vistaEliminarCursoDePlan.btnBuscar.addActionListener(this);
    this.vistaEliminarCursoDePlan.btnEliminarPlanEstudioCurso.addActionListener(this);
    this.vistaEliminarCursoDePlan.btnVolver.addActionListener(this);
  } 
  
  public ControladorCurso(EliminarCurso pVistaEliminarCurso, CursoDAO pModelo) {
    vistaEliminarCurso = pVistaEliminarCurso;
    dao = pModelo;
    
    this.vistaEliminarCurso.btnBuscar.addActionListener(this);
    this.vistaEliminarCurso.btnEliminarCurso.addActionListener(this);
    this.vistaEliminarCurso.btnVolver.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistroCurso.btnRegistrar) {
        try {
            agregarCurso();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (e.getSource() == vistaAsignarCursoRequisito.btnRegistrarRequisito) {

        try {
            agregarCursoRequisito();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if(e.getSource() == vistaAsignarCursoRequisito.btnRegistrarCorrequisito) {
        try {
            agregarCursoCorrequisito();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (e.getSource() == vistaEliminarRequisitoCurso.btnBuscar) {
        consultarCursosRequisito();
    }
    if(e.getSource() == vistaEliminarRequisitoCurso.btnEliminarRequisito) {
        try {
            eliminarRequisitoCurso();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (e.getSource() == vistaEliminarCursoDePlan.btnBuscar){
        consultarCursosPlan();
    }
    if (e.getSource() == vistaEliminarCursoDePlan.btnEliminarPlanEstudioCurso) {
        try {
            eliminarPlanEstudioCurso();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (e.getSource() == vistaEliminarCurso.btnBuscar) {
        consultarCurso();
    }
    if (e.getSource() == vistaEliminarCurso.btnEliminarCurso) {
        try {
            eliminarCurso();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (e.getSource() == vistaRegistroCurso.btnVolver) {
      this.vistaRegistroCurso.setVisible(false);
    }
    if (e.getSource() == vistaAsignarCursoRequisito.btnVolver) {
      this.vistaAsignarCursoRequisito.setVisible(false);
    }
    if (e.getSource() == vistaEliminarRequisitoCurso.btnVolver) {
      this.vistaEliminarRequisitoCurso.setVisible(false);
    }
    if (e.getSource() ==  vistaEliminarCursoDePlan.btnVolver) {
      this.vistaEliminarCursoDePlan.setVisible(false);
    }
    if (e.getSource() ==  vistaEliminarCurso.btnVolver) {
      this.vistaEliminarCurso.setVisible(false);
    }
    
}
  
  public void agregarCurso() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    try{
      String codigoCurso = vistaRegistroCurso.txtCodigoCurso.getText();
      String nombreCurso = vistaRegistroCurso.txtNombreCurso.getText();
      int horasLectivas = Integer.parseInt(vistaRegistroCurso.txtHorasLectivas.getText());
      int cantidadCreditos = Integer.parseInt(vistaRegistroCurso.txtCreditos.getText());
      int numeroPlanEstudioCurso = Integer.parseInt(vistaRegistroCurso.txtCodigoPlanDeEstudios.getText());
      int numeroBloqueSemestral = Integer.parseInt(vistaRegistroCurso.txtBloqueSemestral.getText());
      String codigoEscuela = vistaRegistroCurso.cbxEscuelas.getSelectedItem().toString();
      String resul = dao.registrarCurso(codigoCurso, nombreCurso, horasLectivas, cantidadCreditos,
             numeroPlanEstudioCurso,numeroBloqueSemestral, codigoEscuela );
      String resul2 = dao.registrarCursoBackup(codigoCurso, nombreCurso, horasLectivas, cantidadCreditos,
              numeroBloqueSemestral, codigoEscuela );
      if (resul != null) {
        JOptionPane.showMessageDialog(null,resul); 
      } else {
          JOptionPane.showMessageDialog(vistaRegistroCurso, "Ha sido posible registrar el curso");
        }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public void agregarCursoRequisito() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

      try{

          String codigoCurso = vistaAsignarCursoRequisito.cbxCodigoCurso.getSelectedItem().toString();
          String codigoCurso_Requisito = vistaAsignarCursoRequisito.cbxCodigosCursosRequisito.getSelectedItem().toString();
          //String codigoCurso_Correquisito = vistaAsignarCursoRequisito.txtCursoCorrequisito.getText();
          String codigoEscuela_CursoRequisito = vistaAsignarCursoRequisito.cbxEscuelas.getSelectedItem().toString();
          int numeroPlanEstudio_CursoRequisito = Integer.parseInt(vistaAsignarCursoRequisito.txtNumeroPlanEstudioCurso.getText());
          String resul = dao.asignarRequisitoAUnCurso(codigoCurso, codigoCurso_Requisito,
                  codigoEscuela_CursoRequisito, numeroPlanEstudio_CursoRequisito);
          System.out.println("Se ha registrado el requisito");
          if (resul != null) {
              //vistaRegistroEscuela.setVisible(false);
              JOptionPane.showMessageDialog(null,resul); 
              //vistaRegistroEscuela.setVisible(true);
          } else {

              JOptionPane.showMessageDialog(vistaAsignarCursoRequisito, "Ha sido posible registrar el requisito");
          }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public void agregarCursoCorrequisito() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

    try {

        String codigoCurso = vistaAsignarCursoRequisito.cbxCodigoCurso.getSelectedItem().toString();
        String codigoCurso_Correquisito = vistaAsignarCursoRequisito.cbxCursoCorrequisito.getSelectedItem().toString();
        int numeroPlanEstudio_CursoRequisito = Integer.parseInt(vistaAsignarCursoRequisito.txtNumeroPlanEstudioCurso.getText());
        String resul = dao.asignarCorrequisitoAUnCurso(codigoCurso, codigoCurso_Correquisito, numeroPlanEstudio_CursoRequisito);

        if (resul != null) {
              //vistaRegistroEscuela.setVisible(false);
              JOptionPane.showMessageDialog(null,resul); 
              //vistaRegistroEscuela.setVisible(true);
          } else {

              JOptionPane.showMessageDialog(vistaAsignarCursoRequisito, "Ha sido posible registrar el Correquisito");
          }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }

  }
  
  public void consultarCursosRequisito() {
    String curso = vistaEliminarRequisitoCurso.cbxCurso.getSelectedItem().toString();
    rs = dao.BuscarCurso(curso);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaEliminarRequisitoCurso.tablaInformeCursosRequisito;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo del Curso Buscado","Curso Buscado", "Codigo de Curso Requisito", 
        "Plan de Estudio del Curso"});
    
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("CodigoCurso"),rs.getString("NombreCurso"), rs.getString("CodigoCurso_Requisito"),
        rs.getInt("NumeroPlanEstudio_CursoRequisito")});
        
      }    
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null,ex); 
    }
      
  }
  
  public void eliminarRequisitoCurso() throws ClassNotFoundException {
    int seleccion = vistaEliminarRequisitoCurso.tablaInformeCursosRequisito.getSelectedRow();
    if (seleccion == -1){
        JOptionPane.showMessageDialog(vistaEliminarRequisitoCurso, "Seleccione una fila");
    } else {
        
    
        String nombre = vistaEliminarRequisitoCurso.tablaInformeCursosRequisito.getValueAt(seleccion, 1).toString();
        String codigo = vistaEliminarRequisitoCurso.tablaInformeCursosRequisito.getValueAt(seleccion, 2).toString();
    
        if (dao.eliminarCursoRequisito(codigo) == true){
        
          JOptionPane.showMessageDialog(vistaEliminarRequisitoCurso, "Se ha eliminado el Requisito " + codigo +
              " del curso " + nombre + " exitosamente");
        } else {
            JOptionPane.showMessageDialog(vistaEliminarRequisitoCurso, "No ha sido posible eliminar el requisito");
        }
    }
  }
  
  public void consultarCursosPlan() {
    String curso = vistaEliminarCursoDePlan.cbxCurso.getSelectedItem().toString();
    rs = dao.BuscarPlanEstudioCurso(curso);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaEliminarCursoDePlan.tablaInformeCurso;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo del curso","Curso Buscado", "Cantidad de Creditos", 
        "Plan de Estudio del Curso"});
    
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("CodigoCurso"), rs.getString("NombreCurso"), rs.getString("CantidadCreditos"),
        rs.getInt("NumeroPlanEstudioCurso")});
        
      }    
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(vistaEliminarCursoDePlan,ex); 
    }
      
  }
  
  public void eliminarPlanEstudioCurso() throws ClassNotFoundException {
    int seleccion = vistaEliminarCursoDePlan.tablaInformeCurso.getSelectedRow();
    if (seleccion == -1){
        JOptionPane.showMessageDialog(vistaEliminarCursoDePlan, "Seleccione una fila");
    } else {
        String codigo = vistaEliminarCursoDePlan.tablaInformeCurso.getValueAt(seleccion, 0).toString();
        String nombre = vistaEliminarCursoDePlan.tablaInformeCurso.getValueAt(seleccion, 1).toString();
        int numeroPlan = Integer.parseInt(vistaEliminarCursoDePlan.tablaInformeCurso.getValueAt(seleccion,3).toString());
    
        if (dao.eliminarPlanEstudioCurso(codigo, numeroPlan) == true){
        
          JOptionPane.showMessageDialog(vistaEliminarCursoDePlan, "Se ha eliminado la referencia al plan de estudio " + numeroPlan +
              " del curso " + nombre + " exitosamente");
        } else {
            JOptionPane.showMessageDialog(vistaEliminarCursoDePlan, "No ha sido posible eliminar el plan de estudio");
        }
    }
  }
  
  public void consultarCurso() {
    String curso = vistaEliminarCurso.cbxCurso.getSelectedItem().toString();
    rs = dao.BuscarCursoBackup(curso);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaEliminarCurso.tablaInformeCursosPlan;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo del Curso", "Nombre", "Horas Lectivas", 
        "Cantidad de Creditos", "Codigo de Escuela que pertenece"});
    
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("CodigoCurso"),rs.getString("NombreCurso"), rs.getString("HorasLectivas"),
        rs.getInt("CantidadCreditos"), rs.getString("CodigoEscuelaCurso")});
        
      }    
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  public void eliminarCurso() throws ClassNotFoundException{
    int seleccion = vistaEliminarCurso.tablaInformeCursosPlan.getSelectedRow();
    if (seleccion == -1){
        JOptionPane.showMessageDialog(vistaEliminarCurso, "Seleccione la fila para eliminar el curso");
    } else {  
        String codigo = vistaEliminarCurso.tablaInformeCursosPlan.getValueAt(seleccion, 0).toString();
        String nombre = vistaEliminarCurso.tablaInformeCursosPlan.getValueAt(seleccion, 1).toString();    
        if (dao.eliminarCurso(codigo) == true){
        
          JOptionPane.showMessageDialog(vistaEliminarCurso, "Se ha eliminado el curso " + nombre + " exitosamente");
        } else {
            JOptionPane.showMessageDialog(vistaEliminarCurso, "No ha sido posible eliminar el curso");
        }
    
   }
  }
}
