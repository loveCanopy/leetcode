判断是否为二叉搜索树
它或者是一棵空树，或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
第一种：递归操作，node节点的左子树的最大值小于node.value，右子树的最小值大于node.value
int maxValue(node* root)
{
    if(root == NULL)
        return INT_MAX
    while(root -> right)
        root = root -> right;
    return root -> value;
}
int minValue(node* root)
{
    if(root == NULL)
        return INT_MIN
    while(root -> left)
        root = root -> left;
    return root -> value;
}
bool isBST(node* root )
{
        if (root == NULL)
               return true;
        //如果左子树最大值大于根节点，则返回false
        if (root->left != NULL && maxValue(root->left) > node->value)
               return false;
        //如果右子树最小值小于根节点，则返回false
        if (root->right != NULL && minValue(root->right) < node->value)
               return false;

        //递归判断
        if (!isBST(root->left) || !isBST(root->right))
               return false;
        return true;
}

二。
二叉搜索树的中序遍历是一个递增序列，所以我们只需要把这个中序遍历保存下来，然后判断这是个递增序列即可：
void LDR(node * root, vector<int>& inorder)
{
    if(root == NULL)
        return;
    LDR(root -> left);
    inorder.push_back(root -> value);
    LDR(root -> right);
}
bool isBST(node* root)
{
    vector<int> inorder;
    LDR(root);
    for(int i = 1; i < inorder.size(); ++i)
        if(inorder[i - 1] >= inorder[i])
            return false;
    return true;
}
三。
//保存之前访问过的节点的值，判断当前访问的小于之前保存的值
int lastVisited = INT_MIN;
bool isBST(node * root)
{
    if(root == NULL)
        return true;
    //判断左子树
    if(!LDR(root -> left))
        return false;
    if(root -> value <= lastVisited)
        return false;
    lastVisited = root -> value;
    //判断右子树
    if(!LDR(root -> right))
        return false;
    return true;
}