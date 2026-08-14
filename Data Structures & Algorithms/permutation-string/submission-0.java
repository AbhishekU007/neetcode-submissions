class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] s1_count = new int[26];
        int[] s2_count = new int[26];

        for (char ch : s1.toCharArray()) {
            s1_count[ch - 'a']++;
        }

        for (int i = 0; i < n2; i++) {
            s2_count[s2.charAt(i) - 'a']++;

            if (i >= n1) {
                s2_count[s2.charAt(i - n1) - 'a']--;
            }

            if (Arrays.equals(s1_count, s2_count)) {
                return true;
            }
        }

        return false;
    }
}