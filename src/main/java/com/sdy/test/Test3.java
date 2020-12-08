package com.sdy.test;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author: sundy
 * @date: 2020/11/4 14:31
 * @description:
 */
public class Test3 {
    public static void main(String[] args) {
//        TreeNode tree = TreeNode.builder().value("根").build();
//        TreeNode children11 = TreeNode.builder().value("一层1").build();
//        TreeNode children12 = TreeNode.builder().value("一层2").build();
//        TreeNode children13 = TreeNode.builder().value("一层3").build();
//        TreeNode children21 = TreeNode.builder().value("二层1").build();
//        TreeNode children22 = TreeNode.builder().value("二层2").build();
//        children11.setChildList(Lists.newArrayList(children21, children22));
//        tree.setChildList(Lists.newArrayList(children11, children12, children13));
        CategoryVo tree = CategoryVo.builder().name("根").build();
        CategoryVo children11 = CategoryVo.builder().name("一层1").build();
        CategoryVo children12 = CategoryVo.builder().name("一层2").build();
        CategoryVo children13 = CategoryVo.builder().name("一层3").build();
        CategoryVo children21 = CategoryVo.builder().name("二层1").build();
        CategoryVo children22 = CategoryVo.builder().name("二层2").build();
        children11.setChildren(Lists.newArrayList(children21, children22));
        tree.setChildren(Lists.newArrayList(children11, children12, children13));
//        bfsNotRecursive(tree);
        treeHandler(tree);


    }

    public static <V> void bfsNotRecursive(TreeNode<V> tree) {
        if (tree != null) {
            //跟上面一样，使用 Map 也只是为了保存树的深度，没这个需要可以不用 Map
            Queue<Map<TreeNode<V>, Integer>> queue = new ArrayDeque<>();
            Map<TreeNode<V>, Integer> root = new HashMap<>();
            root.put(tree, 0);
            queue.offer(root);
            while (!queue.isEmpty()) {
                Map<TreeNode<V>, Integer> itemMap = queue.poll();
                TreeNode<V> itemTreeNode = itemMap.keySet().iterator().next();
                int depth = itemMap.get(itemTreeNode);
                //打印节点值以及深度
                System.out.println(itemTreeNode.getValue().toString() + ",   " + depth);
                if (itemTreeNode.getChildList() != null &&
                        !itemTreeNode.getChildList().isEmpty()) {
                    for (TreeNode<V> child : itemTreeNode.getChildList()) {
                        Map<TreeNode<V>, Integer> map = new HashMap<>();
                        map.put(child, depth + 1);
                        queue.offer(map);
                    }
                }
            }
        }
    }

    public static List<CategoryVo> treeHandler(CategoryVo root) {
        if (Objects.isNull(root)) {
            return Lists.newArrayList();
        }
        //跟上面一样，使用 Map 也只是为了保存树的深度，没这个需要可以不用 Map
        Queue<CategoryVo> queue = new ArrayDeque<>();
        List<CategoryVo> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            CategoryVo item = queue.poll();
            //打印节点值以及深度
            list.add(item);
            if (CollectionUtils.isEmpty(item.getChildren())) {
                continue;
            }
            for (CategoryVo child : item.getChildren()) {
                queue.offer(child);
            }
        }
        System.out.println(list);
        return list;
    }
}
