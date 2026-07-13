public class Main_9 {
    
    public static void main(String[] args) {
        
        int n = 3;
        int s = 9;
        for(int i : solution(n, s)) {
            System.out.println(i);
        }
    }

    /**
     * 
     * 자연수 n개로 이루어진 집합 중
     * 각 원소의 합이 s가 되고 원소의 곱이 최대가 되는 집합
     * 
     * @param n 원소의 개수
     * @param s 모든 원소들의 합
     * 
     * <ul>
     *  <li> 1 <= n <= 10,000 </li>
     *  <li> 1 <= s <= 100,000,000 </li>
     * </ul>
     */
    public static int[] solution(int n, int s) {

        if(s < n) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        //곱이 가장 크려면: 합을 최대한 균등하게 나눠 원소 간 차이를 1 이하로 만들기
        //뒤쪽에 큰 값을 배치하므로 결과는 오름차순을 유지.
        int quot = s / n;
        //추가로 필요한 1의 개수
        int remain = s % n;

        //나머지만큼 1을 더할 시작 경계
        int boundary = n - remain;

        for(int i = 0; i <n; i++) {
            if(i < boundary) {
                answer[i] = quot;
            } else {
                answer[i] = quot + 1;
            }
        }

        return answer;
    }
}
