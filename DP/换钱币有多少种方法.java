public static int getMoneyCount(int n){
		//定义一个二维数组 dp[i][j]  在使用0到i的钱币下  j所需要的张数  
		int[] money={1,5,10,20,50,100};
		int[][] dp=new int[money.length][n+1];
		for(int i=0;i<money.length;i++){
			dp[i][0]=1;
		}
		for(int j=0;j<n+1;j++){
			dp[0][j]=1;
		}
		for(int i=1;i<money.length;i++){
			for(int j=1;j<n+1;j++){
				if(j>=money[i]){
					  dp[i][j]=dp[i-1][j]+dp[i][j-money[i]];
				}else{
					   dp[i][j]=dp[i-1][j];
				}
				
			}
		}
		return dp[5][n];
	}
