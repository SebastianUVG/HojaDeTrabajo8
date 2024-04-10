package uvg;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class bucketListTest {
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
    @Test
    public void addTest(){
        NewInterface<Sick> bucketList = PriorityQueueFactory.createQueue("java");
        bucketList.add(new Sick("A", "Dolor de cabeza", "Sebastian"));
        assertEquals("[[Paciente :Sebastian,Symptoms :Dolor de cabeza,Priotiry :A]]", bucketList.toString());
    }


    public void removeTest(){
        NewInterface<Sick> bucketList = PriorityQueueFactory.createQueue("java");
        bucketList.add(new Sick("B", "Dolor de cabeza", "Sebastian"));
        bucketList.add(new Sick("A", "Dolor de cabeza", "Sebastian"));
        assertEquals("[[Paciente :Sebastian,Symptoms :Dolor de cabeza,Priotiry :A]]", bucketList.remove());
        
    }
}
