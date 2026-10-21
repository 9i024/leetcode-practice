class Solution {

    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();
        for(String s : strs){
            output.append((char) s.length());
            output.append(s);
        }
        return output.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int counter = 0;
        while(counter < str.length()){
            int substringLength = (int) str.charAt(counter);
            counter++;
            output.add(str.substring(counter, counter + substringLength));
            counter += substringLength;
        }
        return output;
    }
}
