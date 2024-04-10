/**
 * Esta es la clase principal de la aplicación, se encarga de leer los datos
 * del archivo de pacientes y de presentar las opciones para el usuario.
 * @author Sebastian Garcia
 * @version 1.0
 */
package uvg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Esta clase es el punto de entrada de la aplicación, aca se encarga
 * de leer los datos del archivo de pacientes y de presentar las opciones
 * para el usuario. 
 */
public class App 
{
    /**
     * Método principal de la aplicación, aca se encarga de leer los datos
     * del archivo de pacientes y de presentar las opciones para el usuario.
     * @param args Los argumentos que se reciben desde la linea de comandos
     */
    public static void main( String[] args )
    {
        //Se solicita al usuario que ingrese el nombre del archivo
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo de pacientes:");
        String lista = sc.nextLine();

        //Se abre el archivo y se leen los datos
        String rutaArchivo = "C:\\Users\\sebas\\OneDrive\\Escritorio\\Github\\EstructuraDeDatos\\HojaDeTrabajo8\\hoja8\\src\\main\\java\\uvg\\"+lista;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String datos;
            NewInterface<Sick> bucketList = PriorityQueueFactory.createQueue("java");
            while ((datos = br.readLine()) != null) {
                String[] partes = datos.split(",");
                if (partes.length == 3) {
                    String name = partes[0].trim();
                    String symptoms = partes[1].trim();
                    String priority = partes[2].trim();
                    Sick paciente = new Sick(priority, symptoms, name);
                    bucketList.add(paciente);
                }
            }

            //Se muestra la lista de pacientes y se solicita las opciones al usuario
            System.out.println("La lista de pacientes es:");
            System.out.println(bucketList);
            boolean bandera = true;
            while (bandera ){
                System.out.println("Opciones a realizar: ");
                System.out.println("1. Ver lista de pacientes");
                System.out.println("2. Examinar al paciente con mayor prioridad.");
                System.out.println("3. Salir del programa");
                int respuesta = sc.nextInt();

                if (respuesta == 1){
                    System.out.println(bucketList);
                }else if (respuesta == 2){
                    System.out.println("El paciente con mayor prioridad es: ");
                    try {
                        System.out.println(bucketList.remove());
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("La lista se encuentra vacia");
                        break;
                    }

                }else if (respuesta == 3){
                    bandera = false;
                    System.out.println("Saliendo del programa");
                }else{
                    System.out.println("Opcion no valida");
                    bandera = false;
                }

            }

        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Error al leer el archivo");
        }

    }

    /**
     * Esta clase es una factoría que se encarga de crear una PriorityQueue
     * dependiendo del tipo que se le pase como parametro
     */
    private static class PriorityQueueFactory{
        /**
         * Método que se encarga de crear una PriorityQueue dependiendo del tipo
         * que se le pase como parametro.
         * @param type El tipo de PriorityQueue que se quiere crear
         * @return Devuelve una PriorityQueue del tipo especificado
         */
        public static NewInterface<Sick> createQueue(String type){
            if (type.equals("java")) {
                return new JavaPriorityQueue<Sick>();
            } else {
                return new VectorHeap<Sick>();
            }
        }
    }
}

