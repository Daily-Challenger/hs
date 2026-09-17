package algo3;

import java.util.Arrays;

public class Main_3_2 {

    public static void main(String[] args) {
        
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};

        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int n = A.length;
        for(int i = 0; i < n; i++) {
            answer += A[i] * B[n-1-i];
        }
        return answer;
    }
    
}
