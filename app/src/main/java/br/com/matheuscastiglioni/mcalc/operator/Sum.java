package br.com.matheuscastiglioni.mcalc.operator;

import br.com.matheuscastiglioni.mcalc.model.Number;
import br.com.matheuscastiglioni.mcalc.type.Operator;

/**
 * Created by matheus on 16/08/17.
 */

public class Sum implements Operator {

    private final Operator left;
    private final Operator right;

    public Sum(Operator left, Operator right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double process() {
        return this.left.process() + this.right.process();
    }

    @Override
    public Operator take(Object operator) {
        if (operator.toString().equals("+"))
            return this;
        return next(operator);
    }

    @Override
    public Operator next(Object operator) {
        return new Subtract(this.left, this.right).take(operator);
    }
}
