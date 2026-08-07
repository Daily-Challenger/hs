public class Main_29 {

    public static void main(String[] args) {

        // int[][] arr1 = {{1},{2}};
        // int[][] arr2 = {{3},{4}};
        // solution1(arr1, arr2);

        // solution2(5, 3);
        // String t = "1";
        // String p = "2";
        // System.out.println(solution4(t, p));

        String s = "A";
        System.out.println(solution5(s));
    }

    /**
     * 행렬의 덧셈
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[][] solution1(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr1[0].length];

        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    /**
     * 직사각형 별 찍기
     * @param a
     * @param b
     */
    public static void solution2(int a, int b) {

        for(int i = 0; i < b; i++) {
            for(int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 최대공약수, 최소 공배수
     * @param n
     * @param m
     * @return
     */
    public int[] solution3(int n, int m) {

        int commonFactor = Math.min(n, m);

        while (commonFactor > 0) {
            if(n % commonFactor == 0 && m % commonFactor == 0) {
                break;
            }
            commonFactor--;
        }

        int x = 1; 
        int y = 1;
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        int commonMultiple = n*m;
        while(min * x < n* m) {
            if(min * x < max * y) {
                x++;
            } else if(min * x > max * y) {
                y++; 
            } else {
                commonMultiple = min * x;
                break;
            }
        }

        int[] answer = {commonFactor, commonMultiple};
        return answer;
    }

    /**
     * 크기가 작은 부분 문자열
     * @param t
     * @param p
     * @return
     */
    public static int solution4(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        int tLen = t.length();
        Long pNum = Long.parseLong(p);

        for(int i = 0; i <= tLen - pLen; i++) {
            String temp = t.substring(i, i+pLen);
            if(Long.parseLong(temp) <= pNum) {
                answer++;
            }
        }

        return answer;
    }

    /**
     * 이상한 문자 만들기
     * @param s
     * @return
     */
    public static String solution5(String s) {
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for(char c : s.toCharArray()) {

            if(c == ' ') {
                sb.append(' ');
                index = 0;
            } else {
                if(index % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                index++;
            }
        }

        return sb.toString();
    }
    
}
