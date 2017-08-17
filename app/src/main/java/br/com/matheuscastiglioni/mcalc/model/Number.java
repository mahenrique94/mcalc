package br.com.matheuscastiglioni.mcalc.model;

import br.com.matheuscastiglioni.mcalc.type.Operator;

/**
 * Created by matheus on 16/08/17.
 */

public class Number implements Operator {

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int process() {
        return this.number;
    }

    @Override
    public Operator take(Object operator) {
        return next();
    }

    @Override
    public Operator next() {
        throw new RuntimeException("Operator has been not found");
    }
}
