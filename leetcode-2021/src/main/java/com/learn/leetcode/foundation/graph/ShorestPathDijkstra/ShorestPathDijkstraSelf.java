package com.learn.leetcode.foundation.graph.ShorestPathDijkstra;


import java.util.ArrayList;
import java.util.List;

/**
 * autor:liman
 * createtime:2020/2/14
 * comment:迪杰斯特拉算法
 */
public class ShorestPathDijkstraSelf {

    private int[][] matrix;

    private int MAX_WEIGHT = Integer.MAX_VALUE;

    private String[] vertexes;

    /**
     * 构建图
     *
     * @param index
     */
    public void createGraph(int index) {
        matrix = new int[index][index];
        vertexes = new String[index];

        int[] v0 = {0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] v1 = {1, 0, 3, 7, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] v2 = {5, 3, 0, MAX_WEIGHT, 1, 7, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] v3 = {MAX_WEIGHT, 7, MAX_WEIGHT, 0, 2, MAX_WEIGHT, 3, MAX_WEIGHT, MAX_WEIGHT};
        int[] v4 = {MAX_WEIGHT, 5, 1, 2, 0, 3, 6, 9, MAX_WEIGHT};
        int[] v5 = {MAX_WEIGHT, MAX_WEIGHT, 7, MAX_WEIGHT, 3, 0, MAX_WEIGHT, 5, MAX_WEIGHT};
        int[] v6 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3, 6, MAX_WEIGHT, 0, 2, 7};
        int[] v7 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 9, 5, 2, 0, 4};
        int[] v8 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 7, 4, 0};

        matrix[0] = v0;
        matrix[1] = v1;
        matrix[2] = v2;
        matrix[3] = v3;
        matrix[4] = v4;
        matrix[5] = v5;
        matrix[6] = v6;
        matrix[7] = v7;
        matrix[8] = v8;

        vertexes[0] = "v0";
        vertexes[1] = "v1";
        vertexes[2] = "v2";
        vertexes[3] = "v3";
        vertexes[4] = "v4";
        vertexes[5] = "v5";
        vertexes[6] = "v6";
        vertexes[7] = "v7";
        vertexes[8] = "v8";
    }

    public void dijkstra(int vs) {
        //初始化
        boolean[] flag = new boolean[vertexes.length];
        int[] U = new int[vertexes.length];
        String[] S = new String[vertexes.length];
        int[] prev = new int[vertexes.length];

        for (int i = 0; i < vertexes.length; i++) {
            flag[i] = false;
            U[i] = matrix[vs][i];
            prev[i] = 0;
        }

        //起始节点的处理
        S[0] = vertexes[vs];
        flag[vs] = true;
        U[vs] = 0;

        int k = 0;
        for (int i = 0; i < vertexes.length; i++) {
            //先找到当前U中最小的节点，并记录下标
            int min = MAX_WEIGHT;
            for (int j = 0; j < vertexes.length; j++) {
                if (U[j] < min && flag[j] == false) {
                    min = U[j];
                    k = j;
                }
            }

            //找到的节点应该入S集合
            S[i] = vertexes[k];
            flag[k] = true;//同时标记该最小值的节点为被访问。

            //继续更新集合U
            for (int j = 0; j < vertexes.length; j++) {
//                int temp = min + matrix[k][j];//直接这么写会产生位溢出，毕竟用到了MAX_VALUE
                int temp = matrix[k][j] == MAX_WEIGHT ? MAX_WEIGHT : (min + matrix[k][j]);

                //正式开始更新U集合
                if (flag[j] == false && temp < U[j]) {
                    U[j] = temp;
                    prev[j] = k;
                }
            }
        }

        //开始打印路径
        System.out.println("起始顶点：" + vertexes[vs]);
        for (int i = 0; i < vertexes.length; i++) {
            System.out.print("最短路径(" + vertexes[vs] + "," + vertexes[i] + "):" + U[i] + "  ");

            List<String> path = new ArrayList<>();
            int j = i;
            while (true) {
                path.add(vertexes[j]);
                if (j == 0) {
                    break;
                }
                j = prev[j];
            }

            //完成打印工作
            for (int x = path.size() - 1; x >= 0; x--) {
                if (x == 0) {
                    System.out.println(path.get(x));
                } else {
                    System.out.print(path.get(x) + "->");
                }
            }
        }

        //打印一遍S集合
        System.out.println("顶点放入到S中的顺序");
        for (int i = 0; i < vertexes.length; i++) {
            System.out.print(S[i]);
            if (i != vertexes.length - 1) {
                System.out.print("-->");
            }
        }

    }

    public static void main(String[] args) {
        ShorestPathDijkstraSelf shorestPathDijkstra = new ShorestPathDijkstraSelf();
        shorestPathDijkstra.createGraph(9);
        shorestPathDijkstra.dijkstra(0);
    }

}
