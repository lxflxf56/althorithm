package WY;

import java.util.Scanner;

public class Tools {
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

    public static int[] swap(int [] arrays,int i,int j){
        int tmp=arrays[i];
        arrays[i]=arrays[j];
        arrays[j]=tmp;
        return arrays;
    }


    public static int[][] readLineInt(int n,int m){
        Scanner scanner=new Scanner(System.in);
        int [][] arr=new int[n][m];

        for (int i=0;i<n;i++){
            String str=scanner.nextLine();
            int[] tmp=readArrInt(str);
            arr[i]=tmp;
        }
        return arr;

    }

    public static int readInt(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }

}
