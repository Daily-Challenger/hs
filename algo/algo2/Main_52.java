package algo2;

import java.util.*;

public class Main_52 {
    
    public static void main(String[] args) {
        String X = "19832749012348923798579328047589032749856984357698347568974398505980739857198237498017234890712983075983407698453796798305798";
        String Y = "00000000";

        System.out.println(solution(X, Y));
    }

    /**
     * 숫자 짝꿍
     * X와 Y 에서 공통으로 나타나는 정수를 이용하여 만들 수 있는 가장 큰 정수
     * 0만 있으면 0으로 return
     * 없으면 -1 return
     * @param X
     * @param Y
     * @return
     */
    public static String solution(String X, String Y) {

        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for(char c : X.toCharArray()) {
            xArr[c - '0']++;
        }

        for(char c : Y.toCharArray()) {
            yArr[c - '0']++;
        }

        StringBuilder sb = new StringBuilder(); 

        for(int i = 9; i > -1; i--) {
            int x = xArr[i];
            int y = yArr[i];
            if(x > 0 && y > 0) {
                int min = Math.min(x, y);
                for(int j = 0; j < min; j++) {
                    sb.append(i);
                }
            };
        }

        if(sb.length() < 1) {
            return "-1";
        }
        if(sb.charAt(0) == '0') {
            sb = new StringBuilder("0");
        }

        return sb.toString();
    }
}
