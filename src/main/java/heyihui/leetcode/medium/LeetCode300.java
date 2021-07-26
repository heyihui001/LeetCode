package heyihui.leetcode.medium;

public class LeetCode300 {
    /**
     * 300. 最长递增子序列
     */
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = 1;
        int[] d = new int[nums.length];
        d[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > d[len - 1]) {
                d[len] = nums[i];
                len++;
            } else {
                int start = 0;
                int end = len - 1;
                int pos = 0;
                while(start <= end) {
                    int mid = start - (start - end) / 2;
                    if(nums[i] > d[mid]) {
                        pos = mid;
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                d[pos] = nums[i];
            }
        }

        return len;
    }

    public static void main(String[] args) {
        LeetCode300 leetCode300 = new LeetCode300();
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = leetCode300.lengthOfLIS2(nums);
        System.out.println("res: " + res);
    }
}
