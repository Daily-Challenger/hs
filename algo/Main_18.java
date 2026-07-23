import java.util.Arrays;

/**
 * 동적 계획법(DP), 누적최댓값, 삼각형 경로
 * Main_18
 */
public class Main_18 {

    public static void main(String[] args) {
     
        int[][] test = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(test));   
    }

    /**
     * memory 배열 사용으로 원본 보존
     * 추가 메모리: O(n²)
     * 시간복잡도: O(n²)
     * (  높이가 n일때 저장하는 int개수: n(n + 1) / 2  )
     * DP개념 명확
     * @param triangle
     * @return
     */
    public static int solution(int[][] triangle) {

        int n = triangle.length;
        int[][] memory = new int[n][];

        for(int i = 0; i < n; i++) {
            memory[i] = new int[i+1];
        }

        memory[0][0] = triangle[0][0];

        for(int depth = 1; depth < n; depth++) {
            //가장 왼쪽
            memory[depth][0] = memory[depth-1][0] + triangle[depth][0];

            for(int index = 1; index < depth; index++) {
                memory[depth][index] = Math.max(memory[depth-1][index-1], memory[depth-1][index]) + triangle[depth][index];
            }
            //가장 오른쪽
            memory[depth][depth] = memory[depth-1][depth-1] + triangle[depth][depth];
        }

        int answer = 0;
        for(int value: memory[n-1]) {
            answer = Math.max(value, answer);
        }
        return answer;
    }

    /**
     * triangle 배열 자체에 값을 저장
     * 원본 변경 되지만 위보다 메모리 사용량이 적음
     * 추가 메모리: O(1)
     * 시간복잡도: O(n²)
     * 간단하고 최적화 목적
     * 
     * 성능을 조금이라도 더 신경쓴다면 stream이 아닌 for문으로 처리
     * @param triangle
     * @return
     */
    public static int solution2(int[][] triangle) {

        for(int depth = 1; depth < triangle.length; depth++) {

            //가장 왼쪽
            triangle[depth][0] += triangle[depth-1][0];

            //가장 오른쪽
            triangle[depth][depth] += triangle[depth-1][depth-1];

            //가운데 위치
            for(int index = 1; index < depth; index++) {
                triangle[depth][index] += Math.max(
                                                triangle[depth-1][index-1],
                                                triangle[depth-1][index]
                                                );
            }
        }

        //마지막 행 중 가장 큰 값
        return Arrays.stream(triangle[triangle.length-1])
                .max()
                .getAsInt();
    }
}
