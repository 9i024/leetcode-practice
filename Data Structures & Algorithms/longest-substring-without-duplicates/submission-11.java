class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int start = -1;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i])){
                longest = Math.max(longest, i - start - 1);
                start = Math.max(start, map.get(chars[i]));
            }
            map.put(chars[i], i);
        }
        longest = Math.max(longest, chars.length - start - 1);
        return longest;
    }
}
