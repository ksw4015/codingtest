public class Palindrome {

    /*
        "A man, a plan, a canal: Panama",
        "race a car",
        "" or " "
     */
    public static boolean isPalindrome(String s) {
        if(s.isBlank() || s.isEmpty())
            return true;
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for(int i = 0 ; i < s1.length() / 2 ; i++) {
            if(s1.charAt(i) != s1.charAt(s1.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if(!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if(!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("isPalindrome: " + isPalindrome("0P"));
    }

}
