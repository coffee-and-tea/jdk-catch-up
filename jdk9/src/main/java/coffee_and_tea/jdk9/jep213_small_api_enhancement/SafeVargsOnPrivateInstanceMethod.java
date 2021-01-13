package coffee_and_tea.jdk9.jep213_small_api_enhancement;

import java.util.List;

public class SafeVargsOnPrivateInstanceMethod {

    @SafeVarargs
    private void doSomething(List<String>... lists) {
        System.out.println("Previous @SafeVargs can't be used in private instance method");
    }
}
