class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> list = new HashMap();
        int[] output = new int[2];
        for(int i = 0; i < nums.length; i++){
            int value = 0;
            if(nums[i]*2 <= target) value = target - nums[i]*2;
            else if(nums[i]*2 > target) value = nums[i]*2 - target;

            if(!list.containsKey(value)) list.put(value, i);
            else{
                output[0] = i;
                output[1] = list.get(value);
                Arrays.sort(output);
                
            }
        }
        return output;
    }
}
