
package controlador;

import dao.PlanDeEstudioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logicadenegocios.Curso;
import logicadenegocios.PlanDeEstudios;
import proyecto_i_poo.Conexion;
import vista.ConsultarPlanDeEstudio;
import vista.RegistrarPlanDeEstudios;

/**
 *
 * @author USUARIO
 */
public class ControladorPlanDeEstudio implements ActionListener {
  
  public RegistrarPlanDeEstudios vistaRegistroPlanDeEstudio = new RegistrarPlanDeEstudios();
  public ConsultarPlanDeEstudio vistaConsultarPlanDeEstudio = new ConsultarPlanDeEstudio();
  public PlanDeEstudios logicadenegocios;
  public PlanDeEstudioDAO dao = new PlanDeEstudioDAO();
  public Curso curso;
  public DefaultTableModel modelo = new DefaultTableModel();
  public JTable tabla;
  public ResultSet rs;
  
  //constructor
  public ControladorPlanDeEstudio(RegistrarPlanDeEstudios pVistaRegistroPlanDeEstudio, 
         PlanDeEstudioDAO pModelo) {
      
    vistaRegistroPlanDeEstudio = pVistaRegistroPlanDeEstudio;
    dao = pModelo;
        
    this.vistaRegistroPlanDeEstudio.btnRegistrar.addActionListener(this);
    this.vistaRegistroPlanDeEstudio.btnVolver.addActionListener(this);
  }
  
  public ControladorPlanDeEstudio(ConsultarPlanDeEstudio pVistaConsultarPlanDeEstudio, PlanDeEstudioDAO pModelo) {
    vistaConsultarPlanDeEstudio = pVistaConsultarPlanDeEstudio;
    dao = pModelo;
    this.vistaConsultarPlanDeEstudio.btnGenerarPDF.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaRegistroPlanDeEstudio.btnRegistrar) {
        try {
            agregarPlanDeEstudio();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    if (e.getSource() == vistaConsultarPlanDeEstudio.btnGenerarPDF) {
        listar();
    }
    if(e.getSource() == vistaRegistroPlanDeEstudio.btnVolver) {
        this.vistaRegistroPlanDeEstudio.setVisible(false);
    }
}
  
  public void agregarPlanDeEstudio() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      
      try{
          int codigoPlanDeEstudio = Integer.parseInt(vistaRegistroPlanDeEstudio.txtCodigoPlan.getText());
          String fechaVigencia = vistaRegistroPlanDeEstudio.txtFechaVigencia.getText();
          int cantidadSemestres = Integer.parseInt(vistaRegistroPlanDeEstudio.txtCantidadSemestres.getText());
          String codigoEscuela = vistaRegistroPlanDeEstudio.cbxEscuelas.getSelectedItem().toString();
          String resul = dao.registrarPlanDeEstudio(codigoPlanDeEstudio, fechaVigencia, cantidadSemestres, codigoEscuela);
          if (resul != null) {
              //vistaRegistroEscuela.setVisible(false);
              JOptionPane.showMessageDialog(null,resul); 
              //vistaRegistroEscuela.setVisible(true);
          } else {
              JOptionPane.showMessageDialog(vistaRegistroPlanDeEstudio, "Ha sido posible registrar la escuela");
          }
      } catch (Exception ex) {
          Logger.getLogger(ControladorEscuela.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  
  public void listar() {
    
    String codigoEscuela = vistaConsultarPlanDeEstudio.cbxEscuelas.getSelectedItem().toString();
    int numeroPlanEstudio = Integer.parseInt(vistaConsultarPlanDeEstudio.cbxCodigoPlanDeEstudios.getSelectedItem().toString());
    ResultSet rs2 = dao.indicarFechaVigenciaPlan(codigoEscuela, numeroPlanEstudio);
      try {
          if (rs2.next()){
            String fecha = rs2.getString("FechaEntradaVigencia");
            vistaConsultarPlanDeEstudio.txtFechaVigencia.setText(fecha);
          }
      } catch (SQLException ex) {
          Logger.getLogger(ControladorPlanDeEstudio.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    rs = dao.SeleccionarCursosFiltro(codigoEscuela, numeroPlanEstudio);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaConsultarPlanDeEstudio.tablaInformeCursosPlan;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Codigo", "Nombre", "Horas", "Creditos", "numero Bloque"});
    
    try {
        while (rs.next()) {
            dfm.addRow(new Object[]{rs.getString("CodigoCurso"), rs.getString("NombreCurso"),
            rs.getInt("HorasLectivas"), rs.getInt("CantidadCreditos"), rs.getInt("NumeroBloqueSemestral")});
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,ex);
    }
    
  }
  public void volverMenu() {
      vistaRegistroPlanDeEstudio.volverMenu();
  }
    
}
