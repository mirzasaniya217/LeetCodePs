class Solution {
    public boolean closeStrings(String w1, String w2) {
        if (w1.length() != w2.length())
           return false;
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for (char ch : w1.toCharArray())
             f1[ch - 'a']++;
        for (char ch : w2.toCharArray())
             f2[ch - 'a']++;
        for (int i =0; i < 26; i++){
            if ((f1[i] == 0) != (f2[i] == 0))
                return false;
        } 
        Arrays.sort(f1);
        Arrays.sort(f2);
        return Arrays.equals(f1, f2);       
    }
}