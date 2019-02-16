package SF;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class sf2 {
    public sf2(){
        Scanner scanner=new Scanner(System.in);
        ArrayList<Info> arrayList=new ArrayList<>();
        while (true){
            String s = scanner.nextLine();
            if (s.equals("end")){
                break;
            }
            String[] split = s.split(" ");
            Info info=new Info();
            info.id=Integer.parseInt(split[0]);
            for (int i=1;i<split.length;i++){
                if (split[i].indexOf("s")!=-1){
                    info.run1=split[i];
                }else if (split[i].indexOf("cm")!=-1){
                    info.jump=split[i];
                }else if (split[i].indexOf("m")!=-1){
                    String[] ms = split[i].split("m");
                    if (ms.length==1){
                        info.ball=Double.parseDouble(ms[0]);
                    }else {
                        info.run8=Double.parseDouble(ms[0]+"."+ms[1]);
                    }
                }
            }
            if (!info.check()){
                System.out.println("ERROR");
            }else {
                arrayList.add(info);
            }

        }



        System.out.println("NO.\t100M\t800M\tJUMP\tBALL");
        arrayList.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.id<o2.id){
                    return -1;
                }else if (o1.id==o2.id){
                    return 0;
                }
                return 1;
            }
        });
        for (Info info:arrayList){
            System.out.print(info.id+"\t");

        }

    }

    public String chekcRun1(String s)
    {
        String[] s1 = s.split("s");
        double a=Double.parseDouble(s1[0]+"."+s1[1]);
        if (a>13){
            return "FAIL";
        }else if (a>12.5){
            return "GOOD";
        }else if (a>12.1){
            return "GOOD";
        }else {
            return "GREAT";
        }
    }
    /*
    public String checkRun8(){

    }
    public String checkJump(){

    }
    public String checkBall(){

    }*/


    public static void main(String[] args) {
        new sf2();
    }
    public class Info{
        Integer id;
        String run1,jump;
        Double ball,run8;
        public boolean check(){
            if (id==null||run1==null||run8==null||jump==null||ball==null){
                return false;
            }
            return true;
        }
    }

}
