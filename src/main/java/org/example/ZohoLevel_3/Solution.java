package org.example.ZohoLevel_3;

import org.example.Trees.VerticalOrderTraversal;

import java.util.*;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;

    public VerticalOrderTraversal.TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
       
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return helper(preorder, postorder, 0, postorder.length - 1);
    }

    private VerticalOrderTraversal.TreeNode helper(int[] preorder, int[] postorder, int left, int right) {
        if (preIndex >= preorder.length || left > right) return null;

        VerticalOrderTraversal.TreeNode root = new VerticalOrderTraversal.TreeNode(preorder[preIndex++]);

        // If the root is the only node left, return it
        if (left == right) return root;

        // Find left child position in postorder
        int postIndex = map.get(preorder[preIndex]);

        // Build left and right subtrees
        root.left = helper(preorder, postorder, left, postIndex);
        root.right = helper(preorder, postorder, postIndex + 1, right - 1);

        return root;
    }
}
