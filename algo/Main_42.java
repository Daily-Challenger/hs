public class Main_42 {
    
    public static void main(String[] args) {
        
        int n = 5;
        System.out.println(solution(n));
    }

    public static int solution(int n) {

        int answer = 0;
        int[] arr = new int[n+1];
        for(int i = 2; i < arr.length; i++) {
            if(arr[i] == 0) {
                for(int j = 2; i * j < arr.length; j++) {
                    arr[i*j] = 1;
                } 
            }
        }

        for(int i = 2; i < arr.length; i++) {
            if(arr[i] == 0) {
                answer++;
            }
        }
        return answer;
    }

    /**
     * 에라토스테네스의 체를 이용해 2부터 √n까지 각 소수의 배수를 합성수로 표시한다.
     * 이때 i * i보다 작은 배수는 이전 단계에서 이미 처리되었으므로 i * i부터 제거한다.
     * 마지막까지 합성수로 표시되지 않은 수의 개수를 세어 반환한다.
     * @param n
     * @return
     */
    public static int solution2(int n) {

        boolean[] isComposite = new boolean[n+1];

        for(int i = 2; i * i <= n; i++) {
            if(!isComposite[i]) {
                for(int j = i * i; j <= n; j+= i) {
                    isComposite[j] = true;
                }
            }
        }

        int answer = 0;

        for(int i = 2; i <=n; i++) {
            if(!isComposite[i]) {
                answer++;
            }
        }

        return answer;
    }
}
