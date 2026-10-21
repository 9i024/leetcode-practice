class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> list = new HashMap();
        for(int i : nums){
            if(list.get(i) == null) list.put(i, 1);
            else if(list.get(i) == 1) return true;
        }
        return false;
    }
}
