package leetcode.page1;

import java.util.ArrayList;
/* Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s ="aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Partition {

    public static  ArrayList<ArrayList<String>> partition(String s) {
        ArrayList result=new ArrayList();
        dfs(result,new ArrayList(),s);
        return result;
    }
    public static void dfs(ArrayList result,ArrayList cur,String s){
        if (s==null||s.length()==0){
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i=1;i<s.length()+1;i++){
            String substring = s.substring(0, i);
            if (isPalindrome(substring)){
                cur.add(substring);
                dfs(result,cur,s.substring(i,s.length()));
                cur.remove(cur.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s){
        return isPalindrome(s,0,s.length()-1);
    }
    private static boolean isPalindrome(String s,int i,int j){
        while(i<j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Partition.partition("a");

    }

}
