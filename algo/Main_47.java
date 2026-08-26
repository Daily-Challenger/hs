public class Main_47 {
 
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        for(int i : solution(lottos, win_nums)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 지워진 숫자 0이 있을때, 나올 수 있는 가장 높은 등수와 낮은 등수 구하기
     * @param lottos
     * @param win_nums
     * @return
     */
    public static int[] solution(int[] lottos, int[] win_nums) {
        
        int zeroCount = 0;
        int correct = 0;
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                zeroCount++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    correct++;
                    break;
                }
            }
        }
        int max = correct + zeroCount;
        int min = correct;

        int[] answer = {getPrize(max), getPrize(min)};
        return answer;
    }

    public static int getPrize(int num) {
        
        return switch(num) {
            case 6 -> 1;
            case 5 -> 2; 
            case 4 -> 3; 
            case 3 -> 4; 
            case 2 -> 5; 
            default -> 6;
        };
    }
}
