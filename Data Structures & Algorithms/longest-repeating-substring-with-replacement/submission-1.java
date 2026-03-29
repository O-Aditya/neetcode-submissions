public class Solution {
    public int characterReplacement(String s, int k) {
       int l =0;
       int maxf = 0;
       int res = 0;
       HashMap<Character , Integer> count = new HashMap<>();

       for(int r = 0 ; r<s.length(); r++){

        char ch = s.charAt(r);
        count.put(ch , count.getOrDefault(ch,0)+1);
        maxf = Math.max(maxf , count.get(ch));
        while((r-l+1)-maxf > k){
            char lchar = s.charAt(l);
            count.put(lchar ,count.get(lchar)-1);
            l++;
        }

        res = Math.max(res , r-l+1);

       }


       return res;
    }
}