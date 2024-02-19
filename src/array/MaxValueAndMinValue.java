package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 프로그래머스 레벨2 연습문제
 * 최댓값 최솟값
 *
 * 공백으로 구분한 정수가 들어있는 문자열이 주어지고
 * 해당 문자열의 최대값과 최솟값을 찾는 문제
 */
public class MaxValueAndMinValue {

    /*
        "1 2 3 4" -> "1 4"
        "-1 -2 -3 -4 -> "-1 -4"
        "-1 -1" -> "-1 -1"
     */
    public String solution(String s) {
        List<Integer> list = new ArrayList<>();
        for(String i : s.split(" ")) {
            list.add(Integer.valueOf(i));
        }
        list.sort(Integer::compareTo);
        return list.get(0) + " " + list.get(list.size()-1);
    }

    public static void main(String[] args) {
        MaxValueAndMinValue T = new MaxValueAndMinValue();
        System.out.println(T.solution("1 2 3 4"));
        System.out.println(T.solution("-1 -2 -3 -4"));
        System.out.println(T.solution("-1 -1"));
    }

}
