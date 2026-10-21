class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int midLeft = left + (right - left - 1) / 2;
        int midRight = midLeft + 1;

        if(nums.length == 1 || nums[left] < nums[right]) return nums[left];

        while(nums[midLeft] <= nums[midRight]){
            if(nums[midRight] <= nums[right]){
                right = midRight - 1;
            }
            else if(nums[midLeft] >= nums[left]){
                left = midLeft + 1;
            }
            midLeft = left + (right - left) / 2;
            midRight = midLeft + 1;
        }
        return nums[midRight];
    }
}
