package com.yy.algorithm.backtrack;

/**
 * Created by fitz.li on 2019/1/28.
 * 0-1背包问题
 */
public class Knapsack {

    private int maxW= Integer.MIN_VALUE;//存储背包中物品总重量的最大值


    public void find(int[] items, int n, int w){
        f(0, 0, items, n, w);
    }


    /**
     *
     * @param i 表示考察到哪个物品了
     * @param cw 表示当前已经装进去的物品重量和
     * @param items 表示物品对应的重量
     * @param n 表示物品个数
     * @param w 背包重量
     */
    public void f(int i, int cw, int[] items, int n, int w){
        if(i == n){
            if(cw > maxW) maxW = cw;
            return;
        }
        f(i+1, cw, items, n, w);
        if(cw + items[i] <= w){//已经超过背包重量的时候，就不再装了
            f(i+1, cw+items[i], items, n, w);
        }
    }


    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.find(new int[]{10,20,30,40,50}, 3, 100);
        System.out.println(knapsack.maxW);
    }
}
