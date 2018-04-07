package offer1;//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
// 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
import java.util.ArrayList;

public class ClockwisePrintingMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        ArrayList<Integer> arrayList=new ArrayList<>();
        int circleNum;
        int a=(n-1)/2+1,b=(m-1)/2+1;

        if (a<b){
            circleNum=a;
        }else {
            circleNum=b;
        }
        for (int i=0;i<circleNum;i++){
            for (int j=i;j<m-i;j++){//横
                arrayList.add(matrix[i][j]);
            }

            for (int j=i+1;j<n-i;j++){//竖
                arrayList.add(matrix[j][m-i-1]);
            }

            for (int j=m-i-2;(j>=i)&&(n-i-1!=i);j--){//回横
                arrayList.add(matrix[n-i-1][j]);
            }

            for (int j=n-i-2;(j>=i+1)&&(m-i-1!=i);j--){//回竖
                arrayList.add(matrix[j][i]);
            }

        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[][] arr= Tools.readLineInt(5,1);
        ClockwisePrintingMatrix matrix=new ClockwisePrintingMatrix();
        System.out.println(matrix.printMatrix(arr));
    }
}
