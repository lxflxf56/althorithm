package offer4;

public class MovingCountT {
    int count=0;
    int rows,cols,k;
    boolean[][] flag;
    public int movingCount(int threshold, int rows, int cols)
    {
        this.rows=rows;
        this.cols=cols;
        k=threshold;
        flag=new boolean[rows][cols];
        find(0,0);
        return count;
    }

    void find(int i,int j){
            if (i<0||j<0||j>=cols||i>=rows||flag[i][j]==true||(numSum(i)+numSum(j))>k){
                return;
            }
            count++;
            flag[i][j]=true;
            find(i+1,j);
            find(i-1,j);
            find(i,j+1);
            find(i,j-1);
    }

    int numSum(int num){
        int sum=0;
        while (num>0&&sum<k){
            sum=sum+num%10;
            num=num/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MovingCountT countT=new MovingCountT();
        countT.movingCount(3,4,4);
    }
}
