package logicadenegocios;

/**
 *
 * @author Daniel Vaglio
 */
public class Curso {
    
  private String codigoCurso;
  private String nombreCurso;
  private int cantidadCreditos;
  private int horasLectivas;
  
  /**
   * Metodo Constructor Vacio
   */
  public Curso() {
      
  }

  /**
   * Metodo Constructor sobrecargado
   * @param pCodigoCurso indica el codigo del curso (2 Caracteres + 4 digitos enteros)
   * @param pNombreCurso tiene el nombre del curso
   * @param pCantidadCreditos indica la cantidad de creditos (entero de rango 0 a 4)
   * @param pHorasLectivas  indica la cantidad de horas lectivas del curso (entero de rango 1 a 5) 
   */
  public Curso(String pCodigoCurso, String pNombreCurso, int pCantidadCreditos, int pHorasLectivas) {
    pCodigoCurso = codigoCurso;
    pNombreCurso = nombreCurso;
    pCantidadCreditos = cantidadCreditos;
    pHorasLectivas = horasLectivas;
  }

  /**
   * Metodos GETTERS 
   */
  public String getCodigoCurso() {
    
    return codigoCurso;
    
  }

  public String getNombreCurso() {
    
    return nombreCurso;
    
  }

  public int getCantidadCreditos() {
    
    return cantidadCreditos;
    
  }

  public int getHorasLectivas() {
      
    return horasLectivas;
    
  }
  
  /**
   * Metodos SETTERS
   */
  public void setCodigoCurso(String pCodigoCurso) {
      
    pCodigoCurso = codigoCurso;
    
  }
  
  public void setNmbreCurso(String pNombreCurso) {
      
    pNombreCurso = nombreCurso;
    
  }
  
  public void setCantidadCreditos(int pCantidadCreditos) {
      
    pCantidadCreditos = cantidadCreditos;
    
  }
  
  public void setHorasLectivas(int pHorasLectivas) {
      
    pHorasLectivas = horasLectivas;
    
  }
  
  /**
   * Metodo toString()
   * @return la informacion de un curso contenida en una cadena de caracteres
   */
  public String toString() {
      
    String msg;
    msg = "Codigo del Curso: " + codigoCurso + "\n";
    msg += "Nombre del Curso: " + nombreCurso + "\n";
    msg += "Cantidad de Creditos: " + cantidadCreditos + "\n";
    msg += "Horas Lectivas: " + horasLectivas + "\n";
    
    return msg;
    
  }
  
}
