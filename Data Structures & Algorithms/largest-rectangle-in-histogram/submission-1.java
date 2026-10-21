class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int largest = 0;
        int[] heightsPlus = new int[heights.length + 1];
        for(int i = 0; i < heights.length; i++){
            heightsPlus[i] = heights[i];
        }
        for(int i = 0; i < heightsPlus.length; i++){
            int[] prev = {heightsPlus[i], i};
            while(!stack.isEmpty() && heightsPlus[i] < stack.peek()[0]){
                prev = stack.pop();
                if(prev[0] * (i - prev[1]) > largest){
                    largest = prev[0] * (i - prev[1]);
                }
            }
            stack.push(new int[]{heightsPlus[i], prev[1]});
        }
        return largest;
    }
}
