#选取一个堆栈 遇到（ 压入） 
	`		  遇到{ 压入 }
			  遇到[ 压入 ]
在匹配下一个字符是否与stack.pop()相同

public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
