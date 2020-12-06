package coffee_and_tea.jdk8.jep150_date_time_api;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DurationPeriodApi {

    public static void main(String[] args) {

        playWithPeriod();

        playWithDuration();
    }

    private static void playWithPeriod() {
        Period tenDays = Period.between(LocalDate.now(), LocalDate.now().minusDays(10));
        System.out.println("Period of nagative 10 days: " + tenDays);

        Period sevenDays = Period.from(Period.ofWeeks(1));
        System.out.println("Period of 7 days: " + sevenDays);

        Period monthAnd3Days = Period.of(0, -1, 3);
        System.out.println("Period of negative 1 month and 3 days: " + monthAnd3Days);

        Period period = Period.parse("P10Y-13M60D");
        System.out.println("Period of weird numbers: " + period);

        System.out.println("Units for period: " + monthAnd3Days.getUnits().toString());

        System.out.println("Period has :" + period.get(ChronoUnit.DAYS) + " days.");

        System.out.println("Period is negative: " + period.isNegative());

        System.out.println("Period multi by 2: " + period.multipliedBy(2));

        System.out.println("Normalized Period: " + period.normalized());

        System.out.println("Period replace days only: " + period.withDays(10));
    }

    private static void playWithDuration() {
        Duration oneHour = Duration.ofHours(1);
        System.out.println("Duration of an hour: " + oneHour);

        Duration negative10Hours = Duration.between(LocalDateTime.now(), LocalDateTime.now().minusHours(10));
        System.out.println("Duration of - 10 hours: " + negative10Hours);

        System.out.println("Duration of 10 millis: " + Duration.ofMillis(10));
        System.out.println("Duration of 10 nanos: " + Duration.ofNanos(10));

        System.out.println("Duration plus 10 days: " + oneHour.plusDays(10));

        System.out.println("Duration normalize by default: " + Duration.parse("P-10DT240H10M"));
    }
}
