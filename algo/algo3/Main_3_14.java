package algo3;

/**
 * 숫자 n개가 주어질 때, n개의 최소 공배수 구하기
 * Main_3_14
 */
public class Main_3_14 {

    public static void main(String[] args) {
        Main_3_14 main = new Main_3_14();

        int[] n = {2,6,8,14};

        System.out.println(main.solution(n));
    }

    /**
     * 최소 공약수를 활용하는 방법은 좋으나, 1씩 줄어들어
     * 최악의 경우 모든 수를 반복할 수 있다
     * 
     * @param arr
     * @return
     */
    private int solution(int[] arr) {
        
        int answer = arr[0];

        for(int i = 1; i < arr.length; i++) {
            answer = getLeastCommonMultiple(answer, arr[i]);
        }
        return answer;
    }
    
    private int getLeastCommonMultiple(int x, int y) {

        int commonDivisor = Math.min(x, y);

        while(commonDivisor > 1) {
            if(x % commonDivisor == 0 && y % commonDivisor == 0) {
                return commonDivisor * (x / commonDivisor) * (y / commonDivisor);
            } 
            commonDivisor--;
        }
        return x * y;
    }

    /**
     * 유클리드 호제법을 활용하여, 최대공약수를 구하는 방식을 효율적으로 개선
     * @param arr
     * @return
     */
    private int solution2(int[] arr) {
        int answer = arr[0];

        for(int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }
    
}
