class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < k; i++){
            int curr = nums[i];
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
        output[0] = deque.peek();

        for(int i = k; i < nums.length; i++){
            if(deque.peek() == nums[i-k]) deque.pop();
            int curr = nums[i];
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

            
            output[i-k+1] = deque.peek();


        }
        return output;
    }
}
