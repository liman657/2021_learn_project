package com.learn.leetcode.foundation.graph;

/**
 * autor:liman
 * createtime:2020/2/9
 * comment: 有向图的数组表示
 */
public class MatrixDG {

    int size;
    char[] vertexs; //图顶点名称
    int[][] matrix; //图关系矩阵

    public MatrixDG(char[] vertexs, char[][] edges) {
        size = vertexs.length;
        matrix = new int[size][size];
        this.vertexs = vertexs;

        for (char[] c : edges) {
            int p1 = getPosition(c[0]);
            int p2 = getPosition(c[1]);

            //有向图，只需要存储一个即可
            matrix[p1][p2] = 1;
//            matrix[p2][p1] = 1;
        }
    }

    public void print() {
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //根据顶点名称获取对应的矩阵下标
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        char[][] edges = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'E', 'G'},
                {'D', 'G'},
                {'I', 'J'},
                {'J', 'G'},
                {'E', 'H'},
                {'H', 'K'}};

        MatrixDG matrixNDG = new MatrixDG(vexs,edges);
        matrixNDG.print();
    }
}
