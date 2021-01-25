package coffee_and_tea.jdk13.jep350_dynamic_cds;

public class DynamicCDS {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Hello, CDS at exit");
    }
}
