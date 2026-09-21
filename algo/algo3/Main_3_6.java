package algo3;

import java.util.*;

public class Main_3_6 {
    
    public static void main(String[] args) {
        
        Main_3_6 main = new Main_3_6();
        String s = "cdcd";
        System.out.println(main.solution(s));
        
    }

    /**
     * 짝지어 제거하기
     * 알파벳 소문자로 이루어진 문자열
     *  - 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾아 제거
     *  - 앞뒤로 문자열을 이어 붙임
     *  - 이 과정을 반복해서 모두 제거하면 종료
     * 짝지어 제거하기를 성공적으로 수행할 수 있으면 1, 아니면 0을 리턴
     * 
     * @param s
     * @return
     */
    public int solution(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if(stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty() ? 1 : 0;
    }

    /**
     * Stack 은 Vector를 상속한 클래스로 push(), pop() 등의 연산에 동기화 적용
     * 단일스레드에서는 동기화가 필요하지 않음 -> ArrayDeque를 스택처럼 활요하면 가볍게 처리 가능
     * Stack<Character> 는 기본자료형인 char 를 직접 저장할 수 없어 오토박싱이 발생함
     * -> ArrayDeque<Character> 도 동일한 문제 발생 -> char[] 을 스택처럼 사용하는 것이 효율적
     * @param s
     * @return
     */
    public int solution2(String s) {

        //문자열 길이가 홀수라면 즉시 종료
        if(s.length() % 2 != 0) {
            return 0;
        }

        char[] stack = new char[s.length()];
        int top = -1;

        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            
            if(top >= 0 && stack[top] == current) {
                top--;
            } else {
                //스택이 비어 있거나 마지막 문자와 현재 문자가 다르면 동일하게 문자를 추가.
                stack[++top] = current;
            }
        }

        return top == -1 ? 1 : 0;
    }
}
