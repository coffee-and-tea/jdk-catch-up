package coffee_and_tea.jdk8.jep150_date_time_api;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.temporal.ChronoField;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalField;

public class TimeApi {

    public static void main(String[] args) {

        playWithLocalTime();
        playWithOffsetTime();

    }


    private static void playWithOffsetTime() {
        OffsetTime now = OffsetTime.now();
        System.out.println("Offset created with now(): " + now);

        // hour field
        System.out.println(now.range(ChronoField.CLOCK_HOUR_OF_DAY));
    }

    private static void playWithLocalTime() {
        LocalTime now = LocalTime.now();
        System.out.println("LocalTime created with now(): " + now);


    }
}
