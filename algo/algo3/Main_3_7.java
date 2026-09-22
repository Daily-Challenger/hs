package algo3;

public class Main_3_7 {
    
    public static void main(String[] args) {
        Main_3_7 main = new Main_3_7();
        int n = 15;
        System.out.println(main.solution2(n));
    }

    /**
     * 다음 큰 숫자
     * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
     * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
     * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
     * 
     * @param n
     * @return
     */
    public int solution(int n) {

        int count1 = 0;


        count1 = getCnt(n);

        int count2 = getCnt(++n);

        while(count1 != count2) {
            count2 = getCnt(++n);
        }
        return n;
    }

    private int getCnt(int n) {
        int count = 0;
        while(n > 0) {
            if(n % 2 != 0) {
                count++;
            }
            n /= 2;
        }      
        return count;  
    }

    /**
     * Integer.bitCount()를 활용하여 비트 개수를 직접 계산하는 과정을 생략
     * @param n
     * @return
     */
    public int solution2(int n) {
        int bitCount = Integer.bitCount(n);

        while(Integer.bitCount(++n) != bitCount) {

        }

        return n;
    }
}
