package Methods.Pr10DateModifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class DateModifierMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] start = reader.readLine().split("\\s+");
        String[] end = reader.readLine().split("\\s+");
        DateModifier dateModifier = new DateModifier();
        dateModifier.setStart(Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2]));
        dateModifier.setEnd(Integer.parseInt(end[0]), Integer.parseInt(end[1]), Integer.parseInt(end[2]));
        dateModifier.findDifference();
    }
}

class DateModifier {
    private Calendar start = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();

    public void setStart(int year, int month, int day) {
        this.start.set(year, month, day);
    }

    public void setEnd(int year, int month, int day) {
        this.end.set(year, month, day);
    }

    public void findDifference() {
        Date startDate = start.getTime();
        Date endDate = end.getTime();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = Math.abs(diffTime / (1000 * 60 * 60 * 24));
        System.out.println(diffDays);
    }
}
