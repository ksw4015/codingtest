package sort;

import java.util.*;

public class LRUCacheMemory {
    /*
        내 풀이
     */
    private static void solution(int[] work, int size) {
        LinkedList<Integer> cache = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i : work) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int w = queue.poll();
            if(cache.isEmpty()) {
                cache.addFirst(w);
            } else {
                Integer exist = null;
                for(Integer i : cache) {
                    if(i == w) {
                        exist = i;
                        break;
                    }
                }
                if(exist != null) {
                    cache.remove(exist);
                    cache.addFirst(exist);
                } else {
                    cache.addFirst(w);
                }
            }
            if(cache.size() > size) {
                cache.removeLast();
            }
        }

        for(int i : cache) {
            System.out.print(i + " ");
        }
    }

    /*
        선택정렬(배열) 이용
     */
    private static void solution2(int[] work, int size) {
        int[] cache = new int[size];
        // Hit 상황과 Miss 상황을 구분
        // Hit 상황시 Hit난 지점 Index부터 1까지 --
        // Miss 상황시에는 last ~ 1 번 까지
        for(int x : work) {
            int pos = -1;  // Hit or Miss 구분
            for(int i = 0 ; i < size ; i++) {
                if(cache[i] == x) {
                    pos = i;
                    break;
                }
            }
            if(pos == -1) {
                for(int i = size - 1 ; i > 0 ; i--) {
                    cache[i] = cache[i-1];
                }
            } else {
                for(int i = pos ; i > 0 ; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;
        }
        for(int i : cache) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.valueOf(input[0]);
        int k = Integer.valueOf(input[1]);
        String[] input2 = sc.nextLine().split(" ");
        int[] w = new int[input2.length];
        for(int i = 0 ; i < input2.length ; i++) {
            w[i] = Integer.valueOf(input2[i]);
        }
        solution2(w, n);
    }
}
