package com.learn.leetcode.foundation.graph;

import java.util.LinkedList;

/**
 * autor:liman
 * createtime:2020/2/9
 * comment: 邻接表的方式存储无向图
 */
public class ListNDG {

    Vertex[] vertexList;
    int size;

    class Vertex {
        char ch;
        Vertex next;

        public Vertex(char ch) {
            this.ch = ch;
        }

        void add(char ch) {
            Vertex node = this;
            while (node.next != null) {//找到链表结尾
                node = node.next;
            }
            node.next = new Vertex(ch);
        }
    }

    public ListNDG(char[] vertexs, char[][] edgs) {
        size = vertexs.length;
        this.vertexList = new Vertex[size];//确定邻接表的大小
        //设置邻接表的每一个节点
        for (int i = 0; i < size; i++) {
            this.vertexList[i] = new Vertex(vertexs[i]);
        }

        //存储边的信息
        for (char[] c : edgs) {
            int p1 = getPosition(c[0]);
            vertexList[p1].add(c[1]);
            int p2 = getPosition(c[1]);
            vertexList[p2].add(c[0]);
        }
    }

    //根据顶点名称获取链表下标
    private int getPosition(char ch) {
        for (int i = 0; i < size; i++) {
            if (vertexList[i].ch == ch) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            Vertex temp = vertexList[i];
            while (temp != null) {
                System.out.print(temp.ch + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public void DFS() {
        boolean[] beTraversed = new boolean[size];
//        beTraversed[getPosition(vertexList[0].ch)] = true;
        DFS(beTraversed, vertexList[0]);
    }

    /**
     * 深度优先遍历
     *
     * @param beTraversed
     * @param temp
     */
    public void DFS(boolean[] beTraversed, Vertex temp) {
        System.out.print(temp.ch + " ");
        beTraversed[getPosition(temp.ch)] = true;
        while (temp != null) {
            if (beTraversed[getPosition(temp.ch)] == false) {
                DFS(beTraversed, vertexList[getPosition(temp.ch)]);
            }
            temp = temp.next;
        }
    }

    public void BFS(){
        boolean[] beTraversed = new boolean[size];
        beTraversed[getPosition(vertexList[0].ch)] = true;
        System.out.print(vertexList[0].ch+" ");
        int startPos = getPosition(vertexList[0].ch);
        BFS(startPos,beTraversed);
    }

    /**
     * 广度优先搜素遍历
     * @param beTraversed
     */
    public void BFS(int x,boolean[] beTraversed){
        Vertex temp = vertexList[x];
        LinkedList<Vertex> list = new LinkedList<>();
        while(temp!=null){
            if(beTraversed[getPosition(temp.ch)] == false){
                System.out.print(temp.ch+" ");
                beTraversed[getPosition(temp.ch)] = true;
                list.add(vertexList[getPosition(temp.ch)]);
            }
            temp = temp.next;
        }

        while(!list.isEmpty()){
            Vertex node = list.pop();
            int pos = getPosition(node.ch);
            BFS(pos,beTraversed);
        }
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

        ListNDG listNDG = new ListNDG(vexs, edges);
        listNDG.print();
        listNDG.DFS();
        System.out.println();
        listNDG.BFS();
    }

}
