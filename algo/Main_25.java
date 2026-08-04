public class Main_25 {
 
    public static void main(String[] args) {
        System.out.println(solution(12));
    }

    public static int solution(int n) {
        int answer = 0;

        int i = n - 1;

        while(i > 0) {
            if(n % i == 1) {
                answer = i;
            }
            i--;
        }
        return answer;
    }
}
