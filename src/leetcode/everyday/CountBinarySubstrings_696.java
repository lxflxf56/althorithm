package leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: althorithm
 * @description: https://leetcode-cn.com/problems/count-binary-substrings/
 * @author: Xiaofeng
 * @create: 2020-08-10
 */
public class CountBinarySubstrings_696 {
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int count = 1;
            char c = s.charAt(index);
            while ((index + count) < s.length() && c == s.charAt(index + count)) {
                count++;
            }
            list.add(count);
            index = index + count;
        }
        int result=0;
        for (int i=1;i<list.size();i++){
            result=result+Math.min(list.get(i-1),list.get(i));
        }
        return result;
    }

    public static void main(String[] args){
        int i = new CountBinarySubstrings_696().countBinarySubstrings("10101");
        System.out.println(i);
    }
}
