import util.ListNode;
import util.Point;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String args[]){
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
       /* boolean[] a=new boolean[10];
        System.out.println(a[0]);//false*/
        //test7();
        //System.out.println("sdfsd".substring(1,2));
        //test8();
        //test9();
        //String s="ads";System.out.println(s.substring(0,s.length()));
        //Executors.newFixedThreadPool(3);
        new CountDownLatch(1);
    }
    public static void test9(){
        int bits=0;
        int[] A=new int[]{10,2};
        for(int j=0;j<A.length;++j){
            //>>是移位    &是最后一位与运算
            bits+=(A[j]>>0);//依次获取元素的每一位，并将数组元素相同位相加
        }
        int tmp=(1<<3)+(1<<4);
        System.out.println(tmp);
               /* HashMap map=new HashMap();
        map.put("a",1);
        map.get("a");*/
    }
    public static void test8(){
        Set set=new HashSet();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        System.out.println(set.contains("dog"));

    }
    public static  void test7(){
        Point point=new Point(1,1);
        int[][] mat=new int[3][4];
        Point.setMatrix(mat,point,10);
        System.out.println(Point.getMatrix(mat,point));
    }


    public static  void test6(){
        ListNode node =new ListNode(1);
        node.next=node;
        ListNode node1 = ListNode.detectCycle(node);
        System.out.println(node.val);
    }

    public static  void test5(){
        Map<Double,Integer> map=new HashMap<>();
        Integer integer = map.get(3.1);
        System.out.println(integer);
    }

    public static void test4(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(3);
        minHeap.offer(5);
        minHeap.offer(7);
        System.out.println(minHeap.poll());
        System.out.println(minHeap.peek());
        System.out.println(minHeap.peek());

    }

    public static void test3(){
        System.out.println(8&1);//判断二进制最后一位是否为1
    }


    public static void test2(){
        Rectangle a1=new Rectangle(0,2,0,2);
        Rectangle a2=new Rectangle(10,30,-10,20);
        boolean t=Rectangle.isImpact(a1,a2);
        System.out.println(t);
    }
    public static void test1(){
        Test ex = new Test();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    String str = "good";
    char[ ] ch = { 'a' , 'b' , 'c' };
    public void change(String str,char ch[ ]){
        str = "test ok";
        ch[0] = 'g';
    }


}
