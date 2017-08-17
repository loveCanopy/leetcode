/*
 *输入M、N，1 < M < N < 1000000，求区间[M,N]内的所有素数的个数。素数定义：除了1以外，只能被1和自己整除的自然数称为素数
 * */
public static int getSu1(int m,int n){
		int count=0;
		for(int i=m;i<=n;i++){
			int j=2;
			if(i!=1){
				if(i==2){
					count++;
				}
			while(i%j!=0){
				if(j==i-1){
					System.out.println(i);
					count++;
					break;
				}else{
					j++;
				}
			}
			}
			
		}
		return count;
		
	}
/*
给定一个未排序的数列，找到此数列在已排序状态下的两个相邻值的最大差值，少于两个值时返回0。例如：给定数列 [1,3,2,0,1,6,8] 则 最大差值为3。注意：请尽量使用时间复杂度为O(n)的方案。
*/
public static int getMax(int n,int[] a){
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;			
				}
		
			}	
		}
		
		int max=a[1]-a[0];
		for(int i=2;i<a.length;i++){
			int j=i-1;
			if((a[i]-a[j])>max){
				max=a[i]-a[j];
			}
			
		}
		
		
		return max;
		
	}
