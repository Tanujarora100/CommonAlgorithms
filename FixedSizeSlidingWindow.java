package SlidingWindow.FixedSize;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateTwo {

    public boolean containsDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (k < n) {
            k = k + 1;
        } else {
            k = n;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                if (mp.size() < k)
                    return true;
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0)
                    mp.remove(nums[i]);
                i++;
                j++;
            }
        }
        return false;
    }
}
