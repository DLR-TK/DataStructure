package com.tk.datastructure.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solution347 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (priorityQueue.getSize() < k) {
                priorityQueue.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > priorityQueue.getFront().freq) {
                priorityQueue.dequeue();
                priorityQueue.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.dequeue().e);
        }
        return res;
    }

    private class Freq implements Comparable<Freq>{
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
