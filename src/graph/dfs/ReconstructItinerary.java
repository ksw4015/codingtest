package graph.dfs;

import java.util.*;

/**
 * LeetCode 332
 * 프로그래머스 여행경로 문제와 거의 동일
 */
public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
        for(List<String> ticket : tickets) {
            ticketMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            ticketMap.get(ticket.get(0)).add(ticket.get(1));
        }

        // 자바에서 Stack 클래스는 성능상 이슈가 있으므로
        // Deque로 Stack을 대신한다
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");
        List<String> results = new LinkedList<>();
        while (!stack.isEmpty()) {
            // stack에 모든 티켓에 연결된 도착지를 알파벳순으로 넣는다 (Push 메서드로 삽입하기때문에 Stack 특성상 가장 첫 도착지가 마지막에 있음)
            while (ticketMap.containsKey(stack.peek()) && !ticketMap.get(stack.peek()).isEmpty()) {
                stack.push(ticketMap.get(stack.peek()).poll());
            }
            results.add(0, stack.pop());
        }

        return results;
    }

    public List<String> findItineraryRecursion(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
        for(List<String> ticket : tickets) {
            ticketMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            ticketMap.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> results = new LinkedList<>();
        dfs(results, ticketMap, "JFK");
        return results;
    }

    private void dfs(List<String> results, Map<String, PriorityQueue<String>> map, String from) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            dfs(results, map, map.get(from).poll());
        }
        results.add(0, from);
    }

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("MUC","LHR"));
        input.add(Arrays.asList("JFK","MUC"));
        input.add(Arrays.asList("SFO","SJC"));
        input.add(Arrays.asList("LHR","SFO"));
        System.out.println(new ReconstructItinerary().findItineraryRecursion(input));
    }
}
