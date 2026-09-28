package algo3;

/**
 * 멀리 뛰기
 * 한 번에 1칸 또는 2칸씩 이동하여 n칸에 도달하는 모든 경우의 수를 구한다.
 */
public class Main_3_12 {
 
    public static void main(String[] args) {
        Main_3_12 main = new Main_3_12();

        int n = 4;
        System.out.println(main.solution(n));
    }

    /**
     * 마지막 점프는 1칸 또는 2칸이므로 dp[n] = dp[n-1] + dp[n-2]가 성립한다.
     * 이전 두 값만 저장하며 계산하고, 오버플로 방지를 위해 매 계산마다 1234567로 나눈 나머지를 저장한다.
     * 
     * @param n
     * @return
     */
    private long solution(int n) {

        if(n == 1) {
            return 1;
        }

        int curr = 1;
        int next = 2;
        for(int i = 3; i <= n; i++) {
            int temp = next;
            next = (curr + next) % 1234567 ;
            curr = temp;
        }
        
        return next;
    }    
}
