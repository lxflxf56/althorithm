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
    //byte 8位转int
    public static int byte4ArrayToInt(byte[] b) {
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }
    public static byte[] intToByte4Array(int a) {
        return new byte[] {
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }
    //32位
    public static byte[] intToByte32(int num) {
        byte[] arr = new byte[32];
        for (int i = 31; i >= 0; i--) {
            // &1 也可以改为num&0x01,表示取最地位数字.
            arr[i] = (byte) (num & 1);
            // 右移一位.
            num >>= 1;
        }
        return arr;
    }
    public static int byte32ToInt(byte[] arr) {
        if (arr == null || arr.length != 32) {
            throw new IllegalArgumentException("byte数组必须不为空,并且长度是32!");
        }
        int sum = 0;
        for (int i = 0; i < 32; ++i) {
            sum |= (arr[i] << (31 - i));
        }
        return sum;
    }

    public static long byte64ToLong(byte[] arr) {
        if (arr == null || arr.length != 64) {
            throw new IllegalArgumentException("byte数组必须不为空,并且长度是64!");
        }
        long sum = 0L;
        for (int i = 0; i < 64; ++i) {
            sum |= ((long) arr[i] << (63 - i));
        }
        return sum;
    }
    public static byte[] longToByte64(long sum) {
        byte[] arr = new byte[64];
        for (int i = 63; i >= 0; i--) {
            arr[i] = (byte) (sum & 1);
            sum >>= 1;
        }
        return arr;
    }



    public static int[] readArrInt(String str,String sp){
        String[] orStr=str.split(sp);
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
