package offer2;

import offer1.Tools;

//归并排序
public class MergeSort {
    int[] array;

    public int[] sort(int[] array){
        this.array=array;

        sort(0,array.length-1);
        return array;

    }
    public void sort(int low,int high){

        int mid=(low+high)/2;
        if (low<high){
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
            }
            now++;
        }

        while (i<=mid){
            tmp[now]=array[i];
            now++;
            i++;
        }
        while (j<=high){
            tmp[now]=array[j];
            now++;
            j++;
        }
        for (int k=0;k<tmp.length;k++){
            array[low+k]=tmp[k];
        }
    }


    public static void main(String[] args) {
        MergeSort sort=new MergeSort();
        sort.sort(Tools.readArrInt("1 5 3 4 6 -1"));
    }
}
