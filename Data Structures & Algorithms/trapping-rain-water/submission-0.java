class Solution {
    public int trap(int[] height) {
        int[] maxRight = new int[height.length];
        int total = 0;
        int maxR = 0;
        int maxL = 0;
        for(int i = height.length - 1; i >= 0; i--){
            maxR = Math.max(height[i], maxR);
            maxRight[i] = maxR;
        }
        for(int i = 0; i < height.length; i++){
            maxL = Math.max(height[i], maxL);
            total += Math.min(maxL, maxRight[i]) - height[i];
        }
        return total;
    }
}
