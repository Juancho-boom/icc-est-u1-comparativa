import java.util.Arrays;
import java.util.Comparator;

public class Metodos {

    public void sortBubble(int[] datos) {
        if (datos == null || datos.length <= 1) {
            return;
        }
        int total = datos.length;
        for (int pasada = 0; pasada < total - 1; pasada++) {
            boolean huboCambio = false;
            for (int cursor = 0; cursor < total - 1 - pasada; cursor++) {
                if (datos[cursor] > datos[cursor + 1]) {
                    int aux = datos[cursor];
                    datos[cursor] = datos[cursor + 1];
                    datos[cursor + 1] = aux;
                    huboCambio = true;
                }
            }
            if (!huboCambio) {
                break;
            }
        }
    }

    public void sortQuick(int[] datos) {
        if (datos == null || datos.length <= 1) {
            return;
        }
        ordenarRapido(datos, 0, datos.length - 1);
    }

    private void ordenarRapido(int[] datos, int desde, int hasta) {
        if (desde < hasta) {
            int posPivote = dividir(datos, desde, hasta);
            ordenarRapido(datos, desde, posPivote - 1);
            ordenarRapido(datos, posPivote + 1, hasta);
        }
    }

    private int dividir(int[] datos, int desde, int hasta) {
        int valorPivote = datos[hasta];
        int menor = desde - 1;
        for (int recorrido = desde; recorrido < hasta; recorrido++) {
            if (datos[recorrido] <= valorPivote) {
                menor++;
                int aux = datos[menor];
                datos[menor] = datos[recorrido];
                datos[recorrido] = aux;
            }
        }
        int aux = datos[menor + 1];
        datos[menor + 1] = datos[hasta];
        datos[hasta] = aux;
        return menor + 1;
    }

    public void sortArrays(int[] datos) {
        Arrays.sort(datos);
    }

    public void sortArraysComparator(Integer[] datos, Comparator<Integer> criterio) {
        Arrays.sort(datos, criterio);
    }
}