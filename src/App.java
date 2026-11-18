
import java.util.List;



public class App {
    public static void main(String[] args) throws Exception {
        // long nanoTime = System.nanoTime();
        // long currentTimeMills = System.currentTimeMillis();
        // System.out.println("Nano Time: "+ nanoTime);
        // System.out.println("Current Time: " + currentTimeMills);

        // Runnable funcion = () -> {
        //     System.out.println("Ejecutando tarea 1");
        //     System.out.println("Ejecutnado tarea 2");
        // };

        // // Callable<T> x
        // System.out.println("Ejecucion de ka funcion Runnable");
        // funcion.run();

        Generador g = new Generador();
        Benchmark b = new Benchmark();

        List<Integer> list = g.generate(100000);
        System.out.println(list);

        Results benGenLis = b.medir(
            () -> g.generate(100000),"Generacion de listado", "100");

        System.out.println(benGenLis);
    }
}
