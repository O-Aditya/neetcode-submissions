

class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // Step 1: Build need map
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int formed = 0;
        int required = need.size();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Step 2: Expand window
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If this char satisfies required frequency
            if (need.containsKey(c) &&
                window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Step 3: Try shrinking
            while (formed == required) {

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // If removing breaks validity
                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}