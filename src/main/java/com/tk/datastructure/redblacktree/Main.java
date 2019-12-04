package com.tk.datastructure.redblacktree;

import com.tk.datastructure.avltree.AVLTree;
import com.tk.datastructure.bst.BST2;
import com.tk.datastructure.set.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {

        System.out.println("pride-and-prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

//            Collections.sort(words);

            //BST2测试
            long startTime = System.nanoTime();

            BST2<String, Integer> map = new BST2<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            for (String word : words) {
                map.contains(word);
            }

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST2: " + time + " s");

            //AVLTree测试
            startTime = System.nanoTime();

            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.contains(word)) {
                    avlTree.set(word, avlTree.get(word) + 1);
                } else {
                    avlTree.add(word, 1);
                }
            }

            for (String word : words) {
                avlTree.contains(word);
            }

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVLTree: " + time + " s");

            //RBTree测试
            startTime = System.nanoTime();

            RBTree<String, Integer> RBTree = new RBTree<>();
            for (String word : words) {
                if (RBTree.contains(word)) {
                    RBTree.set(word, RBTree.get(word) + 1);
                } else {
                    RBTree.add(word, 1);
                }
            }

            for (String word : words) {
                RBTree.contains(word);
            }

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");
        }

    }
}
