import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AdditionalTask19_2 {
    public static void main(String[] args) {
        List<Integer> result = Task.sort(Arrays.asList(3,1,1,0,2,3,12,1,-1,-123,5,6,4));
        System.out.println(result);

    }


}

class Task {

    public static List<Integer> sort(List<Integer> list) {

        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(list);

        while (!temp.isEmpty()) {
            int smallestNumber = temp.getFirst();
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(i) < smallestNumber) {
                    smallestNumber = temp.get(i);
                }
            }
            result.add(smallestNumber);
            temp.remove(Integer.valueOf(smallestNumber));
        }

        return result;
    }

}
