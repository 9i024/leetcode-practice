class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length <= nums2.length ? nums1 : nums2;
        int[] bigger = nums1.length > nums2.length ? nums1 : nums2;

        // left and right mean "how many elements go on the left/right"
        int left = 0;
        int right = smaller.length;

        while(left <= right){
            int sLeftCount = left + (right - left) / 2;
            int bLeftCount = (smaller.length + bigger.length) / 2 - sLeftCount;
            int sLeftMax = sLeftCount > 0 ? smaller[sLeftCount - 1] : Integer.MIN_VALUE;
            int sRightMin = sLeftCount < smaller.length ? smaller[sLeftCount] : Integer.MAX_VALUE;
            int bRightMin = bLeftCount < bigger.length ? bigger[bLeftCount] : Integer.MAX_VALUE;
            int bLeftMax = bLeftCount > 0 ? bigger[bLeftCount - 1] : Integer.MIN_VALUE;

            System.out.printf("cut: %d, sleftmax: %d, srightmin: %d, brightmin: %d, bleft max: %d", sLeftCount, sLeftMax, sRightMin, bRightMin, bLeftMax);

            if(sLeftMax > bRightMin){
                right = sLeftCount - 1;
            }
            else if(bLeftMax > sRightMin){
                left = sLeftCount + 1;
            }
            else{
                if((bigger.length + smaller.length) % 2 == 0){
                    return (Math.max(sLeftMax, bLeftMax) + Math.min(sRightMin, bRightMin) + 0.0) / 2;
                }
                else{
                    return Math.min(sRightMin, bRightMin);
                }
            }
            
        }
        return -1.0;
    }
}
