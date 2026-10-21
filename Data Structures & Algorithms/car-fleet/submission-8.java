class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indices = new Integer[position.length];
        for(int i = 0; i < position.length; i++){
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(position[b], position[a]));

        int carFleets = 0;
        double maxTime = 0;

        for(int i = 0; i < position.length; i++){
            double currentTime = (target - position[indices[i]] + 0.0) / speed[indices[i]];
            if(currentTime > maxTime){
                carFleets++;
                maxTime = currentTime;
            }
        }
        return carFleets;
    }
}
