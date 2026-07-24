class Solution {
    public boolean isPalindrome(String s) {
        String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(cleanString);
        String newS = sb.reverse().toString().toLowerCase();
        if(newS.equals(cleanString)) return true;
        else return false;
    }
}
