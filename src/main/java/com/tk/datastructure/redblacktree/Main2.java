package com.tk.datastructure.redblacktree;

import com.tk.datastructure.avltree.AVLTree;
import com.tk.datastructure.bst.BST2;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("all")
public class Main2 {

    public static void main(String[] args) {

        int n = 20000000;

        Random random = new Random(n);
        ArrayList<Integer> testData = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }

        //BST2 Test
        long startTime = System.nanoTime();

        BST2<Integer, Integer> bst2 = new BST2<>();
        for (Integer x : testData) {
            bst2.add(x, null);
        }

        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST2: " + time + " S");

        //AVLTree Test
        startTime = System.nanoTime();

        AVLTree<Integer, Integer> avlTree = new AVLTree<>();
        for (Integer x : testData) {
            avlTree.add(x, null);
        }

        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVLTree: " + time + " S");

        //RBTree Test
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbTree = new RBTree<>();
        for (Integer x : testData) {
            rbTree.add(x, null);
        }

        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " S");
    }
}
