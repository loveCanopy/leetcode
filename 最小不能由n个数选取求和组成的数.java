链接：https://www.nowcoder.com/questionTerminal/876e3c5fcfa5469f8376370d5de87c06
来源：牛客网

 private static int check(int[] X, int n){
	    if (X[0]>1) return 1;
		   else if (n == 1) return X[0]+1;
		      else {
				       int sum = X[0];
					        for (int i = 1; i < n; i++) {
								       if (X[i]-sum>1) break;
									          else sum += X[i];
											       }
							     return sum+1;
								    }
			   }
