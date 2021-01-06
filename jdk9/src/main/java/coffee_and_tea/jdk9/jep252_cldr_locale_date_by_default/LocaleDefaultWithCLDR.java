package coffee_and_tea.jdk9.jep252_cldr_locale_date_by_default;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleDefaultWithCLDR {

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.GERMAN);
        System.out.println(numberFormat.format(123456));
    }
}
