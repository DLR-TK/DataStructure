package com.tk.datastructure.queue;

public class Main {

    public static void main(String[] args) {

        LoopQueue<Integer> arrayQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }
}
