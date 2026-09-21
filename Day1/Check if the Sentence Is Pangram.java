class Solution {
    public boolean checkIfPangram(String sentence) {
        for(char Ch='a';Ch<='z';Ch++){
            if(sentence.indexOf(Ch)==-1){
                return false;
            }
        }
        return true;
    }
}
