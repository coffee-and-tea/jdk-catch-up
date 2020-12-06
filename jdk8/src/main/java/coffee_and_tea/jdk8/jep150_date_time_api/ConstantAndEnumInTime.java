package coffee_and_tea.jdk8.jep150_date_time_api;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class ConstantAndEnumInTime {

    public static void main(String[] args) {
        Month jan = Month.JANUARY;
        System.out.println("Jan with enum class: " + jan);

        System.out.println("Current year is leap year? " + Year.now().isLeap());

        YearMonth janThisyear = Year.now().atMonth(jan);
        System.out.println("Current year Jan: " + janThisyear);

        DayOfWeek dayOfWeek = DayOfWeek.from(LocalDateTime.now());
        System.out.println("Today is: " + dayOfWeek);

        MonthDay monthDay = MonthDay.from(LocalDateTime.now());
        System.out.println("Today's month and day: " + monthDay);

        System.out.println("Month day parsed from --12-02 is: " + MonthDay.parse("--12-02"));

        System.out.println("All the ZoneId with short id: "+ZoneId.SHORT_IDS);

    }
}
