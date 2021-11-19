package com.learn.leetcode.foundation.graph;

/**
 * autor:liman
 * createtime:2020/2/9
 * comment: 邻接表的方式存储有向图
 */
public class ListDG {

    Vertex[] vertexList;
    int size;

    class Vertex{
        char ch;
        Vertex next;

        public Vertex(char ch) {
            this.ch = ch;
        }

        void add(char ch){
            Vertex node = this;
            while(node.next!=null){
                node = node.next;
            }
            node.next = new Vertex(ch);
        }
    }

    public ListDG(char[] vertexs, char[][] edgs){
        size = vertexs.length;
        this.vertexList = new Vertex[size];//确定邻接表的大小
        //设置邻接表的每一个节点
        for(int i = 0;i<size;i++){
            this.vertexList[i] = new Vertex(vertexs[i]);
        }

        //存储边的信息
        for(char[] c:edgs){
            int p1 = getPosition(c[0]);
            vertexList[p1].add(c[1]);
        }
    }

    //根据顶点名称获取链表下标
    private int getPosition(char ch){
        for(int i =0;i<size;i++){
            if(vertexList[i].ch==ch){
                return i;
            }
        }
        return -1;
    }

    public void print(){
        for(int i = 0;i<size;i++){
            Vertex temp = vertexList[i];
            while(temp!=null){
                System.out.print(temp.ch+" ");
                temp = temp.next;
            }
            System.out.println();
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

        ListDG listNDG = new ListDG(vexs,edges);
        listNDG.print();
    }

}
