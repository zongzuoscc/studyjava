package ddz3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {
    //牌盒，只需要把牌和对应序号产生关系即可，不需要按照序号进行排序
    static ArrayList<String> list=new ArrayList<>();
    static HashMap<String,Integer> hm=new HashMap<>();
    static{
        String[] color={"♠","♦","♥","♣"};
        String[] num={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
       for (String n : num) {
           for (String c : color) {
               list.add(c+n);
           }
       }
       list.add(" 小王");
       list.add(" 大王");

       hm.put("J",11);
       hm.put("Q",12);
       hm.put("K",13);
       hm.put("A",14);
       hm.put("2",15);
       hm.put("小王",50);
       hm.put("大王",100);
    }
    public PokerGame(){
        //洗牌
        Collections.shuffle(list);
        //发牌,使用TreeSet的优点，是可以自动排序
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> lord = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            //i表示集合中的每个索引
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
        LookPoker("底牌",lord);
        LookPoker("玩家1",player1);
        LookPoker("玩家2",player2);
        LookPoker("玩家3",player3);
    }

    //利用牌的价值进行排序，参数是集合
    public void order(ArrayList<String> list){
        Collections.sort(list,(String o1,String o2)->{
            String color1=o1.substring(0,1);
            int value1 = getValue(o1);
            String color2=o2.substring(0,1);
            int value2 = getValue(o2);
            int i=value1-value2;
            return i==0?color1.compareTo(color2):i;
        });
    }

    public int getValue(String poker){
        //获取牌上的数据
        String number=poker.substring(1);//这里截取出来的结果，让这个结果再map集合中存在大王，小王
        //判断是否是数字牌
        if(hm.containsKey(number)){
            return hm.get(number);
        }
        else {
            return Integer.parseInt(number);
        }
    }

    public void LookPoker(String name,ArrayList<String> ts){

    }
}