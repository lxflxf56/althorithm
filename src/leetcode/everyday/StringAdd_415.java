package leetcode.everyday;

/**
 * @program: althorithm
 * @description: 415. 字符串相加 https://leetcode-cn.com/problems/add-strings/
 * @author: Xiaofeng
 * @create: 2020-08-03
 */
public class StringAdd_415 {
    static class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder("");
            int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
            while (i >= 0 || j >= 0) {
                int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int tmp = n1 + n2 + carry;
                carry = tmp / 10;
                res.append(tmp % 10);
                i--;
                j--;
            }
            if (carry == 1) res.append(1);
            return res.reverse().toString();
        }
    }

    public static void main(String[] args){
        String s = new Solution().addStrings("1", "2");
        System.out.println(s);
    }

}
