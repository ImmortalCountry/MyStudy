package com.sdy.algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Sun Deyu
 * @date: 2020/6/5 17:27
 * @description: 最近最少使用
 */
public class LRUCache<K, V> {

    /**
     * 双链表的节点元素
     *
     * @param <K>
     * @param <V>
     */
    private class Entry<K, V> {
        Entry<K, V> before;
        Entry<K, V> after;
        private K key;
        private V value;
    }

    /**
     * 缓存容量大小
     */
    private Integer capacity;
    /**
     * 头节点
     */
    Entry<K, V> head;
    /**
     * 尾节点
     */
    Entry<K, V> tail;
    /**
     * 用来存储所有元素
     */
    private Map<K, Entry<K, V>> caches = new HashMap<>();

    public V get(K key) {
        final Entry<K, V> node = caches.get(key);
        if (node != null) {
            // 有访问，就移到链表末尾
            afterNodeAccess(node);
            return node.value;
        }
        return null;
    }

    private void afterNodeAccess(Entry<K, V> e) {
        Entry<K, V> last = tail;
        // 如果 e 不是尾节点，才需要移动
        if (last == e) {
            return;
        }
        // 如果 e 是 头节点
        if (e.before == null) {
            head = e.after;
        } else {
            e.before.after = e.after;
        }
        // 删除该节点与后有一节点的联系
        if (e.after == null) {
            last = e.before;
        } else {
            e.after.before = e.before;
        }
        if (last == null) {
            head = e;
        } else {
            e.before = last;
            last.after = e;
        }
        e.after = null;
        tail = e;
    }

    public V put(K key, V value) {
        Entry<K, V> entry = caches.get(key);
        if (entry == null) {
            entry = new Entry<>();
            entry.key = key;
            entry.value = value;
            // 新节点添加到末尾
            linkNodeLast(entry);
            caches.put(key, entry);
            // 节点数大于容量就删除头节点
            if (this.caches.size() > this.capacity) {
                this.caches.remove(head.key);
                afterNodeRemoval(head);
            }
            return null;
        }
        entry.value = value;
        // 节点有更新就移动到末节点
        afterNodeAccess(entry);
        caches.put(key, entry);
        return entry.value;
    }

    /**
     * 删除该节点
     *
     * @param head
     */
    private void afterNodeRemoval(Entry<K, V> e) {
        if (e.before == null) {
            head = e.after;
        } else {
            e.before.after = e.after;
        }
        if (e.after == null) {
            tail = e.before;
        } else {
            e.after.before = e.before;
        }
    }

    /**
     * 把该节点添加到尾节点
     *
     * @param entry
     */
    private void linkNodeLast(Entry<K, V> e) {
        final Entry<K, V> last = this.tail;
        if (head == null) {
            head = e;
        } else {
            e.before = last;
            last.after = e;
        }
        tail = e;
    }
}

