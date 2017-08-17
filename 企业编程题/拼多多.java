/*
 *给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * */
先排序
比较前三个 和后三个相乘之和哪个大

/*
 *有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 * */
public static void reverseOrder(char[] a,int p,int q){
		char temp;
		while(p<q){
			temp=a[p];
			a[p]=a[q];
			a[q]=temp;
			p++;
			q--;
		}
	}
	/**
	 * 最大整数的乘法
	 * */
	public static String getMaxMulti(String a,String b){
		char[] a_result=a.toCharArray();
		char[] b_result=b.toCharArray();
		int m=a.length();
		int n=b.length();
		char[] result=new char[m+n];
		reverseOrder(a_result,0,m-1);
		reverseOrder(b_result,0,n-1);
		for(int i=0;i<n;i++){  //B的每一位
			int multi=0;
			int add=0;
			for(int j=0;j<m;j++){
				int temp_1=(a_result[j]-48)*(b_result[i]-48)+multi;
				multi=temp_1/10;
				temp_1=temp_1%10;
				int temp_2=(result[i+j]-48)+temp_1+add;
				add=temp_2/10;
				result[i+j]=(char) ((temp_2%10)+48);
			
			}
			result[i+m]+=multi+add;
			
		}
		reverseOrder(result, 0, m+n-1);
		return result.toString();
	}
	

