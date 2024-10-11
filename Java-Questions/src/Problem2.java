import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(List.of(new String[]{"a", "b", "c"}));
        List<String> list2 = new ArrayList<>(List.of(new String[]{"1", "2", "3"}));

        List<String> result = combineAlternating(list1, list2);
        System.out.println(result);
    }

    public static List<String> combineAlternating(List<String> list1, List<String> list2) {
        List<String> combined = new ArrayList<>();
        int size = Math.min(list1.size(), list2.size());

        for (int i = 0; i < size; i++) {
            combined.add(list1.get(i));
            combined.add(list2.get(i));
        }

        // Add remaining elements if list1 is longer
        if (list1.size() > size) {
            combined.addAll(list1.subList(size, list1.size()));
        }

        // Add remaining elements if list2 is longer
        if (list2.size() > size) {
            combined.addAll(list2.subList(size, list2.size()));
        }

        return combined;
    }
}
