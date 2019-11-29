package com.tk.datastructure.linkedlist;

@SuppressWarnings("all")
public class LoopLinkedList<E> {

    private Node dummyHead;
    private int size;

    public LoopLinkedList() {
        dummyHead = new Node(null, null, null);
        dummyHead.next = dummyHead;
        dummyHead.prev = dummyHead;
        size = 0;
    }

    /**
     * 返回链表长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向链表中插入节点（练习）
     */
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }

        Node next = prev.next;

        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        next.prev = node;
        node.prev = prev;


        size++;
    }

    /**
     * 向链表头部插入节点
     */
    public void addFirst(E e) {

        Node next = dummyHead.next;
        Node node = new Node(e);
        node.next = dummyHead.next;
        dummyHead.next = node;

        next.prev = node;
        node.prev = dummyHead;
        size++;
    }

    /**
     * 向链表尾部插入节点
     */
    public void addLast(E e) {

        Node cur = dummyHead.prev;
        Node node = new Node(e);
        node.prev = cur;
        dummyHead.prev = node;

        cur.next = node;
        node.next = dummyHead;
        size++;
    }

    /**
     * 获得链表的第index位置元素（练习）
     */
    public E get(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     */
    public E getFirst() {
        return dummyHead.next.e;
    }

    /**
     * 获得链表的最后一个元素
     */
    public E getLast() {
        return dummyHead.prev.e;
    }

    /**
     * 修改链表的第index元素为e（练习）
     */
    public void set(int index, E e) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否存在e
     */
    public boolean contains(E e) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除第index位置元素 返回删除元素（练习）
     */
    public E remove(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next.prev = prev;
        retNode.next = null;
        retNode.prev = null;
        size--;
        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素 返回删除元素
     */
    public E removeFirst() {

        if (isEmpty())
            throw new IllegalArgumentException("Remove failed. LoopLinkedList is empty.");

        Node delNode = dummyHead.next;
        dummyHead.next = delNode.next;
        delNode.next.prev = dummyHead;
        delNode.next = null;
        delNode.prev = null;
        return delNode.e;
    }

    /**
     * 从链表中删除最后一个元素 返回删除元素
     */
    public E removeLast() {

        if (isEmpty())
            throw new IllegalArgumentException("Remove failed. LoopLinkedList is empty.");

        Node delNode = dummyHead.prev;
        dummyHead.prev = delNode.prev;
        delNode.prev.next = dummyHead;
        delNode.next = null;
        delNode.prev = null;
        return delNode.e;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != dummyHead) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

    private class Node {
        public E e;
        public Node next, prev;

        public Node(E e, Node next, Node prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public static void main(String[] args) {

        LoopLinkedList<Integer> loopLinkedList = new LoopLinkedList<>();
        for (int i = 0; i < 5; i++) {
            loopLinkedList.addFirst(i);
            System.out.println(loopLinkedList);
        }

        loopLinkedList.add(2, 666);
        System.out.println(loopLinkedList);

        loopLinkedList.remove(2);
        System.out.println(loopLinkedList);

        loopLinkedList.removeFirst();
        System.out.println(loopLinkedList);

        loopLinkedList.removeLast();
        System.out.println(loopLinkedList);
    }
}
