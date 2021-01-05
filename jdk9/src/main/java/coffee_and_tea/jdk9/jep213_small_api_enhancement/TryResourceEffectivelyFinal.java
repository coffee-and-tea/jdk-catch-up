package coffee_and_tea.jdk9.jep213_small_api_enhancement;

import java.io.IOException;
import java.io.InputStream;

public class TryResourceEffectivelyFinal {

    public static void main(String[] args) {

        InputStream inputStream = System.in;
        int input = 0;

        // previously this is not allowed
        try(inputStream) {
            input = inputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Your input's first character: " + (char)input);
    }
}
