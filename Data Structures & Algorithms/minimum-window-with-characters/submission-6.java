class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;
        int correctCharCount = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }
        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            if(tMap.containsKey(rightChar)){
                sMap.merge(rightChar, 1, Integer::sum);
                if(sMap.get(rightChar).equals(tMap.get(rightChar))) correctCharCount++;
            }       
            while(correctCharCount == tMap.size()){
                if(right + 1 - left < end - start){
                    start = left;
                    end = right + 1;
                }
                char leftChar = s.charAt(left);
                if(sMap.containsKey(leftChar)){
                    sMap.merge(leftChar, -1, Integer::sum);
                    if(sMap.get(leftChar) < tMap.get(leftChar)) correctCharCount--;
                }
                left++;
            }
        }
        if(end == Integer.MAX_VALUE) return "";
        return s.substring(start, end);
    }
}
