package com.yy.algorithm.backtrack;

/**
 * Created by fitz.li on 2019/1/28.
 */
public class EightQueen {

    private int[] result = new int[8];//全局成员变量，下标表示行，值表示queen存储在那一列
    public void cal8Queens(int row){//调用方式：cal8Queens(0)
        if(row == 8){
            printQueens(result);
            return;
        }

        for (int column = 0; column < 8; column++) {//每一行都有8种方法
             if(isOk(row, column)){
                 result[row] = column;//
                 cal8Queens(row + 1);
             }
        }
    }
    private boolean isOk(int row, int column){
        int leftup = column -1, rightup = column + 1;
        for (int i = row -1; i >= 0 ; i--) {//逐行往上考察每一行
            if(result[i] == column) return false;//第i行的column列有棋子，同一列上有值
            if(leftup >=0 && result[i] == leftup) return false; //考察左上对角线
            if(rightup < 8 && result[i] == rightup) return false;//考察右上对角线
            leftup--;
            rightup++;
        }
        return true;
    }

    private void printQueens(int[] result){
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(result[row] == col){
                    System.out.print("Q ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new EightQueen().cal8Queens(0);
    }

}
