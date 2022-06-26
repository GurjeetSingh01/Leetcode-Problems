class Solution {
public String interpret(String command){
String str = command.replace("()", "o");
String cmd = str.replace("(al)", "al");
return cmd;
}}
