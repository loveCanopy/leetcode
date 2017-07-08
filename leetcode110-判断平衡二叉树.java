左右节点的高度相差，最大为1

bool isBalanced(TreeNode root){
		int height;
		return help(root,height)
}


bool help(TreeNode root,int height){

	if(root==0){
		height=0;
		return true;
	}

	int height1,height2;
	if(!help(root.left,height1)){
		return false;
	}

	if(!help(root.right,height2)){
		return false;
	}

	height=max(height1,height2)+1;
	return (height1>=height2-1)&&(height1<=height2+1)
}