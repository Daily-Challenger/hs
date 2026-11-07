package algo_search;

import java.util.*;

public class search_5 {
    
    public static void main(String[] args) {
        
        int answer = -1;
        int[][] map = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0}
        };  
        int rows = map.length;
        int cols = map[0].length;

        int[][] dist = new int[rows][cols];
        for(int[] row: dist) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> queue = new ArrayDeque<>();

        //방향배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int startX = 0;
        int startY = 0;
        int endX = 4;
        int endY = 3;
        //시작점 등록;
        queue.offer(new int[]{startX, startY});
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int x = current[0];
            int y = current[1];

            if(x == endX && y == endY) {
                //TODO3
                answer = dist[x][y];
                return;
            }

            //현재 위치에서 다음 위치를 구하는 코드
            for(int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //경계검사
                if(nx >= rows || nx < 0) {
                    continue;
                }

                if(ny >= cols || ny < 0) {
                    continue;
                }

                //벽검사
                if(map[nx][ny] == 1) {
                    continue;
                }

                //방문검사
                if(dist[nx][ny] != -1) {
                    continue;
                }

                //다음 좌표까지 최소 이동 횟수
                dist[nx][ny] = dist[x][y] + 1;

                queue.add(new int[]{nx, ny});
            }
        }

        System.out.println(answer);

    }


}
