class TimeMap {
    private record Node(int timestamp, String value) {}
    private Map<String, List<Node>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(store.isEmpty() || store.get(key) == null) return "";
        int left = 0;
        int right = store.get(key).size() - 1;

        while(left < right){
            int mid = left + (right - left + 1) / 2;
            int midTimestamp = store.get(key).get(mid).timestamp;
            if(timestamp > midTimestamp){
                left = mid;
            }
            else if(timestamp < midTimestamp){
                right = mid - 1;
            }
            else{
                return store.get(key).get(mid).value;
            }
        }
        if(store.get(key).get(left).timestamp > timestamp){
            return "";
        }
        else return store.get(key).get(left).value;
    }
}
