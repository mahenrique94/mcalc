package br.com.matheuscastiglioni.mcalc.type;

/**
 * Created by matheus on 16/08/17.
 */

public interface Operator {

    public double process();
    public Operator take(Object operator);
    public Operator next(Object operator);

}
