package br.com.matheuscastiglioni.mcalc.operator;

import br.com.matheuscastiglioni.mcalc.model.Number;
import br.com.matheuscastiglioni.mcalc.type.Operator;

/**
 * Created by matheus on 17/08/17.
 */

public class Divide implements Operator {

    private final Operator left;
    private final Operator right;

    public Divide(Operator left, Operator right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double process() {
        return this.left.process() / this.right.process();
    }

    @Override
    public Operator take(Object operator) {
        if (operator.toString().equals("/"))
            return this;
        return next(operator);
    }

    @Override
    public Operator next(Object operator) {
        return new Number(0);
    }
}
