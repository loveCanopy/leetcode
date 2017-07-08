链表转二叉树（尽量为平衡二叉树）
一。O(nlogn)
1.首先的到链表的长度 
int length;
while(node.next is not null){
	length++;
}
2.类似于二分查找
Link2Tree(ListNode head,int length){
	ListNode now=head
	for(int i=(length-1)>>1;i;--i){
		now=now.next;
	}
	Treenode root=new Treenode(now.value);
	root.left=Link2Tree(head,length>>1);
	root.right=Link2Tree(now.next,length>>1);
	return root;
二.O(n)
2.Link2Tree(ListNode head,int length){
	if(length==0){
		return ;
	}
	int num=(length-1)>>1;
	Treenode left=Link2Tree(head,num);   //head指针也是跟着移动的
	Treenode root=new Treenode(head.value);
	root.left=left；
	head=head.next;   //跳过根节点
	root.right=Link2Tree(head,length-num-1);
	return root;