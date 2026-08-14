class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length()<t.length()) return "";

        HashMap<Character, Integer> freqT = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        int required = freqT.size();
        int formed = 0, left = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> windowCounts = new HashMap<>();

        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (freqT.containsKey(c) && windowCounts.get(c).equals(freqT.get(c))) {
                formed++;
            }

            while(formed == required){
                int currentLen = right - left + 1;
                if(currentLen < minLen){
                    start = left;
                    minLen = currentLen;
                }
                char removedChar = s.charAt(left);
                windowCounts.put(removedChar, windowCounts.get(removedChar) - 1);
                if(freqT.containsKey(removedChar) && windowCounts.get(removedChar) < freqT.get(removedChar)){
                    formed--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
