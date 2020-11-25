package coffee_and_tea.jdk8.jep105_jep106_jep172_javadoc;

/**
 * Class to practice writing javadoc
 * <p>
 * To practice good java doc on methods with:
 * `@param
 * `@see
 * `@return
 * `@author
 * `@version
 * `@exception `@throws
 * `@since
 * `@deprecated
 * and other syntax with period also method override
 */
public class JavaDocPractice extends JavaDocPracticeBase {

    /**
     * Method to practice Javadoc writing
     * <p>
     * method doc will illustrate different doc include .&nbsp;with space behind
     * <p>
     * @author Wei Xue
     * @version 1.0
     * @since 1.0
     * @param param parameter description
     * @throws NullPointerException this would never happen
     * @exception NumberFormatException same as @throws this would never happen
     * @return a String type will be returned
     * @see String documentation for return type
     */
    public String methodForJavaDocPractice(String param) throws NullPointerException, NumberFormatException {
        return "Javadoc practice";
    }

    @Override
    public String methodToAnnotatedWithOverride() {
        return "Method overrides super class, expect to receive javadoc from super class";
    }

    /**
     * Method deprecated
     * <p>
     * @deprecated use #methodToAnnotatedWithOverride() instead
     * @see #methodToAnnotatedWithOverride()
     */
    @Deprecated
    public void deprecatedMethod() {

    }
}


class JavaDocPracticeBase {

    /**
     * Javadoc in JavaDocPracticeBase class
     * <p>
     * expect java doc to be inherited by override method
     */
    public String methodToAnnotatedWithOverride(){
        return "Method javadoc will be applied to method override this";
    }
}
