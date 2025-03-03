package com.cumt.ui;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener , ActionListener {
    //二维数组写在外面的原因是，多个方法要用到，所以写在外面
    int[][] data = new int[4][4];//用来管理数据，加载图片的时候会根据二维数组中的数据进行加载
    //记录空白方块在二维数组中的位置
    int x=0;
    int y=0;
    String path="C:\\Users\\26515\\Desktop\\learnjava\\studyjava\\puzzle_game\\image\\picture1\\";
    //定义一个二维数组来存储正确数据
    int[][] win = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    //用来统计步数
    int step=0;

    //创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");

    public GameJFrame(){//构造方法
        initJFrame();//初始化界面
        initJMenuBar();//初始化菜单
        initData();//初始化数据
        initImage();//初始化图片
        this.setVisible(true);//  设置界面可见，建议写在最后
    }

    //初始化数据（打乱顺序功能）
    private void initData() {
        //需求，把一位数组中的数据打乱顺序，然后再按照四个一组的顺序添加到二维数组中去
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //打乱顺序
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);

            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        //按照四个一组的顺序添加到二维数组中去
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                x=i/4;
                y=i%4;
            }
            //注意，自己在书写代码时使用arraycopy的方法导致图片加载出错，应该一张一张进行加载才不会出错
            data[i/4][i%4] = arr[i];

        }
    }

    private void initImage() {
        //清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        //判断是否胜利
        if(victory()){
            //加载胜利图片
            ImageIcon icon = new ImageIcon("C:\\Users\\26515\\Desktop\\learnjava\\studyjava\\puzzle_game\\image\\win.png");
            JLabel win = new JLabel(icon);
            win.setBounds(100, 100, icon.getIconWidth(), icon.getIconHeight());
            this.getContentPane().add(win);
            //弹出一个对话框
//            JOptionPane.showMessageDialog(this,"恭喜你，拼图成功！");
//            //重新加载图片
//            initData();
//            initImage();
            //return;//这个ruturn坏事了
        }

        JLabel stepCount = new JLabel("步数："+step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);


        //添加图片的时候按照二维数组中的数据进行添加图片
        int imageWidth = 116;
        int imageHeight = 116;
        //加载图片
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int index=data[i][j];//获取当前要加载图片的序号
                ImageIcon icon = new ImageIcon(path+index +".png");
                JLabel jLabel = new JLabel(icon);
                //设置图片的位置
                jLabel.setBounds(j * imageWidth+63, i * imageHeight+134, imageWidth, imageHeight);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(0));
                //把图片添加到界面当中
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        ImageIcon bg = new ImageIcon("C:\\Users\\26515\\Desktop\\learnjava\\studyjava\\puzzle_game\\image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
        //把背景图片添加到界面当中
        this.getContentPane().add(background);
        //注意：先加载的图片在界面上方，后加载的图片在界面下方
        //刷新界面
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        //初始化菜单
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上面两个选项的对象（功能，关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //将条目添加到菜单上
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //给条目添加点击事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        //给整个界面添加键盘监听事件
        //this.addKeyListener(this);//这里多给界面添加了一个键盘监听事件导致虽然按下了一次按键，但是会造成按下两次的效果

        //将菜单添加到菜单条上
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //将菜单条添加到界面上
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603,680);//单位是像素 ，界面默认是隐藏的
        this.setTitle("拼图单机版v1.0");//设置标题
        this.setAlwaysOnTop(true);//设置界面置顶
        this.setLocationRelativeTo(null);//设置界面居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭模式
        //取消默认的居中放置
        this.setLayout(null);
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下不松时会调用这个方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code==65){
            //把界面中所有的图片删除
            this.getContentPane().removeAll();
            //加载第一张完整的图片
            ImageIcon icon = new ImageIcon(path+"all.jpg");
            JLabel all = new JLabel(icon);
            all.setBounds(63, 134, icon.getIconWidth(), icon.getIconHeight());
            this.getContentPane().add(all);//把图片添加到界面当中
            //加载背景图片
            ImageIcon bg = new ImageIcon("C:\\Users\\26515\\Desktop\\learnjava\\studyjava\\puzzle_game\\image\\background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
            //把背景图片添加到界面当中
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，如果胜利，此方法需要结束，不能再执行下面的移动代码了
        if(victory()){
            return;
        }
        //对上下左右进行判断
        //左37，上38，右39，下40
        int code = e.getKeyCode();
        if(code==37){

            //判断是否可以移动
            if(y==3){
                return;
            }
            System.out.println("向左移动");
            //交换位置
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
            step++;
            //重新加载图片
            initImage();
        }
        else if(code==38){
            System.out.println("向上移动");
            //判断是否可以移动
            if(x==3){
                return;
            }
            //交换位置
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            step++;
            //重新加载图片
            initImage();
        }
        else if(code==39){
            System.out.println("向右移动"); //判断是否可以移动
            if(y==0){
                return;
            }    //交换位置
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            step++;
            //重新加载图片
            initImage();
        }
        else if(code==40){
            System.out.println("向下移动");
            //判断是否可以移动
            if(x==0){
                return;
            }
            //交换位置
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            step++;
            //重新加载图片
            initImage();
        }
        else if(code==65){
            //重新加载图片
            initImage();
        }
        else if(code==87){
            //实现自动复原拼图功能
            data=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();
        }
    }

    public boolean victory(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(data[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取到被点击的条目对象
        Object obj = e.getSource();
        //判断当前点击的是谁
        if(obj==replayItem){
            System.out.println("重新游戏");
            //再次打乱二维数组中的数据
            initData();
            //把步数清零
            step=0;
            //重新加载图片
            initImage();
        }

        else if(obj==reLoginItem){
            System.out.println("重新登录");
            //关闭当前游戏界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        }
        else if(obj==closeItem){
            System.out.println("关闭游戏");
            //关闭当前游戏界面
            System.exit(0); //关闭虚拟机
        }
        else if(obj==accountItem){
            System.out.println("公众号");
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("C:\\Users\\26515\\Desktop\\learnjava\\studyjava\\puzzle_game\\image\\account.png"));
            jLabel.setBounds(0,0,258,258);  //设置图片的位置
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344,344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            jDialog.setVisible(true);//让弹框可见
        }

    }
}
