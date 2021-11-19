package com.learn.leetcode.foundation.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * autor:liman
 * createtime:2020/2/9
 * comment: 无向图的数组表示
 */
public class MatrixNDG {

    int size;
    char[] vertexs; //图顶点名称
    int[][] matrix; //图关系矩阵

    public MatrixNDG(char[] vertexs, char[][] edges) {
        size = vertexs.length;
        matrix = new int[size][size];
        this.vertexs = vertexs;

        for (char[] c : edges) {
            int p1 = getPosition(c[0]);
            int p2 = getPosition(c[1]);

            //无向图，两个对称的位置都需要存储
            matrix[p1][p2] = 1;
            matrix[p2][p1] = 1;
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

    /**
     * 邻接矩阵的深度优先遍历
     */
    public void DFS() {
        boolean[] beTraversed = new boolean[size];
        System.out.print(vertexs[0] + " ");
        beTraversed[0] = true;
        DFS(0, 0, beTraversed);
    }

    /**
     * 邻接矩阵的深度优先遍历
     *
     * @param x
     * @param y
     * @param beTraversed
     */
    public void DFS(int x, int y, boolean[] beTraversed) {
        while (y <= size - 1) {
            if (matrix[x][y] != 0 && beTraversed[y] == false) {
                System.out.print(vertexs[y] + " ");
                beTraversed[y] = true;
                DFS(y, 0, beTraversed);
            }
            y++;
        }
    }

    /**
     * 广度优先搜素遍历入口
     */
    public void BFS() {
        boolean[] beTraversed = new boolean[size];
        System.out.print(vertexs[0] + " ");
        beTraversed[0] = true;
        BFS(0, beTraversed);
    }

    /**
     * 广度优先搜索遍历
     *
     * @param x
     * @param beTraversed
     */
    public void BFS(int x, boolean[] beTraversed) {
        LinkedList<Character> list = new LinkedList<>();
        int y = 0;
        while (y <= size - 1) {
            if (matrix[x][y] != 0 && beTraversed[y] == false) {
                System.out.print(vertexs[y] + " ");
                beTraversed[y] = true;
                list.add(vertexs[y]);
            }
            y++;
        }
        while (!list.isEmpty()) {
            Character ch = list.pop();
            int t = getPosition(ch);
            BFS(t, beTraversed);
        }
    }

    public void BFSSelf() {
        boolean[] beTraversed = new boolean[size];
        beTraversed[0] = true;
        System.out.print(vertexs[0] + " ");
        BFSSelf(0, beTraversed, new LinkedList<>());
    }

    /**
     * 自己的广度优先搜索遍历
     *
     * @param x
     * @param beTraversed
     */
    public void BFSSelf(int x, boolean[] beTraversed, LinkedList<Character> list) {
        int y = 0;
        while (y <= size - 1) {
            if (matrix[x][y] != 0 && beTraversed[y] == false) {
                beTraversed[y] = true;
                System.out.print(vertexs[y] + " ");
                list.add(vertexs[y]);
            }
            y++;
        }
        if (!list.isEmpty()) {
            Character node = list.pop();
            int pos = getPosition(node);
            BFSSelf(pos, beTraversed, list);
        }
    }

    public void DFSSelf() {
        boolean[] beTraversed = new boolean[size];
        beTraversed[0] = true;
        System.out.print(vertexs[0] + " ");
        DFSSelf(0, beTraversed);
    }

    public void DFSSelf(int x, boolean[] beTraversed) {
        int y = 0;
        while (y <= size - 1) {
            if (matrix[x][y] != 0 && beTraversed[y] == false) {
                beTraversed[y] = true;
                System.out.print(vertexs[y] + " ");
                DFSSelf(y, beTraversed);
            }
            y++;
        }
    }

    /**
     * 非递归的深度优先遍历
     *
     * @param x
     * @param beTraversed
     */
    public void DFSWithStack(int x, boolean[] beTraversed) {
        Stack<Character> list = new Stack<>();
        list.push(vertexs[x]);
        beTraversed[getPosition(vertexs[x])] = true;
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

        MatrixNDG matrixNDG = new MatrixNDG(vexs, edges);
        matrixNDG.print();
        System.out.println();
        System.out.print("深度优先搜索遍历:");
        matrixNDG.DFS();

        System.out.println();
        System.out.print("广度优先搜索遍历:");
        matrixNDG.BFS();

        System.out.println();
        System.out.print("广度优先搜索遍历自己:");
        matrixNDG.BFSSelf();

        System.out.println();
        System.out.print("深度优先搜索遍历自己:");
        matrixNDG.DFSSelf();
    }
}
