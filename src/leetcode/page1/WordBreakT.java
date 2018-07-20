package leetcode.page1;
import java.util.*;



/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s ="leetcode",
dict =["leet", "code"].

Return true because"leetcode"can be segmented as"leet code".
*/
public class WordBreakT {
    ArrayList<String> arrayList;
    String s;
    Set<String> dict;
    boolean[][] dp;
    public ArrayList<String> wordBreak(String s, Set<String> dict) {

        arrayList=new ArrayList<>();
        if (s == null||s.length() == 0){
            arrayList.add("");
            return arrayList;
        }
        if(dict == null || dict.size() == 0  )
            return arrayList;
        this.dict=dict;
        this.s=s;
        dp=new boolean[s.length()][s.length()+1];
        wordBreak4(0);
        dpfind(0,"");
        return arrayList;
    }

    void dpfind(int start,String result){
        for (int i=start+1;i<s.length()+1;i++){
            if (dp[start][i]){
                if (i!=s.length()){
                    dpfind(i,result+s.substring(start,i)+" ");
                }else {
                    arrayList.add(result+s.substring(start,i));
                    return;
                }
            }
        }
    }
    void wordBreak4(int i){
            for (int j=i+1;j<=s.length();j++) {
                if (dict.contains(s.substring(i, j))) {
                    dp[i][j] = true;
                    wordBreak4(j);
                }
            }
    }


    void wordBreak3(int start,int end,String result){//n*m*r
        if (end>s.length()){
            return;
        }
        String substring = s.substring(start, end);
        if (dict.contains(substring)){
            int startIndex=start+substring.length();
            if (startIndex==s.length()){
                arrayList.add(result+substring);
                return;
            }else {
                wordBreak3(startIndex,startIndex+1,result+substring+" ");
            }
        }
        wordBreak3(start,end+1,result);
    }

    void wordBreak2(int start,String s,Set<String> dict,String result){//n*n
        for (String stmp:dict) {
            int endIndex=start+stmp.length();
            if (s.length()>=endIndex){
                String substring = s.substring(start, endIndex);
                if (stmp.equals(substring)){
                    if (endIndex==s.length()){
                        result=result+stmp;
                        arrayList.add(result);
                        return;
                    }else {
                        wordBreak2(endIndex,s,dict,result+stmp+" ");
                    }
                }
            }


        }
    }
    public void dfs(String s,int index,String cur_string,Set<String> dict){//不知道为什么之前的不能过
        if(index<=0){
            if(cur_string.length()>0)
                arrayList.add(cur_string.substring(0,cur_string.length()-1));
        }
        for(int i=index;i>=0;i--){
            if(dict.contains(s.substring(i,index))){
                dfs(s,i,s.substring(i,index)+" "+cur_string,dict);
            }
        }
    }

    public static void main(String args[]){
        WordBreakT wordBreakT=new WordBreakT();
        Set set=new HashSet();
        set.add("a");






        long startTime=System.nanoTime();   //获取开始时间
        ArrayList arrayList = wordBreakT.wordBreak("b", set);
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println(arrayList);
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }
}
