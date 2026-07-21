import java.util.*;

/**
 * 플로이드-워셜
 */
public class Main_16 {

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;

        int[][] fares = {
            {4, 1, 10},
            {3, 5, 24},
            {5, 6, 2},
            {3, 1, 41},
            {5, 1, 24},
            {4, 6, 50},
            {2, 4, 66},
            {2, 3, 22},
            {1, 6, 25}
        };
        
        System.out.println(solution(n, s, a, b, fares));
    }

    /**
     * 
     * @param n 지점 갯수
     * @param s 출발지점
     * @param a a의 도착 
     * @param b b의 도착
     * @param fares 지점 사이의 예상 택시 요금
     * @return
     */
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        /**
         * 도달할 수 없는 경로를 나타내는 매우 큰값
         *   요금 최댓값이 간선 하나당 100,000
         *   최단경로에서는 n-1개의 간선 사용가능
         *   n의 최댓값이 200 이므로 가능한 최단거리의 최대치
         *   대략 100,000* 199 = 19,900,000
         *   따라서 실제 경로 비용보다 큰 20,000,001을 INF로 사용
         * 
         */
        final int INF = 20_000_0001;

        /**
         * dist[i][j]:
         * i번 지점에서 j번 지점까지 가는 최소 택시요금
         * 지점 번호가 1번부터 n번까지이므로
         * 인덱스를 그대로 사용하기 위해 n + 1 크기로 선언
         * 
         * 0번 인덱스는 사용하지 않는다.
         */
        int[][] dist = new int[n + 1][n + 1];
        
        /**
         * 거리 배열 초기화
         * 
         * 처음에는 각 지점 사이의 최단거리를 알 수 없으므로 
         * 모든값을 INF로 설정
         */
        for(int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);

            /**
             * 자기 자신에게 가는 비용은 0
             */
            dist[i][i] = 0;
        }

        /**
         * 직접 연결된 택시 노선의 비용을 저장
         */
        for(int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            //택시 노선은 양방향이므로 양쪽 모두 저장
            dist[from][to] = cost;
            dist[to][from] = cost;
        }

        /**
         * 플로이드-워셜 알고리즘
         * 모든 지점 i에서 모든 지점 j까지의 최단거리를 계산
         * 
         * 1. i에서 j로 현재 알고 있는 비용
         * dist[i][j]
         * 2. i에서 k를 거쳐 j로 가는 비용
         * dist[i][k] + dist[k][j]
         * 
         * 2번이 더 저렴하다면 dist[i][j]를 갱신
         */
        for(int k = 1; k <=n; k++) {

            /**
             * k: 이번 단계에서 중간 경유지로 사용해 볼 지점
             * 예를 들어 k=3 이라면
             * 모든 경로에 대해 3번 지점을 거쳐 가는 것이 
             * 더 저렴한지 검사한다
             */
            for(int i = 1; i <= n; i++) {
                //i:출발지점, j: 도착지점
                for(int j = 1; j <=n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        //최종 정답 저장(처음은 INF로 초기화)
        int answer = INF;

        /**
         * 두 사람이 어디까지 합승할지를 결정한다.
         * 
         * sharedEnd: A와 B가 함께 택시를 타고 이동한 뒤 서로 갈라지는 지점
         * 모든 지점이 합승 종료 지점이 될 수 있으므로 1부터 n번까지 모두 검사
         */
        for(int sharedEnd =1; sharedEnd <= n; sharedEnd++) {

            /**
             * 전체 택시요금은 다음 세 비용의 합.
             * 1. s -> shareEnd: A와 B가 함꼐 이동하는 합승 비용
             * 2. shareEnd -> a: 갈라진 후 A가 자신의 목적까지 가는 비용
             * 3. shareENd -> b: 갈라진 후 자신의 목적까지 가는 비용
             */
            int totalCost = dist[s][sharedEnd] + dist[sharedEnd][a] + dist[sharedEnd][b];

            answer = Math.min(answer, totalCost);
        }

        return answer;
    }
}
