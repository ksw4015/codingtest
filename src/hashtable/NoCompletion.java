package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NoCompletion {

    public String NoCompletion(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for(String comp : completion) {
            if(map.containsKey(comp)) {
                map.put(comp, map.get(comp) - 1);
            }
        }

        String answer = "";
        for(String noComp : map.keySet()) {
            if(map.get(noComp) > 0) {
                answer = noComp;
                break;
            }
        }

        return answer;
    }

    /*
        우선순위 큐

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
     */
    public String NoCompletion2(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for(String comp : completion) {
            if(map.containsKey(comp)) {
                map.put(comp, map.get(comp) - 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        return pq.poll().getKey();
    }

}
