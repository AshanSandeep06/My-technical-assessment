import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {
        List<Integer> first100FibonacciNumbers = fibonacciNumbers(100);
        System.out.println(first100FibonacciNumbers);
    }

    public static List<Integer> fibonacciNumbers(int n) {
        List<Integer> fibonacciList = new ArrayList<>(n);

        if (n >= 1) {
            fibonacciList.add(0);  // First Fibonacci number
        }

        if (n >= 2) {
            fibonacciList.add(1);  // Second Fibonacci number
        }

        for (int i = 2; i < n; i++) {
            int nextFibonacci = fibonacciList.get(i - 1) + fibonacciList.get(i - 2);
            fibonacciList.add(nextFibonacci);
        }

        return fibonacciList;
    }
}
