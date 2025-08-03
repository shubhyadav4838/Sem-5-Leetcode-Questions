// Last updated: 3/8/2025, 11:55:52 pm
class Solution {
    public int[][] intervalIntersection(int[][] ft, int[][] st) {
        List<int []> ll = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<ft.length && j<st.length){
            int start = Math.max(ft[i][0],st[j][0]);
            int end = Math.min(ft[i][1],st[j][1]);

            if(start<=end)ll.add(new int[]{start,end});

            if(ft[i][1]<st[j][1])i++;
            else j++;
        }
        return ll.toArray(new int[ll.size()][]);

    }
}