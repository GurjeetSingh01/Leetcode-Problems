// class Solution {
//    public boolean isPalindrome(String s) {

// 		String finished = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
// 		return finished.equals(new StringBuffer(finished).reverse().toString()) ? true : false;
// 	}
// }


class Solution {
// public boolean isPalindrome(String s){
// String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
// String rev = new StringBuffer(actual). reverse().toString();
// return actual.equals(rev);
// }}


public boolean isPalindrome(String s) {
        StringBuilder content = new StringBuilder();
        for(int i = 0; i < s.length(); i++) 
            if(Character.isLetterOrDigit(s.charAt(i)))
                content.append(s.charAt(i));
        content = new StringBuilder(content.toString().toLowerCase());
        String value = content.toString();
        return value.equals(content.reverse().toString());
    }

}