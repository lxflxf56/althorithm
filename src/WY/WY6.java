package WY;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
* 一个合法的括号匹配序列被定义为:
1. 空串""是合法的括号序列
2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
3. 如果"X"是一个合法的序列,那么"(X)"也是一个合法的括号序列
4. 每个合法的括号序列都可以由上面的规则生成
例如"", "()", "()()()", "(()())", "(((()))"都是合法的。
从一个字符串S中移除零个或者多个字符得到的序列称为S的子序列。
例如"abcde"的子序列有"abe","","abcde"等。
定义LCS(S,T)为字符串S和字符串T最长公共子序列的长度,即一个最长的序列W既是S的子序列也是T的子序列的长度。
小易给出一个合法的括号匹配序列s,小易希望你能找出具有以下特征的括号序列t:
1、t跟s不同,但是长度相同
2、t也是一个合法的括号匹配序列
3、LCS(s, t)是满足上述两个条件的t中最大的
因为这样的t可能存在多个,小易需要你计算出满足条件的t有多少个。

如样例所示: s = "(())()",跟字符串s长度相同的合法括号匹配序列有:
"()(())", "((()))", "()()()", "(()())",其中LCS( "(())()", "()(())" )为4,其他三个都为5,所以输出3.
* */


//最大子序列长度肯定为s-1；
// 即要想使得 LCS 最大，删去任意一个字符即可获得 LCS = |s| - 1 ，
// 再把该字符插到与原来不同的任意位置可以维持原长度，而不影响 LCS 的计算。
public class WY6 {
    Set set;
    public WY6(String str){
        set=new HashSet();
        strExchange(str);
        System.out.println(set.size()-1);

    }
    public void strExchange(String str){
        StringBuilder builder;
        for (int i=0;i<str.length();i++){
            builder=new StringBuilder(str);
            char c=builder.charAt(i);
            builder.deleteCharAt(i);
            for (int j=0;j<str.length();j++){
                builder.insert(j,c);
                if (isLegal(builder)){
                    set.add(builder.toString());
                }
                builder.deleteCharAt(j);
            }

        }
    }


/*
判合法：实际上就是括号匹配的平衡性。在这里，如果我们从前到后遍历，
左括号可以暂时多于右括号，但不可以少于，
因为能够闭合右括号的左括号都在左边了。每次成功闭合一对括号把数量 - 1 ，
得到负数说明不平衡。 */
    public boolean isLegal(StringBuilder str){
        int left=0,right=0;
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if (c=='('){
                left++;
            }else {
                right++;
            }
            if (left<right){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        WY6 wy6=new WY6(str);
    }
}
