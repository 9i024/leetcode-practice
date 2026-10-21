class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> dict1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> dict2 = new HashMap<Character, Integer>();

        if(s.length() != t.length()) return false;
        for(char ch : s.toCharArray()){
            dict1.merge(ch, 1, Integer::sum);
        }
        for(char ch : t.toCharArray()){
            dict2.merge(ch, 1, Integer::sum);        
        }
        for(char ch : dict1.keySet()){
            if(!dict2.containsKey(ch)) return false;
            if(!(dict1.get(ch).equals(dict2.get(ch)))) return false;
        }
        return true;
    }
}
