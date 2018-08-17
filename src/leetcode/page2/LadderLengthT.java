package leetcode.page2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/*

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

For example,

Given:
start ="hit"
end ="cog"
dict =["hot","dot","dog","lot","log"]

As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length5.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
* */
public class LadderLengthT {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int result=1;
        Queue<String> queue=new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size>0){
                size--;
                String s=queue.poll();
                if (isDiffOne(s,end)){
                    return result+1;
                }
                Iterator<String> iterator = dict.iterator();
                while (iterator.hasNext()){
                    String next = iterator.next();
                    if (isDiffOne(s,next)){
                        queue.offer(next);
                        iterator.remove();
                    }
                }
            }
            result++;
        }
        return 0;
    }
    public boolean isDiffOne(String w1, String w2) {
        int count = 0;
        for(int i = 0; i < w1.length(); i++) {
            if(w1.charAt(i) != w2.charAt(i)) {
                count++;
            }
        }
        return count==1?true:false;
    }
}
