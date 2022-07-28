class Solution {
    public boolean isAnagram(String s, String t) {
//         if(s.length() == t.length())
//             return true;

//         for(int i =0; i<s.length(); i++){
//             for(int j =0; j<t.length(); j++){
//                 if(s.charAt(i)== t.charAt(j))
//                     return true;
//             }
//         }
//         return false; 
        
    

 char[] charArray1 = s.toCharArray();
      char[] charArray2 = t.toCharArray();

      // sort the char array
      Arrays.sort(charArray1);
      Arrays.sort(charArray2);

      // if sorted char arrays are same
      // then the string is anagram
      boolean result = Arrays.equals(charArray1, charArray2);
    return result; 

        
        
}
 }