package leetcode.page2;

import java.util.ArrayList;
/* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
 The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


*/
public class MinimumTotal {
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }

        int[][] result=new int[triangle.size()][triangle.size()];

        result[0][0]=triangle.get(0).get(0);
        for (int i=1;i<triangle.size();i++){
            ArrayList<Integer> arrayList = triangle.get(i);
            for (int j=0;j<arrayList.size();j++){
                if (j==0){
                    result[i][0]=result[i-1][0]+arrayList.get(0);
                    continue;
                }
                if (j==arrayList.size()-1){
                    result[i][j]=result[i-1][j-1]+arrayList.get(j);
                    continue;
                }
                result[i][j]=Math.min(result[i-1][j]+arrayList.get(j),result[i-1][j-1]+arrayList.get(j));
            }
        }
        int min=Integer.MAX_VALUE;

        for (int i=0;i<triangle.size();i++){
            min=Math.min(min,result[triangle.size()-1][i]);
        }
        return min;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> main=new ArrayList();
        ArrayList tmp=new ArrayList();
        tmp.add(1);
        main.add(tmp);
        tmp=new ArrayList();
        tmp.add(2);
        tmp.add(3);
        main.add(tmp);
        MinimumTotal.minimumTotal(main);

    }
}
