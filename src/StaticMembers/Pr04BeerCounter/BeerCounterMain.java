package StaticMembers.Pr04BeerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeerCounterMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] beerInfo = reader.readLine().split("\\s+");

        while (!beerInfo[0].toLowerCase().equals("end")) {
            BeerCounter.buyBeer(Integer.parseInt(beerInfo[0]));
            BeerCounter.drinkBeer(Integer.parseInt(beerInfo[1]));
            beerInfo = reader.readLine().split("\\s+");
        }

        BeerCounter.printBeerInfo();
    }
}

class BeerCounter {
    private static Integer beerInStock;
    private static Integer beersDrankCount;

    static {
        beerInStock = 0;
        beersDrankCount = 0;
    }

    public static void buyBeer (int bottlesCount) {
        beerInStock += bottlesCount;
    }

    public static void drinkBeer (int bottlesCount) {
        beerInStock -= bottlesCount;
        beersDrankCount += bottlesCount;
    }

    public static void printBeerInfo() {
        System.out.println(beerInStock + " " + beersDrankCount);
    }
}