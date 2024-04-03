package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class Calculator extends AppCompatActivity {
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnPoint;
    private TextView equation;
    private TextView numberPlaceHolder;
    private String numRes = "", numTemp = "", op = "";
//    private Double result;

    private Stack<Double> numbersStack;
    private Stack<Character> operationsStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);

        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_sub);
        btnMultiply = findViewById(R.id.btn_mult);
        btnDivide = findViewById(R.id.btn_div);
        btnEquals = findViewById(R.id.btn_equal);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPoint = findViewById(R.id.btn_dec);

        numberPlaceHolder = (TextView) findViewById(R.id.input);
        equation = (TextView) findViewById(R.id.result);

        numbersStack = new Stack<>();
        operationsStack = new Stack<>();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num0 = btn0.getText().toString();

                setPlaceHolders(num0);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = btn1.getText().toString();

                setPlaceHolders(num1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num2 = btn2.getText().toString();

                setPlaceHolders(num2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num3 = btn3.getText().toString();

                setPlaceHolders(num3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num4 = btn4.getText().toString();

                setPlaceHolders(num4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num5 = btn5.getText().toString();

                setPlaceHolders(num5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num6 = btn6.getText().toString();

                setPlaceHolders(num6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num7 = btn7.getText().toString();

                setPlaceHolders(num7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num8 = btn8.getText().toString();

                setPlaceHolders(num8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num9 = btn9.getText().toString();

                setPlaceHolders(num9);
            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String point = btnPoint.getText().toString();

                setPlaceHolders(point);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty() || (equation.getText().charAt(equation.length()-1) == '.')) {
                    return;
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + "+");
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + "+");
                }

                setPlaceHolders("+");

//                if(!numTemp.toString().isEmpty()) {
//                    result = calculateForInline(Double.parseDouble(numRes), Double.parseDouble(numTemp), op) ;
//                    numberPlaceHolder.setText(String.valueOf(result));
//
//                    numRes = String.valueOf(result);
//                    numTemp = "";
//                    result = (double) 0;
//                }
//
//                op = "+";
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty() || (equation.getText().charAt(equation.length()-1) == '.')) {
                    return;
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + "-");
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + "-");
//                    substring ([starting_index], [end_index - 1]);
//                    20+3- 5 length : balig "20+3" + "-"
//                    substring (0, (5-1) - 1) (0, 3)
                }

                setPlaceHolders("-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty() || (equation.getText().charAt(equation.length()-1) == '.')) {
                    return;
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + "*");
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + "*");
                }

                setPlaceHolders("*");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty() || (equation.getText().charAt(equation.length()-1) == '.')) {
                    return;
                }

//                if(numberPlaceHolder.getText().toString() == "MATH ERROR") {
//                    clearAll();
//                    return;
//                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + "/");
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + "/");
                }

                setPlaceHolders("/");
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = equation.getText().toString();

                if (expression.isEmpty() || isOperator(expression.charAt(expression.length() - 1))) {
                    return;
                }

                evaluateExpression(expression);
            }
        });
    }

    private void setPlaceHolders(String str) {
        // first number
        if(op.isEmpty() && !isOperator(str.charAt(0))) {
            if(str.equals(".") && !numRes.isEmpty()) {
                if(numRes.charAt(numRes.length() - 1) == '.') {
                    equation.setText(equation.getText().toString().substring(0, equation.length() - 1));
                    numberPlaceHolder.setText(numberPlaceHolder.getText().toString().substring(0, numberPlaceHolder.length() - 1));
                    numRes = numRes.substring(0, numRes.length() - 1);

                    return;
                }
                if(numRes.contains(".")) {
                    return;
                }
            }
            numRes = (numRes + str);
            numberPlaceHolder.setText(numRes);
            equation.setText(equation.getText() + str);
            return;
        }

        // second number onwards or operation
        if(isOperator(str.charAt(0))) {
            numRes = numberPlaceHolder.getText().toString();
            numTemp = "";
            op = str;
        } else {
            if(str.equals(".") && !numTemp.isEmpty()) {
                if(numTemp.charAt(numTemp.length() - 1) == '.') {
                    equation.setText(equation.getText().toString().substring(0, equation.length() - 1));
                    numTemp = numTemp.substring(0, numTemp.length() - 1);
                    calculateForInline(Double.parseDouble(numRes), Double.parseDouble(numTemp), op);
                    return;
                }
                if(numTemp.contains(".")) {
                    return;
                }
            }

            numTemp = (numTemp + str);

            if(!str.equals(".")) {
                calculateForInline(Double.parseDouble(numRes), Double.parseDouble(numTemp), op);
            }

            equation.setText(equation.getText() + str);
        }
    }
    private void calculateForInline(Double num1, Double num2, String op) {
        Double temp = (double) 0;

        switch(op) {
            case "+":
                temp = num1 + num2;
                break;
            case "-":
                temp = num1 - num2;
                break;
            case "*":
                temp = num1 * num2;
                break;
            case "/":
//                if (num2 != 0) {
                temp = num1 / num2;
//                } else {
//                    numberPlaceHolder.setText("MATH ERROR");
//                    return;
//                }
                break;
        }
        numberPlaceHolder.setText(String.valueOf(temp));
    }

    private void evaluateExpression(String expression) {
        numbersStack.clear();
        operationsStack.clear();

        int n = expression.length();
        int i = 0;

        while (i < n) {
            if (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.') {
                StringBuilder num = new StringBuilder();
                while (i < n && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(expression.charAt(i));
                    i++;
                }
                numbersStack.push(Double.parseDouble(num.toString()));
            } else if (isOperator(expression.charAt(i))) {
                while (!operationsStack.isEmpty() && (hasPrecedence(expression.charAt(i)) || (!hasPrecedence(expression.charAt(i)) && !hasPrecedence(operationsStack.peek())))) {
                    performOperation();
                }
                operationsStack.push(expression.charAt(i));
                i++;
            } else {
                i++;
            }
        }

        while (!operationsStack.isEmpty()) {
            performOperation();
        }

        if (!numbersStack.isEmpty()) {
            numberPlaceHolder.setText(String.valueOf(numbersStack.pop()));
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean hasPrecedence(char op1) {
        return (op1 != '*' && op1 != '/');
    }

    private void clearAll() {
        equation.setText("");
        numberPlaceHolder.setText("");
        numRes = "";
        numTemp = "";
        op = "";
        numbersStack.clear();
        operationsStack.clear();
    }

    private void performOperation() {
        if (numbersStack.size() < 2 || operationsStack.isEmpty()) {
            return;
        }

        Double b = numbersStack.pop();
        Double a = numbersStack.pop();
        Character operation = operationsStack.pop();

        double res = 0;
        switch (operation) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
//                if (b != 0) {
                res = a / b;
//                } else {
//                    numberPlaceHolder.setText("MATH ERROR");
//                    return;
//                }
                break;
        }
        numbersStack.push(res);
    }
}