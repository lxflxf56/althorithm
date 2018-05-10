package offer3;
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

//二进制每位相加就相当于各位做异或操作
//计算进位值，相当于各位做与操作，再向左移一位
public class AddT {
    public int Add(int num1,int num2) {
        while (num2!=0){
            int tmp=num1^num2;//每位相加
            num2=(num1&num2)<<1;
            num1=tmp;
        }
        return num1;
    }
}
