import java.util.Arrays;
import java.util.List;

public class AdditionalTask20_2 {
    public static void main(String[] args) {
        List<Integer> list = Task20_2.sort(Arrays.asList(2,1,10,2,4,6,4,1,1323,2,41,64,2,4,1,13,6,98,1,8,5,4,2,4,1));
        System.out.println("THE RESULT: " + list);
    }
}

class Task20_2 {

    public static List<Integer> sort(List<Integer> list) {
        int temp = -1;

        while (temp == -1) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
            if (temp != -1) {
                temp = -1;
            } else {
                return list;
            }
        }
        return list;
    }
}
