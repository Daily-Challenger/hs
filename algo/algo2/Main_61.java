package algo2;

import java.util.*;

public class Main_61 {
    
    /**
     * 공원 산책
     * 시작 위치에서 주어진 방향과 거리만큼 순서대로 이동한다.
     * 이동 중 공원 범위를 벗어나거나 장애물(X)을 만나면 해당 명령 전체를 무시한다.
     * 모든 명령 수행 후 최종 위치를 [세로, 가로] 좌표로 반환한다.
     * @param args
     */
    public static void main(String[] args) {
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] route = {"E 2","S 3","W 1"};

        for(int i : solution(park, route)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 가로/세로 이동을 처리하기 위해 행·열 데이터를 별도 Map으로 구성해 불필요한 메모리와 코드 복잡도가 증가한다.
     * 좌표 이동을 인덱스와 방향값으로 추상화하면서 오히려 흐름이 직관적이지 않고 유지보수가 어려워진다.
     * @param park
     * @param routes
     * @return
     */
    public static int[] solution(String[] park, String[] routes) {

        int[] answer = new int[2];
        //시작위치
        for(int i = 0; i < park.length; i++) {
            if(park[i].contains("S")) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
            }
        }

        //
        Map<Integer, String> xMap = new HashMap<>();
        for(int i = 0; i < park.length; i++) {
            xMap.put(i, park[i]);
        }

        Map<Integer, String> yMap = new HashMap<>();
        for(int i = 0; i < park[0].length(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < park.length; j++) {
                sb.append(park[j].charAt(i));
            }
            yMap.put(i, sb.toString());
        }

        //최대 길이
        int maxX = park[0].length();
        int maxY = park.length;



        //E,W 는 같은 줄에서 이동 -> 좌표의 y축[1]이 이동 
        //S,N 은 다른 줄로 이동 ->  좌표의 x축[0]이 이동
        //{{0, 1}, {1, 0}, -1, 0}
        //E: 1 1
        //N: 0 -1
        //W: 1 -1 
        //S, 0 1
        Map<String, int[]> map = Map.of(
            "E", new int[]{1, 1},
            "N", new int[]{0, -1},
            "W", new int[]{1, -1},
            "S", new int[]{0, 1}
        );
        for(int i = 0; i < routes.length; i++) {
            String op = routes[i].split(" ")[0];
            int n = Integer.parseInt(routes[i].split(" ")[1]);

            int[] info = map.get(op);

            //1. 벗어나는지 확인
            int max = answer[info[0]] + (n * info[1]);

            if((info[0] == 1)) {
                if(max >= maxX || max < 0){
                    continue;
                }
            } else {
                if(max >= maxY || max < 0){
                    continue;
                }
            }

            //2. 장애물이 있는지 확인
            //세로 for문, 가로 for문인가?
            int start = Math.min(answer[info[0]], max);
            int end = Math.max(answer[info[0]], max);

            boolean isBlock = findBlock(start, end, info[0] == 0 ? yMap.get(answer[1]) : xMap.get(answer[0]));

            if(isBlock) {
                continue;
            }

            answer[info[0]] = max;
        }

        return answer;
    }

    public static boolean findBlock(int start, int end, String tile) {

        boolean isBlock = false;

        char[] c = tile.toCharArray();
        
        for(int i = start; i <= end; i++) {
            if(c[i] == 'X') {
                isBlock = true;
                break;
            }
        }
        return isBlock;
    }

    /**
     * 개선된 풀이
     * 풀이1의 불필요한 Map과 행/열 문자열 생성을 제거하고, 임시 좌표를 한 칸씩 이동하며 직접 검증하도록 개선했다.
     * 문제의 이동 과정을 그대로 시뮬레이션해 코드가 단순하고, 추가 메모리 없이 범위와 장애물을 처리할 수 있다.
     * @param park
     * @param routes
     * @return
     */
    public int[] solution2(String[] park, String[] routes) {

        int h = park.length;
        int w = park[0].length();

        int y = 0;
        int x = 0;

        //시작 위치 찾기
        for(int i = 0; i < h; i++) {
            int start = park[i].indexOf('S');

            if(start != -1) {
                y = i;
                x = start;
                break;
            }
        }

        for(String route : routes) {

            String[] command = route.split(" ");
            char direction = command[0].charAt(0);
            int distance = Integer.parseInt(command[1]);

            int dy = 0;
            int dx = 0;

            switch (direction) {
                case 'N': dy = -1; break;
                case 'S': dy = 1; break;
                case 'W': dx = -1; break;
                case 'E': dx = 1; break;
            }

            //검사를 위한 임시 위치

            int nextY = y;
            int nextX = x;

            boolean canMove = true;

            for(int i = 0; i < distance; i++) {
                nextY += dy;
                nextX += dx;

                // 공원을 벗어나는 경우
                if(nextY < 0 || nextY >= h || nextX < 0 || nextX >= w) {
                    canMove = false;
                    break;
                }

                // 장애물을 만나는 경우
                if(park[nextY].charAt(nextX) == 'X') {
                    canMove = false;
                    break;
                }
            }

            if(canMove) {
                y = nextY;
                x = nextX;
            }
        }

        return new int[]{y, x};
    }
}
