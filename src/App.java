import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Metodos metodos = new Metodos();
        Comparator<Integer> comparador = (x, y) -> Integer.compare(x, y);

        int[] base10k = Generador.generate(10000);
        int[] base50k = Generador.generate(50000);
        int[] base100k = Generador.generate(10000);

        int[] esperado10k = base10k.clone();
        Arrays.sort(esperado10k);
        int[] esperado50k = base50k.clone();
        Arrays.sort(esperado50k);
        int[] esperado100k = base100k.clone();
        Arrays.sort(esperado100k);

        int[] burbuja10k = base10k.clone();
        int[] rapido10k = base10k.clone();
        int[] nativo10k = base10k.clone();
        Integer[] objetos10k = convertirAObjetos(base10k);

        int[] burbuja50k = base50k.clone();
        int[] rapido50k = base50k.clone();
        int[] nativo50k = base50k.clone();
        Integer[] objetos50k = convertirAObjetos(base50k);

        int[] burbuja100k = base100k.clone();
        int[] rapido100k = base100k.clone();
        int[] nativo100k = base100k.clone();
        Integer[] objetos100k = convertirAObjetos(base100k);

        List<Results> listaResultados = new ArrayList<>();

        Results resBurbuja10k = Benchmark.medir(() -> metodos.sortBubble(burbuja10k), "Burbuja", "10.000");
        verificar(burbuja10k, esperado10k, "Burbuja", "10.000");
        listaResultados.add(resBurbuja10k);

        Results resBurbuja50k = Benchmark.medir(() -> metodos.sortBubble(burbuja50k), "Burbuja", "50.000");
        verificar(burbuja50k, esperado50k, "Burbuja", "50.000");
        listaResultados.add(resBurbuja50k);

        Results resBurbuja100k = Benchmark.medir(() -> metodos.sortBubble(burbuja100k), "Burbuja", "100.000");
        verificar(burbuja100k, esperado100k, "Burbuja", "100.000");
        listaResultados.add(resBurbuja100k);

        Results resRapido10k = Benchmark.medir(() -> metodos.sortQuick(rapido10k), "Quick Sort", "10.000");
        verificar(rapido10k, esperado10k, "Quick Sort", "10.000");
        listaResultados.add(resRapido10k);

        Results resRapido50k = Benchmark.medir(() -> metodos.sortQuick(rapido50k), "Quick Sort", "50.000");
        verificar(rapido50k, esperado50k, "Quick Sort", "50.000");
        listaResultados.add(resRapido50k);

        Results resRapido100k = Benchmark.medir(() -> metodos.sortQuick(rapido100k), "Quick Sort", "100.000");
        verificar(rapido100k, esperado100k, "Quick Sort", "100.000");
        listaResultados.add(resRapido100k);

        Results resNativo10k = Benchmark.medir(() -> metodos.sortArrays(nativo10k), "Arrays.sort con int[]", "10.000");
        verificar(nativo10k, esperado10k, "Arrays.sort con int[]", "10.000");
        listaResultados.add(resNativo10k);

        Results resNativo50k = Benchmark.medir(() -> metodos.sortArrays(nativo50k), "Arrays.sort con int[]", "50.000");
        verificar(nativo50k, esperado50k, "Arrays.sort con int[]", "50.000");
        listaResultados.add(resNativo50k);

        Results resNativo100k = Benchmark.medir(() -> metodos.sortArrays(nativo100k), "Arrays.sort con int[]", "100.000");
        verificar(nativo100k, esperado100k, "Arrays.sort con int[]", "100.000");
        listaResultados.add(resNativo100k);

        Results resObjetos10k = Benchmark.medir(() -> metodos.sortArraysComparator(objetos10k, comparador),
                "Arrays.sort con Comparator en Integer[]", "10.000");
        verificarObjetos(objetos10k, esperado10k, "Arrays.sort con Comparator en Integer[]", "10.000");
        listaResultados.add(resObjetos10k);

        Results resObjetos50k = Benchmark.medir(() -> metodos.sortArraysComparator(objetos50k, comparador),
                "Arrays.sort con Comparator en Integer[]", "50.000");
        verificarObjetos(objetos50k, esperado50k, "Arrays.sort con Comparator en Integer[]", "50.000");
        listaResultados.add(resObjetos50k);

        Results resObjetos100k = Benchmark.medir(() -> metodos.sortArraysComparator(objetos100k, comparador),
                "Arrays.sort con Comparator en Integer[]", "100.000");
        verificarObjetos(objetos100k, esperado100k, "Arrays.sort con Comparator en Integer[]", "100.000");
        listaResultados.add(resObjetos100k);

        for (Results item : listaResultados) {
            System.out.println(item);
        }
    }

    private static Integer[] convertirAObjetos(int[] origen) {
        Integer[] destino = new Integer[origen.length];
        for (int idx = 0; idx < origen.length; idx++) {
            destino[idx] = origen[idx];
        }
        return destino;
    }

    private static void verificar(int[] obtenido, int[] esperado, String algoritmo, String tamano) {
        if (!Arrays.equals(obtenido, esperado)) {
            throw new IllegalStateException("Fallo al ordenar con " + algoritmo + " (" + tamano + ")");
        }
    }

    private static void verificarObjetos(Integer[] obtenido, int[] esperado, String algoritmo, String tamano) {
        if (obtenido.length != esperado.length) {
            throw new IllegalStateException("Tamaño distinto al esperado en " + algoritmo + " (" + tamano + ")");
        }
        for (int idx = 0; idx < esperado.length; idx++) {
            if (obtenido[idx] == null || obtenido[idx] != esperado[idx]) {
                throw new IllegalStateException("Fallo al ordenar con " + algoritmo + " (" + tamano + ")");
            }
        }
    }
}