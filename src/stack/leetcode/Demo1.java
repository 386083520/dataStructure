package stack.leetcode;

import java.util.Stack;

public class Demo1 {
    // 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '{' || c == '(') { // (){}{[]}
                stack.push(c);
            }else {
                if(stack.empty()) {
                    return false;
                }
                char popChar = stack.pop();
                if((c == '}' && popChar != '{') || (c == ')' && popChar != '(') || (c == ']' && popChar != '[')) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
