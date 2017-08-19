package br.com.matheuscastiglioni.mcalc.model;

import br.com.matheuscastiglioni.mcalc.type.Operator;

/**
 * Created by matheus on 16/08/17.
 */

public class Number implements Operator {

    private final double number;

    public Number(double number) {
        this.number = number;
    }

    @Override
    public double process() {
        return this.number;
    }

    @Override
    public Operator take(Object operator) {
        return next(operator);
    }

    @Override
    public Operator next(Object operator) {
        throw new RuntimeException("Operator has been not found");
    }
}
