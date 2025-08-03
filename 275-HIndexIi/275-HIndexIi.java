// Last updated: 3/8/2025, 11:59:05 pm
class Solution {
    public int hIndex(int[] citations) {
        return HIndex(citations);
        
    }
    	public static int HIndex(int[]arr) {
		int l = 0;
		int h = arr.length-1;
		int ans = 0;
        if(arr.length==1){
            if(arr[0] == 0){
                 ans = 0;
                return ans;
            }else{
                ans = 1;
                return ans;
            }
           
        }
        if(arr.length==2 && arr[1]==1) {
				ans = 1;
				return ans;
			}else if(arr.length==2 && arr[0]>=2){
                ans = 2;
                return ans;
            }
		while(l<=h) {
			int mid = (h+l)/2;
			
			if(arr.length-(mid+1)>=arr[mid]-1) {
				int r = arr.length-(mid+1);
				 ans = Math.max(r,arr[mid]);
				 l= mid+1;
//				 System.out.println("IN if");
			 }else if(arr[mid]>mid && arr.length-(mid+1)<=arr[mid]-1) {
				 int r = arr.length-mid;
	               ans = Math.max(ans,r);
	               h = mid-1;
			 }
			else if(arr[mid]>mid){
               int n = arr.length-mid;
               ans = Math.max(ans,n);
               l = mid+1;
//               System.out.println("In Elif");
            }
//              
            else {

//				 l = mid+1;
            	h = mid-1;
//            	System.out.println("IN Else");
			 }
			
			
		}
		return ans;
	}

}