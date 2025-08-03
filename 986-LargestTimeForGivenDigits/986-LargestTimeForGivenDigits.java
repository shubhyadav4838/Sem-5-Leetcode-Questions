// Last updated: 3/8/2025, 11:56:07 pm
class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String ans = "";
        for(int i = 0; i <4 ; i++){
            for(int j = 0; j<4 ;j++){
                for(int k = 0 ; k<4;k++){
                    if(i==j || i==k || j==k)continue;
                    String hour = ""+arr[i]+arr[j];
                    String minute = ""+arr[k]+arr[6-i-j-k];
                    String time = hour+":"+minute;
                    if(hour.compareTo("24") < 0 && minute.compareTo("60") < 0 && ans.compareTo(time) < 0)ans = time;

                }
                
            }
        }
        return ans;
    }
}