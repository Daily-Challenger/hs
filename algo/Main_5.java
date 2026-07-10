import java.util.*;

public class Main_5 {
    
    public static void main(String[] args) {
        
        int k = 2;
        int d = 4;

        System.out.println(solution(k, d));
    }

    /**
     * <p>포인트</p>
     * <ul>
     *  <li>모든 x,y를 직접 순회x => 시간 초과됨</li>
     *  <li>int 사용 시 overflow => long 사용</li>
     * </ul>
     * 
     * <p>제한사항</p>
     * <ul>
     *  <li>1 ≤ k ≤ 1,000,000</li>
     *  <li>1 ≤ d ≤ 1,000,000</li>
     * </ul>
     * @param k
     * @param d
     * @return
     */
    public static long solution(int k, int d) {
        
        //주의: 
        long answer = 0;
        long distance = (long) d * d;
        
        for(long x = 0; x <= d; x += k) {
            
            //원점으로 부터의 거리를 조건으로 최대 y좌표를 구함
            // (x*x) + (y*y) <= (d*d)
            // (y*y) <= (d*d) - (x*x);
            // 가능한 y는 k의 배수 이므로 /k
            long maxY = (long) Math.sqrt(distance - x * x);
            answer += maxY / k + 1; //0을 포함하기 위한 +1;
        }
        return answer;
    }

}
