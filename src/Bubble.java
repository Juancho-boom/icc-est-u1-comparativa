import java.util.List;

public class Bubble {
    public void sortBurbujita(List<Integer> list){
        for(int i =0; i< list.size(); i++){
            for(int j =1; j< list.size();j++){
                if (list.get(j-1) > list.get(j)) {
                    int cajita = list.get(j-1);
                    list.set(j-1,list.get(j));
                    list.set(j, cajita);
                }
            }
        }
    }
}
