class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        for(char c : s1.toCharArray()){
            freq1[c - 'a']++;
        }
        for(int i = 0; i < s2.length(); i++){
            if(s2.length() < i + s1.length()) return false;
            else if(s1.indexOf(s2.charAt(i)) != -1){
                int[] freq2 = new int[26];
                for(char c : s2.substring(i, i + s1.length()).toCharArray()){
                    freq2[c - 'a']++;
                }
                if(Arrays.equals(freq1, freq2)) return true;
            }
        }
        return false;
    }
}
