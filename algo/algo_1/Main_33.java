package algo_1;
public class Main_33 {
    
    public static void main(String[] args) {
        System.out.println(solution(100000000));
    }

    /**
     * 자연수 n -> 3진법 상에서 앞뒤로 뒤집은 후 이를 다시 10진법으로 표현
     * @param n
     * @return
     */
    public static int solution(int n) {

        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        int num = 1;

        for(int i = sb.length() -1; i >= 0; i--) {
            answer += Character.digit(sb.charAt(i), 10) * num;
            num *= 3;
        }

        return answer;
    }
}
