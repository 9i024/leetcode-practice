class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int start = 0;
        int end = s.length();
        int correctCharCount = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        for(int right = 0; right < s.length(); right++){
            if(tMap.containsKey(s.charAt(right))){
                sMap.merge(s.charAt(right), 1, Integer::sum);
                if(sMap.get(s.charAt(right)).equals(tMap.get(s.charAt(right)))) correctCharCount++;
            }
            // System.out.println(sMap.values());
            // System.out.println(tMap.values());
            
            while(correctCharCount == tMap.size()){
                if(right + 1 - left < end - start){
                    start = left;
                    end = right + 1;
                }
                if(sMap.containsKey(s.charAt(left))){
                    sMap.merge(s.charAt(left), -1, Integer::sum);
                    if(sMap.get(s.charAt(left)) < tMap.get(s.charAt(left))) correctCharCount--;
                }
                left++;
            }
            // System.out.println(s.substring(left, right+1));
            // System.out.println(s.substring(start, end));
            // System.out.println("\n");

            if(right == s.length() - 1 && left == 0 && !tMap.equals(sMap)) return "";
        }
        return s.substring(start, end);
    }
}
