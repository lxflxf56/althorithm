package offer1;//从一组数中找出和为sum的三个数（leetcode原题，先sort再找，并且剪枝）

import java.util.ArrayList;
import java.util.Arrays;

public class Sum3 {
    int [] orginNums;
    ArrayList<Integer> arrayList;
    int sum;
    public Sum3(int [] nums, int sum){
        orginNums=nums;
        this.sum=sum;
        arrayList=new ArrayList();
    }

    private boolean findNum(int i,int j){
        int tmp=sum-orginNums[i]-orginNums[j];
        for (int k=orginNums.length-1;k>j;k--){
            if (tmp==orginNums[k]){
                arrayList.clear();
                arrayList.add(orginNums[i]);
                arrayList.add(orginNums[j]);
                arrayList.add(tmp);
                return true;
            }
        }

        return false;
    }

    public boolean findSum3(){
        Arrays.sort(orginNums);
        for (int i=0;i<orginNums.length-2;i++){
            for (int j=i+1;j<orginNums.length;j++){
                if (findNum(i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public void print(){
        for (int tmp:arrayList){
            System.out.print(tmp+" ");
        }
    }

    public static void main(String[] args) {
            int[] tmp= StackQueue.readArrInt("1 3 5");
            Sum3 sum3=new Sum3(tmp,9);
            if (sum3.findSum3()){
                sum3.print();
            }else {
                System.out.print("No found");
            }
    }
}
