滑动窗口最大值
题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
那么一共存在6个滑动窗口，他们的最大值分别为{4.4,6,6,6,5}。
我们并不把滑动窗口的每个数值都存入队列中，而只把有可能成为滑动窗口最大值的数值存入到
一个两端开口的队列。接着以输入数字{2,3,4,2,6,2,5,1}为例一步分析。
数组的第一个数字是2，把它存入队列中。第二个数字是3.由于它比前一个数字2大
，因此2不可能成为滑动窗口中的最大值。2先从队列里删除，再把3存入到队列中。此时队列中只有一个数字3.针对第三个数字4的步骤类似，最终在队列中只剩下一个数字4.此时滑动窗口中已经有3个数字，而它的最大值4位于队列的头部。
接下来处理第四个数字2。2比队列中的数字4小。当4滑出窗口之后2还是有可能成为滑
动窗口的最大值，因此把2存入队列的尾部。现在队列中有两个数字4和2，其中最大值4仍然位
于队列的头部。
下一个数字是6.由于它比队列中已有的数字4和2都大，因此这时4和2已经不可能成为滑动
窗口中的最大值。先把4和2从队列中删除，再把数字6存入队列。这个时候最大值6仍然位于队列的头部。
第六个数字是2.由于它比队列中已有的数字6小，所以2也存入队列的尾部。此时队列中有两个数字，
其中最大值6位于队列的头部。
接下来的数字是5.在队列中已有的两个数字6和2里，2小于5，因此2不可能是一个滑动窗口的最大值，
可以把它从队列的尾部删除。删除数字2之后，再把数字5存入队列。此时队列里剩下两个数字6和5，
其中位于队列头部的是最大值6.数组最后一个数字是1，把1存入队列的尾部。注意到位于队列头部的数字6是
数组的第5个数字，此时的滑动窗口已经不包括这个数字了，因此应该把数字6从队列删除。
那么怎么知道滑动窗口是否包括一个数字？应该在队列里存入数字在数组里的下标，而不是数值。
当一个数字的下标与当前处理的数字的下标之差大于或者等于滑动窗口的大小时，
这个数字已经从滑动窗口中滑出，可以从队列中删除了。

/**************************************************************      
* Copyright (c) 2016, 
* All rights reserved.                   
* 版 本 号：v1.0                   
* 题目描述：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
* 			那么一共存在6个滑动窗口，他们的最大值分别为{4.4,6,6,6,5}。
* 输入描述：请输入一个数组：以空格隔开
*			2 3 4 2 6 2 5 1
*			请输入滑动窗口的大小：
*			3
* 程序输出： 滑动窗口的最大值为：
*			[4, 4, 6, 6, 6, 5]
* 问题分析： 队列：队列中允许进行插入操作的一端称为队尾，允许进行删除操作的一端称为队头。队列的插入操作通常称作入队列，队列的删除操作通常称作出队列。
* 算法描述：见程序
* 完成日期：2016-10-18
***************************************************************/ 

package org.marsguo.offerproject65;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class SolutionMethod1{
	public ArrayList<Integer> maxInWindows(int[] num,int size){
		ArrayList<Integer> ret = new ArrayList<>();
		if(num == null){
			return ret;
		}
		if(num.length < size || size < 1){
			return ret;
		}
		
		LinkedList<Integer> indexDeque = new LinkedList<>();		//用于保存滑动窗口中的数字
		
		/*
		滑动窗口内部，用于判断窗口中的最大值
		*/
		for(int i = 0; i < size - 1; i++){
			while(!indexDeque.isEmpty()&& num[i] > num[indexDeque.getLast()]){			//getLast为插入端
				indexDeque.removeLast();			//将前面比K小的直接移除队列，因为不可能成为滑动窗口的最大值
			}
			indexDeque.addLast(i);					//将数字存入滑动窗口中
		}
		 
		/*
		滑动整个窗口
		*/
		for(int i = size - 1; i < num.length; i++){
			while(!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]){			//getLast为插入端，队尾
				indexDeque.removeLast();				//将前面比K小的直接移除队列，因为不可能成为滑动窗口的最大值
			}
			indexDeque.addLast(i);
			//System.out.println("indexDeque = " + indexDeque.getFirst() + ",i = " + i);				//getFirst为允许删除端，队头
			if(i - indexDeque.getFirst() + 1 > size){
				indexDeque.removeFirst();
			}
			
			ret.add(num[indexDeque.getFirst()]);		//每次添加的是num[indexDeque.getFirst()],而不是indexDeque.getFirst().
		}
		return ret;
	}
}

public class MaxInWindows {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个数组：以空格隔开");
		String str = scanner.nextLine();
		
		System.out.println("请输入滑动窗口的大小：");
		int k = scanner.nextInt();
		
		String[] tmp = str.split(" ");
		int[] arrays = new int[tmp.length];
		for(int i = 0; i < tmp.length;i++){
			arrays[i] = Integer.parseInt(tmp[i]);
		}
		scanner.close();
		
		SolutionMethod1 solution1 = new SolutionMethod1();
		System.out.println("滑动窗口的最大值为：");
		System.out.println(solution1.maxInWindows(arrays, k));
	}
}
