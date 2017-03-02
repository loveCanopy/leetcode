public  static int reverse(int x)
	{
	    int result = 0;
	    while(true){
	    		int n=x%10;  //取出最低位上的数字  
	              result=result*10+n;  //依次的反转存储得到反转的数字  
	              x=x/10;//降位  
	              if(x==0)  
	              {  
	                  break;  
	              }  
	 
	}
		return result;
	
	}
