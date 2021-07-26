package heyihui.leetcode.daily.year2021.july.day27;

import heyihui.leetcode.common.TreeNode;

public class Solution {

    /**
     * 671. 二叉树中第二小的节点
     */
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left == null && root.right == null) {
            return -1;
        }

        if(root.left.left == null && root.right.left == null) {
            if(root.left.val > root.val) {
                return root.left.val;
            }

            if(root.right.val > root.val) {
                return root.right.val;
            }

            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;
        if(root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if(root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if(left == -1) {
            return right;
        }

        if(right == -1) {
            return left;
        }

        return Math.min(left, right);
    }

}
