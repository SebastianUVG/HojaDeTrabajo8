/**
 * Clase que representa a un paciente con su nombre,
 * síntomas y prioridad. Además implementa la interfaz
 * Comparable para comparar dos objetos de esta clase.
 * 
 * @author Sebastian Garcia
 * @version 1.0
 */

package uvg;

public class Sick implements Comparable<Sick> {
    /**
     * Prioridad del paciente
     */
    String priotiry;
    
    /**
     * Síntomas del paciente
     */
    String symptoms;
    
    /**
     * Nombre del paciente
     */
    String name;
    
    /**
     * Crea un nuevo objeto Sick con los datos proporcionados
     * 
     * @param priotiry Prioridad del paciente
     * @param symptoms Síntomas del paciente
     * @param name Nombre del paciente
     */
    public Sick(String priotiry, String symptoms, String name) {
        this.name = name;
        this.symptoms = symptoms;
        this.priotiry = priotiry;
    }

    /**
     * Compara dos objetos Sick en base a su prioridad
     * 
     * @param enfermo Objeto Sick a comparar
     * @return Retorna un valor negativo si este objeto es menor
     *         que el objeto proporcionado. Retorna un valor positivo
     *         si este objeto es mayor que el objeto proporcionado.
     *         Retorna 0 si los objetos son iguales
     */
    @Override
    public int compareTo(Sick enfermo) {
        // TODO Auto-generated method stub
        return this.priotiry.compareToIgnoreCase(enfermo.priotiry);
    }
    
    /**
     * Devuelve una representación en cadena del objeto Sick
     * 
     * @return Retorna una cadena con el nombre, síntomas y prioridad
     *         del objeto Sick
     */
    @Override
    public String toString() {
        return "[Paciente :" + this.name + ","
                + "Symptoms :" + this.symptoms + ","
                + "Priotiry :" + this.priotiry + "]";
    }
    
    /**
     * Método principal de prueba para la clase Sick
     * 
     * @param args Los argumentos que se reciben desde la línea de comandos
     */
   

}


