package com.tk.datastructure.trie;

import com.tk.datastructure.set.BSTSet;
import com.tk.datastructure.set.FileOperation;

import java.util.ArrayList;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {

        System.out.println("pride-and-prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

            long startTime = System.nanoTime();

            BSTSet<String> bstSet = new BSTSet<>();
            for (String word : words) {
                bstSet.add(word);
            }

            for (String word : words) {
                bstSet.contains(word);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + bstSet.getSize());
            System.out.println("BSTSet: " + time + " s");


            System.out.println();

            startTime = System.nanoTime();

            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }

            for (String word : words) {
                trie.contains(word);
            }
            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }
    }
}
