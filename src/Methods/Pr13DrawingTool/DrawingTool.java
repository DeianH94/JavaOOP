package Methods.Pr13DrawingTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrawingTool {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String figureType = reader.readLine();
        Figure figure = null;
        if (figureType.equals("Square")) {
            Integer size = Integer.parseInt(reader.readLine());
            figure = new Square(size);
        } else if (figureType.equals("Rectangle")) {
            Integer width = Integer.parseInt(reader.readLine());
            Integer height = Integer.parseInt(reader.readLine());
            figure = new Rectangle(width, height);
        }

        figure.draw();
    }
}

class Square implements Figure {
    private Integer size;

    public Square(Integer size) {
        this.size = size;
    }

    @Override
    public void draw() {
        System.out.printf("|%s|\n", new String(new char[this.size]).replace('\0', '-'));
        for (int i = 0; i < this.size - 2; i++) {
            System.out.printf("|%s|\n", new String(new char[this.size]).replace('\0', ' '));
        }

        System.out.printf("|%s|\n", new String(new char[this.size]).replace('\0', '-'));
    }
}

class Rectangle implements Figure {
    private Integer width;
    private Integer height;

    public Rectangle(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.printf("|%s|\n", new String(new char[this.width]).replace('\0', '-'));
        for (int i = 0; i < this.height - 2; i++) {
            System.out.printf("|%s|\n", new String(new char[this.width]).replace('\0', ' '));
        }

        System.out.printf("|%s|\n", new String(new char[this.width]).replace('\0', '-'));
    }
}

interface Figure {
    void draw();
}