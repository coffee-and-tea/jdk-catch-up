package coffee_and_tea.jdk8.jep150_date_time_api;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

public class ClockApi {

    public static void main(String[] args) throws InterruptedException {

        // different clocks
        Clock sysDefaultZoneClock = Clock.systemDefaultZone();
        Clock utcClock = Clock.systemUTC();
        Clock customizedZoneClock = Clock.system(ZoneId.of("Asia/Shanghai"));
        Clock utcOffset30Minutes = Clock.offset(Clock.systemUTC(), Duration.ofMinutes(30));
        Clock fixedClock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        Clock minuteTickingSystemDefaultZoneClock = Clock.tickMinutes(ZoneId.systemDefault());

        System.out.println("Minute ticking system default zone 1: " + ZonedDateTime.now(minuteTickingSystemDefaultZoneClock));
        System.out.println("Fixed clock timestamp 1: " + ZonedDateTime.now(fixedClock));
        System.out.println("System default zone clock: " + ZonedDateTime.now(sysDefaultZoneClock));
        System.out.println("UTC default zone clock: " + ZonedDateTime.now(utcClock));
        System.out.println("UTC offset 30 minutes clock: " + ZonedDateTime.now(utcOffset30Minutes));
        System.out.println("Customized zone clock: " + ZonedDateTime.now(customizedZoneClock));
        System.out.println("Fixed clock timestamp 2: " + ZonedDateTime.now(fixedClock));
        System.out.println("Fixed clock timestamp 1: " + ZonedDateTime.now(fixedClock));
        System.out.println("Minute ticking system default zone 2: " + ZonedDateTime.now(minuteTickingSystemDefaultZoneClock));
        TimeUnit.MINUTES.sleep(1);
        System.out.println("Minute ticking system default zone 3: " + ZonedDateTime.now(minuteTickingSystemDefaultZoneClock));

        System.out.println("Instant from system default zone clock: " + sysDefaultZoneClock.instant());
        System.out.println("Instand from utc clock:" + utcClock.instant());

        System.out.println("Millis from system default zone clock: " + sysDefaultZoneClock.millis());
        System.out.println("Millis from system utc clock: " + utcClock.millis());
    }
}
