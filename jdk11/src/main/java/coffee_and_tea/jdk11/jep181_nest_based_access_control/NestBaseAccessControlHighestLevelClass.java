package coffee_and_tea.jdk11.jep181_nest_based_access_control;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class NestBaseAccessControlHighestLevelClass implements Comparable {

    private NestBaseAccessControlHighestLevelClass() {
    }

    private static void staticMethodInHighLevelClass() {

    }

    private void methodInHighLevelClass() {
        System.out.println("Higest level class private method invoked.");
    }

    public void methodNonInterface() {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    static class NestClassLowLevel1 {

        private void methodInLowLevel1() throws Throwable {

            // nested class can access private nested host class private method
            MethodType methodType = MethodType.methodType(void.class);
            MethodHandle methodHandle = MethodHandles.lookup()
                    .findVirtual(NestBaseAccessControlHighestLevelClass.class, "methodInHighLevelClass", methodType);
            NestBaseAccessControlHighestLevelClass nestBaseAccessControlHighestLevelClass = new NestBaseAccessControlHighestLevelClass();
            methodHandle.invoke(nestBaseAccessControlHighestLevelClass);

            // nested class access host private constructor
            MethodHandle hostPrivateConstructor = MethodHandles.lookup()
                    .findConstructor(NestClassLowLevel2.class,  methodType);

            var res = hostPrivateConstructor.invoke() instanceof NestClassLowLevel2;
            System.out.println("Created host  using private constructor: " + res);

            // nested class access mates private interface method
            MethodHandle privateInterfaceMethod = MethodHandles.lookup()
                    .findVirtual(NestClassLowLevelInterface.class, "interfacePrivateMethod", methodType);
            NestClassLowLevelInterface nestClassLowLevelInterface = () -> {};
            privateInterfaceMethod.invoke(nestClassLowLevelInterface);

            // access nestmate child class
            MethodHandle lowestLevelMethod = MethodHandles.lookup()
                    .findVirtual(NestClassLowLevel2.NestLowestLevel.class, "lowestLevelMethod", methodType);
            lowestLevelMethod.invoke(new NestClassLowLevel2.NestLowestLevel());

            System.out.println("NestClassLowLevel1 vs NestLowestLevel: "+this.getClass().isNestmateOf(NestClassLowLevel2.NestLowestLevel.class));
            System.out.println("NestClassLowLevel1 vs NestClassLowLevelInterface: "+this.getClass().isNestmateOf(NestClassLowLevelInterface.class));
            System.out.println("NestClassLowLevel1 vs NestBaseAccessControlHighestLevelClass: "+this.getClass().isNestmateOf(NestBaseAccessControlHighestLevelClass.class));
        }
    }

    static class NestClassLowLevel2 {

        private NestClassLowLevel2() {
        }

        private void methodInLowLevel2() throws Throwable {
            new NestClassLowLevel1().methodInLowLevel1();
        }

        static class NestLowestLevel {

            private void lowestLevelMethod(){
                System.out.println("Lowest level method invoked.");
            }
        }
    }

    static interface NestClassLowLevelInterface {

        void interfaceMethod();
        private void interfacePrivateMethod() {
            System.out.println("Interface private method invoked.");
        }
    }

    public static void main(String[] args) throws Throwable {
        new NestClassLowLevel1().methodInLowLevel1();
    }
}
