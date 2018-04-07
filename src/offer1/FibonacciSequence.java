package offer1;

//大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
//1、1、2、3、5、8、13、21、34、……
// 在数学上，斐波纳契数列以如下被以递归的方法定义：F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
//n<=39
public class FibonacciSequence {
    public int Fibonacci(int n) {
        if (n<=0){
            return 0;
        }
        if (n<=2){
            return 1;
        }
        int[] t=new int[n];
        t[0]=1;
        t[1]=1;
        for (int i=2;i<n;i++){
           t[i]=t[i-1]+t[i-2];
        }
        return t[n-1];
    }
}
