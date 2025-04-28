package org.example.DailyProblems;

import java.util.HashMap;

class Non_AdjacentNodes
{
HashMap<Node,Integer> map=new HashMap<>();
public int getMaxSum(Node root) {
    if(map.containsKey(root))return map.get(root);
    if(root == null)return 0;
    int pick=root.data+(root.left != null ? getMaxSum(root.left.left) : 0)+(root.left != null ? getMaxSum(root.left.right) : 0)+(root.right != null ? getMaxSum(root.right.left) : 0)+(root.right != null ? getMaxSum(root.right.right) : 0);
    int nonPick=getMaxSum(root.left)+getMaxSum(root.right);
    map.put(root,Math.max(pick,nonPick));
    return map.get(root);
}
}