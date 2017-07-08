二叉树->单链表  
void BinaryTreeToSinglyList(BiNode* root, BiNode** head, BiNode** tail)  
{  
    if (root == NULL)  
    {  
        *head = NULL;  
        *tail = NULL;  
        return;  
    }  
  
    BiNode* leftHead = NULL;  
    BiNode* leftTail = NULL;  
    BiNode* rightHead = NULL;  
    BiNode* rightTail = NULL;  
  
    BinaryTreeToSinglyList(root->lChild, &leftHead, &leftTail);  
    BinaryTreeToSinglyList(root->rChild, &rightHead, &rightTail);  
  
    if (leftHead == NULL)  
        *head = root;  
    else  
        *head = leftHead;  
  
    if (rightTail == NULL)  
        *tail = root;  
    else  
        *tail = rightTail;  
  
    //将左右子链表链接起来  
    if (leftTail != NULL)  
        leftTail->rChild = root;  
    if (root != NULL)  
        root->rChild = rightHead;  
} 