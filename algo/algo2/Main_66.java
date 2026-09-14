package algo2;

public class Main_66 {
    
    public static void main(String[] args) {

        int[][] signals = {{2, 1, 2}, {5, 1, 1}};
        System.out.println(solution(signals));
    }

    /**
     * 신호등이 초 - 노 - 빨 순서로 반복
     * 
     * @param signals [G, Y, R] 
     * @return
     */
    public static int solution(int[][] signals) {
        
        int lcm = 1;

        // 모든 신호등 주기의 최소공배수 계산
        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            lcm = getLCM(lcm, cycle);
        }

        for (int time = 1; time <= lcm; time++) {

            boolean allYellow = true;

            for (int[] signal : signals) {

                int green = signal[0];
                int yellow = signal[1];
                int cycle = signal[0] + signal[1] + signal[2];

                // 현재 시간이 해당 신호등 주기의 몇 번째 초인지
                int position = (time - 1) % cycle + 1;

                // 노란불 구간: G+1 ~ G+Y
                if (position <= green || position > green + yellow) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return time;
            }
        }

        return -1;        
    }

    public static int getLCMOfArray(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = getLCM(lcm, arr[i]);
        }
        return lcm;
    }    

    public static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }
    
    public static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
