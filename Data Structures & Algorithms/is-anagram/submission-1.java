class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] s1 = new int[26];
        int[] t1 = new int[26];

        for(int i = 0; i<n ; i++){
            char ch = s.charAt(i);
            s1[ch-'a']++;
        }

           for(int i = 0; i<m ; i++){
            char ch = t.charAt(i);
            t1[ch-'a']++;
        }

        return Arrays.equals(s1, t1);

    }
}
