package heyihui.leetcode.daily.year2021.july.day23;

public class Solution {

    /**
     * 1893. 检查是否区域内所有整数都被覆盖
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] nums = new int[51];
        for(int i = left; i <= right; i++) {
            nums[i] = 1;
        }

        for(int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            for(int j = range[0]; j <= range[1]; j++) {
                nums[j] = 0;
            }
        }

        for(int i = 1; i <= 50; i++) {
            if(nums[i] == 1) {
                return false;
            }
        }

        return true;
    }

}
