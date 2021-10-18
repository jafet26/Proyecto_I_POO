package logicadenegocios;

import java.sql.Connection;


import vista.RegistrarEscuela;

/**
 *
 * @author Daniel Vaglio
 */
public class Escuela {
    
  private String codigo;
  private String nombreEscuela;
  
  /**
   * Metodo Constructor vacio
   */
  public Escuela(){
      
  }

  /**
   * Metodo Constructor sobrecargado
   * @param pCodigo se refiere al codigo que tiene la Escuela
   * @param pNombreEscuela indica el nombre de la Escuela 
   */
  public Escuela(String pCodigo, String pNombreEscuela) {
      
    pCodigo = codigo;
    pNombreEscuela = nombreEscuela;
    
  }
  
  /*
   * Metodos GETTERS
   */
  public String getCodigo() {
      
    return codigo;
        
  }

  public String getNombreEscuela() {
    
    return nombreEscuela;
    
  }
  
  /*
   * Metodos SETTERS
   */
  public void setCodigo(String pCodigo) {
      
    pCodigo = codigo;
    
  }
  
  public void setNombreEscuela(String pNombreEscuela) {
      
    pNombreEscuela = nombreEscuela;
    
  }
  
  /**
   * Metodo toString()
   * @return la informacion de la escuela contenida en una cadena de caracteres 
   */
  public String toString() {
      
    String msg;
    msg = "Codigo: " + codigo + "\n";
    msg += "Nombre: " + nombreEscuela + "\n";
    
    return msg;
    
  }
  
}
