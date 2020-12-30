package coffee_and_tea.jdk8.jep150_date_time_api;

import java.time.Duration;
import java.time.Instant;

public class InstantApi {

    public static void main(String[] args) {

        System.out.println("Current system time: " + Instant.now());
        System.out.println("10 days before EPOCH:" + Instant.from(Duration.ofDays(10).subtractFrom(Instant.EPOCH)));
        System.out.println("10 days after EPOCH:" + Instant.from(Duration.ofDays(10).addTo(Instant.EPOCH)));

        Instant now = Instant.now();
        Instant now1 = Instant.now();
        System.out.println("2 time instance: " + now1 + " is after: " + now + " : " + now1.isAfter(now));

        Instant instant = Instant.parse("2020-12-01T22:56:59.878Z");
        System.out.println("Parsed instant: " + instant);

    }
}
