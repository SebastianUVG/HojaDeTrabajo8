package uvg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SickTest {

    @Test
    public void testCompareTo() {
        Sick primero = new Sick("A", "Dolor de cabeza", "Sebastian");
        Sick segundo = new Sick("E", "Le falta una pierna", "Juan Pedro");

        int resultado = primero.compareTo(segundo);

        assertEquals(-4, resultado);
    }

    @Test
    public void testToString() {
        Sick primero = new Sick("A", "Dolor de cabeza", "Sebastian");

        String resultado = primero.toString();

        assertEquals("[Paciente :Sebastian,Symptoms :Dolor de cabeza,Priotiry :A]", resultado);
    }
}
