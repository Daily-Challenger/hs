import java.util.Stack;

public class Main_8 {

    public static void main(String[] args) {
     
        String s = "(()(";

        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        boolean answer = false;

        char[] charArray = s.toCharArray();

        if(charArray[0] == ')') {
            return answer;
        }

        Stack<Character> stack = new Stack<>();

        for(char c : charArray) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return answer;
                }
                stack.pop();
            }
        }

        if(stack.empty()) {
            answer = true;
        }

        return answer;
    }
}
