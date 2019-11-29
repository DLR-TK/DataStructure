package com.tk.datastructure.bst;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!bst.isEmpty()) {
            arrayList.add(bst.removeMax());
        }

        System.out.println(arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i - 1) < arrayList.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMax test completed.");
    }
}
