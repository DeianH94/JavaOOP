package Encapsulation.Pr02ClassBoxDataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassBoxDataValidation {
    public static void main(String[] args) throws IOException {
        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields)
                .stream()
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Double length = Double.parseDouble(reader.readLine());
        Double width = Double.parseDouble(reader.readLine());
        Double height = Double.parseDouble(reader.readLine());

        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f\n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f\n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f\n", box.calculateVolume());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Box {
    private Double length;
    private Double width;
    private Double height;

    public Box(Double length, Double width, Double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(Double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }

        this.length = length;
    }

    private void setWidth(Double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }

        this.width = width;
    }

    private void setHeight(Double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }

        this.height = height;
    }

    public Double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public Double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public Double calculateVolume() {
        return length * width * height;
    }
}