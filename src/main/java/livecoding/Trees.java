package yandex_leetcode.src.main.java.livecoding;

import yandex_leetcode.src.main.java.livecoding.special.TreeNode;

public interface Trees {
    boolean hasPathSum(TreeNode root, int targetSum);
    boolean isSameTree(TreeNode p, TreeNode q);
    int maxDepth(TreeNode root);
}
