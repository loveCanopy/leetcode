c static int getNum(int[] a){
		int [] b=new int[a.length-1];
		for(int i=0;i<a.length-1;i++){
			b[i]=a[i+1]-a[i];
		}
		int j=0;
		int  count=1;
		int flag=0;
		while(j<=b.length-1){
			if(b[j]>0){
				if(flag==0){
					flag=1;
				}
				if(flag==-1){
					flag=0;
					count++;
				}
				
			}
			else{
				if(flag==0){
					flag=-1;
				}
				if(flag==1){
					flag=0;
					count++;
				}
			}
			j++;
			
		}
		
		
		return count;
		
		
		
	}
