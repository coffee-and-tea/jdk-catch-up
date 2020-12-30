package coffee_and_tea.jdk8.jep150_date_time_api;

import java.time.LocalDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;

public class ChronoPackage {

    public static void main(String[] args) {
        Chronology chronology = LocalDateTime.now().getChronology();
        System.out.println("System chronology is ISO: " + (chronology instanceof IsoChronology));

        System.out.println("ISO chronology has following eras: " + chronology.eras());
    }
}
