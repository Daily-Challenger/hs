
/**
 * 
 * 약수의 합 구하기
 * 0 <= n <= 3000
 */
public class Main_13 {
 
    public static void main(String[] args) {
        
        System.out.println(solution2(1));
    }

    public static int solution(int n) {
        if(n == 0) {
            return 0;
        }
        int answer = 0;

        int quotient = Integer.MAX_VALUE;
        int remainder = Integer.MIN_VALUE;

        int i = 1;
        while(quotient > i) {
            quotient = n / i;
            remainder = n % i;

            if(remainder == 0) {
                if(i == quotient) {
                    answer += i;
                } else {
                    answer += quotient + i;
                }
            }
            
            i++;
        }
        return answer;
    }

    public static int solution2(int n) {

        int answer = 0;

        for(int i = 1; i <= n/2; i++) {
            if(n%i == 0) {
                answer += i;
            }
        }

        return answer + n;
    }
}
