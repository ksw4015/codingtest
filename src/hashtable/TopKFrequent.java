package hashtable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Leetcode 347
 */
public class TopKFrequent {

    /*
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> results = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());

        int[] result = new int[k];
        for(int i = 0 ; i < k ; i++) {
            result[i] = results.get(i);
        }
        return result;
    }

    /*
        우선순위 큐
     */
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(map.entrySet());

        int[] result = new int[k];
        for(int i = 0 ; i < k ; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }

}
