package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class Calculator extends AppCompatActivity {
    /*Button add;
    Button sub;
    Button mult;
    Button div;

    Button res;
    Button clr;

    Button dec;
    Button sign;

    *//*Numbers*//*
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    int result = 0;
    String input;
    Stack<Integer> inputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        *//*=========================================
                        NUMBERS
        =========================================*//*
     *//*Button 0*//*
        btn0 = (Button)findViewById(R.id.btn0);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Button 1*//*
        btn1 = (Button)findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Button 2*//*
        btn2 = (Button)findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Button 3*//*
        btn3 = (Button)findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Button 4*//*
        btn4 = (Button)findViewById(R.id.btn4);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Button 5*//*
        btn5 = (Button)findViewById(R.id.btn5);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Button 6*//*
        btn6 = (Button)findViewById(R.id.btn6);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Button 7*//*
        btn7 = (Button)findViewById(R.id.btn7);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Button 8*//*
        btn8 = (Button)findViewById(R.id.btn8);

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Button 9*//*
        btn9 = (Button)findViewById(R.id.btn9);

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        *//*=========================================
                        OPERATIONS
        =========================================*//*
     *//*Division*//*
        div = (Button)findViewById(R.id.btn_div);

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Multiplication*//*
        mult = (Button)findViewById(R.id.btn_mult);

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Addition*//*
        add = (Button)findViewById(R.id.btn_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Subtraction*//*
        sub = (Button)findViewById(R.id.btn_sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Equal*//*
        res = (Button)findViewById(R.id.btn_equal);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        *//*Decimal*//*
        dec = (Button)findViewById(R.id.btn_dec);

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }*/
    Button equal, dec;
    TextView display, viewTotal;
    AtomicBoolean isSpecialOp = new AtomicBoolean(false), isDot = new AtomicBoolean(false), isError = new AtomicBoolean(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);
        Operation operation = new Operation();
        equal = findViewById(R.id.btn_equal);
        dec = findViewById(R.id.btn_dec);
        display = findViewById(R.id.result);
        viewTotal = findViewById(R.id.input);
        /*viewTotal.setText("0");*/

        Button[] numbers = {
                findViewById(R.id.btn0),
                findViewById(R.id.btn1),
                findViewById(R.id.btn2),
                findViewById(R.id.btn3),
                findViewById(R.id.btn4),
                findViewById(R.id.btn5),
                findViewById(R.id.btn6),
                findViewById(R.id.btn7),
                findViewById(R.id.btn8),
                findViewById(R.id.btn9)
        },
                operators = {
                        findViewById(R.id.btn_add),
                        findViewById(R.id.btn_sub),
                        findViewById(R.id.btn_mult),
                        findViewById(R.id.btn_div),
                };
        for(int i=0;i<numbers.length;i++){
            String input = String.valueOf(i);
            numbers[i].setOnClickListener(view->{
                if(isSpecialOp.get()){
                    display.setText(viewTotal.getText().toString());
                    isSpecialOp.set(false);
                }
                try {
                    display.append(input);
                    operation.sequential(this);
                    isError.set(false);
                } catch (Exception e){
                    isError.set(true);
                    viewTotal.setText(e.getMessage());
                }
            });
        }
        for(Button b : operators){
            b.setOnClickListener(view-> {
                isDot.set(false);
                if(isSpecialOp.get()){
                    display.setText(viewTotal.getText().toString());
                    isSpecialOp.set(false);
                }
                String contentText = display.getText().toString();
                if(contentText.isEmpty() || contentText.charAt(contentText.length() - 1) == '.'){
                    display.append(b.getText());
                } else if (operation.isOperator(contentText.charAt(contentText.length() - 1))){
                    display.setText(contentText.substring(0, contentText.length() - 1).concat(b.getText().toString()));
                } else {
                    display.append(b.getText());
                }
            });
        }
        equal.setOnClickListener(view-> {
            try {
                operation.compute(this);
                display.setText(viewTotal.getText());
                isError.set(false);
            } catch (Exception e){
                isError.set(true);
            }
        });

        dec.setOnClickListener(view-> {
            String contentText = display.getText().toString();
            if(!isDot.get()){
                if(contentText.isEmpty() || operation.isOperator(contentText.charAt(contentText.length() - 1))){
                    display.append("0.");
                } else {
                    display.append(".");
                }
                isDot.set(true);
            } else if (contentText.charAt(contentText.length() - 1) == '.'){
                display.setText(contentText.substring(0, contentText.length() - 1));
                isDot.set(false);
            }
        });
    }
}