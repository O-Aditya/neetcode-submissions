public class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int m = s1.length();
       int n = s2.length();
       if(m > n ){
        return false;
       }

       int[] freq1 = new int[26];
       int[] freq2 = new int[26];

       for(int i = 0 ; i<m ; i++){
        freq1[s1.charAt(i)-'a']++;
       }

       int l = 0;

       for(int r = 0; r<n ; r++){

        freq2[s2.charAt(r)-'a']++;

        while(r-l+1 > m){
            freq2[s2.charAt(l)-'a']--;
            l++;
        }

        if(r-l+1 == m){
            if(Arrays.equals(freq1, freq2)){
            return true;
            }
        }

       }

       return false;

    }
}