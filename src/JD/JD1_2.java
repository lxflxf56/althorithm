package JD;



import java.util.Scanner;
import java.util.Stack;

public class JD1_2 {
    public JD1_2(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<n;i++){
            String str=scanner.nextLine();
            //find(str);
            StringBuilder builder=new StringBuilder(str);
            find2(builder);
        }

    }


    public void find(String str){
        if(str.length()%2==1){
            System.out.println("No");
            return;
        }

        StringBuilder builder;
        for (int i=0;i<str.length();i++){
            builder=new StringBuilder(str);
            char c=builder.charAt(i);
            builder.deleteCharAt(i);
            for (int j=0;j<str.length();j++){
                builder.insert(j,c);
                if (isLegal(builder)){
                    System.out.println("Yes");
                    return;
                }
                builder.deleteCharAt(j);
            }

        }
        System.out.println("No");
    }

    public boolean isLegal(StringBuilder str){
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='('){
                stack.add('(');
            }else {
                if (stack.empty())
                    return false;
                stack.pop();
            }
        }
        if (stack.empty()){
            return true;
        }else {
            return false;
        }


    }

    public void find2(StringBuilder str){
        if ("".equals(str.toString())){
            System.out.println("No");
            return;
        }
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='('){
                stack.add('(');
            }else {
                if (stack.empty()){
                    stack.add(')');
                }else if (stack.peek()=='('){
                    stack.pop();
                }else {
                    System.out.println("No");
                    return;
                }
            }
        }
        if (stack.size()==0){
            System.out.println("Yes");
            return;
        }
        if (stack.size()==2){
            char a=stack.pop();
            char b=stack.pop();
            if (a=='('&&b==')'){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
    public static void main(String[] args) {

        JD1_2 jd1_2=new JD1_2();

    }
}
