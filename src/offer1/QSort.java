package offer1;

public class QSort {
    //快排算法
    private float[] array;

    public void swapArray(int i,int j){
        float tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    public static void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    public static void sort(int [] array){
        sort(array,0,array.length-1);
    }

    public static void sort(int[] array,int start,int end){
        if (start<0||end>array.length||start>=end){
            return;
        }
        int i=start,j=end;
        int k=array[start];
        while (i<j){
            while (i<j&&k<array[j]){
                j--;
            }
            swap(array,i,j);
            while (i<j&&k>array[i]){
                i++;
            }
            swap(array,i,j);
        }
        sort(array,start,i-1);
        sort(array,i+1,end);
    }

    public void sort(int strat,int end){
        int i=strat,j=end,kIndex=strat;
        boolean left=true;
        while(true) {
            if (left) {
                if (array[i] < array[kIndex]) {
                    left = false;
                    swapArray(i, kIndex);
                    kIndex = i;
                }
                i++;

            } else {
                if (array[j] < array[kIndex]) {
                    left = true;
                    swapArray(j, kIndex);
                    kIndex = j;
                }
                j--;
            }
            if(i>j){
                break;
            }

        }
        if (strat==end||kIndex<=strat||kIndex>=end){
            return;
        }
        sort(strat,kIndex-1);
        sort(kIndex+1,end);
    }

    public float[] sort(float[] arrays){
        array=arrays;
        sort(0,arrays.length-1);
        return array;
    }


    public static int[] readArrInt(String str){
        String[] orStr=str.split(" ");
        int [] result=new int[orStr.length];
        for (int i=0;i<result.length;i++){
            result[i]=Integer.parseInt(orStr[i]);
        }
        return result;
    }
    public static float[] readArrFloat(String str){
        String[] orStr=str.split(" ");
        float [] result=new float[orStr.length];
        for (int i=0;i<result.length;i++){
            result[i]=Float.parseFloat(orStr[i]);
        }
        return result;
    }
    public void printArr(){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args) {
        /*
        QSort sort=new QSort();
        float[] tmp=readArrFloat("6 5 3 7 9");
        sort.sort(tmp);
        sort.printArr();*/
        int[] tmp=new int[]{5,4,6,2,1};
        QSort.sort(tmp);
        for (int a:tmp) {
            System.out.println(a);
        }

    }
}
