package DangTieuMinh_JavaSE_Final_Test.Ex2.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public Validator() {
        //do nothing
    }
    public static boolean isPhone(String phone){
        Pattern pattern= Pattern.compile(AppConstant.REGEX_PHONE);
        Matcher matcher=pattern.matcher(phone);
        return matcher.matches();
    }
}
