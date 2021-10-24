package logicadenegocios;

/**
 * Abstraccion de la clase Curso
 * Contiene la informacion de los cursos
 * @author Daniel Vaglio Fallas & Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class Curso {
  private String codigoCurso;
  private String nombreCurso;
  private int horasLectivas;
  private int cantidadCreditos;
  private int numeroBloqueSemestre;
  
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
     * @return la informacion correspondiente a cada atributo de la clase
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
  
  public int getNumeroBloqueSemestre() {
    return numeroBloqueSemestre;
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
  
  public void setNumeroBloqueSemestre(int pNumeroBloqueSemestre) {
      pNumeroBloqueSemestre =numeroBloqueSemestre;
  }
  
  /**
   * Metodo toString()
   * @return la informacion de un curso contenida en una cadena de caracteres
   */
  @Override
  public String toString() {
    String msg;
    msg = "Codigo del Curso: " + codigoCurso + "\n";
    msg += "Nombre del Curso: " + nombreCurso + "\n";
    msg += "Cantidad de Creditos: " + cantidadCreditos + "\n";
    msg += "Horas Lectivas: " + horasLectivas + "\n";
    return msg; 
  }
  
}
