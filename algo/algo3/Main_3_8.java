package algo3;

import java.math.BigInteger;

public class Main_3_8 {
    
    public static void main(String[] args) {
        Main_3_8 main = new Main_3_8();

        int n = 100;
        System.out.println(main.solution(n));
    }

    /**
     * BigInteger를 사용하여 피보나치 수를 계산한 뒤 나머지를 구하는 방식
     * 불필요하게 큰 피보나치 수 전체를 계산하고 배열에 저장하므로 연산 및 메모리 사용량이 증가
     * @param n
     * @return
     */
    public int solution(int n) {
        int answer = 0;

        BigInteger[] arr = new BigInteger[n+1];
        
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;

        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1].add(arr[i-2]);
        }

        answer = arr[n].mod(BigInteger.valueOf(1234567)).intValue();
        return answer;
    }    

    /**
     * 매번 나머지를 구해도 최종 결과가 동일하다는 성질을 이용하여 오버플로를 방지
     * 직전 두 값만 변수로 관리하여 기존 풀이의 불필요한 큰 정수 연산과 배열 사용을 제거하고, 
     * 공간 복잡도를 O(1)로 개선
     * @param n
     * @return
     */
    public int solution2(int n) {
        int prev = 0;
        int current = 1;

        for(int i = 2; i <= n; i++) {
            int next = (prev + current) % 1234567;

            prev = current;
            current = next;
        }

        return current;
    }
}
