import java.util.List;

public class Bubble {

    public void sortBubble(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }
}
