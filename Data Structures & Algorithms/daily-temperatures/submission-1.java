class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] output = new int[temperatures.length];
        
        for(int i = temperatures.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                stack.push(i);

            }
            else if(temperatures[i] < temperatures[stack.peek()]){
                output[i] = stack.peek() - i;
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()) output[i] = 0;
                else output[i] = stack.peek() - i;
                stack.push(i);
            }

        }
        return output;
    }
}
