package offer1;//用栈实现队列

import java.util.Stack;

public class StackQueue {
    private Stack stack1;
    private Stack stack2;
    public StackQueue(){
        stack1=new Stack();
        stack2=new Stack();
    }

    public void put(int i){
        stack1.push(i);
    }

    private void oneToTwo(){
        int k=stack1.size();
        for(int i=0;i<k;i++){
            stack2.add(stack1.pop());
        }
    }

    public int popInt(){
        if (stack2.size()==0){
            oneToTwo();
        }
        return (int)stack2.pop();
    }

    public static int[] readArrInt(String str){
        String[] orStr=str.split(" ");
       int [] result=new int[orStr.length];
        for (int i=0;i<result.length;i++){
            result[i]=Integer.parseInt(orStr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] tmp=readArrInt("1 2 3 4 5 6");
        StackQueue stackQueue=new StackQueue();
        for (int i=0;i<tmp.length;i++){
            stackQueue.put(tmp[i]);
        }
        for (int i=0;i<tmp.length;i++){
            int a=stackQueue.popInt();
            System.out.print(a+" ");
        }
    }
}
