import java.util.Arrays;
import java.util.Comparator;

public class Pruebas {

    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        Comparator<Integer> comparador = (x, y) -> Integer.compare(x, y);

        System.out.println("CA02 (n=0): tamaño obtenido = " + Generador.generate(0).length);
        try {
            Generador.generate(-5);
        } catch (IllegalArgumentException ex) {
            System.out.println("CA02 (n=-5): excepción atrapada -> " + ex.getMessage());
        }

        int[] casoRepetidos = { 7, 2, 7, 0, 4, 2 };
        ejecutarVariantes("CA04", casoRepetidos, metodos, comparador);

        ejecutarVariantes("CA05-vacio", new int[] {}, metodos, comparador);
        ejecutarVariantes("CA05-uno", new int[] { 5 }, metodos, comparador);
        ejecutarVariantes("CA05-repetidos", new int[] { 3, 3, 3 }, metodos, comparador);

        ejecutarVariantes("CA06-ordenado", new int[] { 0, 1, 2, 3 }, metodos, comparador);
        ejecutarVariantes("CA06-inverso", new int[] { 3, 2, 1, 0 }, metodos, comparador);

        try {
            Benchmark.medir(() -> {
                throw new IllegalStateException("Fallo simulado");
            }, "OperacionFallida", "10");
        } catch (RuntimeException ex) {
            System.out.println("CA09: excepción atrapada -> " + ex.getMessage()
                    + " | causa de origen: " + ex.getCause().getClass().getSimpleName());
        }

        int[] yaOrdenado = new int[5000];
        for (int pos = 0; pos < yaOrdenado.length; pos++) {
            yaOrdenado[pos] = pos;
        }
        int[] desordenado = Generador.generate(5000);
        Results resDesordenado = Benchmark.medir(() -> metodos.sortQuick(desordenado), "Quick Sort (desordenado)", "5.000");
        Results resYaOrdenado = Benchmark.medir(() -> metodos.sortQuick(yaOrdenado), "Quick Sort (previamente ordenado)", "5.000");
        System.out.println("\n=== PEOR ESCENARIO PARA QUICK SORT (n=5000) ===");
        System.out.println(resDesordenado);
        System.out.println(resYaOrdenado);
    }

    private static void ejecutarVariantes(String codigo, int[] entrada, Metodos metodos, Comparator<Integer> comparador) {
        int[] copiaBurbuja = entrada.clone();
        int[] copiaRapido = entrada.clone();
        int[] copiaNativa = entrada.clone();
        Integer[] copiaObjetos = new Integer[entrada.length];
        for (int pos = 0; pos < entrada.length; pos++) {
            copiaObjetos[pos] = entrada[pos];
        }

        metodos.sortBubble(copiaBurbuja);
        metodos.sortQuick(copiaRapido);
        metodos.sortArrays(copiaNativa);
        metodos.sortArraysComparator(copiaObjetos, comparador);

        System.out.println(codigo + " -> Burbuja:" + Arrays.toString(copiaBurbuja)
                + " | Rápido:" + Arrays.toString(copiaRapido)
                + " | Nativo:" + Arrays.toString(copiaNativa)
                + " | Objetos:" + Arrays.toString(copiaObjetos));
    }
}