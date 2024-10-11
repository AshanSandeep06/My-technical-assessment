import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final int TARGET = 100;

    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        findExpressions("", 1, results);

        // Output the results
        for (String expression : results) {
            System.out.println(expression + " = " + TARGET);
        }

        System.out.println("Total expressions found: " + results.size());
    }

    private static void findExpressions(String expression, int currentNum, List<String> results) {
        if (currentNum == 10) {
            if (evaluateExpression(expression) == TARGET) {
                results.add(expression);
            }
            return;
        }

        // Recursive calls with different operations
        if (currentNum == 1) {
            findExpressions(expression + currentNum, currentNum + 1, results);
        } else {
            findExpressions(expression + "+" + currentNum, currentNum + 1, results);
            findExpressions(expression + "-" + currentNum, currentNum + 1, results);
            findExpressions(expression + currentNum, currentNum + 1, results); // Concatenate
        }
    }

    private static int evaluateExpression(String expression) {
        String[] tokens = expression.split("(?=[-+])");
        int result = 0;

        for (String token : tokens) {
            result += Integer.parseInt(token);
        }

        return result;
    }
}
