package _11_stack;

import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        String express = "2+3*4-6";
        System.out.println(calculate(express));
    }

    /**
     * 1. 两个栈，numbers存数字，operators存符号
     * 2. 遍历表达式，如果是数字，则存numbers，如果是运算符
     *   2.1 如果此时operators为空，则直接存operators
     *   2.2 如果此时operators不为空，
     *     2.2.1 如果该运算符的优先级大于operators栈顶的运行符优先级，直接存入operators
     *     2.2.2 如果该运算符的优先级小于或等于operators栈顶的运行符优先级，取出栈顶运行符，
     *           同时取出numbers两个数进行运算，结果存入numbers，再将该运算符入operators
     * 3. 遍历完成后，依次取出numbers两个数和operators一个运算符，计算后将值入numbers，最终operators为空，
     *    numbers只剩一个数就是运算结果
     * @param express 表达式
     * @return
     */
    private static float calculate(String express) {
        // 数栈
        Stack<Float> numbers = new Stack<>();
        // 操作符栈
        Stack<String> operators = new Stack<>();
        for (char c : express.toCharArray()) {
            String s = String.valueOf(c);
            if (isOperator(s)) {
                if (operators.isEmpty()) {
                    operators.push(s);
                } else {
                    if (priority(s) > priority(operators.peek())) {
                        operators.push(s);
                    } else {
                        float b = numbers.pop();
                        float a = numbers.pop();
                        String operate = operators.pop();
                        numbers.push(simpleCalculate(a, b, operate));
                        operators.push(s);
                    }
                }
            } else {
                numbers.push(Float.valueOf(s));
            }
        }
        System.out.println(numbers);
        System.out.println(operators);
        while (!operators.isEmpty()) {
            float b = numbers.pop();
            float a = numbers.pop();
            String operate = operators.pop();
            numbers.push(simpleCalculate(a, b, operate));
        }
        return numbers.peek();
    }

    /**
     * 是否操作符
     * @param s 符号
     * @return true/false
     */
    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    /**
     * 符号的优先级
     * @param s 符号
     * @return 乘除 1；加减 0
     */
    private static int priority(String s) {
        return s.equals("*") || s.equals("/") ? 1: 0;
    }

    private static float simpleCalculate(float a, float b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return 0;
    }
}
