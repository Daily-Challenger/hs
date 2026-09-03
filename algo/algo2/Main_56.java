package algo2;

import java.util.Map;

public class Main_56 {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        solution(numbers, hand);
    }

    /**
     * 키패드 누르기
     * 1,4,7은 왼손(L)
     * 3,6,9는 오른손(R)
     * 2,5,8,0 은 왼손-오른손 중 거리가 가까운 손
     * 거리가 같다면 주로사용하는 손(hand - left or right)
     * 시작 위치 - 왼손: *, 오른손: #
     * @param numbers
     * @param hand
     * @return
     */
    public static String solution(int[] numbers, String hand) {

        int leftIdx = 10;
        int rightIdx = 12;
        
        Map<Integer, Integer> distanceMap = Map.of(
            1, 1,
            2,2,
            3,1,
            4,2,
            5,3,
            6,2,
            7,3,
            9,3
        );
        StringBuilder sb = new StringBuilder();
        for(int i : numbers) {
            int num = i;
            
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftIdx = num;
                continue;
            }

            if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightIdx = num;
                continue;
            }

            if(num == 0) {
                num = 11;
            }

            if(num == leftIdx) {
                sb.append("L");
                leftIdx = num;
                continue;
            } else if(num == rightIdx) {
                sb.append("R");
                rightIdx = num;
                continue;
            }

            int minusLeft = Math.abs(num - leftIdx);
            int minusRight = Math.abs(num - rightIdx);

            int leftDistance = distanceMap.getOrDefault(minusLeft, 4);
            int rightDistance = distanceMap.getOrDefault(minusRight, 4);

            if(leftDistance < rightDistance) {
                sb.append("L");
                leftIdx = num;
                continue;                
            } else if(leftDistance > rightDistance) {
                sb.append("R");
                rightIdx = num;
                continue;
            } else {
                if("left".equals(hand)) {
                    sb.append("L");
                    leftIdx = num;
                    continue;                        
                } else {
                    sb.append("R");
                    rightIdx = num;
                    continue;                        
                }
            }
        }
 
        return sb.toString();
    }

    /**
     * 풀이 개선
     * 키패드를 2차원 좌표로 표현하고, 가운데 열의 숫자는
     * 왼손/오른손과의 맨해튼 거리를 비교하여 사용할 손을 결정한다.
     * @param numbers
     * @param hand
     * @return
     */
    public static String solution2(int[] numbers, String hand) {

        //key 배열을 좌표로 표시
        int[][] keypad = {
            {3, 1}, // 0
            {0, 0}, // 1
            {0, 1}, // 2
            {0, 2}, // 3
            {1, 0}, // 4
            {1, 1}, // 5
            {1, 2}, // 6
            {2, 0}, // 7
            {2, 1}, // 8
            {2, 2}  // 9            
        };

        int[] leftPos = {3, 0}; // *
        int[] rightPos = {3 ,2}; // #

        StringBuilder answer = new StringBuilder();

        for(int num : numbers) {

            //1,4,7 은 무조건 왼손
            if(num == 1 || num == 4 || num == 7) {
                answer.append("L");
                leftPos = keypad[num];
                continue;
            }
            
            //3,6,9 는 무조건 오른손
            if(num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rightPos = keypad[num];
                continue;
            }

            //가운데(2,5,8,0) 은 현재 손 위치와의 거리 비교
            int leftDistance = Math.abs(leftPos[0] - keypad[num][0]) + Math.abs(leftPos[1] - keypad[num][1]);
            int rightDistance = Math.abs(rightPos[0] - keypad[num][0]) + Math.abs(rightPos[1] - keypad[num][1]);

            if(leftDistance < rightDistance) {
                answer.append("L");
                leftPos = keypad[num];
            } else if(leftDistance > rightDistance) {
                answer.append("R");
                rightPos = keypad[num];
            } else {
                if("left".equals(hand)) {
                    answer.append("L");
                    leftPos = keypad[num];
                } else {
                    answer.append("R");
                    rightPos = keypad[num];
                }
            }
        }

        return answer.toString();
    }
}
