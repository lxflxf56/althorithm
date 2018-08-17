package leetcode.page2;
/* Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).

Here is an example:
S ="rabbbit", T ="rabbit"

Return3.
*/
public class NumDistinct {

/*
 *  思路：dp题。
 *  状态定义：dp[i][j]代表s[0~i-1]中T[0~j-1]不同子串的个数。
 *  递推关系式：S[i-1]!= T[j-1]：  DP[i][j] = DP[i][j-1] （不选择S中的s[i-1]字符）
 *              S[i-1]==T[j-1]： DP[i][j] = DP[i-1][j-1]（选择S中的s[i-1]字符） + DP[i][j-1]
 *  初始状态：第0列：DP[i][0] = 0，第0行：DP[0][j] = 1
 */

    public static int numDistinct(String S, String T) {
        int row = S.length() + 1;
        int col = T.length() + 1;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
    public static void main(String[] args) {
        NumDistinct.numDistinct("asssd","ad");
    }

}
