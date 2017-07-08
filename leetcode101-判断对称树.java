package D13;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSymetic(TreeNode root){
		if(root==null) return true;
		return isSymeticHelper(root.left, root.right);
		
	}
	
	public boolean isSymeticHelper(TreeNode t1,TreeNode t2){
		if(t1==null) return t2==null;
		if(t2==null||t1.data!=t2.data) return false;
		return isSymeticHelper(t1.left, t2.right)&&isSymeticHelper(t1.right, t2.left);
		
	}
	
}

class TreeNode{
	TreeNode root;
	TreeNode left;
	TreeNode right;
	int data;
	
}

