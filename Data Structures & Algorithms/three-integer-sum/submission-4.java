class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length -1;
            // f(i != 0 && nums[i] == nums[i-1]) continue;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(-nums[i] == sum && !output.contains(List.of(nums[i], nums[left], nums[right]))){
                    output.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if(-nums[i] > sum) left++;
                else right--;
            }
        }
        return output;
    }
}
