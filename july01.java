1.链表	
	/**
	 * 数值在链表中逆序存储，求和
	 * */
	public static Node getAdd(Node head1,Node head2){
		Node result=new Node(0); 
		Node result_next=result;//result_next 为头结点 指向无效节点
		int add=0; //加法进位
		Node node_1=head1.next;
		Node node_2=head2.next;
		while(node_1!=null&&node_2!=null){
			int val=(node_1.getVal()+node_2.getVal()+add)%10;
			Node node=new Node(val); //新节点 
			result_next.next=node;
			add=val/10;
			node_1=node_1.next;
			node_2=node_2.next;
			result_next=result_next.next;
		}
		Node p=node_1==null ? node_2:node_1; //使p是俩个链表中最长的那个
		while(p==null){
			int val=(p.val+add)%10;
			Node node=new Node(val); //新节点 
			result_next.next=node;
			add=val/10;
			p=p.next;
			result_next=result_next.next;
		}
		return result;
	}
	
	/**
	 * 给定一个链表和一个x值  将链表划分为俩个部分，小于x的在前面  大于或等于的在后面 且相对位置不变
	 * 1，4，3，2，5, 2   x=3   1,2,2,4,3,5
	 * */
	public static Node huafenList(Node head,int val){
		Node phead=head;
		Node pcur=head;
		while(pcur.val!=val){ //pcur指向val节点的指针		
			pcur=pcur.next;
		}
		Node p_cur=head;
		Node p_tail=p_cur.next;
		while(p_tail.val<val){ //p_cur指向最后一个小于val的节点的指针
			p_cur=p_cur.next;
			p_tail=p_tail.next;
		}
		 while(pcur.next!=null){
			 Node pnext=pcur.next;
			   if(pnext.val<val){
				   pcur.next=pnext.next; //若pnext节点小于val，从pcur后面删除节点
				   Node node=new Node(pnext.val); //将节点放到p_cur后面
				   Node next=p_cur.next;
				   p_cur.next=node;
				   p_cur=p_cur.next;
			   }else{
				   pcur=pcur.next;
			   }
			   
		   }
		 return  head.next;
	}
	
	/**
	 * 链表去除重复元素  保留出现的第一个节点
	 * */
	public static Node quChong(Node head){
		Node pcur=head.next;
		Node pnext=pcur.next;
		while(pnext!=null){
			if(pcur.val!=pnext.val){
			pcur=pcur.next;
			pnext=pnext.next;
			}else{
				pcur.next=pnext.next;
				pnext=pcur.next;
			}
		
		}
		return head.next;
	}
	
	
}

//定义节点类
class Node{
	Node next;
	int val;
	public Node(int val){
		this.val=val;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	
}

2.Stack
	/**
	 * {}[]()
	 * 匹配括号   顺序一定    
	 * */
	public static boolean pandanKuohao(String str){
		Stack stack=new Stack();
		char[] strarray=str.toCharArray();
		for(int i=0;i<strarray.length;i++){
			if(strarray[i]=='('||strarray[i]=='{'||strarray[i]=='['){
				stack.push(strarray[i]);
			}else{
				
				if(stack.isEmpty()){ //   过程中有空的情况   右括号多于左括号  或者 首先遇到右括号
					return false;
				}
				
				if(((char)stack.peek()=='('&&(strarray[i]==')')
						||((char)stack.peek()=='{'&&strarray[i]=='}'))
						||((char)stack.peek()=='['&&strarray[i]==']')){
					stack.pop();
				}else{
					return false;
				}
				
			}
		}
		
		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	


