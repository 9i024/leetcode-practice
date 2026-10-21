class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int total = 0;

        while(left < right){
            if(maxLeft < maxRight){
                total += maxLeft - height[left];
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
            }
            else{
                total += maxRight - height[right];
                right--;
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        return total;
    }
}
