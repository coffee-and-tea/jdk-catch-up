package coffee_and_tea.jdk15.jep375_pattern_matching_for_instanceof_second_preview;

public class PatternMatchingInstanceofSecondPreview {

    public static void main(String[] args) {

        Object object = new String("Hello World!");

        if(object instanceof String s && s.length() > 0) {
            System.out.println(s);
        }
    }
}
