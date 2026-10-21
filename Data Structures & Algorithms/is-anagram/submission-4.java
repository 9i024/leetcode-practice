class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> dict1 = new HashMap<>();
        HashMap<Character, Integer> dict2 = new HashMap<>();

        if(s.length() != t.length()) return false;
        for(char ch : s.toCharArray()) dict1.put(ch, dict1.getOrDefault(ch, 0) + 1);
        for(char ch : t.toCharArray()) dict2.put(ch, dict2.getOrDefault(ch, 0) + 1);

        return dict1.equals(dict2);
    }
}
