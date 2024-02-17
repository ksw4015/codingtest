package hashtable;

import java.util.HashMap;

/**
 * Leetcode 771
 */
public class JewelsAndStones {
    /*
       Input: jewels = "aA", stones = "aAAbbbb"
       Output: 3

       Input: jewels = "z", stones = "ZZ"
       Output: 0
     */
    public static int numJewelsInStones(String jewels, String stones) {
        int result = 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(char jewel : jewels.toCharArray()) {
//            map.put(jewel, 0);
//        }
//        for(char stone : stones.toCharArray()) {
//            if(map.containsKey(stone)) {
//                map.put(stone, map.get(stone) + 1);
//            }
//        }
//        for(Character key : map.keySet()) {
//            result += map.get(key);
//        }
        for(char c : stones.toCharArray()) {
           if(jewels.contains(String.valueOf(c))) {
               result++;
           }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("All: " + numJewelsInStones("aA", "aAAbbbb"));
        System.out.println("All: " + numJewelsInStones("z", "ZZ"));
    }
}
