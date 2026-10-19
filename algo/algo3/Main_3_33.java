package algo3;

/**
 * 
 * 0부터 시작하는 숫자를 n진법으로 변환하여 한 자리씩 말하는 게임이다.
 * m명의 참가자가 순서대로 숫자를 말할 때,
 * p번째 참가자인 튜브가 말해야 할 t개의 문자를 순서대로 반환한다.
 * 
 * Main_3_33
 */
public class Main_3_33 {
    
    public static void main(String[] args) {
        
        Main_3_33 main = new Main_3_33();

        int n = 2; 
        int t = 4; 
        int m = 2;
        int p = 1;

        System.out.println(main.solution(n, t, m, p));
    }

    /**
     * 
     * 0부터 숫자를 n진법 문자열로 변환하여 필요한 길이만큼 이어 붙인다.
     * 튜브의 첫 번째 순서인 p-1 인덱스부터 m칸 간격으로 문자를 추출한다.
     * StringBuilder를 활용하며 시간 및 공간 복잡도는 O(t * m)이다.
     * 
     * @param n 진법
     * @param t 미리 구할 숫자의 갯수
     * @param m 게임에 참가하는 인원
     * @param p 순서
     * @return
     */
    public String solution(int n, int t, int m, int p) {

        int len = t * m;

        StringBuilder sb = new StringBuilder();

        int num = 0;
        while(sb.length() <= len) {
            String s = Integer.toString(num, n).toUpperCase();
            sb.append(s);
            num++;
        }

        StringBuilder answer = new StringBuilder();
        int idx = 0;
        while(answer.length() < t) {
            answer.append(sb.toString().charAt(idx * m + p - 1));
            idx++;
        }
        

        return answer.toString();
    }    


}
