package offer2;

import offer1.Tools;

/*在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
即输出P%1000000007

思路：归并求逆序
*/
public class InversePairsT {
    int sum=0;
    int[] array;
    public int InversePairs(int [] array) {
        this.array=array;
        sort(0,array.length-1);
        return sum;
    }

    public void sort(int low,int high){

        if (low<high){
            int mid=(high+low)/2;
            sort(low,mid);
            sort(mid+1,high);
            merge(low,mid,high);
        }
    }

    public void merge(int low,int mid,int high){
        int[] tmp=new int[high-low+1];
        int now=0;
        int i=low,j=mid+1;
        while (i<=mid&&j<=high){
            if (array[i]<array[j]){
                tmp[now]=array[i];
                i++;
            }else {
                tmp[now]=array[j];
                j++;
                sum=sum+mid-i+1;
                sum=sum%1000000007;
            }
            now++;
        }

        while (i<=mid){
            tmp[now]=array[i];
            i++;
            now++;
        }
        while (j<=high){
            tmp[now]=array[j];
            j++;
            now++;

        }

        for (int k=0;k<tmp.length;k++){
            array[low+k]=tmp[k];
        }

    }



    public static void main(String[] args) {
        InversePairsT pairsT=new InversePairsT();
        pairsT.InversePairs(Tools.readArrInt("1 2 0"));
    }
}
