import java.util.*;

public class ReOrderLog {

    /*
        ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"],
        ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
     */
    public static String[] reorderLogFiles(String[] logs) {
        // 처음부터 쪼개지 말고 문자, 숫자 로그 나누기
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for(String log : logs) {
            if(Character.isLetter(log.split(" ")[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        // Comparator 직접구현
        // 문자 로그는 사전순 정렬하되, 같은 로그가 같으면 식별자를 순서대로 정렬
        // 오름차순 (같으면 0, o2가 작은 경우 1(순서 바꿈), o2가 큰 경우 -1(뒤에 머무름))
        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1x = o1.split(" ", 2);
                String[] s2x = o2.split(" ", 2);

                // 우선 로그값 비교
                int compared = s1x[1].compareTo(s2x[1]);
                if(compared == 0) {
                    return s1x[0].compareTo(s2x[0]);
                }
                return compared;
            }
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] logs = {"1 n u", "r 527", "j 893", "6 14", "6 82"};
        String[] reorderLogs = reorderLogFiles(logs);
        for(String log : reorderLogs) {
            System.out.println(log);
        }
    }
}
