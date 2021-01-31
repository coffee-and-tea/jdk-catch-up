package coffee_and_tea.jdk15.jep378_text_blocks;

public class TextBloc {

    public static void main(String[] args) {

        var textNoIndent = """
                line one
                line two
                line three
                """;

        var textIndent = """
                    line one
                    line two
                    line three
                """;

        var textLongIndent = """
                    line one
                    line two
                    line three
""";

        var textNolinebreakLastLine = """
                line one
                line two
                line three""";

        var textWithEscapeAndDoubleQuote = """
                line one    \s
                line two
                "line two"
                """;

        System.out.println("Start print no indent");
        System.out.println(textNoIndent);
        System.out.println("Finish print");

        System.out.println("Start print with indent");
        System.out.println(textIndent);
        System.out.println("Finish print");

        System.out.println("Start print long indent");
        System.out.println(textLongIndent);
        System.out.println("Finish print");

        System.out.println("Start print no line break");
        System.out.println(textNolinebreakLastLine);
        System.out.println("Finish print");

        System.out.println("Start print escape and quote");
        System.out.println(textWithEscapeAndDoubleQuote);
        System.out.println("Finish print");
    }
}
