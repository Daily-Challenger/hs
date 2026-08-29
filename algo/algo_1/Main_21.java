package algo_1;
import java.util.*;

/**
 * dp[node][0] // node가 불참한다고 정했을 때, node 서브트리의 최소 비용
 * dp[node][1] // node가 참석한다고 정했을 때, node 서브트리의 최소 비용
 */
public class Main_21 {

    public static void main(String[] args) {
        
        int[] sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
        int[][] links = {{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};

        System.out.println(solution(sales, links));
    }

    public static int solution(int[] sales, int[][] links) {
        int n = sales.length;

        List<Integer>[] graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] link : links) {
            int parent = link[0];
            int child = link[1];

            graph[parent].add(child);
        }

        int[] order = new int[n];
        int orderSize = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            order[orderSize++] = node;

            for(int child : graph[node]) {
                stack.push(child);
            }
        }

        /**
         * dp[node][0] : node가 참석하지 않는 경우
         * dp[node][1] : node가 참석하는 경우
         */
        long[][] dp = new long[n+1][2];

        //역순 조회
        for(int i = orderSize - 1; i >= 0; i--) {
            int node = order[i];

            //node가 참석하는 경우 자신의 매출액 포함
            dp[node][1] = sales[node - 1];

            //리프 노드는 자신이 담당하는 팀이 없음
            //리프 노드가 불참하면 매출 손실이 없음.
            //참석하면 본인의 매출액만큼 손실 발생
            if(graph[node].isEmpty()) {
                dp[node][0] = 0;
                continue;
            }

            long baseCost = 0;
            long minimumExtraCost = Long.MAX_VALUE;

            for(int child : graph[node]) {
                //자식 node가 참석하는것과 안하는 것중 적은 cost를 선택?
                long cheaperCost = Math.min(dp[child][0], dp[child][1]);

                baseCost += cheaperCost;
                /**
                 * child를 참석 상태로 만들 떄 필요한 추가비용
                 */
                long extraCost = dp[child][1] - cheaperCost;
                
                minimumExtraCost = Math.min(minimumExtraCost, extraCost);
            }

            /**
             * node가 참석하면 node의 팀 조건이 이미 만족
             * 자식별 최소비용만 더한다.
             */
            dp[node][1] += baseCost;

            /**
             * node가 참석하지 않으면 자식 중 최소 한명이 참석해야함.
             */
            dp[node][0] = baseCost + minimumExtraCost;
        }

        return (int) Math.min(dp[1][0], dp[1][1]);
    }
    
}
