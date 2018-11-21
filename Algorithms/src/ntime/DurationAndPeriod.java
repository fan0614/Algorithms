package ntime;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DurationAndPeriod {
    public static void main(String[] args) {
        Duration thrMin = Duration.ofMinutes(3);
        System.out.println(thrMin.get(ChronoUnit.SECONDS));
    }
}
