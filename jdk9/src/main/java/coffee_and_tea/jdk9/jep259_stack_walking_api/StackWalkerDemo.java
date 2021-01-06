package coffee_and_tea.jdk9.jep259_stack_walking_api;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class StackWalkerDemo {

    public static void main(String[] args) {
        new Fib().fib(10);
    }
}

class Fib {

    public int fib(int i) {
        if (i == 1 ) {
            System.out.println("Print stack trace calls for fib(1) with forEach");
            StackWalker
                    .getInstance(StackWalker.Option.SHOW_HIDDEN_FRAMES)
                    .forEach(
                            s ->
                                    System.out.println(s.toStackTraceElement())
                    );
            return 1;
        } if(i ==2 ) {
            System.out.println("Print stack trace calls for fib(2) by filtering out Fib class");
            List<StackWalker.StackFrame> stackFrames = StackWalker
                    .getInstance(StackWalker.Option.SHOW_REFLECT_FRAMES)
                    .walk(
                            s ->
                                   s.filter(
                                           stackFrame ->
                                               stackFrame.getClassName() != Fib.class.getName()

                                   ).collect(Collectors.toList())
                    );

            stackFrames.stream().forEach(System.out::println);
            return 1;
        } else {
            System.out.println("Print calller class: " + StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass());
            return fib(i - 1) + fib(i - 2);
        }
    }
}
