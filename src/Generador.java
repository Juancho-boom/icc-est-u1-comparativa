
import java.util.ArrayList;
import java.util.List;

public class Generador {

    //genera un listado de tamaño size
    // con numeros aleatorios de 0 - size
    public static List<Integer> generate(int size){
        List<Integer> list = new ArrayList<>();
            for(int i =0 ; i < size; i++){
                list.add((int) (Math.random()*size));
            }
            return list;
    }

    public void sortBurbujita(List<Integer> list) {
        int n = list.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 1; j < n - i; j++) {
                    if (list.get(j - 1) > list.get(j)) {
                int cajita = list.get(j - 1);
                list.set(j - 1, list.get(j));
                list.set(j, cajita);
                }
            }
        }
    }
}
