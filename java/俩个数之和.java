Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
#自己写的测试程序
public static int[] twoSum(int [] nums,int target){
		int[] result=null;
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target){
					System.out.println(i+""+j);
					result=new int[]{i,j};
					break;
				}else{
					continue;
				}
			}
		}
		
		return result;
	
	}
#官方代码示例
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(tracker.containsKey(nums[i])){
                int left = tracker.get(nums[i]);
                System.out.println(left+""+i);
                return new int[]{left,i};
            }else{
                tracker.put(target - nums[i], i);
            }
        }
        return new int[2];
    }


