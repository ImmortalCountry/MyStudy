package com.sdy.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: sundy
 * @date: 2020/11/4 14:44
 * @description:
 */
@Data
@NoArgsConstructor
@Builder
public class TreeNode<V> {

    private V value;
    private List<TreeNode<V>> childList;//子节点列表

    public TreeNode(V value) {
        this.value = value;
    }

    public TreeNode(V value, List<TreeNode<V>> childList) {
        this.value = value;
        this.childList = childList;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public List<TreeNode<V>> getChildList() {
        return childList;
    }

    public void setChildList(List<TreeNode<V>> childList) {
        this.childList = childList;
    }
}
