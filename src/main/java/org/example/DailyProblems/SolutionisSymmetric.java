package org.example.DailyProblems;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SolutionisSymmetric {
     public boolean isSame(TreeNode l1,TreeNode l2){
          if (l1 == null && l2 == null) return true;

        if (l1 == null || l2 == null || l1.val != l2.val) return false;
    
         return isSame(l1.left, l2.right) && isSame(l1.right, l2.left);
        
     }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return isSame(root.left,root.right);
    }
}
  