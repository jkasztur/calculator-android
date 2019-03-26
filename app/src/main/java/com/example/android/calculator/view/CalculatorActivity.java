package com.example.android.calculator.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.calculator.R;
import com.example.android.calculator.presenter.CalculatorPresenter;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {
    private TextView numberLineView;

    private CalculatorPresenter presenter = new CalculatorPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        numberLineView = findViewById(R.id.calc_text_view);
    }

    @Override
    public void setNumberLine(String number) {
        numberLineView.setText(number);
    }

    @Override
    public void clearNumberLine() {
        setNumberLine("0");
    }

    public void onNumberClicked(View view) {
        Button button = (Button) view;
        presenter.onNumberClicked(button.getText().toString());
    }

    public void onOperationClicked(View view) {
        Button button = (Button) view;
        presenter.onOperationClicked(button.getTag().toString());
    }

    public void onResetClicked(View view) {
        presenter.onResetClicked();
    }
}
