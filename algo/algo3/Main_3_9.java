package algo3;

public class Main_3_9 {
    
    public static void main(String[] args) {
        
        Main_3_9 main = new Main_3_9();
        int brown = 10;
        int yellow = 2;
        for(int i: main.solution(brown, yellow)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 노란색 격자의 약수를 √yellow부터 역순으로 탐색하여 카펫의 가로와 세로를 계산
     * 탐색 범위가 작아 효율적이지만, 불필요한 초기값과 Math.max/min 연산이 존재
     * @param brown
     * @param yellow
     * @return
     */
    public int[] solution(int brown, int yellow) {
        

        int x = 1;
        int y = 1;
        int n = (int) Math.sqrt(yellow);

        for(int i = n; i  >= 1; i--) {
            if(yellow % i == 0) {
                x = Math.max(yellow / i, i);
                y = Math.min(yellow / i, i);

                if((x + 2) * (y + 2) - yellow == brown) {
                    break;
                }
            }
        }

        int[] answer = {x + 2, y + 2};
        return answer;
    }

    /**
     * 개선된 풀이
     * 
     * 노란색 격자의 약수를 √yellow까지만 탐색하여 가로와 세로 길이를 구한다
     * 기존 풀이의 불필요한 연산과 초기값을 제거하고, 조건을 만족하면 즉시 결과를 반환
     * 
     * @param brown
     * @param yellow
     * @return
     */
    public int[] solution2(int brown, int yellow) {

        for(int height = (int) Math.sqrt(yellow); height >= 1; height--) {

            // 노란색 영역의 세로 길이가 약수가 아니면 제외
            if(yellow % height != 0) {
                continue;
            }

            // 노란색 영역의 가로길이
            int width = yellow / height;

            // 갈색 테두리를 포함한 전체 카펫 크기
            int carpetWidth = width + 2;
            int carpetHeight = height + 2;

            //전체 격자에서 노란색 격자를 제외한 개수가 갈색 격자와 일치하는지 확인
            if((carpetWidth * carpetHeight) - yellow == brown) {
                return new int[]{carpetWidth, carpetHeight};
            }
        }

        
        return new int[0];
    }
}
