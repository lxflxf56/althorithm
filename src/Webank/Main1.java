package Webank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String GetResult(int N) {
        int sum=0;
        boolean isRight=false;
        int i=1;
        for (;sum<N;i++){
            sum+=i;
            isRight=!isRight;
        }

        int x,y;
        if (!isRight){
            x=i-1;
            y=1;
        }else {
            x=1;
            y=i-1;
        }

        while (sum>N){
            if (isRight){
                x++;
                y--;
            }else {
                x--;
                y++;
            }
            sum--;
        }

        return x+"/"+y;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _N;
        _N = in.nextInt();

        res = GetResult(_N);
        System.out.println(res);
    }
}
