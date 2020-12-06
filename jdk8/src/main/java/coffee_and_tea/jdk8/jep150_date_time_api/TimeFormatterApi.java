package coffee_and_tea.jdk8.jep150_date_time_api;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatterApi {

    public static void main(String[] args) {
        System.out.println("ZonedDateTime with ISO Date Time format: " + ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        System.out.println("ZonedDateTime with customized format: " +
                ZonedDateTime.now().format(DateTimeFormatter.ofPattern("G':'yyyy-LLL-dd'T'KKa:mm:ssZ")));

        ZonedDateTime parsed = ZonedDateTime.parse("AD:2020-12-03T05PM:41:03-0600", DateTimeFormatter.ofPattern("G':'yyyy-LLL-dd'T'KKa:mm:ssZ"));
        System.out.println("Parsed ZonedDateTime: " + parsed);
    }
}
