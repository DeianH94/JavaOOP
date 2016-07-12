package StaticMembers.Pr07BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicMath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] command = reader.readLine().split("\\s+");

        while (!command[0].toLowerCase().equals("end")) {
            Double first = Double.parseDouble(command[1]);
            Double second = Double.parseDouble(command[2]);
            switch (command[0]) {
                case "Sum":
                    System.out.printf("%.2f\n", MathUtil.sum(first, second));
                    break;
                case "Multiply":
                    System.out.printf("%.2f\n", MathUtil.multiply(first, second));
                    break;
                case "Percentage":
                    System.out.printf("%.2f\n", MathUtil.percentage(first, second));
                    break;
                case "Divide":
                    System.out.printf("%.2f\n", MathUtil.divide(first, second));
                    break;
                case "Subtract":
                    System.out.printf("%.2f\n", MathUtil.subtract(first, second));
                    break;
            }

            command = reader.readLine().split("\\s+");
        }
    }
}

class MathUtil {
    public static Double sum (Double firstNum, Double secondSum) {
        return firstNum + secondSum;
    }

    public static Double subtract  (Double firstNum, Double secondSum) {
        return firstNum - secondSum;
    }

    public static Double multiply (Double firstNum, Double secondSum) {
        return firstNum * secondSum;
    }

    public static Double divide (Double dividend, Double divisor) {
        return dividend / divisor;
    }

    public static Double percentage  (Double num, Double percentOfNum) {
        return num * (percentOfNum / 100);
    }
}