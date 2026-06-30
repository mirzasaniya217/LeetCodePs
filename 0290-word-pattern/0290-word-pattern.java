class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
           return false;
        HashMap<Character, String> m1 = new HashMap<>();
        HashMap<String, Character> m2 = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (m1.containsKey(c) && !m1.get(c).equals(word))
               return false;
            if (m2.containsKey(word) && m2.get(word) != c)
               return false;
            m1.put(c, word);
            m2.put(word, c);
        }
        return true;
    }
}