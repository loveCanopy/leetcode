#第一个为大写  以后不能出现大写
public class Solution {

	    public boolean detectCapitalUse(String word) {

			        return word.matches("[A-Z]+|[A-Z]?[a-z]*");

					    }

}
