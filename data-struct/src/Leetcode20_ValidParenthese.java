import java.util.*;
import java.util.Stack;

public class Leetcode20_ValidParenthese {




    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> paren = new HashMap<>();
        paren.put(')', '(');
        paren.put(']', '[');
        paren.put('}', '{');

        for (int i = 0; i < s.length(); i ++) {

            if (paren.values().contains(s.charAt(i))){

                stack.push(s.charAt(i));

            } else {

                if (paren.keySet().contains(s.charAt(i))){

                    if(stack.size() == 0) {

                        return false;
                    }

                    if (stack.pop() != paren.get(s.charAt(i))){
                        return false;
                    }
                }
            }

        }

        return stack.size() == 0;

    }
}
