import java.util.Random;

public class Generador {

    public static int[] generate(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser un valor negativo: " + cantidad);
        }
        int[] valores = new int[cantidad];
        Random azar = new Random();
        long tope = (long) cantidad + 1;
        for (int pos = 0; pos < cantidad; pos++) {
            valores[pos] = (int) azar.nextLong(tope);
        }
        return valores;
    }
}