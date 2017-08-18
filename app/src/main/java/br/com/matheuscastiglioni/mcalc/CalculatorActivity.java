package br.com.matheuscastiglioni.mcalc;

import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Queue;

import br.com.matheuscastiglioni.mcalc.engine.CalculatorEngine;
import br.com.matheuscastiglioni.mcalc.factory.OperatorFactory;
import br.com.matheuscastiglioni.mcalc.model.Number;
import br.com.matheuscastiglioni.mcalc.operator.Subtract;
import br.com.matheuscastiglioni.mcalc.operator.Sum;
import br.com.matheuscastiglioni.mcalc.type.Operator;
import br.com.matheuscastiglioni.mcalc.validator.CalculatorValidator;
import br.com.matheuscastiglioni.mcalc.view.CalculatorView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorActivity extends AppCompatActivity {

    @BindView(R.id.tvCalculator_result)
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCalculator_ac)
    public void clear() {
        CalculatorView.clear(this.textViewResult);
    }

    @OnClick(R.id.btnCalculator_backspace)
    public void erase() {
        CalculatorView.erase(this.textViewResult);
    }

    @OnClick({
        R.id.btnCalculator_one,
        R.id.btnCalculator_two,
        R.id.btnCalculator_three,
        R.id.btnCalculator_four,
        R.id.btnCalculator_five,
        R.id.btnCalculator_six,
        R.id.btnCalculator_seven,
        R.id.btnCalculator_eight,
        R.id.btnCalculator_nine,
        R.id.btnCalculator_zero,
        R.id.btnCalculator_dot,
        R.id.btnCalculator_divive,
        R.id.btnCalculator_multiply,
        R.id.btnCalculator_subtract,
        R.id.btnCalculator_sum
    })
    public void key(Button btn) {
        CalculatorView.updateResult(this.textViewResult, btn.getText());
    }

    @OnClick(R.id.btnCalculator_equals)
    public void operate(Button btn) {
        CalculatorEngine.process(this.textViewResult.getText());
    }

}
