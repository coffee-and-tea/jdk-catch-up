package coffee_and_tea.jdk7.jsr334_small_enhancements_project_coin;

import java.io.File;
import java.io.IOException;

public class MultiCatchAndPreciseRethrowException {

    public static void main(String[] args) throws IOException {

        playWithMultiCatch();

        playWithPreciseRethrow();
    }

    private static void playWithPreciseRethrow() throws IOException {
        try{
            File file = new File("somefile");
            file.getCanonicalPath();
        }
        catch (Exception e){
            System.out.println("Caught: " + e);
            // catch IOException from file.getCanonicalPath(),
            // rethrow only need add IOException in method signature, not Exception
            throw e;
        }
    }

    private static void playWithMultiCatch() {

        try{
            int a = 1 / 0;
        }
        catch(IllegalArgumentException | ArithmeticException e){
            System.out.println("Multi-catch caught: " + e);
        }
    }
}
