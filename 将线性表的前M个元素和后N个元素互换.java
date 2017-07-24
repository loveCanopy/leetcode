/*
[a1,a2,a3,..,am,b1,b2,..,bn]
申请一个辅助空间，长度为1
* 先将b1放到辅助空间，a1,..,am整体后移，将b1，放到a1的位置
* ...
* */
	public static int[] swap(int []a,int m,int n){
		    int[] help=new int[1];
            for(int i=1;i<=n;i++){		
			help[0]=a[m+i-1];
			//避免复制的时候复制前一个元素，采取从后向前的复制方法
			for(int j=m-1+(i-1);j>=i-1;j--){
				int temp=j+1;
				a[temp]=a[j];
			}
			a[i-1]=help[0];
            }
		
		  return a;
	}
