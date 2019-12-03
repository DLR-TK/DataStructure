package com.tk.datastructure.unionfind;

/**
 * isConnected    O(h)    O(log*n)      0        if(n<=1)  近乎是O(1)
 * unionElements  O(h)             1+log*(logn)  if(n>1)
 * 路径压缩 Path Compression
 */
@SuppressWarnings("all")
public class UnionFind5 implements UF {

    private int[] parent;
    private int[] rank;       //rank[i]表示以i为根的集合所表示的

    public UnionFind5(int size) {

        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看元素p和元素q是否属于一个集合 O(h)
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p与元素q所属的集合  O(h)
     */
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        /**
         * 将元素rank低的集合 合并到元素rank高的元素的集合
         */
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] < rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }

    }

    /**
     * 查找元素p所对应的集合编号  O(h)
     * @param p 目标元素
     * @return 集合编号
     */
    private int find(int p) {

        if (p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p id out of bound.");
        }

        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
