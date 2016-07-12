package StaticMembers.Pr08ShapesVolume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapesVolume {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] shapeInfo = reader.readLine().split("\\s+");
        while (!shapeInfo[0].toLowerCase().equals("end")) {
            switch (shapeInfo[0]) {
                case "TrianglePrism":
                    Double baseSide = Double.parseDouble(shapeInfo[1]);
                    Double heightFromBaseSide = Double.parseDouble(shapeInfo[2]);
                    Double length = Double.parseDouble(shapeInfo[3]);
                    TriangularPrism prism = new TriangularPrism(baseSide, heightFromBaseSide, length);
                    System.out.printf("%.3f\n", VolumeCalculator.calculateTriangularPrismVolume(prism));
                    break;
                case "Cube":
                    Double sideLength = Double.parseDouble(shapeInfo[1]);
                    Cube cube = new Cube(sideLength);
                    System.out.printf("%.3f\n", VolumeCalculator.calculateCubeVolume(cube));
                    break;
                case "Cylinder":
                    Double radius = Double.parseDouble(shapeInfo[1]);
                    Double height = Double.parseDouble(shapeInfo[2]);
                    Cylinder cylinder = new Cylinder(radius, height);
                    System.out.printf("%.3f\n", VolumeCalculator.calculateCylinderVolume(cylinder));
                    break;
            }

            shapeInfo = reader.readLine().split("\\s+");
        }
    }
}

class TriangularPrism {
    private Double baseSide;
    private Double heightFromBaseSide;
    private Double length;

    public TriangularPrism(Double baseSide, Double heightFromBaseSide, Double length) {
        this.baseSide = baseSide;
        this.heightFromBaseSide = heightFromBaseSide;
        this.length = length;
    }

    public Double getBaseSide() {
        return this.baseSide;
    }

    public Double getHeightFromBaseSide() {
        return this.heightFromBaseSide;
    }

    public Double getLength() {
        return this.length;
    }
}

class Cube {
    private Double sideLength;

    public Cube(Double sideLength) {
        this.sideLength = sideLength;
    }

    public Double getSideLength() {
        return this.sideLength;
    }
}

class Cylinder {
    private Double radius;
    private Double height;

    public Cylinder(Double radius, Double height) {
        this.radius = radius;
        this.height = height;
    }

    public Double getRadius() {
        return this.radius;
    }

    public Double getHeight() {
        return this.height;
    }
}

class VolumeCalculator {
    public static Double calculateCubeVolume (Cube cube) {
        return Math.pow(cube.getSideLength(), 3);
    }

    public static Double calculateCylinderVolume (Cylinder cylinder) {
        return Math.PI * Math.pow(cylinder.getRadius(), 2) * cylinder.getHeight();
    }

    public static Double calculateTriangularPrismVolume (TriangularPrism triangularPrism) {
        return 0.5 * triangularPrism.getBaseSide()
                * triangularPrism.getHeightFromBaseSide()
                * triangularPrism.getLength();
    }
}