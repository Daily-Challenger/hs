package algo_search;

import java.util.Arrays;

public class search_8 {
    
    boolean[] visited = new boolean[4];
    int[] selected = new int[3];
    public static void main(String[] args) {
        search_8 search = new search_8();
        search.dfs(0);
    }

    void dfs(int depth) {

        if(depth == 3) {
            System.out.println(Arrays.toString(selected));
            return;
        }

        for(int i = 1; i <=3; i++) {
            //1. 이미 선택한 숫자라면 건너뛰기
            if(visited[i]) { 
                continue;
            }
            //2. 숫자 i를 방문처리
            visited[i] = true;

            //3. selected[depth]에 숫자 i 저장
            selected[depth] = i;

            //4. 다음 깊이로 재귀 호출
            dfs(depth + 1);

            //5. 재귀 호출이 반환된 후 방문 상태 복구
            visited[i] = false;
        }
    }
}
