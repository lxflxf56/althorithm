package leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: althorithm
 * @description: 949. 给定数字能组成的最大时间 https://leetcode-cn.com/problems/largest-time-for-given-digits/
 * @author: Xiaofeng
 * @create: 2020-08-03
 */
public class LargestTimeFromDigits_949 {
    @Deprecated
    //错误解答
    static class Solution1 {
        public String largestTimeFromDigits(int[] A) {
            if (A.length != 4) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            List<Integer> list = new ArrayList<>();
            for (int a : A) {
                list.add(a);
            }
//            list.sort(Integer::compareTo);
            //1位
            Integer integer = list.stream().filter(e -> e <= 2).max(Integer::compareTo).orElse(null);
            if (integer == null) {
                return "";
            }
            stringBuilder.append(integer);
            list.remove(integer);
            //2位
            if (integer == 2) {
                integer = list.stream().filter(e -> e <= 3).max(Integer::compareTo).orElse(null);
            } else {
                integer = list.stream().max(Integer::compareTo).orElse(null);
            }
            if (integer == null) {
                return "";
            }
            stringBuilder.append(integer);
            list.remove(integer);

            stringBuilder.append(":");
            //3位
            integer = list.stream().filter(e -> e <= 5).max(Integer::compareTo).orElse(null);
            if (integer == null) {
                return "";
            }
            stringBuilder.append(integer);
            list.remove(integer);
            //4
            stringBuilder.append(list.get(0));
            return stringBuilder.toString();
        }
    }

    static class Solution {
        public String largestTimeFromDigits(int[] A) {
            int ans = -1;

            // Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
            for (int i = 0; i < 4; ++i)
                for (int j = 0; j < 4; ++j)
                    if (j != i)
                        for (int k = 0; k < 4; ++k)
                            if (k != i && k != j) {
                                int l = 6 - i - j - k;

                                // For each permutation of A[i], read out the time and
                                // record the largest legal time.
                                int hours = 10 * A[i] + A[j];
                                int mins = 10 * A[k] + A[l];
                                if (hours < 24 && mins < 60)
                                    ans = Math.max(ans, hours * 60 + mins);
                            }

            return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
        }
    }

    public static void main(String[] a) {
        String s = new Solution().largestTimeFromDigits(new int[]{5, 5, 5, 5});
        System.out.println(s);
    }
}
