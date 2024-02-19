package graph.dfs;

import java.util.*;

/**
 * 프로그래머스 DFS/BFS 레벨3
 * 여행경로
 *
 * 스택으로 DFS 구현
 *
 */
public class TravelPath {

    public String[] solution(String[][] tickets) {
        // 결과값을 담을 리스트
        List<String> results = new LinkedList<>();

        // 출발지, 도착지(우선순위 큐)
        // 도착지가 여러개인 경우 알파벳 순서로 poll 하기위해서 우선순위 큐로 구성
        HashMap<String, PriorityQueue<String>> fromToMap = new HashMap<>();
        for(String[] ticket : tickets) {
            fromToMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            fromToMap.get(ticket[0]).add(ticket[1]);
        }

        Deque<String> stack = new ArrayDeque<>();
        stack.push("ICN");
        while (!stack.isEmpty()) {
            // 스택에서 출발지 추출 후 해당 출발지가 Map에 있고, 출발지에 해당하는 도착지 우선순위 큐가 비어있지 않으면 반복
            // 두번째 조건때문에 우선순위큐가 모두 빌때까지 stack에서 pop하지 않을채로 Head만 바뀌면서 계속 반복!
            while (fromToMap.containsKey(stack.peek()) && !fromToMap.get(stack.peek()).isEmpty()) {
                // 도착지 우선순위 큐가 빌때까지 스택에 삽입
                // 도착지를 스택에 쌓고 다음 출발지로 사용함
                stack.push(fromToMap.get(stack.peek()).poll());
            }
            System.out.println("첫번째 while문: " + stack);
            results.add(0, stack.pop());
        }
        return results.toArray(new String[0]);
    }

    public static void main(String[] args) {
//        System.out.print(Arrays.asList(new TravelPath().solution(new String[][]{{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}})));
        System.out.print(Arrays.asList(new TravelPath().solution(new String[][]{{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}})));
    }

}
