package algo2;

public class Main_51 {
    
    public static void main(String[] args) {
        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println(solution(ingredient));
    }

    /**
     * 햄버거 만들기
     * 1-2-3-1 이 연속될때 햄버거 완성
     * 만들 수 있는 최대 갯수 구하기
     * @param ingredient
     * @return
     */
    public static int solution(int[] ingredient) {
        int answer = 0;
        int size = 0;

        int[] stack = new int[ingredient.length]; 
        for(int item : ingredient) {
            stack[size++] = item;

            if(size >=4
                && stack[size-4] == 1 
                && stack[size-3] == 2
                && stack[size-2] == 3
                && stack[size-1] == 1) {
                    size -= 4;
                    answer++;
                }
        }
        return answer;
    }

}
