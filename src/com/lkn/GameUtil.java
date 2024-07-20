package com.lkn;

import java.awt.*;
import java.time.LocalTime;

/*工具类*/
public class GameUtil {
    //数格子
    static int MAP_W = 11;
    //格子数
    static int MAP_H=11;
    //边距
    static int OFFSET=45;
    //格子大小
    static int SQUARE_LENGTH=50;
    //鼠标x
    static int Mouse_X;
    //鼠标Y
    static int Mouse_Y;
    //鼠标位于块x，y坐标
    static int x=-100;
    static int y;
    static boolean LEFT=false;

    static  boolean RIGHT=false;
    static long beginTime=System.currentTimeMillis();
    static long endTime;

    //最大雷数
    static int bong_MAX=15;
    static int bong_jilu=bong_MAX;
    //游戏当前状态，-1失败，0游戏中，1胜利
    static int state=0;
    //底层数组，存放真实情况，-1雷，0无，1-9代表周围雷数
    static int[][]MAP_BOTTON=new int[MAP_W+2][MAP_W+2];

    //顶层数组，存放顶层情况，-1无，0未打开，1插旗，2插错旗
    static int[][]MAP_TOP=new int[MAP_W+2][MAP_W+2];

    //导入图片
    static Image bong=Toolkit.getDefaultToolkit().getImage("imgs/bong.png");
    static Image bg=Toolkit.getDefaultToolkit().getImage("imgs/bg.png");
    static Image[] images=new Image[9];
    static {
        for (int i = 1; i <=8 ; i++) {
            images[i]=Toolkit.getDefaultToolkit().getImage("imgs/num/"+i+".png");
        }
    }
    static Image yuan=Toolkit.getDefaultToolkit().getImage("imgs/yuan.png");
    static Image flag=Toolkit.getDefaultToolkit().getImage("imgs/flag.png");
    static Image over=Toolkit.getDefaultToolkit().getImage("imgs/over.png");
    static Image win=Toolkit.getDefaultToolkit().getImage("imgs/win.png");

    static Image begin=Toolkit.getDefaultToolkit().getImage("imgs/begin.png");
    static Image cuo=Toolkit.getDefaultToolkit().getImage("imgs/cuo.png");
}
