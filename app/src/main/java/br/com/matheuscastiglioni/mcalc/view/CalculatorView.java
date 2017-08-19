package br.com.matheuscastiglioni.mcalc.view;

import android.widget.TextView;

import br.com.matheuscastiglioni.mcalc.validator.CalculatorValidator;

/**
 * Created by matheus on 16/08/17.
 */

public abstract class CalculatorView {

    public static void updateResult(TextView result, Object key) {
        if (CalculatorValidator.resultAnKeyAreValids(result, key)) {
            if (CalculatorValidator.resultIsZero(result))
                CalculatorView.clear(result);
            if ((CalculatorValidator.keyIsDot(key) && !CalculatorValidator.checkResultHasNumber(result))
                    || (CalculatorValidator.keyIsDot(key) && CalculatorValidator.resultEndsWithOperator(result))
                    || (CalculatorValidator.resultEndsWithDot(result) && CalculatorValidator.keyIsOperator(key)))
                key = "0" + key;
            result.setText(result.getText() + key.toString());
        }
    }

    public static void setResult(TextView result, Object value) {
        result.setText(value.toString());
    }

    public static void clear(TextView result) {
        result.setText("");
    }

    public static void erase(TextView result) {
        if (CalculatorValidator.checkResultHasNumber(result))
            result.setText(result.getText().toString().substring(0, result.getText().toString().length() - 1));
    }

}
