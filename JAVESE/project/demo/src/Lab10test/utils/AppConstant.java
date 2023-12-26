package Lab10test.utils;

import java.util.Arrays;
import java.util.List;

public class AppConstant {
    public static final String MYSQL_URL="jdbc:mysql://localhost:3306/customer";
    public static final String MYSQL_USERNAME="root";
    public static final String MYSQL_PASS="12345678";
    public static final String REGEX_PHONE="\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
    public static final List<String> CHAR_FINISH = Arrays.asList("n", "N");
}
