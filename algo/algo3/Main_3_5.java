package algo3;

import java.util.*;

public class Main_3_5 {
    
    public static void main(String[] args) {
        int n = 2;
        System.out.println(solution(n));
        System.out.println(solution2(n));
    }

    /**
     * 숫자 표현하기
     * 자연수 n을 연속한 자연수의 합으로 표현할 수 있는 방법의 수 구하기
     * 
     * 
     * 
     * 1 + 2 + 3 + 4 + 5 = 15
     * 4 + 5 + 6 = 15
     * 7 + 8 = 15
     * 15 = 15
     * 
     * 투포인터 사용하지 않고 수학적으로도 풀이가능
     * @param n
     * @return
     */
    public static int solution(int n) {
        
        int answer = 0;

        int x = 1;
        int y = 1;
        int sum = 0;

        while (x <= n) {
            if (sum < n) {
                sum += y;
                y++;
            } else {
                if (sum == n) {
                    answer++;
                }
                sum -= x;
                x++;
            }
        }

        return answer;
    }

    /**
     * 자연수 n을 연속된 양의 정수의 합으로 나타내는 방법의 수는 n의 홀수 약수의 개수와 같다.
     * 
     * n의 홀수 약수의 개수만 필요하므로 list에 저장할 필요없이 숫자만 count 하면 된다.
     * @param n
     * @return
     */
    public static int solution2(int n) {

        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++) {
            
            if(n % i == 0) {
                list.add(i);
                
                if(i != Math.sqrt(n)) {
                    list.add(n / i);    
                }
            }
        }

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 1) {
                answer++;
            }
        }

        return answer;
    }

    /**
     * 홀수만 탐색해서 약수면 count 를 증가
     * @param n
     * @return
     */
    public static int solution3(int n) {
        int answer = 0;

        for(int i = 1; i <=n; i += 2) {

            if(n % i == 0) {
                answer++;
            }
        }

        return answer;
    }
}
