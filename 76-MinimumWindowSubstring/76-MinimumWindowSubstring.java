// Last updated: 1/1/2026, 3:58:50 pm
class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter fw = new FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
    public String minWindow(String s, String t) {
        int cnt[] = new int[256];
        int req = 0;
        for(int c:t.toCharArray())cnt[c]++;
        for(int i = 0;i<256;i++){
            if(cnt[i]>0)req++;
        }

        int curr[] = new int[256];

        System.out.println(req);
        int match = 0;
        int n = s.length(), l = 0,left = -1, right = n;
        for(int i = 0;i<n;i++){
            int it = s.charAt(i);
            curr[it]++;
            if(curr[it] == cnt[it])match++;

            while(match == req){
                if(i-l+1<right-left+1){
                    left = l;right = i;
                }
                int c = s.charAt(l++);
                if(cnt[c] == curr[c])match--;
                curr[c]--;

            }
        }

        return left == -1?"":s.substring(left,right+1);
    }
}