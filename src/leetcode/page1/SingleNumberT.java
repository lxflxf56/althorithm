package leetcode.page1;
/*
*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


*
* */
public class SingleNumberT {
    public int singleNumber(int[] A) {
        int result=0;
        for (int i=0;i<32;i++){
            int bits=0;
            for (int j=0;j<A.length;j++){
                bits+=(A[j]>>i)&1;
            }
            result+=((bits%3)<<i);
        }
        return result;
    }
}
