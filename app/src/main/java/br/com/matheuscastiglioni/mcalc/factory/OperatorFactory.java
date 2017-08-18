package br.com.matheuscastiglioni.mcalc.factory;

import br.com.matheuscastiglioni.mcalc.model.Number;
import br.com.matheuscastiglioni.mcalc.operator.Sum;
import br.com.matheuscastiglioni.mcalc.type.Operator;

/**
 * Created by matheus on 16/08/17.
 */

public abstract class OperatorFactory {

    public static Operator findOperatorTo(Operator left, Operator right, Object operator) {
        return new Number(0);
    }

}
