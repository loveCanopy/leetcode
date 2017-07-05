众数
分析：每次扔掉俩个不同的数
1.如果扔掉为一个众数，一个非众数
2.如果扔掉的都为非众数
摩尔投票法 Moore Voting
public class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {res = num; ++cnt;}
            else if (num == res) ++cnt;
            else --cnt;
        }
        return res;
    }
}

最大间隙问题：（元素分段法/分桶法（bucket）
（一）问题：
已知一个整数数组a
,找出n个元素在数轴上两个相邻元素之间的最大间距。
（二）解析：

（1）方案一：
先对n个数据排序，然后扫描一遍可以找到有序数组中相邻元素的最大间距。
（ 时间复杂度为O(n*lgn) ）

（2）方案二：O(n)
这个问题很经典，解法很巧妙。如果是要求O(nlogn)的做法，那么只需要简单地排序一下就行了。但是这里要求O（n）,就需要另外的方法了。基于比较的排序方法，最好的也是O（nlogn），但是，还有一些不是基于比较的排序方法，例如桶排序。桶排序加速的思想为分治，将元素划分为若干个更小规模的桶，以后处理的时候，只需要处理同一个桶的元素。
说回这道题，这道题的思路也是用桶。假设有数组x[1...n]，其中最大的元素为max，最小元素为min，将左闭右开的实数区间[min，max)划分为n-1个等长的子区间（桶），每个子区间也是左闭右开的，我们用len来表示每个子区间的长度。除去max和min，剩下的n-2个数，每个数都属于其中一个桶。对于同一个桶的两个数，因为桶是左闭右开的，所以他们的距离肯定是小于len的。然后，关键的一点是，n-2个数放进n-1个桶，由抽屉原理可以知道，肯定有一个桶是空的，所以，距离最远的相邻的两个数，肯定是属于两个不同的桶。于是，我们可以把每个桶都扫描一次，相邻最远的两个数，必定其中一个是某个桶里的最大值，另一个是另一个桶里的最小值。
 不过，事情还没完。刚才我们的做法是除去了max和min的，所以，最后我们还要考虑max和min对问题答案的影响，除了用上面的方法算出一个可能的答案外，我们还要考虑这两个数会不会是答案：“min 和 第一个桶的最小值的距离”， “max 和 最后一个桶的最大值的距离”。
 #define MAXINT (1<<31)-1
#define MININT 1<<31
typedef struct _bucket
{
    int min, max;
} Bucket;

/*求取数组a[n]在数轴上的相邻两个元素的最大间距*/
int maxGap(int *a, int n)
{
    int max = MININT, min = MAXINT, i;
    double bucketLen;
    //扫描一遍数组，得到最大值max,最小值min.复杂度为O(n)
    for(i = 0; i < n; ++i)
    {
        if(a[i] > max) max = a[i];
        if(a[i] < min) min = a[i];
    }
    bucketLen = (max-min) * 1.0 / (n-1);//桶的大小，即每段区域的大小
    Bucket *bucket = new Bucket[n-1];//开辟n-1段区域。

    //初始化每段区域的最大，最小值,即初始化每段区域为空 。
    for(i = 0; i < n-1; ++i)
    {
        bucket[i].max = MININT;
        bucket[i].min = MAXINT;
        
    }
    //初始化第一个区域的最大，最小值为min,
    //初始化第n-1个区域的最大，最小值为max.
    bucket[0].max = min; bucket[0].min = min;
    bucket[n-2].max = max; bucket[n-2].min = max;

    //将数组中的其他n-2个数，放到n-1个区域中。并且获得每个区域的最大，最小值。复杂度为O(n)
    for(i = 0; i < n; ++i)
    {
        int index;
        if(a[i] != min && a[i] != max)
        {
            index = (a[i]-min) * 1.0 / bucketLen;
            //获取当前元素坐在区域的区域号。区域号从0~n-2;

            if(bucket[index].max < a[i]) bucket[index].max = a[i];
            if(bucket[index].min > a[i]) bucket[index].min = a[i];
        }
    }

//最大间距在两个相邻区域出现，或者两个不相邻的区域出现且中间区域为空，
//最大间距一定是前一个区域的最大值与后一个区域的最小值之间出现。

    int low = -1, high = -1, maxGap = 0, curGap, pre = 0;
//low记录的是最大间距的前一个数，high记录的是最大区间的后一个数。
//maxGap为最大间距，pre为最大间距出现的两个区域中的前一个区域的编号。

    for(i = 1; i < n-1; ++i)
    {
        if(bucket[i].max != MAXINT)//区域i非空
        {
            curGap = bucket[i].min - bucket[pre].max;
            if(curGap > maxGap)
            {
                maxGap = curGap;
                low = bucket[pre].max, high = bucket[i].min;
            }
            pre = i;
        }
    }
    printf("the maximum gap is %d, between %d and %d!\n", maxGap, low, high);
    return maxGap;
}

int main()
{
    int a[] = {1,8,4,5,6};
    maxGap(a,5);
    return 0;
}

求数组中连续一段和，绝对值最小
1> 如果数组全正数或全是负数,那么就等价于寻找绝对值最小的那个数。
2》数组中出现0，则这就是最小的和了。
3》有正数有负数无0的情况。

a。首先寻找到绝对值最小的那个数。
b。寻找出现正负数交替的边界，两数相加曲绝对值，然后跟最小的绝对值比较，一直加到再次出现正负交替或者，再循环。