package ddz2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {
    //牌盒，只需要把牌和对应序号产生关系即可，不需要按照序号进行排序
    static HashMap<Integer,String> hm=new HashMap<>();
    static ArrayList<Integer> list=new ArrayList<>();

    static{
        String[] color={"♠","♦","♥","♣"};
        String[] num={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //牌的序号
        int serialNumber=1;
        for (String n : num) {
            //依次表示每一个花色
            for (String c : color) {
                //依次表示每一个数字
                hm.put(serialNumber,c+n);
                list.add(serialNumber);
                serialNumber++;
            }
        }
        //添加大小王
        hm.put(serialNumber,"小王");
        list.add(serialNumber);
        serialNumber++;
        hm.put(serialNumber,"大王");
        list.add(serialNumber);
    }
    public PokerGame(){
        //洗牌
        Collections.shuffle(list);
        //发牌,使用TreeSet的优点，是可以自动排序
        TreeSet <Integer>  player1=new TreeSet<>();
        TreeSet <Integer>  player2=new TreeSet<>();
        TreeSet <Integer>  player3=new TreeSet<>();
        TreeSet <Integer>  lord=new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            //i表示集合中的每个索引
            Integer serialNumber = list.get(i);
            if(i<=2){
                lord.add(serialNumber);
                continue;
            }

            if(i%3==0){
                player1.add(serialNumber);
            }
            else if(i%3==1){
                player2.add(serialNumber);
            }
            else {
                player3.add(serialNumber);
            }

        }
        //看牌
        LookPoker("底牌",lord);
        LookPoker("玩家1",player1);
        LookPoker("玩家2",player2);
        LookPoker("玩家3",player3);
    }
    public void LookPoker(String name,TreeSet<Integer> ts){
        //遍历集合，获取每一个序号，通过序号获取对应的牌面
        //再拿着序号到map集合中找
        System.out.println(name+"：");
        for (Integer serialNumber : ts) {
            String poker = hm.get(serialNumber);
            System.out.print(poker+" ");
        }
        System.out.println();
    }
}
