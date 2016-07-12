package Methods.Pr03LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastDigitName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Number number = new Number(Integer.parseInt(reader.readLine()));
        System.out.println(number.lastDigit());
    }
}

class Number {
    private Integer number;

    Number(Integer number) {
        this.number = number;
    }

    public String lastDigit() {
        int last = number % 10;
        switch (last) {
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            case 0: return "zero";
            default: return "error";
        }
    }
}