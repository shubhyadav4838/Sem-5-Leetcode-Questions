// Last updated: 3/8/2025, 11:57:05 pm
class Solution {
    public int calPoints(String[] operations) {
        int index=0;
        int [] arr=new int[operations.length];
        for(String i:operations){
            if(i.equals("+")){
                arr[index]=arr[index-1]+arr[index-2];
                index++;
            }
            else if(i.equals("C")){
                --index;
            }
            else if(i.equals("D")){
                arr[index]=2 * arr[index-1];
                index++;
            }
            else{
                arr[index]=Integer.parseInt(i);
                index++;
            }
        }
        int ans=0;
        while(--index!=-1){
            ans+=arr[index];
        }
        return ans;
        
        
    }
}
/*Stack <Integer> stack=new Stack<>();
        for(String i:operations){
            if(i.equals("+")){
                int a=stack.pop();
                int b=stack.pop();
                int c=a+b;
                stack.push(b);
                stack.push(a);
                stack.push(c);
            }
            else if(i.equals("C")){
                stack.pop();
            }
            else if(i.equals("D")){
                stack.push(2*stack.peek());
            }
            else{
                stack.push(Integer.parseInt(i));
            }
        }
        int ans=0;
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
        */

                                                         