package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56
 * 구간 병합
 *
 * 문제를 풀기위해선 먼저 정렬이 필요함으로 정렬 패키지에 넣었다.
 */
public class MergeIntervals {

    /*
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        설명 : 1,3의 도착지인 3과 2,6의 출발지인 2가 겹침으로
            3 >= 2 이기 문에 [1,6]으로 구간 병합이 가능하다.
            8,10은 15,18의 8 >= 15가 성립하지 않아서,
            그대로 8,10을 유지한다
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            Integer dest = o1[0];
            Integer start = o2[0];
            return dest.compareTo(start);
        });

        List<List<Integer>> results = new ArrayList<>();
        results.add(Arrays.asList(intervals[0][0], intervals[0][1]));
        for(int i = 1 ; i < intervals.length ; i++) {
            if(results.get(results.size()-1).get(1) >= intervals[i][0]) {
                if(results.get(results.size()-1).get(1) < intervals[i][1])
                    results.get(results.size()-1).set(1, intervals[i][1]);
            } else {
                List<Integer> newElement = new ArrayList<>();
                newElement.add(intervals[i][0]);
                newElement.add(intervals[i][1]);
                results.add(newElement);
            }
        }

        int[][] answer = new int[results.size()][2];
        for(int i = 0 ; i < results.size() ; i++) {
            answer[i] = new int[]{results.get(i).get(0), results.get(i).get(1)};
        }
        return answer;
    }

    public static void main(String[] args) {
    }

}
