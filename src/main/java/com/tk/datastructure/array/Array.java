package com.tk.datastructure.array;

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 有参构造 创建容量为capacity的数组
     * @param capacity 容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造默认创建容量为10的数组
     */
    public Array() {
        this(10);
    }

    /**
     * 返回数组中元素个数
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组容量
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return 数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个元素
     * @param e 添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向所有元素前添加一个元素
     * @param e 添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向指定索引index出插入一个元素e
     * @param index 索引
     * @param e 元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;

    }

    /**
     * 获取索引为index的元素
     * @param index 索引
     * @return 索引为index的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改索引为index的元素为e
     * @param index 索引
     * @param e 更新元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e 元素
     * @return 操作成功或失败
     */
    public boolean contains(E e) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中e所在的索引，若不存在返回-1
     * @param e 元素
     * @return 返回索引,若不存在返回-1
     */
    public int find(E e) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除索引为index的元素，返回删除的元素
     * @param index 索引
     * @return 删除的元素
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除数组的第一个元素，返回删除的元素
     * @return 删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组的最后一个元素，返回删除的元素
     * @return 删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     * @param e 元素
     */
    public void removeElement(E e) {

        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1 ) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }


    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
