package offer1;//求A的B次的后三位

public class Pow3 {

    private static int findback3(int num){
        return num%1000;
    }

    public static int pow(int num,int n){
        if (n==0){
            return 1;
        }

        int sum=1;
        num=findback3(num);
        for (int i=1;i<=n;i++){
            sum=findback3(sum);
            sum=num*sum;
        }
        return findback3(sum);
    }

    public static void main(String[] args) {
        System.out.print(pow(111,101));
    }
}
