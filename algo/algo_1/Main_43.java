package algo_1;
public class Main_43 {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(solution(nums));
        
    }

    /**
     * 소수 만들기
     * @param nums
     * @return
     */
    public static int solution(int [] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int x =(int) Math.sqrt(sum);
                    boolean isPrime = true;
                    for(int l = 2; l <= x; l++) {
                        if(sum % l == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if(isPrime) {
                        answer++;
                    }

                }
            }
        }
        return answer;
    }
}
