package com.tk.datastructure.avltree;

import com.tk.datastructure.map.BSTMap;
import com.tk.datastructure.set.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {

        System.out.println("pride-and-prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

            Collections.sort(words);

            long startTime = System.nanoTime();

            BSTMap<String, Integer> map = new BSTMap<>();
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
            System.out.println("BST: " + time + " s");

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
        }

    }
}
