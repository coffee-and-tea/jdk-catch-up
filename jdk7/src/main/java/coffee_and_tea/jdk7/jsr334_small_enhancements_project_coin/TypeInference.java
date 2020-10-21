package coffee_and_tea.jdk7.jsr334_small_enhancements_project_coin;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TypeInference {

    public static void main(String[] args) {

        // improve type inference in constructor, previously only possible for method

        // pre project coin type inference example
        // infer type for emptyMap()
        Map<String, Integer> noInferMap = Collections.<String, Integer>emptyMap();
        Map<String, Integer> typeInferMap = Collections.emptyMap();

        // jdk7 new inference on constructor
        Set<AtomicInteger> noInferSet = new HashSet<AtomicInteger>();
        Set<AtomicInteger> inferSet = new HashSet<>();
        // old no generic HashSet without <> compatible with generic
        Set<AtomicInteger> noGeneric = new HashSet();
    }
}
