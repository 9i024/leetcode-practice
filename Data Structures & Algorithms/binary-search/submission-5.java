class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int curr = start + (end - start) / 2;
            if(target > nums[curr]) start = curr + 1;
            else if(target < nums[curr]) end = curr - 1;
            else return curr;
        }
        return -1;
    }
}
