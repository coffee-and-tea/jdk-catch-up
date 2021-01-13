package coffee_and_tea.jdk9.jep228_more_diagnostic_commands;

public class LoopForJCMD {

    public static void main(String[] args) {
        // keep application running to play with diagnostic command
        int count = 1;
        while(true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sleep count: " + count++);
        }
    }
}
