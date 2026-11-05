package algo_search;

public class search_5 {
    
    public static void main(String[] args) {
        
        int x = 2;
        int y = 3;
        //방향배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //현재 위치에서 다음 위치를 구하는 코드
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            System.out.println(nx + ", " + ny);
        }

    }


}
