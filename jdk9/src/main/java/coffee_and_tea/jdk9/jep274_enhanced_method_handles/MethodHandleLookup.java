package coffee_and_tea.jdk9.jep274_enhanced_method_handles;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MethodHandleLookup {

    public static void main(String[] args) throws Throwable {

        MethodHandles.Lookup lookup = MethodHandles.lookup();

        // look up static method
        lookupStaticMethod(lookup);

        // look up constructor
        lookupConstructor(lookup);

        // look up return void method
        lookupReturnVoidMethod(lookup);

        // look up private method
        lookupPrivateMethod(lookup);

        // look up in interface default method
        lookupInInterfaceForDefaultMethod(lookup);
    }

    private static void lookupInInterfaceForDefaultMethod(MethodHandles.Lookup lookup) throws Throwable {

        // look up negate method in Predicate interface
        MethodType methodType = MethodType.methodType(Predicate.class);
        MethodHandle predicateHandle = lookup.findVirtual(Predicate.class, "negate", methodType);
        Predicate<String> stringPredicate = (s) -> true;
        Predicate<String> negateStringPredicate = (Predicate<String>) predicateHandle.invoke(stringPredicate);

        System.out.println("Negative always: " + negateStringPredicate.test("whatever"));

        MethodHandle negateHandle = predicateHandle.bindTo(stringPredicate);

        Predicate<String> negateHandleAgain = (Predicate<String>) negateHandle.invoke();

        System.out.println("Negative always: " + negateHandleAgain.test("whatever"));

    }

    private static void lookupPrivateMethod(MethodHandles.Lookup lookup) throws NoSuchMethodException, IllegalAccessException {
        MethodType arrayListType = MethodType.methodType(void.class, int.class);
        try {
            MethodHandle fastRemoveHandle = lookup.findVirtual(ArrayList.class, "fastRemove", arrayListType);
        } catch (IllegalAccessException e) {
            System.out.println("Attempt to access private method");
        }
    }

    private static void lookupReturnVoidMethod(MethodHandles.Lookup lookup) throws Throwable {
        MethodType listSet = MethodType.methodType(void.class, int.class, Object.class);
        MethodHandle listSetHandle = lookup.findVirtual(ArrayList.class, "add",  listSet);
        ArrayList<String> stringList = new ArrayList<String>();
        listSetHandle.invoke(stringList, 0, "Hello world!");
        System.out.println(stringList.get(0));
    }

    private static void lookupConstructor(MethodHandles.Lookup lookup) throws Throwable {

        // new String(string) constructor, constructor does not declare a return type
        MethodType stringConstr = MethodType.methodType(void.class, String.class);
        MethodHandle intArrayConstructorMethodHandle = lookup.findConstructor(String.class, stringConstr);
        String helloWorld = (String) intArrayConstructorMethodHandle.invoke("Hello World");
        System.out.println("Find String constructor: " + helloWorld);
    }

    private static void lookupStaticMethod(MethodHandles.Lookup lookup) throws Throwable {

        // Set.of(...)
        MethodType setOfType = MethodType.methodType(Set.class, Object[].class);
        MethodHandle setOfMethodHandle = lookup.findStatic(Set.class, "of", setOfType);
        Set<Integer> intSet = (Set<Integer>) setOfMethodHandle.invoke(1, 2, 3);
        System.out.println("Set has 1: " + intSet.contains(1));

        MethodHandle integerSet = setOfMethodHandle.asCollector(Object[].class, 10);
        Set<Integer> integerSet1 = (Set<Integer>) integerSet.invoke(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Set size: " + integerSet1.size());

    }
}


