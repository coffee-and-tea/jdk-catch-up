package coffee_and_tea.jdk8.jep150_date_time_api;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateApi {

    public static void main(String[] args) {
        System.out.println("System LocalDate using now(): " + LocalDate.now());
        System.out.println("LocalDate created using of: " + LocalDate.of(2002, Month.APRIL, 1));
        System.out.println("LocalDate parsed from ISO format: " + LocalDate.parse("2020-12-02", DateTimeFormatter.ISO_DATE));
        LocalDate now = LocalDate.now();
    }
}
