package ls10.lab.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private Validator() {
        // do nothing
    }

    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile(AppConstant.REGEX_PHONE);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
