import java.util.Arrays;
import java.util.Comparator;

public class Problem4 {
    public static void main(String[] args) {
        int[] numbers = {50, 2, 1, 9};
        System.out.println(formLargestNumber(numbers));
    }

    public static String formLargestNumber(int[] numbers) {
        String[] numStrings = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);  // Sort in descending order
            }
        });

        // If the largest number is "0", return "0" (for cases like [0, 0])
        if (numStrings[0].equals("0")) {
            return "0";
        }

        // Build the largest number by concatenating the sorted strings
        StringBuilder largestNumber = new StringBuilder();
        for (String numStr : numStrings) {
            largestNumber.append(numStr);
        }

        return largestNumber.toString();
    }
}
