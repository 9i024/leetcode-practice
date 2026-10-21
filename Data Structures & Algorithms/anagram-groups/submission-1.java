class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<Integer>, ArrayList<String>> map = new HashMap<>();

        for(String str : strs){
            int[] strMap = new int[26];
            for(int i = 0; i < str.length(); i++){
                strMap[str.charAt(i) - 'a']++;
                
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int x : strMap) {
                list.add(x);
            }
            map.computeIfAbsent(list, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> output = new ArrayList<>();
        for(ArrayList<Integer> key : map.keySet()){
            output.add(map.get(key));
        }
        return output;
    }
}
