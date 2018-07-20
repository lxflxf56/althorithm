package Ali;

import offer1.Tools;
import util.Point;

import java.util.Scanner;

//机器人走迷宫，有障碍，转向要1s，直行要1s
/*
输入:start end mat -1为障碍
0 0
2 1
5
4
0 0 0 0
0 -1 0 0
0 0 -1 0
0 0 0 0
0 0 0 0
* */
public class Ali1 {
    int[][] matrix;
    Point strat,end;

    int[][] cost;
    public Ali1(int[][] matrix, Point strat, Point end) {
        this.matrix = matrix;
        this.strat = strat;
        this.end = end;

    }

    public int getResult(){
        for (int i=0;i<4;i++){
            run(strat,0,i);
        }
        return Point.getMatrix(matrix,end);
    }

    public void run(Point point,int nowCost,int nowCondition){//nowCondition  0:left ,1:right,2:up,3:down
        if (!Point.check(point,matrix.length-1,matrix[0].length-1)){
            return;
        }
        int lastNum = Point.getMatrix(this.matrix, point);
        if (nowCost<lastNum||lastNum==0){
            Point.setMatrix(this.matrix,point,nowCost);
        }else{
            return;
        }

        if (end.equals(point)){
            return;
        }
        for (int i=0;i<4;i++){
            if (i==nowCondition){
                run(Point.go(point,i),nowCost+1,i);
            }else {
                run(Point.go(point,i),nowCost+1+1,i);
            }

        }

    }

    public static void main(String args[]){
        //System.out.println();
        //Ali1 ali1=new Ali1();
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        int[] tmp= Tools.readArrInt(line);
        Point start = new Point(tmp[0], tmp[1]);
        line = scanner.nextLine();
        tmp= Tools.readArrInt(line);
        Point end = new Point(tmp[0], tmp[1]);
        int[][] mat=readMat(scanner);
        Ali1 ali1 = new Ali1(mat, start, end);
        int result = ali1.getResult();
        System.out.println(result);

    }

    public static int[][] readMat(Scanner scanner){
        int n=Integer.parseInt(scanner.nextLine());
        int m=Integer.parseInt(scanner.nextLine());
        int[][] mat=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mat[i][j]=scanner.nextInt();
            }
        }
        return mat;
    }

}
