class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indices = new Integer[position.length];
        for(int i = 0; i < position.length; i++){
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(position[b], position[a]));

        int carFleets = 1;
        double maxTime = (target - position[indices[0]] + 0.0) / speed[indices[0]];

        for(int i = 0; i < position.length; i++){
            
            if(i < position.length - 1){
                if(position[indices[i+1]] + maxTime * speed[indices[i+1]] < target){
                    carFleets++;
                    maxTime = (target - position[indices[i+1]] + 0.0) / speed[indices[i+1]];
                }
                // else maxTime = (target - position[indices[i]] + 0.0) / speed[indices[i]];
                
            }
        }
        return carFleets;
    }
}
