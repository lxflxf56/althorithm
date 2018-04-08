package offer2;

import java.util.ArrayList;

/*
* 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
* 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
* 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!*/
public class FindContinuousSequenceT {
    int[][] sumT;
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {//动态规划，过多计算,废弃
        ArrayList<ArrayList<Integer>> all=new ArrayList<>();
        if (sum<=1){
            return all;
        }
        sumT=new int[sum][sum];
        sumT[1][1]=1;
        for (int i=2;i<sum;i++){
            sumT[i][1]=sumT[i-1][1]+i;
            for (int j=2;j<=i;j++){
                sumT[i][j]=sumT[i][j-1]+1-j;
            }
        }


        for (int i=1;i<sum;i++){
            for (int j=1;j<=i;j++){
                if (sumT[i][j]==sum){
                    all.add(continuousSequence(i,j));
                }
            }
        }
        return all;
    }


    public ArrayList<Integer> continuousSequence(int e,int f){
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i=f;i<=e;i++){
            arrayList.add(i);
        }
        return arrayList;
    }

    /*
    *small到big序列和小于sum，big++;大于sum，small++;
    *当small增加到(1+sum)/2是停止*/
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {//废弃，麻烦
        ArrayList<ArrayList<Integer>> all=new ArrayList<>();
        //根据数学公式计算:(a1+an)*n/2=s  n=an-a1+1
        /*sumT=new int[sum][sum];
        if (sum<3)
            return all;
        sumT[1][1]=1;
        int j=2;
        for (int i=1;i<(sum+1)/2;i++){
            if (i!=1){
                sumT[i][j]=sumT[i-1][j]+1-i;

            }
            for (;j<(sum+1)/2;j++){
                //sumT[i][j];
                //if (sumT[])
            }
        }
*/
        return all;





    }

    /*
*small到big序列和小于sum，big++;大于sum，small++;
*当small增加到(1+sum)/2是停止*/



    public static void main(String[] args) {
        FindContinuousSequenceT sequenceT=new FindContinuousSequenceT();
        ArrayList<ArrayList<Integer>> arrayList=sequenceT.FindContinuousSequence(100);
        for (ArrayList<Integer> a:arrayList){
            System.out.println(a.toString());
        }


    }

}
