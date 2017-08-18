package br.com.matheuscastiglioni.mcalc.validator;

import android.widget.TextView;

import br.com.matheuscastiglioni.mcalc.type.OperatorType;

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

    public static boolean keyIsOperator(Object key) {
        return isOperator(key.toString());
    }

    public static boolean keyIsZero(Object key) {
        return key.toString().equals("0");
    }

    public static boolean resultAnKeyAreValids(TextView result, Object key) {
        if (keyIsOperator(key)) {
            if (resultEndsWithOperator(result))
                return false;
            if (!checkResultHasNumber(result))
                return false;
        }
        if (keyIsDot(key)) {
            if (checkResultAlreadyHasDot(result))
                return false;
        }
        return true;
    }

    public static boolean resultEndsWithOperator(TextView result) {
        return isOperator(result.getText().toString());
    }

    public static boolean resultIsZero(TextView result) {
        return result.getText().toString().equals("0");
    }

    private static boolean isOperator(String s) {
        return s.endsWith(OperatorType.SUM.getSymbol()) || s.endsWith(OperatorType.SUBTRACT.getSymbol())
            || s.endsWith(OperatorType.MULTIPLY.getSymbol()) || s.endsWith(OperatorType.DIVIDE.getSymbol());
    }
}
