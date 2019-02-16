package beike;
/*
*
*字符串的编辑距离，又称为Levenshtein距离，由俄罗斯的数学家Vladimir Levenshtein在1965年提出。是指利用字符操作，把字符串A转换成字符串B所需要的最少操作数。其中，字符操作包括：

删除一个字符     a) Insert a character
插入一个字符     b) Delete a character
修改一个字符     c) Replace a character
例如对于字符串"if"和"iff"，可以通过插入一个'f'或者删除一个'f'来达到目的。

  一般来说，两个字符串的编辑距离越小，则它们越相似。如果两个字符串相等，则它们的编辑距离（为了方便，本文后续出现的“距离”，如果没有特别说明，则默认为“编辑距离”）为0（不需要任何操作）。不难分析出，两个字符串的编辑距离肯定不超过它们的最大长度（可以通过先把短串的每一位都修改成长串对应位置的字符，然后插入长串中的剩下字符）。

* */
public class Levenshtein {
    public static int levenshtein(String a,String b){
        int[][] dp=new int[a.length()+1][b.length()+1];
        for (int i=1;i<=a.length();i++){
            dp[i][0]=i;
        }
        for (int i=1;i<=b.length();i++){
            dp[0][i]=i;
        }
        for (int i=1;i<=a.length();i++){
            for (int j=1;j<=b.length();j++){
                int cost=1;
                if (a.charAt(i-1)==b.charAt(j-1)){
                    cost=0;
                }
                //状态转移方程
                dp[i][j]=Math.min(
                        Math.min(dp[i-1][j]+1,dp[i][j-1]+1)
                        ,dp[i-1][j-1]+cost
                );
            }
        }
        return dp[a.length()][b.length()];
    }
    public static void main(String[] args) {
            System.out.println(levenshtein("asd","abd"));
    }
}
