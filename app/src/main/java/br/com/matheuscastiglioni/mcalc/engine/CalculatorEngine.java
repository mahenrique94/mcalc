package br.com.matheuscastiglioni.mcalc.engine;

import android.util.Log;
import android.widget.TextView;

import br.com.matheuscastiglioni.mcalc.type.Operator;

/**
 * Created by matheus on 16/08/17.
 */

public abstract class CalculatorEngine {

    public static void process(Object formula) {
        for(int i = 0; i < formula.toString().length(); i++) {
            Log.d("[Engine] => ", "Process: " + formula.toString().charAt(i));
        }
    }

}
