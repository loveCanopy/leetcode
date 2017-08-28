/*
袋鼠的跳出牢笼  最少要跳多少步
 * */
public static int getDaishu(int n,int[] arr){
		int dp[]=new int[n+1];
		dp[0]=0;
		for(int i=1;i<=n;i++){
			dp[i]=Integer.MAX_VALUE;
			for(int j=i-1;j>=0;j--){
				if(arr[j]==0) continue;
				if(j+arr[j]>=i){
					dp[i]=Math.min(dp[i], dp[j]+1);
				}
			}
		}
		return dp[n];
	}

