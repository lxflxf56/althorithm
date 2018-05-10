package offer3;

import java.util.ArrayList;
import java.util.Arrays;


public class LastRemainingT {
    public static int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1) return -1;
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i=0;i<n;i++){
            arrayList.add(i);
        }
        int now=m-1;
        while (arrayList.size()>1){
            int index=thisIndex(now,arrayList.size());
            arrayList.remove(index);
            now=index+m-1;
        }
        return arrayList.get(0);
    }

    public static int thisIndex(int now,int n){
        while (now>=n){
            now=now-n;
        }
        return now;
    }

    public static void main(String[] args) {
       int a= LastRemaining_Solution(3,2);
       System.out.println(a);

    }
}
