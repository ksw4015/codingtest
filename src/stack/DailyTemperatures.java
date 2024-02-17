package stack;

import java.util.*;

public class DailyTemperatures {
    /*
        Input: temperatures = [73,74,75,71,69,72,76,73]
        Output: [1,1,4,2,1,1,0,0]
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        // 완전탐색
        for(int i = 0 ; i < temperatures.length - 1 ; i++) {
            int count = 0;
            for(int j = i+1 ; j < temperatures.length ; j++) {
                if(temperatures[i] < temperatures[j]) {
                    result[i] = count + 1;
                    break;
                } else {
                    count++;
                }
            }
        }

        return result;
    }

    /*
        Input: temperatures = [73,74,75,71,69,72,76,73]
        Output: [1,1,4,2,1,1,0,0]
     */
    public static int[] dailyTemperatures2(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < temperatures.length ; i++) {
            // 현재 온도가 stack head에 있는 인덱스의 온도 보다 높으면
            // stack head에 있는 인덱스에 현재 온도 인덱스 - stack head 인덱스한 값을 넣는다.
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int last = stack.pop();
                result[last] = i - last;
            }
            // stack에 인덱스는 계속 삽입
            stack.push(i); // 6, 3, 2
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        for(int i : result) {
            System.out.println("" + i);
        }
    }
}
