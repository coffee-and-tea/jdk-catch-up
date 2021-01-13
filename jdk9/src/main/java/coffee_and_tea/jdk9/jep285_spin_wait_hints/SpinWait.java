package coffee_and_tea.jdk9.jep285_spin_wait_hints;

import java.time.Duration;
import java.time.Instant;

public class SpinWait {

    public static void main(String[] args) {


        for (int i = 0; i < 10000; i++) {
            Thread.onSpinWait();
        }

    }
}
