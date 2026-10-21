class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList();
        HashMap<List<Integer>, List<String>> map = new HashMap();

        if(strs.length == 1){
            List<String> stringList = new ArrayList();
            stringList.add(strs[0]);
            output.add(stringList);
            return output;
        }

        for(String s : strs){
            List<Integer> dict = new ArrayList<>(Collections.nCopies(26, 0));
            for(char c : s.toCharArray()){
                dict.set(c - 'a', dict.get(c - 'a') + 1);
            }
            if(!map.containsKey(dict)){
                List<String> newStringList = new ArrayList();
                newStringList.add(s);
                map.put(dict, newStringList);
            }
            else map.get(dict).add(s);
        }

        for(List<Integer> key : map.keySet()){
            output.add(map.get(key));
        }

        return output;
    }
}
