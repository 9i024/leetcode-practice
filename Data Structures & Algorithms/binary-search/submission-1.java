class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int curr = 0;
        while(nums[curr] != target){
            if(start + 1 == end) return -1;
            curr = (end + start) / 2;
            if(target > nums[curr]) start = curr;
            else if(target < nums[curr]) end = curr;
        }
        return curr;
    }
}
