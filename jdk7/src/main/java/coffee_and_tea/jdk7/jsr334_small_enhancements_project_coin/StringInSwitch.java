package coffee_and_tea.jdk7.jsr334_small_enhancements_project_coin;

public class StringInSwitch {

    public static void main(String[] args) {
        String dream = "big";
        switch (dream){
            case "big":
                System.out.println("dream big");
                break;
            case "high":
                System.out.println("dream high");
                break;
            default:
                System.out.println("dream is dream");
                break;
        }
    }
}
