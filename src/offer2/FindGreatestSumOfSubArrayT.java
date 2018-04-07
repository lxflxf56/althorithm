package offer2;

import offer1.Tools;
//连续子数组的最大和
public class FindGreatestSumOfSubArrayT {
    int[] max;
    public int FindGreatestSumOfSubArray(int[] array) {
        max=new int[array.length];
        int sum=array[0];
        max[0]=array[0];
        for (int i=1;i<array.length;i++){
            if (sum>=0){
                sum=sum+array[i];
            }else {
                sum=array[i];
            }

            if (sum>max[i-1]){
                max[i]=sum;
            }else {
                max[i]=max[i-1];
            }
        }

        return max[max.length-1];
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArrayT arrayT=new FindGreatestSumOfSubArrayT();
        arrayT.FindGreatestSumOfSubArray(Tools.readArrInt("6 -3 -2 7 -15 1 2 2"));
    }
}
