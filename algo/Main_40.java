import java.util.Arrays;

public class Main_40 {
    
    public static void main(String[] args) {
        int n = 4;
        int m = 1;
        int[] section = {1,2,3,4};
        System.out.println(solution(n, m, section));
    }

    /**
     * 벽의 다시 칠해야 할 구역을 길이 m인 롤러로 모두 덮어야 한다.
     * 이미 칠한 구역은 넘어가고, 아직 안 칠한 가장 왼쪽 구역부터 롤러를 칠해 최소 횟수를 구한다.
     * @param n
     * @param m
     * @param section
     * @return
     */
    public static int solution(int n, int m, int[] section) {

        int answer = 1;
        int paint = section[0] + m;
        for(int i = 1; i < section.length; i++) {
            if(section[i] < paint) {
                continue;
            } else {
                answer++;
                paint = section[i] + m;
            }
        }

        return answer;
    }

    public static int solution2(int n, int m, int[] section) {

        int answer = 0;
        int paint = 0;

        for(int s : section) {
            if(s >= paint) {
                answer++;
                paint = s + m;
            }
        }
        return answer;
    }
}
