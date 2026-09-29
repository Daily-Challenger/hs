package algo3;

/**
 * 점프와 순간이동
 * 
 * K칸 점프 or 순간이동 = (현재까지 온 거리) * 2
 * K칸을 점프하면 K만큼의 건전지 사용량이 든다(순간이동은 건전지 사용 안함)
 * 
 * N만큼 떨어져 있는 장소로 가려고 함.
 * 건전지 사용량을 줄이기 위해 점프로 이동하는 것은 최소로 하려고 한다.
 * 사용해야하는 건전지 사용량의 최솟값을 return
 * 
 * Main_3_13
 */
public class Main_3_13 {
    
    public static void main(String[] args) {
        Main_3_13 main_3_13 = new Main_3_13();
        int n = 5000;
        System.out.println(main_3_13.solution(n));
    }

    /**
     * n부터 0으로 거꾸로 계산하여
     * 홀수면 1칸 점프가 필요하므로 배터리 1증가.
     * @param n
     * @return
     */
    public int solution(int n) {
        int answer = 0;

        while(n > 0) {
            int remain = n % 2;
            if(remain == 1) {
                answer++;
            }
            n /= 2;
        }
        return answer;
    }

    /**
     * 이진수에서 1의 갯수를 세는 것과 같다.
     * @param n
     * @return
     */
    public int solution2(int n) { 
        return Integer.bitCount(n);
    }
}
