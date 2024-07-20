package com.lkn;

//生成地雷周围数字
public class NumBotton {

    void reset(){
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                if(GameUtil.MAP_BOTTON[i][j]==-1){
                    for (int k = i-1; k <=i+1 ; k++) {
                        for (int l = j-1; l <=j+1 ; l++) {
                            if(GameUtil.MAP_BOTTON[k][l]!=-1)
                            {
                                GameUtil.MAP_BOTTON[k][l]++;
                            }
                        }
                        
                    }
                }
            }
        }
    }
}
