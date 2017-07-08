链表存取整数
给定x,比x小的节点放到>=x的节点前
分析：
分成俩个链表
h1,t1 小于x的链表的首尾指针
h2,t2 大于x的链表的首尾指针

for(;head;head=head->next)
	if(head->value<x){
		if(!t1){
			h1=t1=head;
		}else{
			t1->next=head;
			t1=t1->next;
		}

	}else if(!t2){
			h2=t2=head;

	}else{
			t2->next=head;
			t2=t2->next;
	}

//连接俩个链表
	if(t2){
		t2->next=0;
	}
	if(t1){
		t1->next=h2;
	}
	return h1?h1:h2;