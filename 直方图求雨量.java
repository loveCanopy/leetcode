package newCoder;
/*
  max(0,i-1) i max(i+1,a.length-1)
*/
public class liuShui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]a={3,1,2,4};
		System.out.println(liuShui(a));
	}

	public static int liuShui(int[] a){
		    int result = 0;
			for(int i=0;i<a.length;i++){
				if(i==0){
					result+=Max(a,1,a.length-1)-a[i];
				}else if(i==a.length-1){
					result+=Max(a,0,a.length-2)-a[i];
				}
				else{
					result+=Math.min(Max(a,0,i-1), Max(a,i+1,a.length-1))-a[i];
			}
			}
			return result;
		}
		
	public static int Max(int []a,int start,int end){
		
		if(start==end){
			return a[start];
		}else {
			return Math.max(Max(a,start,end-1),a[end]);
		}
		
		
		
	}
	
	
		
	}
	
	
	


