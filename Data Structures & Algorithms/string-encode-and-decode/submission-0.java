class Solution {

    public String encode(List<String> strs) {
        String output = "";
        for(String s : strs){
            output += (char) s.length() + s;
        }
        return output;
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
