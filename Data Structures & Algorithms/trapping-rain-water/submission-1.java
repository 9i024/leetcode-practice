class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int total = 0;

        while(left < right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if(maxLeft < maxRight){
                total += maxLeft - height[left];
                left++;
            }
            else{
                total += maxRight - height[right];
                right--;
            }
        }
        return total;
    }
}
