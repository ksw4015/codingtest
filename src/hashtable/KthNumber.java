package hashtable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hash 강의
 * K번째 큰 수
 */
public class KthNumber {
    private static void solution(int[] numbers, int k) {
        List<Integer> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), Arrays.stream(numbers).boxed().collect(Collectors.toList()), k);
        results.sort(Comparator.reverseOrder());
        System.out.print(results.get(k-1));
    }

    private static void dfs(List<Integer> list, List<Integer> prevList, List<Integer> nextList, int k) {
        if(k == 0) {
            int sum = 0;
            for(Integer i : prevList) {
                sum += i;
            }
            if(!list.contains(sum))
                list.add(sum);
            return;
        }

        for(Integer i : nextList) {
            List<Integer> nextElements = new ArrayList<>(nextList);
            nextElements.remove(i);

            prevList.add(i);
            dfs(list, prevList, nextElements, k-1);
            prevList.remove(prevList.size() - 1);
        }
    }

    private static int solution2(int[] numbers, int k) {
        TreeSet<Integer> tSet= new TreeSet<>(Comparator.reverseOrder());
        for(int i = 0 ; i < numbers.length ; i++) {
            for (int j = i+1 ; j < numbers.length ; j++) {
                for(int n = j+1 ; n < numbers.length ; n++) {
                    tSet.add(numbers[i] + numbers[j] + numbers[n]);
                }
            }
        }

        int cnt = 0;
        for(Integer i : tSet) {
            cnt++;
            if(cnt == k)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        String[] input2 = sc.nextLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);
        int[] numbers = new int[n];

        for(int i = 0 ; i < numbers.length ; i++) {
            numbers[i] = Integer.parseInt(input2[i]);
        }

        System.out.print(solution2(numbers, k));
    }
}
