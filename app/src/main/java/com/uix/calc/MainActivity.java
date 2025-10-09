package com.uix.calc;
import android.util.Log;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button_ac, button_del, button_precent, button_divide,
            button_multiply, button_add, button_sub, button_dot, button_equ;

    private Button button1, button2, button3,
            button4, button5, button6,
            button7, button8, button9,
            button0;

    private double result;
    private static final String TAG = "MyActivity";


    private String currentInput = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean isNewInput = true;
    boolean isOperator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate method called.");

        setContentView(R.layout.activity_main);

        iniViews();
        setupButtons();
        setupOperatrs();
        setupSpecialButtons();
    }

    private void iniViews() {
        textView = findViewById(R.id.textView);
        button_ac = findViewById(R.id.button_ac);
        button_del = findViewById(R.id.button_del);
        button_precent = findViewById(R.id.button_precent);
        button_divide = findViewById(R.id.button_divide);
        button_multiply = findViewById(R.id.button_multiply);
        button_add = findViewById(R.id.button_add);
        button_sub = findViewById(R.id.button_sub);
        button_dot = findViewById(R.id.button_dot);
        button_equ = findViewById(R.id.button_equ);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
    }

    private void setupButtons() {
        // Set click listeners for all number buttons
        setButtonClickListener(button0, "0");
        setButtonClickListener(button1, "1");
        setButtonClickListener(button2, "2");
        setButtonClickListener(button3, "3");
        setButtonClickListener(button4, "4");
        setButtonClickListener(button5, "5");
        setButtonClickListener(button6, "6");
        setButtonClickListener(button7, "7");
        setButtonClickListener(button8, "8");
        setButtonClickListener(button9, "9");
    }

    private void setupOperatrs() {
        // Set click listeners for operator buttons
        setButtonClickListener(button_add, "+");
        setButtonClickListener(button_sub, "-");
        setButtonClickListener(button_multiply, "×");
        setButtonClickListener(button_divide, "÷");
        setButtonClickListener(button_dot, ".");
        setButtonClickListener(button_precent, "%");

    }

    private void setupSpecialButtons() {
        button_ac.setOnClickListener(v -> clearAll());
        button_del.setOnClickListener(v -> delLast());
        button_equ.setOnClickListener(v -> calcResult());
    }

    private void clearAll() {
        currentInput = "";
        operator = "";
        firstNumber = 0;
        isNewInput = true;
        textView.setText("");
    }
    private void delLast() {
        Log.d(TAG, "CURRENTINPUT" + textView);

        String text = textView.getText().toString();

        if (!text.isEmpty()) {
            text=text.substring(0, text.length()-1);
            textView.setText(text);
            currentInput=text;

        }
    }

    private void calcResult() {
        Log.d(TAG, "calcResult: " + operator);
        Log.d(TAG, "calcResult: " + currentInput);
        Log.d(TAG, "calcResult: " + isNewInput);




//        if (!operator.isEmpty() && !currentInput.isEmpty() && !isNewInput) {
//        if (!currentInput.isEmpty()) {

            double secondNum = Double.parseDouble(currentInput);

            Log.d(TAG, "calcResult: firstnum" + firstNumber);
            Log.d(TAG, "calcResult: secondNum" + secondNum);
//            double result = calulation(firstNumber, secondNum, operator);



            String resultText = formatResult(result);
            textView.setText(resultText);

            currentInput = resultText;
            operator = "";
            isNewInput = true;

            textView.setText(resultText);

//        }
    }


    private double calulation(double first, double second, String operator){
        switch (operator) {
            case  "+":
                return first + second;
            case  "-":
                return first - second;
            case  "×":
                return first * second;
            case  "÷":
                if (second == 0){
                    return second;
                }
                return first / second;


            default:
                return  second;

        }


    }

    private String formatResult( double result ) {
        if (result == (long) result) {
            return String.valueOf((long) result);
        } else {
            return String.format(
                    "%.10f", result
            ).replaceAll(
                    "0^$", ""
            ).replaceAll(
                    "\\.$", "");
        }
    }


    private void setButtonClickListener(Button button, String value) {
        button.setOnClickListener(v -> {
            String current = textView.getText().toString();
            isOperator =
                       value.equals("+")
                    || value.equals("-")
                    || value.equals("×")
                    || value.equals("÷")
                    || value.equals(".")
                    || value.equals("%");



            if( current.isEmpty() && isOperator) {
                return;
            }

            if (!current.isEmpty() && isOperator && islastCharOperator(current)) {
                current = current.substring(0, current.length() - 1);
            }
            textView.setText(current + value);




            Log.d(TAG, "TextView value: " + current);

        });
    }

    private boolean islastCharOperator(String text) {
        if (text.isEmpty()) return false;

        char lastChar = text.charAt(text.length() - 1 );
        return lastChar == '+'
                || lastChar == '-'
                || lastChar == '×'
                || lastChar == '÷'
                || lastChar == '%'
                || lastChar == '.';

    }

    //    eq
//    private void setEqual()


}