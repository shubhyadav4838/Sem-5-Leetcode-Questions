// Last updated: 4/8/2025, 12:01:49 am
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result=new ArrayList<>();
    if(s==null ||s.length()==0 || words==null || words.length==0){
        return result;
    }
    int wordlen=words[0].length();
    int totalLen=wordlen*words.length;
    int n=s.length();
    Map<String,Integer> wordMap=new HashMap<>();
    for(String word:words){
        wordMap.put(word,wordMap.getOrDefault(word,0)+1);
    }
    for(int i=0;i<wordlen;i++){
        int left=i,right=i;
        Map<String,Integer> seen=new HashMap<>();
        while(right+wordlen<=n){
            String word=s.substring(right,right+wordlen);
            right+=wordlen;
            if(wordMap.containsKey(word)){
                seen.put(word,seen.getOrDefault(word,0)+1);
            
            while(seen.get(word)>wordMap.get(word)){
                String leftword=s.substring(left,left+wordlen);
                seen.put(leftword,seen.get(leftword)-1);
                left+=wordlen;
            }
            if(right-left==totalLen){
                result.add(left);
            }
            }
            else{
                seen.clear();
                left=right;
            }
        }
    }
    return result;

   
    }
}