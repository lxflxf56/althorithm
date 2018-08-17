package DynamicProgramming;
/*
有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。

给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
测试样例：

[2,7,9,4,1],5

返回：14*/
public class MaxInnerRec {

    public int countArea(int[] A, int n) {
        int maxArea=0;
        int min;
        for(int i=0;i<n;i++){
            min=Integer.MAX_VALUE;
            for(int j=i;j>=0;j--){
                min=Math.min(min, A[j]);
                maxArea=Math.max(maxArea,(i-j+1)*min);
            }
        }
        return maxArea;
    }
}
