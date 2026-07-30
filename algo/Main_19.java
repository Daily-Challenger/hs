import java.util.*;

public class Main_19 {

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        
        System.out.println(solution(n, wires));
        
    }


    /**
     * 
     * @param n 2이상 100 이하
     * @param wires 길이가 n-1인 정수형 2차원 배열
     * @return
     */
    public static int solution(int n, int[][] wires) {

        List<Integer>[] graph = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        //인접 리스트 구성
        for(int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        int answer = Integer.MAX_VALUE;

        //전선을 하나씩 끊기
        for(int[] wire: wires) {
            int cutNode1 = wire[0];
            int cutNode2 = wire[1];

            int count = bfs(cutNode1, cutNode1, cutNode2, graph, n);

            int otherCount = n - count;
            int difference = Math.abs(count - otherCount);

            answer = Math.min(answer, difference);
        }

        return answer;
    }

    public static int bfs(int start, int cutNode1, int cutNode2, List<Integer>[] graph, int n) {

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(start);
        visited[start] = true;

        int count = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for(int next: graph[current]) {
                //현재 끊은 전선은 이동하지 않는다.
                if((current == cutNode1 && next == cutNode2) 
                    || (current == cutNode2 && next == cutNode1)) {
                    continue;
                }
                
                if(visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.offer(next);
            }
        }

        return count;
    }
}
