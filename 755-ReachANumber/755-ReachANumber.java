// Last updated: 3/8/2025, 11:56:51 pm
class Solution 
{
    public int reachNumber(int target) 
    {
        target = Math.abs(target);
        int sum = 0, steps = 0;

        while (sum < target || (sum - target) % 2 != 0) 
        {
            steps++;
            sum += steps;
        }

        return steps;
    }
}