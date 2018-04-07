

public class Test {

    public static void main(String args[]){
        //test1();
        //test2();
        test3();
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
