import java.util.Arrays;

public class Main_6 {

    public static void main(String[] args) {
        
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        System.out.println(solution(k, m, score));
    }

    /**
     * 
     * <p>최저 사과점수) * (한 상자에 담긴 사과 개수) * (상자의 개수)</p>
     * <ul>
     *  <li>3 <= k <= 9</li>
     *  <li>3 <= m <= 10</li>
     *  <li>7 <= score 의 길이 <= 1,000,000</li>
     *  <li>이익이 나지 않을 경우 0 을 return</li>
     * </ul>
     * @param k 사과의 최대 점수
     * @param m 한 상자에 들어가는 사과의 수
     * @param score 사과들의 점수
     * @return
     */
    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        //상자 개수
        int boxCount = score.length / m;

        //이익이 나지 않을 경우 0을 return;
        if(boxCount <= 0) {
            return 0;
        }

        int point = score.length - m;
        while(point >= 0) {
            int min = score[point];
            answer += min * m;

            point -= m; 
        }

        return answer;
    }
    
}
