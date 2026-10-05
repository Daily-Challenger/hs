package algo3;

import java.util.*;

/**
 * n x n 크기의 배열을 만들고, i번째 단계마다 (1, 1)부터 (i, i) 영역의 빈 칸을 i로 채운다.
 * 완성된 2차원 배열을 행 순서대로 이어붙여 1차원 배열로 만든다.
 * 이 배열에서 left부터 right 인덱스까지의 구간만 반환한다.
 * 
 * Main_3_20
 */
public class Main_3_20 {
    
    public static void main(String[] args) {

        Main_3_20 main = new Main_3_20();

        int n = 3;
        long left = 2;
        long right = 5;;

        for(int i : main.solution(n, left, right)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 1차원 인덱스에서 행과 열 위치를 계산하여 해당 위치의 값을 직접 구한다.
     * 접근은 올바르지만 값 계산식과 결과 인덱스 계산이 다소 복잡하고,
     * long 배열 생성 후 int 배열로 변환하는 불필요한 과정이 있다.
     * 
     * @param n
     * @param left
     * @param right
     * @return
     */
    private int[] solution(int n, long left, long right) {
        /**
         * 회차 구하기 
         * (left / n) + 1;
         * 
         * 자리 구하기
         * (left % n) + 1; 
         * 
         * 자리의 숫자 구하기
         * = 회차 + (자리 - 회차)
         */
        
        
        long length = right - left + 1;
        long[] arr = new long[(int) length];

        for(long i = left; i <= right; i++) {

            //반복 회차
            long round = (i / n) + 1;

            //자리
            long x = i % n + 1;

            //자리가 반복회차 보다 작으면 반복회차
            //자리가 반복회차 보다 크면 반복 회차 + (자리 - 회차)
            long num = x - round <= 0 ? round : round + (x - round);

            int idx = (int) (length - (right - i)) - 1;
            arr[idx] = num;
        }
        
        int[] answer = Arrays.stream(arr)
                        .mapToInt(l -> (int) l)
                        .toArray();
        return answer;
    }

    /**
     * 개선된 풀이
     * 
     * 1차원 인덱스를 행(i / n), 열(i % n)로 변환하고 max(행, 열) + 1로 값을 계산한다.
     * 필요한 구간만 순회하여 전체 n x n 배열 생성을 피하고,
     * 결과 배열에 바로 저장해 시간과 메모리를 효율적으로 사용한다.
     * 
     * @param n
     * @param left
     * @param right
     * @return
     */
    private int[] solution2(int n, long left, long right) {

        int[] answer = new int[(int) (right - left + 1)];

        for(long i = left; i <= right; i++) {

            long row = i / n;
            long col = i % n;

            answer[(int) (i - left)] = (int) Math.max(row, col) + 1;
        }

        return answer;
    }
}
