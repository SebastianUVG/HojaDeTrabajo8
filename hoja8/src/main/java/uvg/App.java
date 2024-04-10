package uvg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        NewInterface<Sick> bucketList = PriorityQueueFactory.createQueue("java");
        Scanner sc = new Scanner(System.in);
        System.out.println( "--------------------Ficha de enfermos--------------------" );
        System.out.println("Por favor ingrese el nombre del documento de pacientes que quiere abrir (pacientes.txt):");
        String lista = sc.nextLine();
        String rutaArchivo = "C:\\Users\\sebas\\OneDrive\\Escritorio\\Github\\EstructuraDeDatos\\HojaDeTrabajo8\\hoja8\\src\\main\\java\\uvg\\"+lista;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String datos;
            while ((datos = br.readLine()) != null) {
                String[] partes = datos.split(",");
                if (partes.length == 3) {
                    String name = partes[0].trim();
                    String symptoms = partes[1].trim();
                    String priority = partes[2].trim();
                    Sick paciente = new Sick(priority, symptoms, name);
                    //System.out.println(paciente);
                    bucketList.add(paciente);
                }
                
            }
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
            //System.out.println(bucketList);
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Error al leer el archivo");
        }

    }


    private static class PriorityQueueFactory{
        public static NewInterface<Sick> createQueue(String type){
            if (type.equals("java")) {
                return new JavaPriorityQueue<Sick>();
            } else {
                return new VectorHeap<Sick>();
            }
        }
    }
}