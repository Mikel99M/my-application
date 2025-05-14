import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

public class AdditionalTask22_4 {
    public static void main(String[] args) {
        Task22_4 task = new Task22_4();
        String num = "2040";
        Integer result = task.excecuteTask(num);

        if(result != null){
            System.out.println(result + " is an " + result.getClass().getSimpleName());
        }
    }
}

@Slf4j
class Task22_4 {

    public Integer excecuteTask(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            char[] elements = text.toCharArray();
            List<Character> invalidElements = new ArrayList<>();
            for(char element : elements) {
                if(!Character.isDigit(element)) {
                    invalidElements.add(element);
                }
            }
            StringBuilder sb = new StringBuilder();
            String prefix = "";
            for(char element : invalidElements) {
                sb.append(prefix);
                prefix = ", ";
                sb.append(element);
            }
            sb.append(".");

            String wordInPluralOrSingular = "elements are";
            if(invalidElements.size() == 1) {
                wordInPluralOrSingular = "element is";
            }

            log.warn("Invalid format. Following " + wordInPluralOrSingular + " illegal: " + sb);
        }
        return null;
    }

}
