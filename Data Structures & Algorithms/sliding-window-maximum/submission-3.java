class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(i >=k) output[i-k] = deque.peek();
            if(i >= k && deque.peek() == nums[i-k]) deque.pop();
            if(deque.size() == 0) deque.push(curr);
            else if(deque.peek() < curr){
                deque.pop();
                deque.push(curr);
            }
            else{
                while(deque.peekLast() < curr){
                    deque.removeLast();
                }
                deque.addLast(curr);
            }
            
            
        }
        output[output.length-1] = deque.peek();
        return output;
    }
}
