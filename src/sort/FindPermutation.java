package sort;

import java.util.*;

/**
 * 오름차순 수열이 존재했었음
 * 기존 수열에 *2한 값을 무작위로 섞어넣음
 * 기존 수열을 구하시오
 */
public class FindPermutation {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 != 0) {
                result.add(num);
            } else {
                result2.add(num);
            }
        }
        for(int i = 0 ; i < result.size() ; i++) {
            if(result2.contains(result.get(i)*2)) {
                result2.remove(Integer.valueOf(result.get(i)*2));
            }
        }
        for(int i = 0 ; i < result2.size() ; i++) {
            if(!result2.contains(result2.get(i)/2)) {
               result.add(result2.get(i));
            }
        }

        result.sort(Comparator.comparingInt(o -> o));
        if(result.size() == answer.length) {
            for(int i = 0 ; i < answer.length ; i++) {
                answer[i] = result.get(i);
            }
        }
        return answer;
    }

    /**
     * 가장 작은 값은 원래 수열에 있던 값임은 확실
     * @param
     */
    public int[] solution2(int[] nums) {
        Arrays.sort(nums);
        // 카운팅하기 위한 HashSet 자료구조
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++) {
            // 가장 작은 수부터 반복하면서 결과값에 넣고 카운트 -1
            if(map.containsKey(nums[i]) && map.get(nums[i]) > 0) {
                map.put(nums[i], map.get(nums[i]) - 1);
                result.add(nums[i]);
            }
            // 가장작은수 *2한 값이 Map에 있으면 카운트 -1
            if(map.containsKey(nums[i]*2)) {
                map.put(nums[i]*2, map.get(nums[i]*2)-1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args){
        FindPermutation T = new FindPermutation();
        System.out.println(Arrays.toString(T.solution2(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution2(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution2(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
