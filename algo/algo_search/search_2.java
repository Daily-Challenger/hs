package algo_search;

import java.util.ArrayList;
import java.util.List;

public class search_2 {
    
    public static void main(String[] args) {
        
    }

    boolean[] visited = new boolean[6];

    List<List<Integer>> graph = new ArrayList<>();

    void dfs(int current) {


        System.out.println(current);

        for(int next: graph.get(current)) {
            if(visited[next]) {
                continue;
            }

            visited[next] = true;
            dfs(next);
        }
    }
}
