/*
如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列
*/
public static boolean getDengcha(int n,int[] a){
		Arrays.sort(a);
		int d=a[0]-a[1];
		for(int i=1;i<n-1;i++){
			if(a[i]-a[i+1]!=d){
				return false;
			}
			if(i==n-2){
				return true;
			}
		}
		
		return true;
	}
/*
小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
1、将a_i放入b序列的末尾
2、逆置b序列
小易需要你计算输出操作n次之后的b序列。
*/
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
 
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            for (int i = n - 1; i >= 0; i -= 2) {     // 前一半从最后一个数开始以2为步长递减
                System.out.print(nums[i] + " ");
            }
            for (int i = n % 2; i < n - 2; i += 2) {  // 后一半根据整数个数的奇偶，分别从第二个或第一个数开始以2为步长递增
                System.out.print(nums[i] + " ");
            }
            System.out.print(nums[n - 2]);  // 最后一个数
        }
    }
}

/*
小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
*/

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int rentPay=sc.nextInt();
        int appleNum=sc.nextInt();
        int totalMoney=sc.nextInt();
        int applePrice=sc.nextInt();
         
        if(totalMoney/rentPay<=appleNum)
            System.out.println(totalMoney/rentPay);
        else
            System.out.println(appleNum+(totalMoney-appleNum*rentPay)/(applePrice+rentPay));
         
        sc.close();
    }
}


/*
小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.
*/
public static int[] getQizi(int n,int[] x,int[] y){
		int [] result=new int[n];
		for(int i=0;i<result.length;i++){
			result[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<n;i++){
			/*当i取0的时候   
			 * 0,7,1,1,4,--------------   第一个点x[0]y[0]到各点的距离
			   7,0,8,8,9,--------------   第二个点x[1]y[1]到各点的距离
			   1,8,0,0,5,--------------   第三个点x[2]y[2]到各点的距离
			   1,8,0,0,5,--------------   第四个点x[3]y[3]到各点的距离
			   4,9,5,5,0,--------------   第五个点x[4]y[4]到各点的距离
			   在上述中取 最小的值  即0
			 当i=1， 即处理第二的点时 ,取每个行中  俩个元素之和最小的和   即0+0
			   当i=2， 即处理第三的点时 ,取每个行中  三个元素之和最小的和   即0+0+1
			    当i=3， 即处理第四的点时 ,取每个行中  四个元素之和最小的和  即0+1+1+4
			   当i=4， 即处理第五的点时 ,取每个行中  五个元素之和最小的和   即 0+7+1+1+4
			 * */
			
				for(int k=0;k<n;k++){
					int[] res=new int[n];
					for(int l=0;l<n;l++){  
						res[l]=Math.abs(x[l]-x[k])+Math.abs(y[l]-y[k]);
					}
					Arrays.sort(res);
					int res3=0;
					for(int l=0;l<=i;l++){
						res3=res3+res[l];
					}
					result[i]=Math.min(res3, result[i]);
				}
		
		}
		
		return result;
	}
/*
小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
*/
case 90%
	public static int getZuiMax(int n,int[] arr){
		Arrays.sort(arr);
	    int[] b=new int[n];
	   int j=1;
	   int mid=n%2!=0 ? n/2:(n-1)/2;
	   b[mid]=arr[n-1];
	   while(mid+j<=n-1||mid-j>=0){
		  if(n%2!=0){
			  if(j%2!=0){ //j为奇数
				   if(mid-j>=0){
					   b[mid-j]=arr[j-1];
				   }
				   b[mid+j]=arr[j]; 
			   }else{  //j为偶数
				   if(mid-j>=0){
					   b[mid-j]=arr[n-j-1];
				   }
				   b[mid+j]=arr[n-j];
			   }
		  }else{
			  if(j%2!=0){ //j为奇数
				   if(mid-j>=0){
					   b[mid-j]=arr[j];
				   }
				   b[mid+j]=arr[j-1];
				  
			   }else{  //j为偶数
				   if(mid-j>=0){
					   b[mid-j]=arr[n-j-1];
				   }
				   b[mid+j]=arr[n-j];
				   
			   }
		  }
		  j++;
	   }

	   for(int i:b){
		   System.out.print(i+",");
	   }
	   System.out.println("------------------");
	   int max=0;
	   int result=0;
	   for(int i=0;i<b.length-1;i++){
		   int val=Math.abs(b[i]-b[i+1]);
		   result+=val;
	   }
		return result;
	}
/*
如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
*/
思路：使用动态规划的思想，定义一个dp数组，dp【i】表示以下标为i的字符结尾的最长交错01串，
显然       当i和i-1位置上的字符相等时，dp【i】 = 1；否则，dp【i】=dp【i-1】+1；最后求出dp数组中的极大值即可；           
public class Demo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String s = in.nextLine();
			int[] dp = new int[s.length()];
			dp[0] = 1;
			for (int i = 1; i < dp.length; i++) {
				if (s.charAt(i - 1) != s.charAt(i)) {
					dp[i] = dp[i - 1] + 1;
				} else {
					dp[i] = 1;
				}
			}
			int max = 0;
			for (int i : dp) {
				if (i > max) {
					max = i;
				}
			}
			System.out.println(max);
		}
	}
	
}

