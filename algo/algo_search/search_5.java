package algo_search;

public class search_5 {
    
    public static void main(String[] args) {
        
        int[][] map = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0}
        };  
        int rows = 4;
        int cols = 5;

        int x = 2;
        int y = 3;
        //방향배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

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

            System.out.println(nx + ", " + ny);
        }

    }


}
