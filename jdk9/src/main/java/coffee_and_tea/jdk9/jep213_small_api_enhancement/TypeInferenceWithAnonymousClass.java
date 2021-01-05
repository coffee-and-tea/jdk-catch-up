package coffee_and_tea.jdk9.jep213_small_api_enhancement;

import java.util.Iterator;

public class TypeInferenceWithAnonymousClass {

    public static void main(String[] args) {

        // previously you have to do new Iterator<String>() {...}
        Iterator<String> stringIterator = new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }
        };
    }
}
