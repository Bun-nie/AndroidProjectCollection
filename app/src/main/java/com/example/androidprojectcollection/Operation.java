package com.example.androidprojectcollection;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {
    public void evaluate2(int i, ArrayList<String> operands, ArrayList<String> operators) throws Exception {
        double operand1 = (operands.get(i).contains(".") ? Double.parseDouble(operands.get(i)) : (double) Long.parseLong(operands.get(i)));
        operand1 = evaluate(operands.get(i+1), operators.get(i).charAt(0), operand1);
        operands.remove(i+1);
        operands.set(i, String.valueOf(operand1));
    }

    public boolean isOperator (char ch){
        return ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '%';
    }

    public String evaluatePostFix (ArrayList<String> expression) throws Exception {
        Stack<String> stack = new Stack<>();
        for(String s : expression){
            if(s.matches("[-+/*%]")){
                String popped = stack.pop();
                stack.push(String.valueOf(evaluate(stack.pop(), s.charAt(0), (popped.contains(".") ? Double.parseDouble(popped) : (double) Long.parseLong(popped)))));
            } else {
                stack.push(s);
            }
        }
        return stack.pop();
    }

    public void convertToPostFix (ArrayList<ArrayList<String>> operands, ArrayList<ArrayList<String>> operators, int i){
        operands.get(i+1).addAll(operands.get(i));
        operands.get(i+1).addAll(operators.get(i));
        operands.remove(i);
        operators.remove(i);
    }

    public void sequential (Calculator c) throws Exception {
        if(c.isSpecialOp.get()){
            c.display.setText(c.viewTotal.getText().toString());
            c.isSpecialOp.set(false);
        }
        ArrayList<String> operands = new ArrayList<>(), operators = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\d*\\.?\\d+|[-+*/%]").matcher(c.display.getText().toString());
        while(matcher.find()){
            String token = matcher.group();
            if(token.matches("[-+/*%]")){
                operators.add(token);
            } else {
                operands.add(token);
            }
        }
        if(operators.size() == operands.size() && !operands.isEmpty()){
            operators.remove(operators.size()-1);
        }
        int i=0;
        while(i<operators.size()){
            evaluate2(i, operands, operators);
        }
        double output = (!operands.isEmpty() ? Double.parseDouble(operands.get(0)) : 0);
        if(!Double.isInfinite(output)){
            String outputString = String.valueOf(output);
            c.viewTotal.setText(output < Math.ceil(output) ? outputString : output == 0 ? "0" : outputString.contains("E") ? String.format(Locale.US, "%.0f", output) : outputString.replaceAll("0*$", "").replaceAll("\\.$", ""));
        }
    }

    public void compute (Calculator c) throws Exception {
        if(c.isSpecialOp.get()){
            c.display.setText(c.viewTotal.getText().toString());
            c.isSpecialOp.set(false);
        }
        c.isDot.set(false);
        ArrayList<ArrayList<String>> operands = new ArrayList<>(), operators = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\d*\\.?\\d+|[-+*/%]").matcher(c.display.getText().toString());
        while(matcher.find()){
            String token = matcher.group();
            ArrayList<String> elements = new ArrayList<>();
            if(token.matches("[-+*/%]")){
                elements.add(token);
                operators.add(elements);
            } else {
                elements.add(token);
                operands.add(elements);
            }
        }
        if(operators.size() == operands.size() && !operands.isEmpty()){
            operators.remove(operators.size()-1);
        }

        /*Solve for Multiplication*/
        for(int i = operators.size()-1;i>=0;i--){
            while (i < operators.size() && operators.get(i).get(0).equals("*")) {
                convertToPostFix(operands, operators, i);
            }
        }
        /*Solve for Division*/
        for(int i = operators.size()-1;i>=0;i--){
            while (i < operators.size() && operators.get(i).get(0).equals("/")) {
                convertToPostFix(operands, operators, i);
            }
        }
        /*Solve for Addition*/
        for(int i = operators.size()-1;i>=0;i--){
            while (i < operators.size() && operators.get(i).get(0).equals("+")) {
                convertToPostFix(operands, operators, i);
            }
        }
        /*Solve for Subtraction*/
        for(int i = operators.size()-1;i>=0;i--){
            while (i < operators.size() && operators.get(i).get(0).equals("-")) {
                convertToPostFix(operands, operators, i);
            }
        }
        double output = Double.parseDouble(evaluatePostFix(operands.get(0)));
        if(!Double.isInfinite(output)){
            String outputString = String.valueOf(output);
            c.viewTotal.setText(output < Math.ceil(output) ? outputString : output == 0 ? "0" : outputString.contains("E") ? String.format(Locale.US, "%.0f", output) : outputString.replaceAll("0*$", "").replaceAll("\\.$", ""));
        }
    }

    double evaluate(String str, char op, double total) throws Exception {
        double value = (str.contains(".") ? Double.parseDouble(str) : (double) Long.parseLong(str));
        switch (op) {
            case '+':
                total += value;
                break;
            case '-':
                total -= value;
                break;
            case '*':
                total *= value;
                break;
            case '/':
                if(value == 0)throw new Exception("Division by zero");
                total /= value;
                break;
        }
        return total;
    }
}