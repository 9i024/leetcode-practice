class Solution {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toLowerCase().toCharArray();
        List<Character> cleaned = new ArrayList<>();
        for(char c : charArray){
            if(Character.isLetterOrDigit(c)) cleaned.add(c);
        }
        for(int i = 0; i < cleaned.size() / 2; i++){
            if(cleaned.get(i) != cleaned.get(cleaned.size() - 1 - i)) return false;
        }
        return true;
    }
}
