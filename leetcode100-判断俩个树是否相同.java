判断俩个树是否相同
bool isSameTree(TreeNode p,TreeNode q){
	
	if(p==0&&q==0){
		return true;
	}
	else if(q==0||q==0){
		return false;
	}

	return (p.value=q.value)&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

}