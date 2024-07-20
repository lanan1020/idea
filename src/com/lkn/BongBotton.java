package com.lkn;

/*生产地雷*/
public class BongBotton {

    int jilu,x,y;
//    int sum=0;
    void reset(){
        //初始化底层数组
        for (int i = 1; i <= GameUtil.MAP_W; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                GameUtil.MAP_BOTTON[i][j]=0;
            }
        }

        //生成地雷
        for (int i = 0; i < GameUtil.bong_MAX; i++) {
            jilu=(int)(Math.random()*1000)%(GameUtil.MAP_W*GameUtil.MAP_H)+1;
            x=jilu/GameUtil.MAP_W+1;
            y=jilu%GameUtil.MAP_W;
            if(y==0){
                x--;
                y=GameUtil.MAP_W;
            }
            if(GameUtil.MAP_BOTTON[x][y]==-1){
                i--;
//                sum++;
                continue;
            }
            GameUtil.MAP_BOTTON[x][y]=-1;
        }
//        for (int i = 1; i <= GameUtil.MAP_W; i++) {
//            for (int j = 1; j <= GameUtil.MAP_H; j++) {
//                System.out.print(GameUtil.MAP_BOTTON[i][j]+" ");
//
//            }
//            System.out.println();
//        }
//        System.out.println(sum);
    }

}
