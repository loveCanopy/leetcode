/*连灯泡的问题
 *
 * glowState数组，灯泡的状态 0 表示不亮， 1 表示亮
 * distanceOfBulb数组，灯泡相邻的距离
 *
 * 只要把不亮的灯泡接到亮的灯泡上即可，求最短的连接长度
 */
 public static int minWireLength(int numOfBulbs, int[] glowState, 
             int[] distanceOfBulb)    
	 {
// WRITE YOUR CODE HERE
		 	int distance=0;
		 	int sum=0;
		 ArrayList<Integer> no_light=new ArrayList<Integer>();
		 ArrayList<Integer> light=new ArrayList<Integer>();
		 for(int i=0;i<glowState.length;i++){
			 if(glowState[i]==0){
				 no_light.add(i);
			 }
			 if(glowState[i]==1){
				 light.add(i);
			 }
		 }
		 HashMap<Integer,Integer> hashMap=new HashMap<>();
		 ArrayList<Integer> min_list=new ArrayList<>();
		 while(no_light.size()!=0||!no_light.isEmpty()){
			 for(int i=0;i<no_light.size();i++){
				 int min=Integer.MAX_VALUE;
				 for(int j=0;j<light.size();j++){
					 distance=Math.abs(distanceOfBulb[no_light.get(i)]-distanceOfBulb[light.get(j)]);
					 if(distance<min){
		 					min=distance;
		 				}
				 }
				 hashMap.put(no_light.get(i), min);
				 min_list.add(min);
			 }
			 for(Entry<Integer, Integer> entry:hashMap.entrySet())
			  {
			   System.out.println(entry.getKey()+"="+entry.getValue());
			  }
			 Collections.sort(min_list);
			 sum+=min_list.get(0);
			 for(Object obj:hashMap.keySet()){
				 Object key=obj;
				 Object val=hashMap.get(key);
				 if(val==min_list.get(0)){
					 no_light.remove(obj);
					 light.add((int)obj);
					 break;
				 }
			 }
			 hashMap.clear();
			 min_list.clear();
			 
		 }
		 	return sum;
		 	
}
