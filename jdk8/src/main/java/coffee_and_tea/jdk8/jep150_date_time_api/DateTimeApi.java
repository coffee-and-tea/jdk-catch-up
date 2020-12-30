package coffee_and_tea.jdk8.jep150_date_time_api;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeApi {

    public static void main(String[] args) {

        playWithLocalDateTime();
        playWithZonedDateTime();
        playWithOffsetDateTime();
    }

    private static void playWithOffsetDateTime() {
        // OffsetDateTime is LocalDatetime with time offset to UTC without zone information
        OffsetDateTime now = OffsetDateTime.now();
        System.out.println("System default OffsetDateTime: " + now);
    }

    private static void playWithZonedDateTime() {
        // ZonedDateTime is an OffsetDateTime with zone information
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("System default ZonedDateTime: " + now);
    }

    private static void playWithLocalDateTime() {
        // LocalDateTime is date time without information on zone
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime with now(): " + now);

        // converting to OffsetDateTime and ZonedDateTime
        OffsetDateTime nowWithOffset = now.atOffset(ZoneOffset.of("+1"));
        System.out.println("OffsetDateTime converted from LocalDateTime: " + nowWithOffset);

        ZonedDateTime nowWithZone = now.atZone(ZoneId.of(ZoneId.SHORT_IDS.get("CTT")));
        System.out.println("ZonedDateTime converted from ZonedDateTime: " + nowWithZone);
    }
}
