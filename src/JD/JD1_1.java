package JD;

import java.util.Scanner;

public class JD1_1 {
    public JD1_1(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        find(str);
    }

    int sum=0;
    StringBuilder builder;
    StringBuilder builder2;
    public void find(String str){
        builder=new StringBuilder(str);
        builder2=new StringBuilder();
        addchar(builder2,0);
        System.out.println(sum);

    }

    /*
    public void addchar(String str,int index){
        isLegal(str);
        for (int i=index;i<builder.length();i++){
            addchar(str+builder.charAt(i),i+1);
        }

    }*/

    public void addchar(StringBuilder str,int index){
        isLegal(str.toString());
        for (int i=index;i<builder.length();i++){
            str.append(builder.charAt(i));
            addchar(str,i+1);
            str.deleteCharAt(str.length()-1);
        }
    }


    public boolean isLegal(String str){
        if ("".equals(str)){
            return false;
        }
        StringBuilder stringBuilder=new StringBuilder(str);
        stringBuilder.reverse();
        if (str.equals(stringBuilder.toString())){
            sum++;
            return true;

        }
        return false;
    }





    public static void main(String[] args) {
        JD1_1 jd1_1=new JD1_1();
    }
}
