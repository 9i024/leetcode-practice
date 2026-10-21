class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        prefixProduct[0] = nums[0];
        suffixProduct[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++){
            prefixProduct[i] = prefixProduct[i-1] * nums[i];
            suffixProduct[nums.length-1-i]=suffixProduct[nums.length-i]*nums[nums.length-1-i];
        }

        output[0] = suffixProduct[1];
        output[nums.length - 1] = prefixProduct[nums.length - 2];

        for(int i = 1; i < nums.length -1; i++){
            output[i] = prefixProduct[i-1] * suffixProduct[i+1];
        }
        
        return output;
    }
}  
