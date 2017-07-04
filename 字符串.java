一。0-1交换，排序，设定交换次数
for(int i=0;j=length-1;i++,j--){
	for(;(i<j)&&(a[i]==0);++i);
	for(;(i<j)&&(a[j]==1);--j);
	if(i<j) ++answer

}

二。删除字符串中的a ，复制b
//删除a
int n=0,numb=0;
for (int i=0;s[i];++i){
	if(s[i]!=a){
		s[n++]=s[i];
	}

	if(s[i]==b){
	  ++numb;   //统计B的个数
	}

}
//复制b 从后向前开始操作 倒着复制
int newlenght=n+numb;
s[newLength]=0;
for(int i=newlenght-1,j=n-1;j>=0;--j){
	
	s[i--]=s[j];
	if(s[j]==b){
		s[i--]='b'
	}
}

三。一个字符有* 数字，将*放到开头  顺序不变
1.
[0,i-1] *
[i,j-1] 数字
[j,n] 没有探测

for(int i=0,j=0;j<n;++j){
	if(s[j]==*){
		swap(s[i++],s[j]) *位置和第一个数字交换，交换后 i++ 仍指向第一个数字
	}
}

2.
先把数字都复制过来 然后剩下的都复制为*
int j=n-1;
for(int i=n-1;i>=0;i--){
	if(isdigit(s[i])){
		s[j--]=s[i];
	}

}
for(;j>=0;--j){
	s[j]="*"
}

四。变位串
例如 a='hello' 字串的变形为变位串
滑动窗口模式
int nonzero=0
for(int i=0;i<lenb;++i){
	if(++num[b[i]='a']==1){
	++nonzero;  //统计新字母出现的次数

	}
}
```
计算字符种类差
for(int i=0;i<lenb;++i){

	int c=a[i]-'a';  将a中的字母变成0-25数字
	--num[c];
	if(num[c]==0){
		//原来是1 出现过
		--nonZero;
	}else if(num[c]==-1){
	   //原来是0 没有出现过
	   ++nonZero;
	}

}

if(nonZero==0){
	return true;
}
```
窗口滑动:新窗口a[i-lenb+1,i]
         旧窗口a[i-lenb,i-1]
扔掉a[i-lenb] 加入a[i]
for (int i = lenb; i < lena; ++i) {
		int c = a[i – lenb] – ‘a’;
		++num[c];
		if (num[c] == 1) ++nonZero;
		else if (num[c] == 0) --nonZero;
		c = a[i] – ‘a’;
		--num[c];
		if (num[c] == 0) --nonZero;
		else if (num[c] == -1) ++nonZero;
		if (nonZero == 0) return true;
}

判断是否为变位串
for(int i=0; i<s1_length; i++){  
            int index = s1_char[i] - 'a';    
            nums[index]++;    
        }  
  
        for(int i=0; i<s1_length; i++){  
            int index = s2_char[i] - 'a';    
            nums[index]--;    
        }  
          
        for(int i=0; i<nums.length; i++){  
            if(nums[i]>0) return false;  
        }  
          
        return true;  

五。单词反转

字符串循环移位
前m%n 反转，后n-m%n反转
整体反转














