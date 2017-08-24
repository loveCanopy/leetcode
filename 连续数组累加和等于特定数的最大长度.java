/*   假设找到0到i中特定值等于400的数组的长度
     已知0到i的长度为总和为700
	 每次计算0到k的数值累加和 放到一个hashmap中 0到ki 数值和为300  并且sum，index都在
     hashmap中了  那么i-index即位所求
	 * 连续数组累加和等于特定值的数组的最大长度
	 * {1，2，1，2，4，7，7} 假设特定值为7 则满足条件的为{1，2，4} 长度为3
	 * */
	public static int getMaxSz(int[] arr,int n){	
		HashMap<Integer,Integer> hashmap=new HashMap<>();
		int sum=0;
		int sub=0;
		int len=0;
		hashmap.put(0, -1);
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
			sub=sum-n;
			if(!hashmap.containsKey(sub)){
				hashmap.put(sum, i);
			}else{
				len=Math.max(len,i-hashmap.get(sub));
			}
			
		}
		return len;
	}
	/*
	 * 找到交错的01字串 并且01的个数相等最多的最大长度
	 * 0001010101011 得到0101010101的长度
	 * */
	public static int getMaxsz1(int[] arr,int n){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				arr[i]=-1;
			}
		}
		return getMaxSz(arr, 0);
	}
	
