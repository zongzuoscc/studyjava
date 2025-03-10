package ddz1;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {
    static ArrayList<String> list = new ArrayList<>();
    //准备牌，回忆知识点，静态代码块
    //特点：随着类的加载而加载，只加载一次      静态代码块优先于构造方法执行
    static {
        String[] nums = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors = {"♠","♥","♣","♦"};
        //牌盒

        for (String c : colors) {
            for (String n : nums) {
                list.add(c+n);
            }
        }
        list.add("小王");
        list.add("大王");

    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(list);
        //发牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> lord = new ArrayList<>();
        //遍历牌盒得到每一张牌
        for (int i = 0; i < list.size(); i++) {
            //i就是索引
            String poker = list.get(i);
            if(i<=2){
                lord.add(poker);
                continue;
            }
            if(i%3==0){
                player1.add(poker);
            }
            else if(i%3==1){
                player2.add(poker);
            }
            else {
                player3.add(poker);
            }

        }
        //看牌
        lookPoker("玩家1",player1);
        lookPoker("玩家2",player2);
        lookPoker("玩家3",player3);
        lookPoker("底牌",lord);
    }
    public void lookPoker(String name,ArrayList<String> list){
        System.out.print(name+"：");
        for (String poker : list) {
            System.out.print(poker+" ");
        }
        System.out.println();
    }
}
