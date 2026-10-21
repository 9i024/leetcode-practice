class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target > nums[mid]){
                if(target > nums[right] && nums[mid] < nums[left]) right = mid - 1;
                else left = mid + 1;
            }
            else if(target < nums[mid]){
                if(target < nums[left] && nums[mid] > nums[right]) left = mid + 1;
                else right = mid - 1;
            }
            else return mid;
        }
        return -1;
    }
}
