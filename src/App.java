
import java.util.ArrayList;
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

        List<Integer> list = g.generate(1000);
        System.out.println(list);

        Results benGenLis = b.medir(
            () -> g.generate(1000),"Generacion de listado", "100");

        System.out.println(benGenLis);

        // ARREGLO BASE
        
        //Lsitado 10000
        List<Integer> listA = g.generate(10000);
        //Listado 50000
        List<Integer> listB = g.generate(5000);
        //Listado 100000
        List<Integer> listC = g.generate(100000);

        //COPIAS DE LISTADOS

        List<Integer> listAc1 = new ArrayList<>(listA);
        List<Integer> listAc2 = new ArrayList<>(listA);
        List<Integer> listAc3 = new ArrayList<>(listA);
        List<Integer> listAc4 = new ArrayList<>(listA);

        List<Integer> listBc1 = new ArrayList<>(listB);
        List<Integer> listBc2 = new ArrayList<>(listB);
        List<Integer> listBc3 = new ArrayList<>(listB);
        List<Integer> listBc4 = new ArrayList<>(listB);
        
        List<Integer> listCc1 = new ArrayList<>(listC);
        List<Integer> listCc2 = new ArrayList<>(listC);
        List<Integer> listCc3 = new ArrayList<>(listC);
        List<Integer> listCc4 = new ArrayList<>(listC);

    
        List<Results> resultados = new ArrayList<>();

        Results resultadoA1c1 = Benchmark.medir(
            () -> g.sortBurbujita(listAc1), "Burbuja","10.000");
        Results resultadoA1c2 = Benchmark.medir(
            () -> g.sortBurbujita(listAc2), "Burbuja","10.000");
        Results resultadoA1c3 = Benchmark.medir(
            () -> g.sortBurbujita(listAc3), "Burbuja","10.000");
        
        resultados.add(resultadoA1c1);
        resultados.add(resultadoA1c2);
        resultados.add(resultadoA1c3);

        Results resultadoB1c1 = Benchmark.medir(
            () -> g.sortBurbujita(listBc1), "Burbuja","10.000");
        Results resultadoB1c2 = Benchmark.medir(
            () -> g.sortBurbujita(listBc2), "Burbuja","10.000");
        Results resultadoB1c3 = Benchmark.medir(
            () -> g.sortBurbujita(listBc3), "Burbuja","10.000");

        resultados.add(resultadoB1c1);
        resultados.add(resultadoB1c2);
        resultados.add(resultadoB1c3);
        
        Results resultadoC1c1 = Benchmark.medir(
            () -> g.sortBurbujita(listCc1), "Burbuja","10.000");
        Results resultadoC1c2 = Benchmark.medir(
            () -> g.sortBurbujita(listCc2), "Burbuja","10.000");
        Results resultadoC1c3 = Benchmark.medir(
            () -> g.sortBurbujita(listCc3), "Burbuja","10.000");

        resultados.add(resultadoC1c1);
        resultados.add(resultadoC1c2);
        resultados.add(resultadoC1c3);    

        for(Results re : resultados){
            System.out.println(re);
        }
    }
}
