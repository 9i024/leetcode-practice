class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){
            // remove the out of window indices
            if(i >= k && deque.peek() <= i - k) deque.pop();

            // remove and add from back
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);

            if(i >= k - 1) output[i-k+1] = nums[deque.peek()];
        }
        return output;
    }
}
