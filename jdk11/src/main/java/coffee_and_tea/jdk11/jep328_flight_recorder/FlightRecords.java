package coffee_and_tea.jdk11.jep328_flight_recorder;

public class FlightRecords {

    public static void main(String[] args) {

        while (true) {

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wake up from sleep after 10 seconds");
        }
    }
}
