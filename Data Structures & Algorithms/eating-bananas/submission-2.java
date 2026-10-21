class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        int left = 1;
        int curr = 0;

        for(int i : piles){
            right = Math.max(right, i);
        }

        while(left < right){
            curr = left + (right - left) / 2;
            long count = 0;
            for(int i = 0; i < piles.length; i++){
                int pile = piles[i];
                count += (pile + curr - 1) / curr;
            }

            if(count > h){
                left = curr + 1;
            }
            else if(count <= h){
                right = curr;
            }
        }

        return left;
    }
}
