// Last updated: 3/8/2025, 11:53:08 pm
class Solution {
    public String findCommonResponse(List<List<String>> rs) {
         Map<String,Integer> m = new HashMap<>();

        for(List<String> d:rs){
            Set<String> u = new HashSet<>(d);
            for(String r:u){
                m.put(r,m.getOrDefault(r,0)+1);
            }
        }
        String a = "";
        int mf = 0;

        for(Map.Entry<String,Integer> e: m.entrySet()){
            String r = e.getKey();
            int f = e.getValue();
            if(f>mf || (f==mf && r.compareTo(a)<0)){
                mf = f;
                a = r;
            }
        }
        return a;
    }
}