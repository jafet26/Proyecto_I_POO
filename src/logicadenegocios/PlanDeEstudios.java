package logicadenegocios;

/**
 * Abstraccion de la clase Curso
 * Contiene la informacion de los planes de estudio
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class PlanDeEstudios {
  private int numeroPlan;
  private String fechaEntradaVigente;
  private int cantidadSemestres;
  
  /*
  * Metodo Constructor Vacio
  */  
  public PlanDeEstudios(){ 
  }
  
  /**
   * Metodo Constructor sobrecargado
   * @param pNumeroPlan contiene el numero de plan que se va a crear
   * @param pFechaEntradaVigente indica la fecha de vigencia del plan
   * @param pCantidadSemestres indica la cantidad de semestre que contiene el plan
   */
  public PlanDeEstudios(int pNumeroPlan, String pFechaEntradaVigente, int pCantidadSemestres) {
    pNumeroPlan = numeroPlan;
    pFechaEntradaVigente = fechaEntradaVigente;
    pCantidadSemestres = cantidadSemestres; 
  }

  /**
   * Metodos GETTERS
     * @return la informacion correspondiente a cada atributo de la clase
   */
  public int getNumeroPlan() {
    return numeroPlan;
  }

  public String getFechaEntradaVigente() {
    return fechaEntradaVigente;
  }

  public int getCantidadSemestres() {
    return cantidadSemestres;
  }
  
  
  //Metodos SETTERS
  public void setNumeroPlan(int pNumeroPlan) {
    pNumeroPlan = numeroPlan; 
  }
  
  public void setFechaEntradaVigencia(String pFechaEntradaVigente) { 
    pFechaEntradaVigente = fechaEntradaVigente;
  }
  
  public void setCantidadSemestres(int pCantidadSemestres) {
    pCantidadSemestres = cantidadSemestres;
  }
  
  /**
   * Metodo ToString()
   * @return la informacion del Plan de Estudios contenida en una cadena de caracteres
   */
  @Override
  public String toString() {
    String msg;
    msg = "Numero de Plan: " + numeroPlan + "\n";
    msg += "Fecha de vigencia: " + fechaEntradaVigente + "\n";
    msg += "Cantidad de Semestres del plan: " + cantidadSemestres + "\n";
    return msg;
  } 
}
