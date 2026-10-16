package algo3;

import java.util.*;

/**
 * 방문길이
 * 
 * 시작점 (0, 0)에서 U, D, L, R 명령어에 따라 이동한다.
 * 좌표 범위는 -5부터 5까지이며, 경계를 벗어나는 이동은 무시한다.
 * 이동한 경로 중 중복을 제외하고 처음 방문한 길의 개수를 반환한다.
 * 
 * Main_3_30
 */
public class Main_3_30 {
    
    public static void main(String[] args) {
        
        Main_3_30 main = new Main_3_30();
        String dirs = "ULURRDLLU";
        System.out.println(main.solution(dirs));
    }

    /**
     * Map과 Set을 이용하여 각 좌표에서 이동한 경로를 관리한다.
     * 동일한 길의 역방향 이동도 중복 처리하기 위해 양방향으로 저장한다.
     * 문자열 좌표 생성과 해시 자료구조 사용으로 불필요한 연산이 발생한다.
     * 
     * @param dirs
     * @return
     */
    public int solution(String dirs) {
        int answer = 0;

        int x = 5;
        int y = 5;

        Map<String, Set<String>> map = new HashMap<>();
        String now = x + "," + y;

        for(char c : dirs.toCharArray()) {

            switch (c) {
                case 'U': y--; break;
                case 'D': y++; break;
                case 'L': x--; break;
                case 'R': x++; break;
            }

            if(y < 0) {
                y = 0;
                continue;
            } else if(y > 10) {
                y = 10;
                continue;
            } else if(x < 0) {
                x = 0;
                continue;
            } else if(x > 10) {
                x = 10;
                continue;
            }

            String next = x + "," + y;
            //key 가 있는지 확인
            if(!map.containsKey(next)) {
                answer++;
            } else if(!map.get(next).contains(now)) {
                answer++;
            } 

            Set<String> temp = map.getOrDefault(now, new HashSet<>());
            temp.add(next);
            map.put(now, temp);
            temp = map.getOrDefault(next, new HashSet<>());
            temp.add(now);
            map.put(next, temp);
            now = next;
        }

        return answer;
    }
    
    /**
     * 3차원 boolean 배열을 이용하여 각 좌표의 4방향 방문 여부를 관리한다.
     * 새로운 길을 방문하면 현재 방향과 도착 좌표의 반대 방향을 함께 기록한다.
     * 고정된 좌표 범위를 활용하여 해시 탐색과 문자열 생성 없이 방문 여부를 확인한다.
     * 
     * @param dirs
     * @return
     */
    public int solution2(String dirs) { 

        int answer = 0;

        // 상, 하, 좌, 우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};        
        //반대 방향 인덱스
        int[] opposite = {1, 0, 3, 2};
        // 각 좌표에서 4방향의 방문 여부
        boolean[][][] visited = new boolean[11][11][4];

        int x = 5;
        int y = 5;

        for (char c : dirs.toCharArray()) {
            int dir;

            switch (c) {
                case 'U': dir = 0; break;
                case 'D': dir = 1; break;
                case 'L': dir = 2; break;
                default:  dir = 3; break;
            }

            // 다음 좌표 계산
            int nx = x + dx[dir];
            int ny = y + dy[dir];


            // 경계를 벗어나면 이동하지 않음
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
                continue;
            }            

            // 처음 방문한 길이라면 카운트
            if (!visited[y][x][dir]) {
                answer++;

                // 현재 좌표에서 이동한 방향 기록
                visited[y][x][dir] = true;

                // 다음 좌표에서 반대 방향 기록
                visited[ny][nx][opposite[dir]] = true;
            }

            // 현재 좌표 갱신
            x = nx;
            y = ny;            
        }

        return answer;
    }
}
