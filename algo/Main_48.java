public class Main_48 {
    
    public static void main(String[] args) {
        String dartResult = "1D2S0T";
        System.out.println(solution(dartResult));
    }

    /**
     * 다트점수 계산하기
     * @param dartResult
     * @return
     */
    public static int solution(String dartResult) {
        int answer = 0;
        
        //다트(1~10점)
        int[] dart = new int[3];
        //보너스(S: 1, D: 제곱, T: 3제곱)
        int[] bonus = new int[3];
        //옵션(*: 2배, #: -1배)
        int[] option = new int[3];

        int idx = 0;

        StringBuilder sb = new StringBuilder();
        for(char c : dartResult.toCharArray()) {

            if(c == '*' || c == '#') {
                option[idx-1] = switch(c) {
                    case '*' -> 2;
                    case '#' -> -1;
                    default -> 0;
                };
            }
            if(Character.isDigit(c)) {
                sb.append(c);
                continue;
            }
            if(Character.isAlphabetic(c)) {
                dart[idx] = Integer.parseInt(sb.toString());
                
                bonus[idx] = switch(c) {
                    case 'S' -> 1;
                    case 'D' -> 2;
                    case 'T' -> 3;
                    default -> 0;
                };
                idx++;
                sb.setLength(0);
                continue;
            }
        }

        //점수계산을 해보자
        int[] score = new int[3];

        for(int i = 0; i < score.length; i++) {
            int n = (int) Math.pow(dart[i], bonus[i]);
            if(option[i] == 2) {
                score[i] = n * 2;
                if(i > 0) {
                    score[i-1] = score[i-1] * 2;
                }
            } else if(option[i] == -1) {
                score[i] = n * -1;
            } else {
                score[i] = n;
            }
        }

        for(int i = 0; i < score.length; i++) {
            answer += score[i];
        }
        return answer;
    }
}
