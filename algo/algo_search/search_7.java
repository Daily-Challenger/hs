package algo_search;

public class search_7 {
    
    int answer = 0;
    int[] numbers;
    int target;
    public static void main(String[] args) {
        search_7 s = new search_7();
        int[] numbers = {1, 2};
        int target = 1;

        System.out.println(s.solution(numbers, target));
    }

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);

        return answer;
    }

    private void dfs(int index, int sum) {
        if(index == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }

        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);

    }
}
