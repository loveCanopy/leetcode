 /** 
     * 求二叉树中节点的最大距离 即二叉树中相距最远的两个节点之间的距离。 (distance / diameter) 
     * 递归解法：  
     * （1）如果二叉树为空，返回0，同时记录左子树和右子树的深度，都为0 
     * （2）如果二叉树不为空，最大距离要么是左子树中的最大距离，要么是右子树中的最大距离， 
     * 要么是左子树节点中到根节点的最大距离+右子树节点中到根节点的最大距离， 
     * 同时记录左子树和右子树节点中到根节点的最大距离。 
     *  
     * http://www.cnblogs.com/miloyip/archive/2010/02/25/1673114.html 
     *  
     * 计算一个二叉树的最大距离有两个情况: 
  
        情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。 
        情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。 
        只需要计算这两个情况的路径距离，并取其大者，就是该二叉树的最大距离 
     */ 
    public static Result getMaxDistanceRec(TreeNode root){  
        if(root == null){  
            Result empty = new Result(0, -1);       // 目的是让调用方 +1 后，把当前的不存在的 (NULL) 子树当成最大深度为 0  
            return empty;  
        }  
           
        // 计算出左右子树分别最大距离  
        Result lmd = getMaxDistanceRec(root.left);  
        Result rmd = getMaxDistanceRec(root.right);  
           
        Result res = new Result();  
        res.maxDepth = Math.max(lmd.maxDepth, rmd.maxDepth) + 1;        // 当前最大深度  
        // 取情况A和情况B中较大值  
        res.maxDistance = Math.max( lmd.maxDepth+rmd.maxDepth, Math.max(lmd.maxDistance, rmd.maxDistance) );  
        return res;  
    }  
       
    private static class Result{  
        int maxDistance;  
        int maxDepth;  
        public Result() {  
        }  
   
        public Result(int maxDistance, int maxDepth) {  
            this.maxDistance = maxDistance;  
            this.maxDepth = maxDepth;  
        }  
    }  
       