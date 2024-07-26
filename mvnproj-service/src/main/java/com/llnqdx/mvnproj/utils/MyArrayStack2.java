package com.llnqdx.mvnproj.utils;

// 用数组作为底层数据结构实现栈（环形数组头部增删元素）
public class MyArrayStack2<E> {
    private CycleArray<E> list = new CycleArray<>();

    // 向栈顶加入元素，时间复杂度 O(1)
    public void push(E e) {
        list.addFirst(e);
    }

    // 从栈顶弹出元素，时间复杂度 O(1)
    public void pop() {
        list.removeFirst();
    }

    // 查看栈顶元素，时间复杂度 O(1)
    public E peek() {
        return list.getFirst();
    }

    // 返回栈中的元素个数，时间复杂度 O(1)
    public int size() {
        return list.size();
    }
}