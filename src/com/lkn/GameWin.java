package com.lkn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameWin extends JFrame {

    //展示框宽度
    int width=2*GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH;
    //展示框高度
    int height=4*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH;

    Image huabu=null;
    MapBotton mapBotton=new MapBotton();
    MapTop mapTop=new MapTop();

    //展示框设置
    void launch(){
//        //创建菜单栏
//        JMenuBar menuBar=new JMenuBar();
//        //将菜单栏添加到窗口中
//        this.setJMenuBar(menuBar);
//        //创建菜单
//        JMenu menu=new JMenu("游戏");
//        menuBar.add(menu);
//        //将菜单项添加到菜单中
//        JMenuItem item1=new JMenuItem("TAN");
//        menu.add(item1);
//        menu.addSeparator();
//        JTextField textField = new JTextField("Enter text here");
//        textField.setBounds(50, 50, 150, 30); // 设置文本框的位置和大小
//        this.add(textField); // 将文本框添加到 JFrame




        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setTitle("扫雷");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==1){
                    GameUtil.Mouse_X=e.getX();
                    GameUtil.Mouse_Y=e.getY();
                    GameUtil.LEFT=true;
                    if(GameUtil.Mouse_X>=(GameUtil.OFFSET+GameUtil.MAP_W/2*GameUtil.SQUARE_LENGTH)
                    &&GameUtil.Mouse_X<=(GameUtil.OFFSET+GameUtil.MAP_W/2*GameUtil.SQUARE_LENGTH+GameUtil.SQUARE_LENGTH)
                    &&GameUtil.Mouse_Y>=GameUtil.OFFSET
                    &&GameUtil.Mouse_Y<=GameUtil.OFFSET+GameUtil.SQUARE_LENGTH){
                        mapBotton.regame();
                        GameUtil.state=0;
                        GameUtil.bong_jilu=GameUtil.bong_MAX;
                        GameUtil.LEFT=false;
                    }
                }
                if(e.getButton()==3){
                    GameUtil.Mouse_X=e.getX();
                    GameUtil.Mouse_Y=e.getY();
                    GameUtil.RIGHT=true;
                }
//                repaint();
            }
        });
//        while (GameUtil.x==-100){
//            repaint();
//        }
        //循环
        while (true){
            repaint();
        }

//        JButton jButton=new JButton("@");
//        jButton.setBounds(GameUtil.OFFSET,3*GameUtil.OFFSET,GameUtil.OFFSET+GameUtil.SQUARE_LENGTH,3*GameUtil.OFFSET+GameUtil.SQUARE_LENGTH);
//        jButton.addMouseListener((MouseListener) this);

//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                int x = e.getX(); // 获取鼠标按下的x坐标
//                int y = e.getY(); // 获取鼠标按下的y坐标
//
//                System.out.println("鼠标按下位置：x=" + x + ", y=" + y);
//            }
//        });
    }
    @Override
    public void paint(Graphics g) {
        huabu=this.createImage(width,height);
        Graphics graphics=huabu.getGraphics();
        graphics.setColor(Color.lightGray);
        graphics.fillRect(0,0,width,height);
        mapBotton.paintSelf(graphics);
        mapTop.paintself(graphics);
        g.drawImage(huabu,0,0,null);
    }
    //画笔绘制


    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();

    }
}
