public class Benchmark {

    public static Results medir(Runnable tarea, String etiqueta, String tamano) {
        long inicio = System.nanoTime();
        try {
            tarea.run();
        } catch (RuntimeException ex) {
            throw new RuntimeException(
                    "Error durante '" + etiqueta + "' (tamano=" + tamano + "): " + ex.getMessage(), ex);
        }
        long fin = System.nanoTime();

        return new Results(etiqueta, fin - inicio, tamano);
    }
}