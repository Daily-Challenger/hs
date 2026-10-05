package algo3;

import java.util.*;


/**
 * 괄호 회전하기
 * 
 * 대괄호, 중괄호, 소괄호로 이루어진 문자열 s가 매개별수로 주어질 때,
 * s를 왼쪽으로 x(0 <= x < s 의 길이) 칸만큼 회전시켰을때 s 가 올바른 괄호 문자열이 되게하는 x의 경우의 수
 * Main_3_19
 */
public class Main_3_19 {
    
    public static void main(String[] args) {
        Main_3_19 main = new Main_3_19();

        String s = "}]()[{";
        System.out.println(main.solution(s));
    }

    /**
     * 문자열을 List로 변환한 뒤 직접 회전시키며 각 상태가 올바른 괄호 문자열인지 스택으로 검사한다.
     * 접근법은 올바르지만, 매 회전마다 리스트의 첫 원소를 제거하고 이동시키는 불필요한 연산이 발생한다.
     * 
     * @param s
     * @return
     */
    private int solution(String s) {

        int answer = 0;

        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        int cnt = 0; 

        while(cnt < s.length()) {
            if(checkCorrect(list)) {
                answer++;
            };

            char temp = list.getFirst();
            list.removeFirst();
            list.add(temp);
            cnt++;
        }
        return answer;
    }    

    private boolean checkCorrect(List<Character> arr) {

        Deque<Character> temp = new ArrayDeque<>();
        for(int i = 0; i < arr.size(); i++) {
            char current = arr.get(i);
            if(temp.isEmpty()) {
                temp.add(current);
                continue;
            }

            if(current == '(' || current == '{' || current == '[') {
                temp.add(current);
                continue;
            }

            char prev = temp.getLast();
            if(current == ')') {
                if(prev == '(') {
                    temp.pollLast();
                } else {
                    break;
                }
            } else if(current == '}') {
                if(prev == '{') {
                    temp.pollLast();
                } else {
                    break;
                }                
            } else if(current == ']') {
                if(prev == '[') {
                    temp.pollLast();
                } else {
                    break;
                }
            }
        }

        if(temp.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 개선된 풀이
     * 
     * 문자열을 실제로 회전시키지 않고 (start + i) % n 인덱스로 회전된 순서를 탐색한다.
     * 각 회전 상태를 스택으로 검증하여 불필요한 문자열/리스트 변경 없이 간결하게 처리한다.
     * 
     * @param s
     * @return
     */
    private int solution2(String s) {

        int answer = 0;
        int n = s.length();

        // start: 왼쪽으로 몇 칸 회전한 상태인지 의미
        for(int start = 0; start < n; start++) {
            if(isCorrect(s, start)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isCorrect(String s, int start) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();

        for(int i = 0; i < n; i++) {

            /**
             * 문자열을 실제로 회전시키지 않고
             * start 위치부터 순화하면서 문자를 가져온다.
             * 
             * 예)
             * s = "[](){}", start = 2
             *
             * i = 0 -> s[2]
             * i = 1 -> s[3]
             * ...
             * i = 4 -> s[0]
             *
             */

            char current = s.charAt((start + i) % n);

            if(current == '(' || current == '{' || current == '[') {
                stack.addLast(current);
                continue;
            }

            //닫는 괄호가 나왔는데 비어있다면 false;
            if(stack.isEmpty()) {
                return false;
            }

            char open = stack.pollLast();

            if(current == ')' && open != '(') {
                return false;
            }

            if(current == '}' && open != '{') {
                return false;
            }

            if(current == ']' && open != '[') {
                return false;
            }            
        }

        /**
         * 모든 문자를 처리한 뒤 스택이 비어 있어햐 한다.
         */
        return stack.isEmpty();
    }
}
