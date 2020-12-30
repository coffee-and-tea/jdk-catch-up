package coffee_and_tea.jdk8.jep107_jep126_lambda_collection_map_filter_reduce;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class LambdaSyntax {

    public static void main(String[] args) throws Exception {

        // same thing below
        Runnable runnable = () -> System.out.println("Hello Lambda");
        runnable = () -> {
            System.out.println("Hello Lambda");
        };

        runnable.run();

        // same thing below
        Callable callable = () -> args.clone();
        callable = () -> { return args.clone(); };

        callable.call();

        // same thing below
        // type of x is inferred from generic
        Predicate<Integer> zero = (x) -> x.equals(0);
        zero = (Integer x) -> x.equals(0);

        System.out.println(zero.test(0));
    }
}
