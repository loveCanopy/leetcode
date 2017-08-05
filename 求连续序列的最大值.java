public static int getMax(int[] a){
		int max=0;
		for(int start=0;start<a.length;start++){
			for(int end=start;end<a.length;end++){
				int sum=0;
				for(int index=start;index<=end;index++){
				   sum+=a[index];
				}
				if(sum>max){
					max=sum;
				}
				
		}
			
		}
	
		return max;
	}

改进：
public static int getMax1(int[] a){
		int max=0;
		for(int start=0;start<a.length;start++){
			int sum=0;
			for(int end=start;end<a.length;end++){
				sum+=a[end];
				if(sum>max){
					max=sum;
				}
				
		}
			
		}
	
		return max;
		
		
	}
