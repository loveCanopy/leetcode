树的最大高度
int maxDepth(TreeNode root){
	return root?(max(maxDepth(root.left),maxDepth(root.right))+1):0;
}