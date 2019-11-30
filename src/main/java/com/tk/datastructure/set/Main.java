package com.tk.datastructure.set;

import java.util.ArrayList;

@SuppressWarnings("all")
public class Main {

    /**
     *                    时间复杂度
     *                   LinkedListSet              BSTSet  (平均)    (最差)
     * 增 add               O(n)                      O(h)  O(logn)   O(n)
     * 查 contains          O(n)                      O(h)  O(logn)   O(n)
     * 删 remove            O(n)                      O(h)  O(logn)   O(n)
     */
    public static double testSet(Set<String> set, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {

            System.out.println("Total words: " + words.size());
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BSTSet: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("LinkedListSet: " + time2 + " s");
    }
}
