package Webank;

import java.util.Scanner;

public class Main2 {
    /*
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] nums=new int[6];
        for (int i=0;i<6;i++){
            nums[i]=scanner.nextInt();
        }
        int sum=0;
        for (int i=5;i>=0;i--){
            if (i==5){//6
                sum+=nums[5];
            }else if (i==4){//5
                sum+=nums[4];
                nums[0]=nums[0]-11*nums[4];
                if (nums[0]<0){
                    nums[0]=0;
                }
            }else if (i==3){//4
                /*
                while (nums[3]>0){
                    sum+=;
                    nums[3]--;
                    if (nums[1]>=5){
                        nums[1]-=5;
                    }else if (nums[1]>0){
                        nums[0]-=4*nums[1];
                        nums[1]=0;
                    }else if (nums[0]>0){
                        nums[0]-=20;
                    }else if (nums[0]<=0&&nums[1]<=0){
                        sum+=nums[3];
                        break;
                    }
                }*//*
                sum+=nums[3];
                while (nums[1]>0&&nums[3]>0){
                    nums[3]--;
                    nums[1]-=5;
                }
                while (nums[0]>0&&nums[3]>0){
                    nums[3]--;
                    nums[0]-=20;
                }
            }else if (i==2){//3
                while (nums[2]>0){
                    if (nums[2]>=4){
                        int div=nums[2]/4;
                        sum+=div;
                        nums[2]=nums[2]%4;
                    }else if (nums[2]>0){

                        sum++;
                        int sub=36-nums[2]*9;
                        while (nums[1]>0&&sub>0){
                            nums[i]--;
                            sub-=4;
                        }
                        if (sub>0){
                            nums[0]-=sub;
                        }
                        break;
                        /*
                        int sub=4-nums[2];
                        if (nums[1]>0){
                            if (sub==3){
                                if (nums[1]>=5){
                                    nums[1]-=5;
                                }else {
                                    nums[0]-=(27-nums[1]*4);
                                    nums[1]=0;
                                }
                            }else if (sub==2){
                                if (nums[1]>=3){
                                    nums[1]-=3;
                                }else {
                                    nums[0]-=(18-nums[1]*4);
                                    nums[1]=0;
                                }
                            }else {
                                if (nums[1]>=1){
                                    nums[0]-=(9-nums[1]*4);
                                }else {
                                    nums[1]=0;
                                    nums[0]-=4;
                                }
                            }
                        }
                    }
                }
            }else if (i==1){//2
                while (nums[1]>0){
                    if (nums[1]>9){
                        int div=nums[1]/9;
                        sum+=div;
                        nums[1]=nums[1]%9;
                    }else if (nums[1]>0){
                        sum++;
                        int sub=36-nums[1]*4;
                        nums[0]-=sub;
                        nums[1]=0;
                    }
                }
            }else if (i==0){//1
                if (nums[0]>0){
                    sum+=(nums[0]/36+1);
                }
            }
        }
      System.out.print(sum);
    }*/
}
