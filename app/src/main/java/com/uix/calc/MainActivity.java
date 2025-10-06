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


import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate method called.");

        setContentView(R.layout.activity_main);

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

        // Set click listeners for operator buttons
        setButtonClickListener(button_add, "+");
        setButtonClickListener(button_sub, "-");
        setButtonClickListener(button_multiply, "×");
        setButtonClickListener(button_divide, "÷");
        setButtonClickListener(button_dot, ".");
        setButtonClickListener(button_precent, "%");


        // Set click listeners for special buttons
        button_ac.setOnClickListener(v -> textView.setText(""));
//        button_equ.setOnClickListener(v -> );
        button_del.setOnClickListener(v -> {
            String current = textView.getText().toString();
            if(!current.isEmpty()) {
                textView.setText(
                        current.substring(
                                0,
                                current.length() - 1
                        )
                );
            }
        });


        button_add.setOnClickListener( v -> {
            String current = textView.getText().toString();

        });
//        EdgeToEdge.enable(this);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    private void setButtonClickListener(Button button, String value) {
        button.setOnClickListener(v -> {
            String current = textView.getText().toString();

            textView.setText(current + value);
            Log.d(TAG, "TextView value: " + textView.getText().toString());

            Log.d(TAG, "TextView value: " + textView.getText());
        });
    }

    //    eq
//    private void setEqual()


}