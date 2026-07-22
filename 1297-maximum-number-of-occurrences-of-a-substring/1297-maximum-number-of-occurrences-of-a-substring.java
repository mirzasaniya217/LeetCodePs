class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<Character, Integer> count = new HashMap<>();
        HashMap<String, Integer> freq = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            count.put(ch, count.getOrDefault(ch , 0) + 1);
            if (right-left + 1 > minSize) {
                char remove = s.charAt(left);
                count.put(remove, count.get(remove) - 1);
                if (count.get(remove) == 0)
                   count.remove(remove);
                left++;
            }
            if (right-left+1 == minSize && count.size() <= maxLetters) {
                String sub = s.substring(left, right + 1);
                int value = freq.getOrDefault(sub, 0) + 1;
                freq.put(sub, value);
                ans = Math.max(ans, value);
            }
        }
        return ans;
        
    }
}