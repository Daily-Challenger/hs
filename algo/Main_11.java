import java.util.*;

public class Main_11 {
    
    /**
     * 배열 arr에서 연속된 수는 하나만 남기고 제거
     * 제거 후 반환시 원소들의 순서를 유지
     * <ul>
     *  <li>배열 arr의 크기 : 1,000,000 이하의 자연수</li>
     *  <li>배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수</li>
     * </ul>
     */
    public static void main(String[] args) {

        int[] t = {4,4,4,3,3};
        for(int i : solution(t)) {
            System.out.print(i + ", ");
        }
    }

    /**
     * 배열 전체를 순회한 뒤 Stream.filter().toArray() 로 다시 전체를 처리해 느림
     * 별도 List 는 없지만 Stream 내부 버퍼와 최종 배열이 필요해 메모리 사용량 증가
     * @param arr
     * @return
     */
    public static int[] solution(int[] arr) {
        
        int p1 = 0;
        int p2 = 1;
        
        while(p2 < arr.length) {
            if(arr[p1] == arr[p2]) {
                arr[p2] = -1;
                p2++;
            } else {
                p1 = p2;
                p2 = p1 + 1;
            }
        }

        int[] answer = Arrays.stream(arr)
                        .filter(n -> n != -1)
                        .toArray();
        
        return answer;
    }

    /**
     * 단순 반복문이라 Stream보다 빠르지만, ArrayList<Integer>의 박싱·언박싱과 내부 배열 확장 비용 발생
     * 리스트와 최종 int[]를 함께 보유해 메모리 사용량이 가장 큼
     * @param arr
     * @return
     */
    public static int[] solution2(int[] arr) {

        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] != arr[i]) {
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    /**
     * 기본형 배열에 직접 저장해 Stream·박싱·리스트 확장 비용이 없어 빠름
     * 크기 arr.length의 임시 배열과 Arrays.copyOf()로 만든 최종 배열이 잠시 함께 존재하여 1번과 메모리 풀 비슷
     */
    public static int[] solution3(int[] arr) {
        int[] result = new int[arr.length];
        
        result[0] = arr[0];
        int size = 1;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] != arr[i]) {
                result[size++] = arr[i];
            }
        }

        return Arrays.copyOf(result, size);
    }
}
