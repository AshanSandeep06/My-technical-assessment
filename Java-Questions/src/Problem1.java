public class Problem1 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println(Problem1.sumOfNumbersUsingForLoop(numbers));    // Output: 150
        System.out.println(Problem1.sumOfNumbersUsingWhileLoop(numbers));  // Output: 150
        System.out.println(Problem1.sumOfNumbersUsingRecursion(numbers));  // Output: 150
    }

    public static int sumOfNumbersUsingForLoop(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public static int sumOfNumbersUsingWhileLoop(int[] numbers) {
        int total = 0;
        int index = 0;
        while (index < numbers.length) {
            total += numbers[index];
            index++;
        }
        return total;
    }

    public static int sumOfNumbersUsingRecursion(int[] numbers) {
        return recursion(numbers, 0);
    }

    private static int recursion(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        }
        return numbers[index] + recursion(numbers, index + 1);
    }

}
