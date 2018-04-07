package offer1;

//最长公共子序列
public class LCS {
    int [][] sum;
    StringBuilder builder1;
    StringBuilder builder2;
    int length1,length2;
    public void setBuilder(String str1,String str2){
        builder1=new StringBuilder(str1);
        builder2=new StringBuilder(str2);
        length1=builder1.length();
        length2=builder2.length();
        sum=new int[length1+1][length2+1];
    }

    public int max(int a,int b){
        if (a>=b){
            return a;
        }
        return b;
    }

    public int compute(){
        for (int i=1;i<=length1;i++){
            for (int j=1;j<=length2;j++){
                char c1=builder1.charAt(i-1);
                char c2=builder2.charAt(j-1);
                if (c1==c2){
                    sum[i][j]=sum[i-1][j-1]+1;
                }else {
                    sum[i][j]=max(sum[i-1][j],sum[i][j-1]);
                }
            }
        }
        return sum[builder1.length()][builder2.length()];
    }





    public static void main(String[] args) {
        //StringBuilder stringBuilder=new StringBuilder("asd");
        //System.out.println(stringBuilder.charAt(0));
        LCS lcs=new LCS();
        lcs.setBuilder("1357","1351");
        int a=lcs.compute();
        System.out.println(a);
    }
}
