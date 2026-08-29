package algo_1;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main_37 {
    
    public static void main(String[] args) {
        // System.out.println(solution3(3, 1, 20));

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(solution4(cards1, cards2, goal));
    }

    /**
     * 배열을 정해진 범위로 자른 후, 자른 배열의 k번째 숫자 가져오기
     * stream 파이프라인 구성,처리로 인해 단순 배열 연산보다 상수 시간 오버헤드가 큼
     * @param array
     * @param commands
     * @return
     */
    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int temp = IntStream.range(commands[i][0]-1, commands[i][1])
            .map(num -> array[num])
            .sorted()
            .skip(commands[i][2]-1)
            .findFirst()
            .orElse(-1);
            answer[i] = temp;
        }
        return answer;
    }

    /**
     * 배열을 정해진 범위로 자른 후, 자른 배열의 k번째 숫자 가져오기 - 개선된 풀이
     * @param array
     * @param commands
     * @return
     */
    public static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }

    /**
     * 
     * @param a 빈병 a개를 주면
     * @param b 새 콜라 b 개를 준다
     * @param n 가지고 있는 빈 병의 개수
     * @return
     */
    public static int solution3(int a, int b, int n) {
        int answer = 0;
        int remain = 0;
        int cnt = 0;

        while(n >= a) {
            cnt = n / a;
            remain = n % a;
            
            answer += cnt * b;

            n = cnt * b + remain;
        }
        
        return answer;
    }

    public static String solution4(String[] cards1, String[] cards2, String[] goal) {

        int cards1Idx = 0;
        int cards2Idx = 0; 

        boolean isGoal = true;
        for(int i = 0; i < goal.length; i++) {

            if(cards1Idx < cards1.length && goal[i].equals(cards1[cards1Idx])) {
                cards1Idx++;
            } else if(cards2Idx < cards2.length && goal[i].equals(cards2[cards2Idx])) {
                cards2Idx++;
            } else {
                isGoal = false;
                break;
            }
        }

        return isGoal ? "Yes" : "No";
    }
}
