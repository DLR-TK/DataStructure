package com.tk.datastructure.unionfind;

/**
 * isConnected    O(h)
 * unionElements  O(h)
 */
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {

        parent = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
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
        parent[pRoot] = qRoot;
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
            p = parent[p];
        }
        return p;
    }
}
