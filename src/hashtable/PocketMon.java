package hashtable;

import java.util.HashSet;

public class PocketMon {

    public int pocketMon(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int monster : nums) {
            set.add(monster);
        }
        if(set.size() >= nums.length / 2)
            return nums.length / 2;
        return set.size();
    }

}
