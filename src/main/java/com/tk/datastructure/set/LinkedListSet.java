package com.tk.datastructure.set;

import com.tk.datastructure.linkedlist.LinkedList;

import java.util.ArrayList;

@SuppressWarnings("all")
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {

        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    public static void main(String[] args) {

        System.out.println("pride-and-prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {

            System.out.println("Total words: " + words1.size());
            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }
        System.out.println();

        System.out.println("a-tale-of-two-cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {

            System.out.println("Total words: " + words2.size());
            LinkedListSet<String> set2 = new LinkedListSet<>();
            for (String word : words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
