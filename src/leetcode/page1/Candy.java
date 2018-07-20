package leetcode.page1;

import java.util.Arrays;

/* There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give? */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length==0){
            return 0;
        }
        int result=0;
        int[] child=new int[ratings.length];
        Arrays.fill(child,1);
        for (int i=1;i<ratings.length;i++){
            if (ratings[i-1]<ratings[i]){
                child[i]=child[i-1]+1;
            }
        }
        for (int i=ratings.length-1;i>0;i--){
            result+=child[i];
            if (ratings[i]<ratings[i-1]&&child[i]>=child[i-1]){
                child[i-1]=child[i]+1;
            }
        }
        result+=child[0];
        return result;
    }
}
