	/*
	 * 最长01字串的长度
	 * */
	public static int getLen(String str){
		char[] charArray = str.toCharArray();
		int[] dp=new int[charArray.length];
		dp[0]=1;
		for(int i=1;i<charArray.length;i++){
			if(charArray[i]!=charArray[i-1]){
				dp[i]=dp[i-1]+1;
			}else{
				dp[i]=1;
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<dp.length;i++){
			if(dp[i]>max)
				max=dp[i];
		}
		return max;
	}
