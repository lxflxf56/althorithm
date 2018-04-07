package offer2;

import java.util.ArrayList;
import java.util.Stack;

public class IsPopOrderT {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack1=new Stack<>();
        int j=0;
        for (int i=0;i<pushA.length;i++){
            stack1.add(pushA[i]);
            while (!stack1.empty()&&popA[j]==stack1.peek()){
                j++;
                stack1.pop();
            }
        }
        return stack1.empty();
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        //arr.add()
    }
}
