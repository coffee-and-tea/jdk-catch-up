package coffee_and_tea.jdk8.jep150_date_time_api;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.util.Arrays;

public class TemporalPackage {

    public static void main(String[] args) {

        System.out.println("ChronoFields: " + Arrays.toString(ChronoField.values()));

        System.out.println("ChronoUnits: " + Arrays.toString(ChronoUnit.values()));

        System.out.println("ChronoFields and valid range: ");
        Arrays.stream(ChronoField.values()).forEach(
                field -> {
                    System.out.println("Field: " + field + " with valid range: " + field.range());
                }
        );

        System.out.println("TemporalAccessor get() method, get value for field DAY_OF_WEEK: " + LocalDateTime.now().get(ChronoField.DAY_OF_WEEK));

        System.out.println("TemporalAdjuster method adjustInto(): " + DayOfWeek.THURSDAY.adjustInto(LocalDate.now()));
        System.out.println("Same as above using with() from Temporal: " + LocalDate.now().with(DayOfWeek.THURSDAY));

        System.out.println("Query local date from local date time: " + LocalDateTime.now().query(TemporalQueries.localDate()));
    }
}
