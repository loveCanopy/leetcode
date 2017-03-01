Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
	   ↑   ↑
#java.lang.Integer.bitCount() 方法返回数字1位的二进制补码表示指定的int值i。这有时被称为作为总体计数	   
public class Solution {
	public int hammingDistance(int x, int y) 
	        return Integer.bitCount(x ^ y);

					    }

}
