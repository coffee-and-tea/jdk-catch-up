package coffee_and_tea.jdk14.jep361_switch_expression;

public class SwitchExpressionPractice {

    public static void main(String[] args) {

        String stock = "AAPL";
        double price = switch (stock) {
            case "AAPL" -> 142.92;
            case "GOOG" -> 1899.40;
            case "TSLA" -> 880.80;
            case "BABA", "BIDU" -> 250.00;
            default -> {
                // do other operation/calculation before yield
                yield 0.0;
            }
        };
    }
}
