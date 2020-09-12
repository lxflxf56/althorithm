package leetcode.everyday;

import java.util.*;

/**
 * @program: althorithm
 * @description: https://leetcode-cn.com/problems/number-of-ways-to-wear-different-hats-to-each-other/
 * @author: Xiaofeng
 * @create: 2020-08-13
 */
public class NumberWays_1434 {
    public int numberWays(List<List<Integer>> hats) {
        Long sum=1L;
        for (List list:hats){
            sum=sum*list.size();
        }
        Long result=new Long(sum);
//        Set<Pair<Integer,Integer>> set=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<hats.size();i++){
            List<Integer> list1 = hats.get(i);
            for (int a:list1){
                for (int j=i+1;j<hats.size();j++){
                    List<Integer> list2 = hats.get(j);
                    for (int b:list2){
                        if (a==b){
//                            set.add(new Pair(i,j));
//                            System.out.println(i+"-"+j+","+a);
                            Integer orDefault = map.get(a);
                            if (orDefault==null){
                                map.put(a,0);
                            }else {


                            }

                            long l = sum / (list1.size() * list2.size());
                            result=result-l;
                        }
                    }
                }
            }
        }
//        for (Pair<Integer,Integer> pair:set){
//            long l = sum / (hats.get(pair.getKey()).size() * hats.get(pair.getValue()).size());
//            result=result-l;
//        }
        for (Integer integer:map.values()){
            result=result+integer;
        }
        return result.intValue();
    }

    public static void main(String[] args){
        List<List<Integer>> ints=new ArrayList<>();
        ints.add(Arrays.asList(1,2,3,4));
        ints.add(Arrays.asList(1,2,3,4));
        ints.add(Arrays.asList(1,2,3,4));
        ints.add(Arrays.asList(1,2,3,4));
        System.out.println(new NumberWays_1434().numberWays(ints));
    }
}
