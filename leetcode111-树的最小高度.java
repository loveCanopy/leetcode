/*
求解二叉树最小高度
根节点到最近的叶子节点的最小高度
使用堆栈 
首先存入根节点，如果空，返回，接下来弹出节点，没有左右节点，直接返回当前高度；
存在左右节点，存入堆栈
*/
public int minDept(TreeNode root){

 if(root==null) return 0;
 if(root.left==null) return minDept(root.right)+1;
 if(root.right==null) return minDept(root.left)+1;
 return Math.min(minDept(root.right),minDept(root.left))+1;

}
