package com.lkn;

import com.lkn.GameUtil;

import java.awt.*;

/*绘制顶层*/
public class MapTop {

    //胜利
    boolean victory(){
        int sum=0;
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                if(GameUtil.MAP_TOP[i][j]!=-1){
                    sum++;
                }
            }
        }
        if(sum==GameUtil.bong_MAX){
            System.out.println("victory");
            GameUtil.state=1;
            return true;
        }
        return false;
    }
    //展开所有雷
    void openall(){
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                if(GameUtil.MAP_BOTTON[i][j]==-1&&GameUtil.MAP_TOP[i][j]!=1){
                    GameUtil.MAP_TOP[i][j]=-1;
                }
                if(GameUtil.MAP_BOTTON[i][j]!=-1&&GameUtil.MAP_TOP[i][j]==1){
                    GameUtil.MAP_TOP[i][j]=2;
                }
            }
        }
    }

    //失败
    boolean gameover(int xx,int yy){
        if(GameUtil.MAP_BOTTON[xx][yy]==-1){
            System.out.println("over");
            openall();
            GameUtil.state=-1;
            return true;
        }
        return false;
    }
    //递归展开
    void digui(int xx,int yy){
        if(xx>=1&&xx<=GameUtil.MAP_W&&yy>=1&&yy<=GameUtil.MAP_H){
            if(GameUtil.MAP_BOTTON[xx][yy]==0){
                for (int i = xx-1; i <=xx+1 ; i++) {
                    for (int j = yy-1; j <=yy+1 ; j++) {
                        if(GameUtil.MAP_TOP[i][j]==0){
                            GameUtil.MAP_TOP[i][j]=-1;
                            digui(i,j);
                        }
                    }
                }
            }
        }
    }

    //鼠标点击格子事件
    void panduan(){
        if(GameUtil.Mouse_X>GameUtil.OFFSET&&GameUtil.Mouse_Y>3*GameUtil.OFFSET){
            GameUtil.x=(GameUtil.Mouse_X-GameUtil.OFFSET)/GameUtil.SQUARE_LENGTH+1;
            GameUtil.y=(GameUtil.Mouse_Y-3*GameUtil.OFFSET)/GameUtil.SQUARE_LENGTH+1;
        }
        if(GameUtil.LEFT){
            GameUtil.LEFT=false;
            if(GameUtil.x>=1&&GameUtil.x<= GameUtil.MAP_W&&GameUtil.y>=1&&GameUtil.y<= GameUtil.MAP_H){
                if(GameUtil.MAP_TOP[GameUtil.x][GameUtil.y]==0){
                    GameUtil.MAP_TOP[GameUtil.x][GameUtil.y]=-1;
                    if( GameUtil.MAP_BOTTON[GameUtil.x][GameUtil.y]==0){
                        digui(GameUtil.x,GameUtil.y);
                    }
                    gameover(GameUtil.x,GameUtil.y);
                    victory();
//                    if(GameUtil.MAP_BOTTON[GameUtil.x][GameUtil.y]==-1){
//                        BongBotton bongBotton=new BongBotton();
//                        NumBotton numBotton=new NumBotton();
//                    }
                }
            }
        }
        if(GameUtil.RIGHT){
            GameUtil.RIGHT=false;
            if(GameUtil.x>=1&&GameUtil.x<= GameUtil.MAP_W&&GameUtil.y>=1&&GameUtil.y<= GameUtil.MAP_H){
                if(GameUtil.MAP_TOP[GameUtil.x][GameUtil.y]==0&&GameUtil.bong_jilu>0){
                    GameUtil.MAP_TOP[GameUtil.x][GameUtil.y]=1;
                    GameUtil.bong_jilu--;
                }else if(GameUtil.MAP_TOP[GameUtil.x][GameUtil.y]==1){
                    GameUtil.MAP_TOP[GameUtil.x][GameUtil.y]=0;
                    GameUtil.bong_jilu++;
                }
                System.out.println(GameUtil.bong_jilu);
            }
        }

    }

    //绘制
    void paintself(Graphics g)
    {
        panduan();
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                if(GameUtil.MAP_TOP[i][j]==0){
                    g.drawImage(GameUtil.yuan,
                            GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH,
                            3*GameUtil.OFFSET+(j-1)*GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            null);
                } else if (GameUtil.MAP_TOP[i][j]==1) {
                    g.drawImage(GameUtil.flag,
                            GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH,
                            3*GameUtil.OFFSET+(j-1)*GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            null);
                } else if(GameUtil.MAP_TOP[i][j]==2){
                    g.drawImage(GameUtil.cuo,
                            GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH,
                            3*GameUtil.OFFSET+(j-1)*GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            null);
                }
            }
        }
    }
}
