package algo_search;

public class search_9 {
    
    boolean[] visited = new boolean[7];
    int answer = 0;

    void dfs(int depth, int sum) {

        //1. 정상적인 종료 조건
        if(depth == 3) {
            if(sum == 8) {
                answer++;
            }
            return;
        }

        //2. 가지치기
        if(sum > 8) {
            return;
        }

        //3. 다음 선택
        for(int i = 0; i <= 6; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, sum + i);
            visited[i] = false;
        }
    }
}
