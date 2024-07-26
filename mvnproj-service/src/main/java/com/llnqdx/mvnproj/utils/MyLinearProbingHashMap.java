package com.llnqdx.mvnproj.utils;

// 线性探查法的基本逻辑，伪码实现

class MyLinearProbingHashMap {
    // 数组中每个元素都存储一个键值对
    private ExampleChainingHashMap.KVNode[] table = new ExampleChainingHashMap.KVNode[5];

    private int hash(int key) {
        return key % table.length;
    }

    public void put(int key, int value) {
        int index = hash(key);
        ExampleChainingHashMap.KVNode node = table[index];
        if (node == null) {
            table[index] = new ExampleChainingHashMap.KVNode(key, value);
        } else {
            // 线性探查法的逻辑
            // 向后探查，直到找到 key 或者找到空位
            while (table[index] != null && table[index].key != key) {
                index++;
            }
            table[index] = new ExampleChainingHashMap.KVNode(key, value);
        }
    }

    public int get(int key) {
        int index = hash(key);
        // 向后探查，直到找到 key 或者找到空位
        while (table[index] != null && table[index].key != key) {
            index++;
        }
        if (table[index] == null) {
            return -1;
        }
        return table[index].value;
    }

    public void remove(int key) {
        int index = hash(key);
        // 向后探查，直到找到 key 或者找到空位
        while (table[index] != null && table[index].key != key) {
            index++;
        }
        // 删除 table[index]
        // ...
    }
}