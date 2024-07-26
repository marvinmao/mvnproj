//package com.llnqdx.mvnproj.utils;
//
//class MyHashMap {
//
//    private Object[] table;
//
//    // 增/改，复杂度 O(1)
//    public void put(K key, V value) {
//        int index = hash(key);
//        table[index] = value;
//    }
//
//    // 查，复杂度 O(1)
//    public V get(K key) {
//        int index = hash(key);
//        return table[index];
//    }
//
//    // 删，复杂度 O(1)
//    public void remove(K key) {
//        int index = hash(key);
//        table[index] = null;
//    }
//
//    // 哈希函数，把 key 转化成 table 中的合法索引
//    // 时间复杂度必须是 O(1)，才能保证上述方法的复杂度都是 O(1)
//    private int hash(K key) {
//        // ...
//    }
//}