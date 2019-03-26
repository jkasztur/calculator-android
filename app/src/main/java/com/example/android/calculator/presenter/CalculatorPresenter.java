package com.example.android.calculator.presenter;

import android.util.Log;

import com.example.android.calculator.model.Calculator;
import com.example.android.calculator.model.MathOperator;
import com.example.android.calculator.view.CalculatorView;

public class CalculatorPresenter implements Presenter {
    private Calculator calc;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorView view) {
        this.view = view;
        calc = new Calculator();
    }

    @Override
    public void onCreate() {
        calc = new Calculator();
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {
    }

    public void onNumberClicked(String num) {
        Log.i(this.getClass().getSimpleName(), "clicked: " + num);
        String viewNumber = calc.appendNumber(num);
        view.setNumberLine(viewNumber);
    }

    public void onOperationClicked(String op) {
        long returned = calc.operation(MathOperator.valueOf(op));
        view.setNumberLine(Long.valueOf(returned).toString());
    }

    public void onResetClicked() {
        calc.reset();
        view.clearNumberLine();
    }

}
