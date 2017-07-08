求最大直方图面积
用堆栈计算每一块板能延伸到的左右边界
对每一块板
堆栈顶矮，这一块左边界确定，入栈
堆栈顶高，堆栈顶右边界确定，出栈，计算面积
入栈时左边界确定
出栈时右边界确定
堆栈里元素是递增的
for(int i=0;i<n;++i){
	while((!s.empty()&&(height[s.top()]>=height[i])){ //栈顶元素比右栈元素大 ，出栈，确认右边界

			int h=height[s.top()]
			s.pop()
			result=max(result,(i-1-(s.empty()?-1:s.top()))*h) //***左边界一直在栈顶s.top()
	}

	s.push(i);  //栈顶元素比右栈元素小，入栈 ，确认左边界
}

while (!s.empty()){
	
	int h=height[s.top()]
	s.pop()
	result=max(result,(n-1-(s.empty()?-1:s.top()))*h)
}

return result;