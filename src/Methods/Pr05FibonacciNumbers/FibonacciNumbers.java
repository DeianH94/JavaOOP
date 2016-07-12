package Methods.Pr05FibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer start = Integer.parseInt(reader.readLine());
        Integer end = Integer.parseInt(reader.readLine());
        Fibonacci fib = new Fibonacci();
        fib.generateFibonacci(end);

        List<Long> list = fib.returnNumsInRange(start, end);

        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ", ");
        }

        System.out.println(list.get(list.size() - 1));
    }
}

class Fibonacci {
    private List<Long> nums;

    public Fibonacci() {
        nums = new ArrayList<>();
    }

    public void generateFibonacci(Integer end) {
        Long first = 0L;
        Long second = 1L;
        this.nums.add(first);
        this.nums.add(second);
        for (long i = 0; i <= end; i++) {
            Long third = first + second;
            first = second;
            second = third;
            this.nums.add(third);
        }
    }

    public List<Long> returnNumsInRange(Integer start, Integer end) {
        List<Long> numsInRange = new ArrayList<>();

        for (int i = start; i < end; i++) {
            numsInRange.add(nums.get(i));
        }

        return numsInRange;
    }
}
