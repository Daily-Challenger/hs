package algo_search;

import java.util.*;;

public class search_4 {
    
    boolean[] visited;
    int[][] computers;
    int n;

    public static void main(String[] args) {

        int[][] computers = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int n = 3;

        search_4 s = new search_4();
        System.out.println(s.solution(n, computers));

    }

    int solution(int n, int[][] computers) {

        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];

        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }


    void dfs(int current) {
        visited[current] = true;

        for(int next = 0; next < n; next++) {
            //연결 여부 검사
            if(computers[current][next] == 0) {
                continue;
            }

            //방문 여부 검사
            if(visited[next]) {
                continue;
            }

            //재귀 호출
            dfs(next);
        }
    }



        


    
}
