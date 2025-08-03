// Last updated: 3/8/2025, 11:56:54 pm
class Solution {
    public int[] dailyTemperatures(int[] arr) {
        return temp(arr);
    }
    public static int[] temp(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(!st.isEmpty() && arr[i]>=arr[st.peek()]){
                while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i]=0;
                }else{
                    ans[i]=st.peek()-i;
                }

            }else{
                if(st.isEmpty()){
                    ans[i] =0;
                }else{
                    ans[i] = st.peek()-i;
                }
            }
            st.push(i);
        }
        return ans;
    }
}