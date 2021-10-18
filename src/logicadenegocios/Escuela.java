package logicadenegocios;

import java.sql.SQLException;

/**
 *
 * @author Daniel Vaglio
 */
public class Escuela {
    
  Conexion conect = new Conexion();   
    
  private int codigo;
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
  public Escuela(int pCodigo, String pNombreEscuela) {
      
    pCodigo = codigo;
    pNombreEscuela = nombreEscuela;
    
  }
  
  public void RegistrarEscuela(String CodigoEscuela, String NombreEscuela) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{
    
    String st ="insert into Escuela values ('"+CodigoEscuela+"', '"+NombreEscuela+"');";
    conect.getConexion().createStatement().execute(st);
    System.out.println("Se ha registrado una escuela");
    
  }
  
  /*
   * Metodos GETTERS
   */
  public int getCodigo() {
      
    return codigo;
        
  }

  public String getNombreEscuela() {
    
    return nombreEscuela;
    
  }
  
  /*
   * Metodos SETTERS
   */
  public void setCodigo(int pCodigo) {
      
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
