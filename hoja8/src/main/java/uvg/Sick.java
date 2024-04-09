package uvg;

public class Sick implements Comparable<Sick> {
    String priotiry; 
    String symptoms;
    String name;

    public Sick(String priotiry,String symptoms,String name){
        this.name = name;
        this.symptoms = symptoms;
        this.priotiry = priotiry;
    }

    @Override
    public int compareTo(Sick enfermo) {
        // TODO Auto-generated method stub
        return this.priotiry.compareToIgnoreCase(enfermo.priotiry);
    } 

    @Override
    public String toString(){
        return "[Paciente :" + this.name + "," + "Symptoms :" + this.symptoms + "," + "Priotiry :" + this.priotiry + "]";
    }

    public static void main(String[] args) {
        Sick primero = new Sick("A", "Dolor de cabeza", "Sebastian");
        Sick segundo = new Sick("E","Le falta una pierna","Juan Pedro");
        System.out.println(primero);
        System.out.println(segundo);
        System.out.println(primero.compareTo(segundo));
    }


}

