package algo_1;
import java.util.Arrays;

public class Main_31 {
    
    public static void main(String[] args) {
        int[] d = {2,2,3,3};
        int budget = 10;

        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);

        for(int i = 0; i < d.length; i++) {
            sum += d[i];
            if(sum <= budget) {
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
