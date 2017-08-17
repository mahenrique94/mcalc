package br.com.matheuscastiglioni.mcalc.validator;

import android.widget.TextView;

/**
 * Created by matheus on 16/08/17.
 */

public abstract class CalculatorValidator {

    public static boolean checkResultAlreadyHasDot(TextView result) {
        return result.getText().toString().indexOf(".") > 0;
    }

    public static boolean checkResultHasNumber(TextView result) {
        return !result.getText().toString().equals("");
    }

    public static boolean keyIsDot(Object key) {
        return key.toString().equals(".");
    }

    public static boolean keyIsZero(Object key) {
        return key.toString().equals("0");
    }

    public static boolean resultAnKeyAreValids(TextView result, Object key) {
        if (CalculatorValidator.keyIsDot(key) || CalculatorValidator.keyIsZero(key)) {
            if (!CalculatorValidator.checkResultHasNumber(result))
                return false;
        }
        if (CalculatorValidator.keyIsDot(key)) {
            if (CalculatorValidator.checkResultAlreadyHasDot(result))
                return false;
        }
        return true;
    }

}
