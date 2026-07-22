class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long ans = 0;
        int left = 0;
        for (int right = 0; right < nums.size(); right++) {
            int num = nums.get(right);
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (right-left+1 > k) {
                int remove = nums.get(left);
                sum -= remove;
                map.put(remove, map.get(remove)-1);
                if (map.get(remove)==0)
                   map.remove(remove);
                left++;
            }
            if (right-left+1 == k && map.size() >= m){
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}