package com.tk.datastructure.unionfind;

/**
 * isConnected    O(1)
 * unionElements  O(n)
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {

        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查看元素p和元素q是否属于一个集合
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p与元素q所属的集合
     */
    @Override
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }

    /**
     * 查找元素p所对应的集合编号
     * @param p 目标元素
     * @return 集合编号
     */
    private int find(int p) {
        if (p < 0 && p >= id.length) {
            throw new IllegalArgumentException("p id out of bound.");
        }
        return id[p];
    }
}
