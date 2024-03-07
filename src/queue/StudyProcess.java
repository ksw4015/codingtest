package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StudyProcess {
    private static void solution(String s, String e) {
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            queue.add(c);
        }

        for(char c : e.toCharArray()) {
            if(queue.contains(c) && queue.poll() != c) {
                System.out.print("NO");
                return;
            }
        }
        if(queue.isEmpty()) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String in2 = sc.nextLine();
        solution(in, in2);
    }
}
