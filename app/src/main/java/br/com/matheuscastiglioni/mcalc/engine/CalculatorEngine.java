package br.com.matheuscastiglioni.mcalc.engine;

import android.util.Log;
import android.widget.TextView;

import br.com.matheuscastiglioni.mcalc.factory.OperatorFactory;
import br.com.matheuscastiglioni.mcalc.model.Number;
import br.com.matheuscastiglioni.mcalc.type.Operator;
import br.com.matheuscastiglioni.mcalc.validator.CalculatorValidator;

/**
 * Created by matheus on 16/08/17.
 */

public abstract class CalculatorEngine {

    public static String process(Object expression) {
        double result = 0;
        StringBuilder number = new StringBuilder();
        String operator = "+";
        String key = "";
        for(int i = 0; i < expression.toString().length(); i++) {
            key = String.valueOf(expression.toString().charAt(i));
            if (!CalculatorValidator.keyIsOperator(key)) {
                number.append(key);
            } else {
                result = OperatorFactory.findOperatorTo(new Number(result), new Number(Double.parseDouble(number.toString())), operator).process();
                operator = key;
                number.delete(0, number.length());
            }
        }
        result = OperatorFactory.findOperatorTo(new Number(result), new Number(Double.parseDouble(number.toString())), operator).process();
        if (Math.floor(result) == result)
            return Integer.toString((int) result);
        return Double.toString(result);
    }

}
