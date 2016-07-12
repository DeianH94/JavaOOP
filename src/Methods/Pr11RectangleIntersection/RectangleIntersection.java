package Methods.Pr11RectangleIntersection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RectangleIntersection {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Rectangle> rectangles = new HashMap<>();
        String[] numOfEntries = reader.readLine().split("\\s+");
        Integer numOfRectangles = Integer.parseInt(numOfEntries[0]);
        Integer nuOfChecks = Integer.parseInt(numOfEntries[1]);

        for (int i = 0; i < numOfRectangles; i++) {
            String[] rectangleInfo = reader.readLine().split("\\s+");
            String id = rectangleInfo[0];
            Double width = Double.parseDouble(rectangleInfo[1]);;
            Double height = Double.parseDouble(rectangleInfo[2]);
            Double x = Double.parseDouble(rectangleInfo[3]);
            Double y = Double.parseDouble(rectangleInfo[4]);
            if (!rectangles.containsKey(id)) {
                rectangles.put(id, new Rectangle(id, width, height, x, y));
            }
        }

        for (int i = 0; i < nuOfChecks; i++) {
            String[] ids = reader.readLine().split("\\s+");
            Rectangle firstRectangle = rectangles.get(ids[0]);
            Rectangle secondRectangle = rectangles.get(ids[1]);
            System.out.println(firstRectangle.checkIfIntersects(secondRectangle));
        }
    }
}

class Rectangle {
    private String id;
    private Double width;
    private Double height;
    private Double x;
    private Double y;

    public Rectangle(String id, Double width, Double height, Double x, Double y) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public Double getWidth() {
        return this.width;
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getX() {
        return this.x;
    }

    public Double getY() {
        return this.y;
    }

    public boolean checkIfIntersects(Rectangle r) {
        if (this.x + this.width < r.getX() || r.getX() + r.getWidth() < this.x ||
                this.y + this.height < r.getY() || r.getY() + r.getHeight() < this.y) {
            return false;
        } else {
            return true;
        }
    }
}