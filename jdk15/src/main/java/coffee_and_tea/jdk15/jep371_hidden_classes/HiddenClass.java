package coffee_and_tea.jdk15.jep371_hidden_classes;

import org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.invoke.MethodHandles.Lookup.ClassOption.NESTMATE;

public class HiddenClass {

    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        var inputStream =
                HiddenClass.class.getClassLoader().getResourceAsStream("DebitAccounts.class.file");
        var classFileBytes = inputStream.readAllBytes();

        ClassReader classReader = new ClassReader(classFileBytes);

        System.out.println(classReader.getClassName());

        Class<?> c = lookup.defineHiddenClass(classFileBytes, true, NESTMATE).lookupClass();

        Constructor<?> constructor = c.getConstructor(null);

        Object object = constructor.newInstance(null);

        Accounts accountDeposit = (Accounts) object;

        accountDeposit.deposit(100);
    }
}
