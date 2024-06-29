package twopointer;


public class AppendCharacters {
    /*
        TestCase 1 s = "coaching", t = "coding"
        TestCase 2 s = "abcde" t = "a"
        TestCase 3 s = "z" t + "abcde"
    */
    public int appendCharacters(String s, String t) {
        int lp = 0;
        int rp = 0;
        while (lp < s.length()) {
            if(s.charAt(lp) == t.charAt(rp)) {
                rp++;
            }
            if(rp >= t.length())
                break;
            lp++;
        }
        return t.length() - rp;
    }

    public static void main(String[] args) {
        AppendCharacters T = new AppendCharacters();
        System.out.println(T.appendCharacters("coaching", "coding"));
        System.out.println(T.appendCharacters("abcde", "a"));
        System.out.println(T.appendCharacters("z", "abcde"));
    }
}
