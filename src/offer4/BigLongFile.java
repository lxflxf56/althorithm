package offer4;


import java.io.*;
import java.math.BigDecimal;

public class BigLongFile {
    public static void main(String args[]){
        try  {
            BufferedReader bufferedReader=new BufferedReader(new FileReader("src.txt"));
            String tmpStr=null;
            //double sum=0;
            BigDecimal sum=new BigDecimal(0);
            while ((tmpStr=bufferedReader.readLine())!=null){
               sum=sum.add(new BigDecimal(tmpStr));
            }
            BufferedWriter writer=new BufferedWriter(new FileWriter("out.txt"));
            writer.write(sum.toString());
            bufferedReader.close();
            writer.close();
        }catch (Exception e){

        }


    }
}
