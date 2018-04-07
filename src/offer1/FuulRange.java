package offer1;

import java.util.ArrayList;

public class FuulRange {
    //全排列算法
    private float[] orginArray;
    private int len;
    public ArrayList<float[]> result;
    private boolean isSwap(int index){//如果后面有与其相同的数则不交换


        for(int i=index+1;i<len;i++){
            if (orginArray[index]==orginArray[i]){
                return false;
            }
        }
        return true;
    }
    private float[] swap(float[] array,int i,int j){
        float tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
        return array;
    }
    private void permutation(float [] array,int index){
        if (index==len-1){
            float[] tmp=array.clone();
            result.add(tmp);
            return;
        }
        for (int i=index;i<len;i++){
            if (isSwap(i)){
                float[] tmpArr=swap(array,index,i);
                permutation(tmpArr,index+1);
            }

        }

    }
    public FuulRange(float[] array){
        result=new ArrayList<float[]>();
        orginArray=array;
        len=array.length;
        permutation(array,0);
    }
    public void printResult(){
        for (float[] tmp:result){
            for (float tmpF:tmp){
                System.out.print(tmpF+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        float[] tmp= QSort.readArrFloat("1 1 2");
        FuulRange fuulRange=new FuulRange(tmp);
        fuulRange.printResult();
    }
}
