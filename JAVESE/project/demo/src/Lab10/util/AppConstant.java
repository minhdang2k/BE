package ls10.lab.util;

import java.util.Arrays;
import java.util.List;

public class AppConstant {
    private AppConstant() {
        // do nothing
    }

    public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/r2s_sale_management";
    public static final String MYSQL_USERNAME = "root";
    public static final String MYSQL_PASS = "Tt123456789@";

    public static final String REGEX_PHONE = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
    public static final List<String> CHAR_FINISH = Arrays.asList("n", "N");
}
