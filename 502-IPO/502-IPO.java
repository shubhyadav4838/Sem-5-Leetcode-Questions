// Last updated: 21/8/2025, 12:09:58 pm
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
        int[][] arr = new int[profit.length][2];
		for(int i=0;i<arr.length;i++) {
			arr[i][0] = capital[i];
			arr[i][1] = profit[i];
		}
        return ipo(arr,k,w);
        
    }
    public static int ipo(int[][] arr, int k,int w) {
		Arrays.sort(arr,(a,b)-> a[0]-b[0]);
		PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
		
		for(int i=0;i<arr.length;) {
			while(i<arr.length && w>=arr[i][0]) {
				pq.add(arr[i]);
				i++;
			}
			if(pq.isEmpty() || k==0) {
				return w;
			}
			w+=pq.poll()[1];
			k--;
		}
		while(!pq.isEmpty() && k>0) {
			w+=pq.poll()[1];
			k--;
		}
		return w;
	}

}