class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for(int n : nums){
            if(!dict.containsKey(n)) dict.put(n, 1);
            else return true;
        }
        return false;
    }
}