package coffee_and_tea.jdk8.jep104_jep120_annotations;

public class OverrideAnnotated {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Override a function, only can be used on method, " +
                        "and annotation only retented in source code");
            }
        };

        runnable.run();
    }
}
