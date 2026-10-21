class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.merge(n, 1, Integer::sum);
        }

        List<Integer>[] bucketList = new List[nums.length + 1];

        for(int key : map.keySet()){
            if(bucketList[map.get(key)] == null){
                bucketList[map.get(key)] = new ArrayList<>();
            }
            bucketList[map.get(key)].add(key);
        }
        
        ArrayList<Integer> outputList = new ArrayList<>();
        int count = 0;

        for(int i = nums.length; i>=0 && count<k; i--){
            if(bucketList[i] != null){
                for(int num : bucketList[i]){
                    outputList.add(num);
                    count++;
                    if(count == k) break;
                }
            }
        }
        
        int[] output = new int[outputList.size()];
        for(int i = 0; i<outputList.size(); i++){
            output[i] = outputList.get(i);
        }
        return output;
    }
}
