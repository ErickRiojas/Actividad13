import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        ArrayList<String> Array = new ArrayList<>();
        Array.add("Abeja");
        Array.add("Conejo saltador");
        Array.add("Borrego pequeño");
        Array.add("Elefante");
        Array.add("Foca marina");
        Array.add("Delfin inteligente");
        Array.add("Gato montes");
        Array.add("Jirafa grande");
        Array.add("Hipopotamo");
        Array.add("Koala dormilon");


        Anonima anonima = new Anonima() {
            public void Ordenar() {
                System.out.println("*----ORDENADAS EN CLASE ANONIMA----*");
                System.out.println("La/s palabra/s ordenadas por su tamaño: ");
                Collections.sort(Array, Comparator.comparing(String::length));
                Array.forEach(System.out::println);

                System.out.println("\nLa/s palabra/s ordenadas alfabeticamente");
                Array.sort(String::compareToIgnoreCase);
                Array.forEach(System.out::println);
            }
        };anonima.Ordenar();


        System.out.println("\n*----ORDENADAS EN EXPRESIONES LAMBDA----*");
        System.out.println("La/s palabra/s ordenadas por su tamaño: ");
        Collections.sort(Array, (x, y) -> Float.compare(x.length(), y.length()));
        Array.forEach(array -> System.out.println(array));

        System.out.println("\nLa/s palabra/s ordenadas alfabeticamente");
        Array.sort((x, y) -> x.compareToIgnoreCase(y));
        Array.forEach(array -> System.out.println(array));

        System.out.println("\n*----ORDENADAS EN METODOS DE REFERENCIA----*");
        MetodoReferencia tamaño = MetodosReferencias::OrdenTamaño;
        System.out.println("La/s palabra/s ordenadas por su tamaño: " + tamaño.array(Array)+ "\n");
        MetodoReferencia alfabetico = MetodosReferencias::OrdenAlfabetico;
        System.out.println("La/s palabra/s ordenadas alfabeticamente" + alfabetico.array(Array) + "\n");

    }
    class MetodosReferencias {
        static ArrayList<String> OrdenTamaño(ArrayList<String> array) {
            Collections.sort(array, (x, y) -> Float.compare(x.length(), y.length()));
            return array;
        }
        static ArrayList<String> OrdenAlfabetico(ArrayList<String> array) {
            Collections.sort(array, (a, b) -> a.compareToIgnoreCase(b));
            return array;
        }
    }
}

