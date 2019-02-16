package WY.WYTest;

import WY.Tools;

import java.util.Scanner;

public class WY1_1 {



    public static void compute(int[] inputArr){
        int head = 0;
        int tail = inputArr.length - 1;
        int times = 0;
        while(head < tail){
            if(inputArr[head] > inputArr[tail]){
                inputArr[--tail] += inputArr[tail + 1];
                times++;
            }else if(inputArr[head] < inputArr[tail]){
                inputArr[++head] += inputArr[head - 1];
                times++;
            }else{
                head++;
                tail--;
            }
        }
        System.out.println(times);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //int n = scanner.nextInt();
        int[] arr= Tools.readArrInt(scanner.nextLine());
        WY1_1.compute(arr);
    }
}
