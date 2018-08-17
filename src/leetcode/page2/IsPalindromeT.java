package leetcode.page2;
/*
*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama"is a palindrome.
"race a car"is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
* */
public class IsPalindromeT {
    public boolean isPalindrome(String s) {
        if (s==null||s.length()==0){
            return true;
        }
        s=s.replaceAll("\\W", ""); // 使用正则去除非字符数字的字符
        s=s.toLowerCase();
        for(int i = 0,j=s.length()-1; i < j; i++,j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
