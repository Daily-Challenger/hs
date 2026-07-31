public class Main_20 {

    public static void main(String[] args) {
        String[] keymap = {"AA"};
        String[] targets = {"B"};

        System.out.println();
        for(int i : solution(keymap, targets)) {
            System.out.println(i + " ");
        }
    }

    public static int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];

        for(int i = 0; i < targets.length; i++) {

            String target = targets[i];

            for(int j = 0; j < target.length(); j++) {

                char c = target.charAt(j);
                int minCount = Integer.MAX_VALUE;

                for(int k = 0; k < keymap.length; k++) {
                    
                    int index = keymap[k].indexOf(c);
                    
                    if (index != -1) {
                        minCount = Math.min(minCount, index + 1);
                    }
                }

                if(minCount == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                }

                answer[i] += minCount;
 
            }
        }
        return answer;
    }
    
}
