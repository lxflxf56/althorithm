package offer2;

import offer1.Tools;

//统计一个数字在排序数组中出现的次数。
public class GetNumberOfKT {
    public static int GetNumberOfK1(int [] array , int k) {
        boolean find=false;
        int sum=0;
        for (int i=0;i<array.length;i++){
            if (!find){
                if (array[i]==k){
                    find=true;
                    sum++;
                }
            }else {
                if (array[i]==k){
                    sum++;
                }else {
                    break;
                }
            }

        }
        return sum;
    }

    public static int GetNumberOfK(int [] array , int k) {//二分法
        int high=array.length-1;
        int low=0;
        boolean find=false;
        int sum=0;
        int mid=0;
        while (low<=high){
            mid=(low+high)/2;
            if (array[mid]==k){
                find=true;
                sum++;
                break;
            }
            if (array[mid]<k){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }

        if (find){
            int index=mid+1;
            while (index<=high&&array[index]==k){
                sum++;
                index++;
            }
            index=mid-1;
            while (low<=index&&array[index]==k){
                sum++;
                index--;
            }

        }
        return sum;



    }


    public static void main(String[] args) {
        GetNumberOfK(Tools.readArrInt("1 3 5 7 9 11 11"),1);
    }
}
