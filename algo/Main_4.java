import java.util.Scanner;

public class Main_4 {
    public static void main(String[] args) {

        int[] wallet = {50, 50};
        int[] bill = {100, 241};


        System.out.println(solution(wallet, bill));
    }

    /**
    * <p>지폐접기</p>
    * <ul>
    *   <li> 접을 땐 길이가 긴쪽을 반으로 접음(이때 소수점 이하는 버림) </li>
    *   <li> 접힌 지폐를 그대로 또는 돌려서 넣을 수 있다면 종료 </li>
    * </ul>
    * @param wallet 지갑의 크기 {x, y}
    * @param bill 지페의 크기 {x, y}
    * 
    * @return answer 지갑에 넣기위해 지폐를 접어야 하는 횟수

    */
    public static int solution(int[] wallet, int[] bill) {

        int answer = 0;

        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);
        int billMin = Math.min(bill[0], bill[1]);
        int billMax = Math.max(bill[0], bill[1]);

        while(billMin > walletMin || billMax > walletMax) {
            if(bill[0] > bill[1]) {
                bill[0] = bill[0] / 2;
            } else {
                bill[1] = bill[1] / 2;
            }

            billMin = Math.min(bill[0], bill[1]);
            billMax = Math.max(bill[0], bill[1]);

            answer++;
        }
        return answer;
    }
}
