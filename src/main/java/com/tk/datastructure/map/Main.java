package com.tk.datastructure.map;

import com.tk.datastructure.set.FileOperation;

import java.util.ArrayList;

@SuppressWarnings("all")
public class Main {

    /**
     *                    时间复杂度
     *                   LinkedListMap              BSTMap  (平均)    (最差)
     * 增 add               O(n)                      O(h)  O(logn)   O(n)
     * 查 contains          O(n)                      O(h)  O(logn)   O(n)
     * 删 remove            O(n)                      O(h)  O(logn)   O(n)
     * 改 set               O(n)                      O(h)  O(logn)   O(n)
     * 查 get               O(n)                      O(h)  O(logn)   O(n)
     */
    public static double testMap(Map<String, Integer> map, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {

            System.out.println("Total words: " + words.size());
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main (String[]args) {

        String filename = "pride-and-prejudice.txt";

        BSTMap<String, Integer> bstSet = new BSTMap<>();
        double time1 = testMap(bstSet, filename);
        System.out.println("BSTSet: " + time1 + " s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListSet = new LinkedListMap<>();
        double time2 = testMap(linkedListSet, filename);
        System.out.println("LinkedListSet: " + time2 + " s");
    }
}
