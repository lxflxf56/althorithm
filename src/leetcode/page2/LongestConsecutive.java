package leetcode.page2;

import java.util.HashMap;
import java.util.Iterator;

/*
*

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given[100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.

Your algorithm should run in O(n) complexity.
* */
public class LongestConsecutive {
    public int longestConsecutive(int[] num) {
        if (num==null){
            return 0;
        }
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int tmp:num){
            hashMap.put(tmp,false);
        }
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        int max=Integer.MIN_VALUE;


        while (max<hashMap.size()/2&&iterator.hasNext()){
            Integer integer = iterator.next();
            if (hashMap.get(integer)==true){
                continue;
            }
            hashMap.put(integer,true);
            int tmp=integer-1;
            int count=1;
            while (hashMap.containsKey(tmp)){
                hashMap.put(tmp,true);
                count++;
                tmp--;
            }
            tmp=integer+1;
            while (hashMap.containsKey(tmp)){
                hashMap.put(tmp,true);
                count++;
                tmp++;
            }
            if (max<count){
                max=count;
            }
        }
        return max;

    }
}
