package com.example.koros.calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            recentOperator = R.id.button_equal;
            result = 0;
            isOperatorKeyPushed = false;

            textView.setText("");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_Calculation);

        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(buttonListener);
        button0.setOnClickListener(buttonNumberListener);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(buttonListener);
        button1.setOnClickListener(buttonNumberListener);


        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(buttonListener);
        button2.setOnClickListener(buttonNumberListener);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(buttonListener);
        button3.setOnClickListener(buttonNumberListener);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(buttonListener);
        button4.setOnClickListener(buttonNumberListener);

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(buttonListener);
        button5.setOnClickListener(buttonNumberListener);

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(buttonListener);
        button6.setOnClickListener(buttonNumberListener);

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(buttonListener);
        button7.setOnClickListener(buttonNumberListener);

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(buttonListener);
        button8.setOnClickListener(buttonNumberListener);

        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(buttonListener);
        button9.setOnClickListener(buttonNumberListener);

        Button button_dot = (Button) findViewById(R.id.button_dot);
        button_dot.setOnClickListener(buttonListener);
        button_dot.setOnClickListener(buttonNumberListener);

        Button button2Ex = (Button) findViewById(R.id.button2Ex);
        button2Ex.setOnClickListener(buttonListener);
        button2Ex.setOnClickListener(buttonNumberListener);


//        Button buttonPlusANDMinus = (Button) findViewById(R.id.button_PlusANDMinus);
//        buttonPlusANDMinus.setOnClickListener(buttonListener);
//        buttonPlusANDMinus.setOnClickListener(buttonNumberListener);
//
//        Button buttonPercent = (Button) findViewById(R.id.button_percent);
//        buttonPercent.setOnClickListener(buttonListener);
//        buttonPercent.setOnClickListener(buttonNumberListener);


        //割り算
        Button buttonDivision = (Button) findViewById(R.id.button_division);
        buttonDivision.setOnClickListener(buttonListener);
        buttonDivision.setOnClickListener(buttonOperatorListener);

        //掛け算
        Button buttonMultiplication = (Button) findViewById(R.id.button_multiplication);
        buttonMultiplication.setOnClickListener(buttonListener);
        buttonMultiplication.setOnClickListener(buttonOperatorListener);

        //引き算
        Button buttonSubtraction = (Button) findViewById(R.id.button_subtraction);
        buttonSubtraction.setOnClickListener(buttonListener);
        buttonSubtraction.setOnClickListener(buttonOperatorListener);

        //掛け算
        Button buttonAddition = (Button) findViewById(R.id.button_addition);
        buttonAddition.setOnClickListener(buttonListener);
        buttonAddition.setOnClickListener(buttonOperatorListener);

        //イコール
        Button buttonEqual = (Button) findViewById(R.id.button_equal);
        buttonEqual.setOnClickListener(buttonListener);
        buttonEqual.setOnClickListener(buttonOperatorListener);


        //オールクリア
//        Button buttonAllClear = (Button) findViewById(R.id.button_allClear);
//        buttonAllClear.setOnClickListener(buttonListener);
//        buttonAllClear.setOnClickListener(buttonNumberListener);

    }


    View.OnClickListener buttonNumberListener = new View.OnClickListener() {
        @Override
        public void onClick(View getTextButton) {
            Button buttonGetText = (Button) getTextButton;

            if (isOperatorKeyPushed == true) {
                textView.setText(buttonGetText.getText());
            } else {
                textView.append(buttonGetText.getText());
            }

            isOperatorKeyPushed = false;
        }
    };


    int recentOperator = R.id.button_equal;
    double result;
    boolean isOperatorKeyPushed;

    View.OnClickListener buttonOperatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View operator) {
            Button operatorButton = (Button) operator;
            double value = Double.parseDouble(textView.getText().toString());
            if (recentOperator == R.id.button_equal) {
                result = value;
            } else {
                result = calculation(recentOperator, result, value);
            }

            recentOperator = operatorButton.getId();
            textView.setText(operatorButton.getText());
            textView.setText(String.valueOf(result));
            isOperatorKeyPushed = true;
        }
    };


    //計算式メソッド
    double calculation(int operator, double value1, double value2) {
        switch (operator){
            case R.id.button_addition:
                return value1 + value2;

            case R.id.button_subtraction:
                return value1 - value2;

            case R.id.button_multiplication:
                return value1 * value2;

            case R.id.button_division:
                return value1 / value2;

            default:
                return value1;
        }
    }

}
