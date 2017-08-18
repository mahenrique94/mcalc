package br.com.matheuscastiglioni.mcalc.operator;

import br.com.matheuscastiglioni.mcalc.type.Operator;

/**
 * Created by matheus on 17/08/17.
 */

public class Multiply implements Operator {

    private final Operator left;
    private final Operator right;

    public Multiply(Operator left, Operator right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int process() {
        return this.left.process() * this.right.process();
    }

    @Override
    public Operator take(Object operator) {
        if (operator.toString().equals("*"))
            return this;
        return next();
    }

    @Override
    public Operator next() {
        return new Divide(this.left, this.right);
    }
}
