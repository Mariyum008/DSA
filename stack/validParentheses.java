import java.util.*;

public class validParentheses {
    public static boolean checkValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                s.push(str.charAt(i));
            } else {
                if (s.isEmpty()) {
                return false;
            }
            if ((s.peek() == '(' && str.charAt(i) == ')')
                    || (s.peek() == '[' && str.charAt(i) == ']')
                    || (s.peek() == '{' && str.charAt(i) == '}')) {
                s.pop();
            } else {
                return false;
            }
        }
    }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            // chosing
            if(ch == ')'){
                int count = 0;
                while (s.peek() !='(' ) {
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true; //duplicate.
                } else{
                    s.pop(); //opening pair.
                }
            } else{
                // opening
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(({[]})())";
        System.out.println(checkValid(str));
        System.out.println(isDuplicate(str));
    }
    
}
