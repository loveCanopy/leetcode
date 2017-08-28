/*连续子数组中最大和
	 * */
public static int getMaxsz(int[] arr){
		int[] dp=new int[arr.length];
		dp[0]=arr[0];
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
				if(dp[i-1]+arr[i] > arr[i])
					dp[i]=dp[i-1]+arr[i];
				else
					dp[i]=arr[i]; 
				if(dp[i]>max)
					max=dp[i];
		}
		
		return max;
	}
	
	public static int getMaxsz1(int[] arr){
		int[] dp=new int[arr.length];
		dp[0]=arr[0];
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			  dp[i]=Math.max(arr[i], arr[i]+dp[i-1]);
			  max=Math.max(max,dp[i]);
		}
		return max;
		
	}
	public static int getShuzuMax(int []a ){
		int cur=0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			 cur+=a[i];
			 max=Math.max(max, cur);
			 cur=cur<0?0:cur;  //寻找下一个不为0的前缀
		}
		
		return max;
	}
/*
	 * 连续子数组中最大乘积
	 * 以i结尾的情况下
	 * 100 -10 -2    i-1最小  加i变大
	 * 100 10 2  i-1为最大  加i更大
	 * 100 10 0   不要i
	 * 0.1  0.01 1000  必须从i开始
	 * */
	public static int getShuzuchengji(int[] a){
		
		int[] dp=new int[a.length]; //存取最大值
		int[] dp_min=new int[a.length]; //存取最小值
		dp[0]=a[0];
		dp_min[0]=a[0];
		int Max=Integer.MIN_VALUE;
		for(int i=1;i<a.length;i++){
			dp[i]=getThreeMax(a[i],dp[i-1]*a[i],dp_min[i-1]*a[i]);
			dp_min[i]=getThreeMin(a[i],dp[i-1]*a[i],dp_min[i-1]*a[i]);
			Max=Math.max(Max, dp[i]);
		}
		
			return Max;
		}
	public static int getThreeMax(int a,int b,int c){
		int max=a>b?a:b;
		max=max>c?max:c;
		return max;
		
	}	
	public static int getThreeMin(int a,int b,int c){
		int min=a<b?a:b;
		min=min<c?min:c;
		return min;
		
	}
	
