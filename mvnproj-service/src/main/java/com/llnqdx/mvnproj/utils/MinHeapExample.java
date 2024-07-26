package com.llnqdx.mvnproj.utils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        // 创建一个最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 插入元素
        minHeap.offer(5);
        minHeap.offer(1);
        minHeap.offer(3);
        minHeap.offer(4);
        System.out.println("堆中的元素：" + minHeap);

        // 获取最小元素
        Integer smallest = minHeap.peek();
        System.out.println("最小元素是：" + smallest);

        // 删除最小元素
        Integer removed = minHeap.poll();
        System.out.println("删除的最小元素：" + removed);
        System.out.println("删除后堆中的元素：" + minHeap);
    }
}
