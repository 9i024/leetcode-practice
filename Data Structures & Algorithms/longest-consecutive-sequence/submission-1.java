class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        int totalCount = 0;
        for(int n : nums){
            numsSet.add(n);
        }

        for(int n : numsSet){
            if(numsSet.contains(n-1)) continue;
            int count = 1;
            int curr = n;
            
            while(numsSet.contains(curr+1)){
                count++;
                curr++;
            }

            if(count > totalCount) totalCount = count;
        }
        return totalCount;
    }
}
