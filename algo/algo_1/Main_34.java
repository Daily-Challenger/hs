package algo_1;
public class Main_34 {
    
    public static void main(String[] args) {

        int[][] test = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(test));
    }

    /**
     * 최소 직사각형
     * @param sizes
     * @return
     */
    public static int solution(int[][] sizes) {
        int answer = 0;

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i = 0; i < sizes.length; i++) {
            int x = Math.max(sizes[i][0], sizes[i][1]);
            int y = Math.min(sizes[i][0], sizes[i][1]);

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        answer = maxX * maxY;
        return answer;
    }
}
