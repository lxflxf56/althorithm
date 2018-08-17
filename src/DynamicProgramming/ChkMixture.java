package DynamicProgramming;
/*

对于三个字符串A，B，C。我们称C由A和B交错组成当且仅当C包含且仅包含A，B中所有字符，且对应的顺序不改变。请编写一个高效算法，判断C串是否由A和B交错组成。

给定三个字符串A,B和C，及他们的长度。请返回一个bool值，代表C是否由A和B交错组成。保证三个串的长度均小于等于100。
测试样例：

"ABC",3,"12C",3,"A12BCC",6

返回：true
* */
/*
    状态转移方程：dp[i][j]为A的前i个和B的前j个能不能构成C的前i+j
    dp[i][j]=
        dp[i][j-1]&&B这个j-1字符是否与C的i+j-1匹配 或
        dp[i-1][j]&&A这个i-1字符是否与C的i+j-1匹配
* */
public class ChkMixture {
    public static boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        // write code here
        boolean[][] dp=new boolean[A.length()+1][B.length()+1];
        dp[0][0]=true;
        for (int i=1;i<dp.length;i++){
            if (A.charAt(i-1)==C.charAt(i-1)){
                dp[i][0]=true;
            }else {
                break;
            }
        }
        for (int i=1;i<dp[0].length;i++){
            if (B.charAt(i-1)==C.charAt(i-1)){
                dp[0][i]=true;
            }else
                break;
        }

        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                if (dp[i][j-1]&&B.charAt(j-1)==C.charAt(i+j-1)){
                    dp[i][j]=true;
                }
                if (dp[i-1][j]&&A.charAt(i-1)==C.charAt(i+j-1)){
                    dp[i][j]=true;
                }
            }
        }
        return dp[A.length()][B.length()];
    }

    public static void main(String[] args) {
        boolean b = ChkMixture.chkMixture("ABC",3,"12a",3,"A12BCC",6);
        System.out.println(b);
    }
}
