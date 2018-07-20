package leetcode.page1;

import java.util.Stack;

/*
*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are+,-,*,/. Each operand may be an integer or another expression.

https://zh.wikipedia.org/wiki/%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E7%A4%BA%E6%B3%95
*
    while有输入符号
        读入下一个符号X
        IF X是一个操作数
            入栈
        ELSE IF X是一个操作符
            有一个先验的表格给出该操作符需要n个参数
            IF堆栈中少于n个操作数
                （错误） 用户没有输入足够的操作数
            Else，n个操作数出栈
            计算操作符。
            将计算所得的值入栈
    IF栈内只有一个值
        这个值就是整个计算式的结果
    ELSE多于一个值
        （错误） 用户输入了多余的操作数
*/
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int a,b,result;
        for (int i=0;i<tokens.length;i++){
            switch (tokens[i]){
                case "*":
                    a=stack.pop();
                    b=stack.pop();
                    result=a*b;
                    stack.add(result);
                    break;
                case "+":
                    a=stack.pop();
                    b=stack.pop();
                    result=a+b;
                    stack.add(result);
                    break;
                case "-":
                    a=stack.pop();
                    b=stack.pop();
                    result=b-a;
                    stack.add(result);
                    break;
                case "/":
                    a=stack.pop();
                    b=stack.pop();
                    result=b/a;
                    stack.add(result);
                    break;
                default:
                    int i1 = Integer.parseInt(tokens[i]);
                    stack.add(i1);
                    break;
            }
        }
        return stack.peek();
    }

}
