package leetcode.page1;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.


    /*

  需要两重循环，第一重循环遍历起始点a，第二重循环遍历剩余点b。

    a和b如果不重合，就可以确定一条直线。

    对于每个点a，构建 斜率->点数 的map。

    (1)b与a重合，以a起始的所有直线点数+1 (用dup统一相加)

    (2)b与a不重合，a与b确定的直线点数+1
    * */
public class MaxPoints {
    public int maxPoints(Point[] points) {//map储存斜率
        if(points.length<=2){
            return points.length;
        }
        int max=0;
        for (int i=0;i<points.length;i++){
            int curMax=1;
            int sam=0;//重复点
            int vcnt=0;//垂直点
            Map<Double,Integer> map=new HashMap<>();
            for (int j=0;j<points.length;j++){
                if (i==j){
                    continue;
                }
                double x1=points[i].x-points[j].x;
                double y1=points[i].y-points[j].y;
                if (x1==0&&y1==0){//重复
                    sam++;
                }else if (x1==0){//垂直
                    if (vcnt==0){
                        vcnt=2;
                    }else {
                        vcnt++;
                    }
                    curMax=Math.max(curMax,vcnt);
                }else {
                    double k=y1/x1;
                    Integer integer = map.get(k);
                    if (integer!=null){
                        integer++;
                    }else {
                       integer=2;
                    }
                    map.put(k,integer);
                    curMax=Math.max(curMax,integer);
                }

            }
            max=Math.max(curMax+sam,max);
        }

        return max;
    }
}

class Point{
    int x,y;
    Point(){
        x=0;y=0;
    }
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
