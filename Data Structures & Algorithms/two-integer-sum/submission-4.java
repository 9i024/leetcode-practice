class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
            else{
                map.get(nums[i]).add(i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(diff == nums[i]){
                if(map.get(nums[i]).size() > 1){
                    output[0] = map.get(nums[i]).get(0);
                    output[1] = map.get(nums[i]).get(1);
                }
            }
            else if(map.get(nums[i]) != null && map.get(diff) != null){
                if(map.get(nums[i]).get(0) < map.get(diff).get(0)){
                    output[0] = map.get(nums[i]).get(0);
                    output[1] = map.get(diff).get(0);
                }
                else{
                    output[0] = map.get(diff).get(0);
                    output[1] = map.get(nums[i]).get(0);
                }
            }
        }
        return output;
    }
}
