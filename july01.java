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
	
 /*
	 * 最长括号匹配  例如（）（（）） 则得到6
	 * （）（（（   ） ） 则得到5
	 * 算法分析：  压入栈中索引 即可
	 * 	start为匹配位置，最大匹配长度为m
	 * 	首先遇到的字符为（  则入栈
	 * 	若遇到的为） 若栈为空，说明没有匹配的左括号 start=i
	 * 			若栈不为空  ，出栈
	 * 				若栈为空  说明相匹配  i-start为匹配长度  与 m 取最大值
	 * 				若栈不为空 ，当前的栈顶元素为上次匹配的最后位置   检查i-t 与m  取最大值
	 * */
	public static int getLongkuo(String str){
		Stack stack=new Stack();
		int start=-1;
		int ml=0;
		char[] strarray=str.toCharArray();
		for(int i=0;i<strarray.length;i++){
			if(strarray[i]=='('){
				stack.push(i);
			}else{
				if(stack.isEmpty()){
					start=i;
				}else{
					stack.pop();
					if(stack.isEmpty()){
						ml=(i-start)>ml?(i-start):ml;
					}else{
						ml=(i-(int)stack.peek())>ml?(i-(int)stack.peek()):ml;
					}
					
				}
				
			}
			
			
		}
		
		return ml;
	}
	/*
	 * 逆波兰表达式
	 * 创建栈，遇到数值则压入栈，遇到操作符 ，弹出俩个元素，计算值，再压入栈
	 * */
	public static int getniPolan(String str){
		char[] strarr=str.toCharArray();
		Stack stack=new Stack();
		int result=0;
		for(int i=0;i<strarr.length;i++){
			
			if(strarr[i]=='+'||strarr[i]=='-'||strarr[i]=='*'){
				int num1=Integer.parseInt(stack.pop().toString());
				int num2=Integer.parseInt(stack.pop().toString());
				if(strarr[i]=='+') result=num1+num2;
				if(strarr[i]=='-') result=num1-num2;
				if(strarr[i]=='*') result=num1*num2;
				stack.push(result);
			}else{
				stack.push(strarr[i]);
			}
		}
		
		return result;
		
	}
3.queue
   	/**
	 *拓扑排序  找入度为0的点，删除，然后删边
	 * */
	
	public static int[] tuoPu(int[][] a){
		int cnt=0;
		int n=0;
		int[] degree=new int[n]; //存放每个节点的入度
		Queue queue = null;
		for(int i=0;i<degree.length;i++){
			if(degree[i]==0){
				queue.add(degree[i]);
			}
		}
		int[]result=new int[Integer.MAX_VALUE];
		int cur=0;
		while(!queue.isEmpty()){
			cur=(int)queue.peek();
			queue.poll();
			result[cnt++]=cur;
			for(int i=0;i<n;i++){
				if(a[cur][i]!=0){
					degree[i]--;   //cur节点已被删除，cur到i的边 也被删除 ，所以i的入度要减一
					if(degree[i]==0){
						queue.add(degree[i]);
					}
				}
				
			}
			
		}
		
		
		return result;
		
		
		
	}
	
	/**
	 * Dijkstra 最短路径的总数
	 * 	设G[][]保存 权值  G[0][1] 表示0到1联通
	 * 	假设i到邻接节点j 
	 * 	若 step[j]=0 则  stepNumber[j]=stepNumber[i] 
	 *  若step[j]!=0 且 step[j]=step[i+1]  说明事先已经遍历过   stepNumber[j]+=stepNumber[i] 
	 * */
	public static int getDiskstra(int[][]G){
		int[] step=null;  //每个节点第几步达到
		int[] stepNumber=null; //到每个节点有几种走法
		stepNumber[0]=1;
		int n=16;  //假设节点的个数
		Queue queue=null;
		queue.add(0);
		int from,s;
		while(!queue.isEmpty()){
			from=(int)queue.peek();
			queue.poll();
			s=step[from]+1;
			for(int i=1;i< n;i++){
				if(G[from][i]==1){ //from到i是联通的
					if(step[i]==0){  //若i还没有访问过
						step[i]=s;
						stepNumber[i]=stepNumber[from];
						queue.add(i);
					}else if(step[i]==s){ //i已经访问过  
						stepNumber[i]+=stepNumber[from];
					}
					
				}
				
			}
		}
		return stepNumber[n-1];
	}

