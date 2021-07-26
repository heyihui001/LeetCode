package heyihui.leetcode.daily.year2021.july.day26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * 1713. 得到子序列的最少操作次数
     */
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            Integer index = map.get(arr[i]);
            if(index != null) {
                list.add(index);
            }
        }

        if(list.size() == 0) {
            return target.length;
        }

        int[] idx = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            idx[i] = list.get(i);
        }

        int len = lengthOfLIS(idx);
        return target.length - len;
    }

    private int lengthOfLIS(int[] idx) {
        int len = 1;
        int[] d = new int[idx.length];
        d[0] = idx[0];

        for(int i = 1; i < idx.length; i++) {
            if(idx[i] > d[len - 1]) {
                d[len] = idx[i];
                len++;
            } else {
                int start = 0;
                int end = len - 1;
                int pos = -1;
                while(start <= end) {
                    int mid = start - (start - end) / 2;
                    if(idx[i] > d[mid]) {
                        pos = mid;
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                d[pos + 1] = idx[i];
            }
        }

        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] target = {6,4,8,1,3,2};
        int[] arr = {4,7,6,2,3,8,6,1};
        int res = solution.minOperations(target, arr);
        System.out.println("res: " + res);
    }
}
