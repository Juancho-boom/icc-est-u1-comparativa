public class Benchmark {
    public static Results medir(Runnable accion, String nombre, String sample){
        
        // tiempo actual
        long nanoTimeInicial = System.nanoTime();
        // accion 
        accion.run();
        //tiempo final
        long nanoTimeFinal = System.nanoTime();

        //retornar tiempo de duracion
        Results results = new Results(nombre, (nanoTimeFinal-nanoTimeInicial), sample);
        
        return results;
   }
}
