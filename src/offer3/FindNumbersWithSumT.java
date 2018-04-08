package offer3;

import java.util.ArrayList;
/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，
是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
*/
public class FindNumbersWithSumT {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        int i=0,j=array.length-1;
        while (i<j){
            int tmp=array[i]+array[j];
            if (tmp==sum){
                arrayList.add(array[i]);
                arrayList.add(array[j]);
                return arrayList;
            }
            if (tmp<sum){
                i++;
            }else {
                j--;
            }

        }
        return arrayList;
    }
}
