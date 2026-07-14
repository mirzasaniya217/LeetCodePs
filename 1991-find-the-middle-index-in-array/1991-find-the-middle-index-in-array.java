class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
            if (left == total)
               return i;
            left += nums[i];
        }
        return -1;
    }
}