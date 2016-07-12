package Methods.Pr04NumberInReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberInReversedOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DecimalNumber number = new DecimalNumber(reader.readLine());
        System.out.println(number.printReversedDigits());
    }
}

class DecimalNumber {
    private String number;

    public DecimalNumber(String  number) {
        this.number = number;
    }

    public String  printReversedDigits() {
        String reversed = (new StringBuilder(number.toString()).reverse().toString());
        return reversed;
    }
}
