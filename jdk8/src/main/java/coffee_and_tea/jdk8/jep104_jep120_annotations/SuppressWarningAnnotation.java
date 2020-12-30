package coffee_and_tea.jdk8.jep104_jep120_annotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppressWarningAnnotation {

    @SuppressWarnings({"deprecation", "unchecked"})
    public static void main(String[] args) {


        // unchecked suppressed
        List stringList = new ArrayList();
        stringList.add("add String to type not declared list will cause compiler to warn about this");

        System.out.println(stringList.get(0));

        // deprecation suppressed getDate() method
        new Date().getDate();
    }
}
