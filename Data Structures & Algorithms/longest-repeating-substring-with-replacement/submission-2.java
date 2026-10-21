class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        // int longest = k;
        int maxFreq = 0;
        int[] count = new int[26];
        while(right < s.length()){
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            if(right - left < maxFreq + k){
                right++;
            }
            else{
                count[s.charAt(left) - 'A']--;
                right++;
                left++;
            }
        }
        return Math.min(maxFreq + k, s.length());
    }
}
