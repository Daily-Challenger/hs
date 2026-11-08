package algo_search;

import java.util.*;

public class search_6 {
    
    public static void main(String[] args) {
        int[][] map = {
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0}
        };

        search_6 s = new search_6();
        System.out.println(s.solution(map));
    }

    public int solution(int[][] map) {

        int answer = -1;
        int startX = 0;
        int startY = 0;
        int endX = 3;
        int endY = 4;

        int[][] dist = new int[map.length][map[0].length];

        for(int[] row: dist) {
            Arrays.fill(row, -1);
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        dist[startX][startY] = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if(x == endX && y == endY) {
                answer = dist[x][y];
                return answer;
            }

            for(int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= map.length || nx < 0 || ny >= map[0].length || ny < 0) {
                    continue;
                }

                if(map[nx][ny] == 1) {
                    continue;
                }

                if(dist[nx][ny] != -1) {
                    continue;
                }

                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        return answer;
    }   
}
