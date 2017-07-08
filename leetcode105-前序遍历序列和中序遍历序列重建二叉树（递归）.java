public static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder, List<Integer> inOrder){  
        TreeNode root = null;  
        List<Integer> leftPreOrder;  
        List<Integer> rightPreOrder;  
        List<Integer> leftInorder;  
        List<Integer> rightInorder;  
        int inorderPos;  
        int preorderPos;  
    
        if ((preOrder.size() != 0) && (inOrder.size() != 0))  
        {  
            // 把preorder的第一个元素作为root  
            root = new TreeNode(preOrder.get(0));  
    
            //  Based upon the current node data seperate the traversals into leftPreorder, rightPreorder,  
            //  leftInorder, rightInorder lists  
            // 因为知道root节点了，所以根据root节点位置，把preorder，inorder分别划分为 root左侧 和 右侧 的两个子区间  
            inorderPos = inOrder.indexOf(preOrder.get(0));      // inorder序列的分割点  
            leftInorder = inOrder.subList(0, inorderPos);  
            rightInorder = inOrder.subList(inorderPos + 1, inOrder.size());  
    
            preorderPos = leftInorder.size();                           // preorder序列的分割点  
            leftPreOrder = preOrder.subList(1, preorderPos + 1);  
            rightPreOrder = preOrder.subList(preorderPos + 1, preOrder.size());  
    
            root.left = rebuildBinaryTreeRec(leftPreOrder, leftInorder);        // root的左子树就是preorder和inorder的左侧区间而形成的树  
            root.right = rebuildBinaryTreeRec(rightPreOrder, rightInorder); // root的右子树就是preorder和inorder的右侧区间而形成的树  
        }  
    
        return root;  
    }  