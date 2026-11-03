package algo_search;

import java.util.*;

public class search_3 {
    
    List<List<Integer>> graph;
    boolean[] visited;
    int count = 0;

    public static void main(String[] args) {
        search_3 s3 = new search_3();
        System.out.println(s3.solution());
        
    }

    public int solution() {
        int n = 7;

        int[][] edges = {
            {1, 2},
            {1, 3},
            {2, 4},
            {3, 4},
            {5, 6}
        };
        graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n + 1];

        int answer = 0;

        for(int i = 1; i <= n; i++) {
            if(visited[i]) {
                continue;
            }

            dfs(i);
            answer++;
        }


        return answer;


    }

    void dfs(int current) {
        //1. 현재 노드 방문처리
        visited[current] = true;

        //2. 방문한 노드 개수 증가
        // count++;

        //3. 현재 노드의 인접 노드 탐색
        for(int next : graph.get(current)) {
            //4. 이미 방문한 노드는 건너뛰기
            if(visited[next]) {
                continue;
            }
            //5. 방문하지 않은 노드라면 재귀 호출
            dfs(next);
        }
    }
}
