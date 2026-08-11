public class Main_32 {
    

    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        System.out.println(solution(number));
    }

    /**
     * 세 수의 합이 0이 되는 경우
     * <ul>
     *  <li>3 ≤ number의 길이 ≤ 13</li>
     *  <li>-1,000 ≤ number의 각 원소 ≤ 1,000</li>
     * </ul>
     * 범위가 크지 않기에 3중 for문으로 해결 가능
     * @param number
     * @return
     */
    public static int solution(int[] number) {

        int answer = 0;

        for(int i = 0; i < number.length - 2; i++) {
            for(int j = i+1; j < number.length -1; j++) {
                for(int k = j+1; k < number.length; k++) {
                    if(number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
