package algo_1;
import java.math.BigDecimal;
import java.util.*;

public class Main_44 {
    
    public static void main(String[] args) {

    }

    public static int[] solution(int N, int[] stages) { 
       
        //스테이지별 도전자 수
        int[] stageChallenger = new int[N+2];
        for(int i = 0; i < stages.length; i++) {
            int num = stages[i];
            stageChallenger[num] += 1;
        }

        //스테이지별 총 도전자 수
        int[] allChallenger = new int[stageChallenger.length-1];
        for(int i = 1; i < allChallenger.length; i++) {
            for(int j = stageChallenger.length-1; j >= i; j--) {
                allChallenger[i] += stageChallenger[j];
            }
        }  

        //실패 확률 구하기
        double[][] failure = new double[N][2];

        for(int i = 0; i < failure.length; i++) {
            failure[i][0] = (double) i+1;
            //double의 0.0 / 0.0 은 0이 아닌 NaN 이므로 정렬에서 숫자보다 큰값으로 정렬됨
            if(allChallenger[i + 1] == 0) {
               failure[i][1] = 0.0;
            } else {
               failure[i][1] = (double) stageChallenger[i + 1] / allChallenger[i + 1];
            }
        }

        //실패 기준 정렬(같을 때 낮은 스테이지 번호가 앞으로 오도록)
        Arrays.sort(failure, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return Double.compare(o1[0], o2[0]);
            }
            return Double.compare(o2[1], o1[1]);
        });

        int[] answer = new int[N];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = (int) failure[i][0];
        }
        return answer;
    }

    /**
     * 첫번째 풀이에서 스테이지마다 뒤쪽을 다시 합산하는 방식을 개선
     * 실패율을 1번스테이지 부터 계산
     * int challenger = stages.length;
     * 1번 계산 후 challenger -= stageChallenger[1];
     * @param N
     * @param stages
     * @return
     */
    public static int[] solution2(int N, int[] stages) { 

        int[] stageChallenger = new int[N+2];

        for(int stage : stages) {
            stageChallenger[stage]++;
        }

        double[][] failure = new double[N][2];

        //1번 스테이지에는 모든 사용자가 도달한 상태
        int challenger = stages.length;

        for(int i = 1; i <= N; i++) {
            failure[i-1][0] = i;

            if(challenger == 0) {
                //도달한 사람 없으면 실패율 0
                failure[i-1][1] = 0.0;
            } else {
                failure[i-1][1] = (double) stageChallenger[i] / challenger;
            }
            //현재 스테이지에서 실패한사람은 다음 스테이지 못감
            challenger -= stageChallenger[i];
        }

        Arrays.sort(failure, (o1, o2) -> {
        
            int compare = Double.compare(o2[1], o1[1]);
        
            if(compare == 0) {
                return Double.compare(o1[0], o2[0]);
            }
        
            return compare;
        });
    
        int[] answer = new int[N];
    
        for(int i = 0; i < N; i++) {
            answer[i] = (int) failure[i][0];
        }
    
        return answer;        
    }
}
