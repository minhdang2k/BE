package com.example.lab_session3_4.util;

import com.example.lab_session3_4.dto.UserAccountReqDTO;
import org.springframework.stereotype.Component;

@Component
public class AccountUtil {
    private final Validator validator;

    public AccountUtil(Validator validator) {
        this.validator = validator;
    }

    public String validateRegisterData(UserAccountReqDTO data){
        if (validator.isEmptyString(data.getFirstName())) return "Invalid firstname";
        if (!validator.notIncludeDigits(data.getFirstName())) return "Firstname should not include digits";

        if (validator.isEmptyString(data.getLastName())) return "Invalid lastname";
        if (!validator.notIncludeDigits(data.getLastName())) return "Lastname should not include digits";

        if (!validator.isEmail(data.getEmail())){
            return "Invalid email.";
        }

        if (validator.isEmptyString(data.getUsername())) return "Invalid username";

        if (!validator.isPassword(data.getPassword())) return "Password at least 4 chars";
        return null;
    }
}
