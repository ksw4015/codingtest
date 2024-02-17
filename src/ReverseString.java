public class ReverseString {

    public static char[] reverseString(char[] s) {
        if(s == null || s.length == 2 )
            return s;
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char startC = s[start];
            char endC = s[end];
            s[start] = endC;
            s[end] = startC;
            start++;
            end--;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(reverseString(new char[]{'h','e','l','l','o'}));
    }

}
