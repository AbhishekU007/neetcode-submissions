class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded_string = new StringBuilder();
        for(String str : strs){
            encoded_string.append(str.length()).append("#").append(str);
        }
        return encoded_string.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, j));
            int stringStart = j+1;
            String word = str.substring(stringStart, stringStart + len);
            result.add(word);
            i = stringStart + len;
        }
        return result;
    }
}
