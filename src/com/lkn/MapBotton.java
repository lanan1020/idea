package com.lkn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.ValueRange;

/*游戏绘制*/
public class MapBotton {
    BongBotton bongBotton=new BongBotton();
    NumBotton numBotton=new NumBotton();
    {
        bongBotton.reset();
        numBotton.reset();
    }

    //重置游戏
    void regame(){
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                GameUtil.MAP_TOP[i][j]=0;
            }
        }
        bongBotton.reset();
        numBotton.reset();
        GameUtil.beginTime=System.currentTimeMillis();
    }
    //绘制
    void paintSelf(Graphics g){
//        for (int i = 0; i < 500; i=i+50) {
//            g.setColor(Color.red);
//            g.drawLine(0,i,500,i);
//            g.drawLine(i,0,i,500);
//        }
        //格子框颜色
        g.setColor(Color.white);
        //绘制竖线
        for (int i = 0; i < GameUtil.MAP_W; i++) {
            g.drawLine(GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH,3*GameUtil.OFFSET,
                    GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH,3*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH);
        }

        //绘制横线
        for (int i = 0; i < GameUtil.MAP_H; i++) {
            g.drawLine(GameUtil.OFFSET,3*GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH,
                    GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH,3*GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH);
        }
        //绘制雷，无，数字
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                if(GameUtil.MAP_BOTTON[i][j]==-1){
                    g.drawImage(GameUtil.bong,
                            GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                            3*GameUtil.OFFSET+(j-1)*GameUtil.SQUARE_LENGTH+1,
                            GameUtil.SQUARE_LENGTH-2,
                            GameUtil.SQUARE_LENGTH-2,
                            null);
                } else if (GameUtil.MAP_BOTTON[i][j]==0) {
                    g.drawImage(GameUtil.bg,
                            GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                            3*GameUtil.OFFSET+(j-1)*GameUtil.SQUARE_LENGTH+1,
                            GameUtil.SQUARE_LENGTH-2,
                            GameUtil.SQUARE_LENGTH-2,
                            null);
                } else {
                    g.drawImage(GameUtil.images[GameUtil.MAP_BOTTON[i][j]],
                            GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                            3*GameUtil.OFFSET+(j-1)*GameUtil.SQUARE_LENGTH+1,
                            GameUtil.SQUARE_LENGTH-2,
                            GameUtil.SQUARE_LENGTH-2,
                            null);
                }
            }
        }
        if(GameUtil.state==-1){
            g.drawImage(GameUtil.over,
                    GameUtil.OFFSET+GameUtil.MAP_W/2*GameUtil.SQUARE_LENGTH,
                    GameUtil.OFFSET,
                    GameUtil.SQUARE_LENGTH,
                    GameUtil.SQUARE_LENGTH,
                    null);
        }else if(GameUtil.state==0){
            g.drawImage(GameUtil.begin,
                    GameUtil.OFFSET+GameUtil.MAP_W/2*GameUtil.SQUARE_LENGTH,
                    GameUtil.OFFSET,
                    GameUtil.SQUARE_LENGTH,
                    GameUtil.SQUARE_LENGTH,
                    null);
        }else{
            g.drawImage(GameUtil.win,
                    GameUtil.OFFSET+GameUtil.MAP_W/2*GameUtil.SQUARE_LENGTH,
                    GameUtil.OFFSET,
                    GameUtil.SQUARE_LENGTH,
                    GameUtil.SQUARE_LENGTH,
                    null);
        }
//        {
//            //计时器
//            Timer timer = new Timer(1000, new ActionListener() {
//                int time = 0;
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    time++;
//                }
//            });
//            timer.start();
            //写雷的数量
        g.setColor(Color.red);
        g.setFont(new Font("方正粗黑宋简体", Font.BOLD, 30));
        g.drawString(" "+GameUtil.bong_jilu, GameUtil.OFFSET, 2*GameUtil.OFFSET);
        //记录时间
        if(GameUtil.state==0){
            GameUtil.endTime=System.currentTimeMillis();
        }
        g.setColor(Color.red);
        g.setFont(new Font("方正粗黑宋简体", Font.BOLD, 30));
        g.drawString(" "+(GameUtil.endTime-GameUtil.beginTime)/1000, GameUtil.OFFSET+(GameUtil.MAP_W-1)*GameUtil.SQUARE_LENGTH, 2*GameUtil.OFFSET);
    }

}
