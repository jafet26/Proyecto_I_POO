package logicadenegocios;

/**
 * Abstraccion de la clase Escuela 
 * Contiene la informacion de las Escuelas o Areas Academicas
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
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
  
  /**
   * Metodos GETTERS
     * @return la informacion correspondiente a cada atributo de la clase
   */
  public String getCodigo() {
    return codigo;   
  }

  public String getNombreEscuela() {
    return nombreEscuela;
  }
  
 
  // Metodos SETTERS
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
