// class Solution {
//    public boolean isPalindrome(String s) {

// 		String finished = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
// 		return finished.equals(new StringBuffer(finished).reverse().toString()) ? true : false;
// 	}
// }


class Solution {
public boolean isPalindrome(String s){
String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
String rev = new StringBuffer(actual). reverse().toString();
return actual.equals(rev);
}}
