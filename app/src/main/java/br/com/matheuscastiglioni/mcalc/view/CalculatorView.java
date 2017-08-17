package br.com.matheuscastiglioni.mcalc.view;

import android.widget.TextView;

import br.com.matheuscastiglioni.mcalc.validator.CalculatorValidator;

/**
 * Created by matheus on 16/08/17.
 */

public abstract class CalculatorView {

    public static void updateResult(TextView result, Object key) {
        if (CalculatorValidator.resultAnKeyAreValids(result, key))
            result.setText(result.getText() + key.toString());
    }

    public static void clear(TextView result) {
        result.setText("");
    }

    public static void erase(TextView result) {
        result.setText(result.getText().toString().substring(0, result.getText().toString().length() - 1));
    }

}
