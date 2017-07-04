import java.util.Stack;  
//用栈实现  
public class GetAllSubsetByStack {  
  
    /** Set a value for target sum */  
    public static final int TARGET_SUM = 15;  
  
    private Stack<Integer> stack = new Stack<Integer>();  
  
    /** Store the sum of current elements stored in stack */  
    private int sumInStack = 0;  
  
    public void populateSubset(final int[] data, int fromIndex, int endIndex) {  
  
        if (sumInStack >= TARGET_SUM) {  
            if (sumInStack == TARGET_SUM) {  
                print(stack);  
            }  
            // there is no need to continue when we have an answer  
            // because nothing we add from here on in will make it  
            // add to anything less than what we have...  
            return;  
        }  
  
        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {  
  
            if (sumInStack + data[currentIndex] <= TARGET_SUM) {  
                stack.push(data[currentIndex]);  
                sumInStack += data[currentIndex];  
  
                /* 
                 * Make the currentIndex +1, and then use recursion to proceed 
                 * further. 
                 */  
                populateSubset(data, currentIndex + 1, endIndex);  
                sumInStack -= (Integer) stack.pop();  
            }  
        }  
    }  
  
    /** 
     * Print satisfied result. i.e. 15 = 4+6+5 
     */  
  
    private void print(Stack<Integer> stack) {  
        StringBuilder sb = new StringBuilder();  
        sb.append(TARGET_SUM).append(" = ");  
        for (Integer i : stack) {  
            sb.append(i).append("+");  
        }  
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());  
    }  
}  

//不用栈实现

import java.util.Arrays;  
  
public class GetAllSubsets {  
  
    /** Set a value for target sum */  
    public static final int TARGET_SUM = 15;  
  
    public void populateSubset(final int[] data, int fromIndex,  
            final int[] stack, final int stacklen, final int target) {  
        if (target == 0) {  
            // exact match of our target. Success!  
            printResult(Arrays.copyOf(stack, stacklen));  
            return;  
        }  
  
        while (fromIndex < data.length && data[fromIndex] > target) {  
            // take advantage of sorted data.  
            // we can skip all values that are too large.  
            fromIndex++;  
        }  
  
        while (fromIndex < data.length && data[fromIndex] <= target) {  
            // stop looping when we run out of data, or when we overflow our  
            // target.  
            stack[stacklen] = data[fromIndex];  
            populateSubset(data, fromIndex + 1, stack, stacklen + 1, target  
                    - data[fromIndex]);  
            fromIndex++;  
        }  
    }  
  
    private void printResult(int[] copyOf) {  
        StringBuilder sb = new StringBuilder();  
        sb.append(TARGET_SUM).append(" = ");  
        for (Integer i : copyOf) {  
            sb.append(i).append("+");  
        }  
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());  
    }  
}  