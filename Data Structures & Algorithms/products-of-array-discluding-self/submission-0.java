class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        long totalProduct = 1;
        int zeroCounter = 0;
        for(int num : nums){
            if(num == 0){
                zeroCounter++;
                continue;
            }
            totalProduct *= num;
        }
        for(int i=0; i<nums.length; i++){
            if(zeroCounter == 0){
                output[i] = (int) (totalProduct / nums[i]);
            }
            else if(zeroCounter == 1){
                if(nums[i] == 0) output[i] = (int) totalProduct;
                else output[i] = 0;
            }
            else output[i] = 0;
        }
        return output;
    }
}  
