package StaticMembers.Pr03TemperatureConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemperatureConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] temperature = reader.readLine().split("\\s+");

        while (!temperature[0].toLowerCase().equals("end")) {
            Converter.convertTemp(temperature[1], Integer.parseInt(temperature[0]));
            temperature = reader.readLine().split("\\s+");
        }
    }
}

class Converter {
    public static void convertTemp(String tempType, Integer tempValue) {
        if (tempType.toLowerCase().equals("fahrenheit")) {
            Double newTemp = ((double)tempValue - 32) * ((double)5 / 9);
            System.out.printf("%.2f Celsius\n", newTemp);
        } else if (tempType.toLowerCase().equals("celsius")) {
            Double newTemp = 32 + ((double)tempValue * 9 / 5);
            System.out.printf("%.2f Fahrenheit\n", newTemp);
        }
    }
}