package algo3;

public class Main_3_4 {

    
    static int zeroCnt = 0;
    static int resolveCnt = 0;
    public static void main(String[] args) {
        String s = "1111111";
        for(int i : solution(s)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 이진변환 반복하기
     * 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환
     * [이진변환]
     * 1. x의 모든 0을 제거
     * 2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿈    
     * 
     * 0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. 
     * s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 
     * 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return
     * 
     * @param s
     * @return
     */
    public static int[] solution(String s) {

        while(!"1".equals(s)) {
            resolveCnt++;
            s = removeZero(s);
            s = resolveBinary(s.length());
        }

        int[] answer = {resolveCnt, zeroCnt};
        return answer;
    }    

    private static String removeZero(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '0') {
                zeroCnt++;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private static String resolveBinary(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            sb.insert(0, n%2);
            n /= 2;
        }

        return sb.toString();
    }

    /**
     * 개선된 풀이
     * 필요한건 1의 갯수이지, 0을 제거한 문자가 필요하진 않음.
     * 직접 이진변환 구현 불필요(Integer.toBinaryString 활용).
     * 
     * 문자열을 순회하며 제거되는 0의 개수와 남는 1의 개수를 동시에 계산한다
     * 0을 제거한 문자열을 별도로 만들지 않고, 1의 개수를 바로 이진수로 변환해
     * 불필요한 문자열 생성과 정규식 연산을 줄인다.
     * @param s
     * @return
     */
    public int[] solution2(String s) {
        int transformCount = 0;
        int zeroCount = 0;

        while(!"1".equals(s)) {
            int oneCount = 0;

            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            s = Integer.toBinaryString(oneCount);
            transformCount++;
        }

        return new int[]{transformCount, zeroCount};
    }
}
