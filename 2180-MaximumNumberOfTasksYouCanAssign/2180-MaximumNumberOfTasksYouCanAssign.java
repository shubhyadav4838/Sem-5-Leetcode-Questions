// Last updated: 3/8/2025, 11:54:10 pm
class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        return assignTask(tasks,workers,pills,strength);
    }
    public static int assignTask(int[] task, int[] workers, int pills, int strength) {
		Arrays.sort(task);
		Arrays.sort(workers);
		int ans = 0;
		int lo = 0;
		int hi = Math.min(task.length, workers.length);
		while(lo<=hi) {
			int mid = (hi+lo)/2;
			if(isitpossible(task,workers,pills,strength,mid)) {
				lo=mid+1;
			    ans = Math.max(ans, mid);
			}
			else {
				hi = mid-1;
			}
		}
		return ans;
	}
	private static boolean isitpossible(int[] task, int[] worker, int pills, int strength, int mid) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ls = new ArrayList<>();
		int w = worker.length-1;
		int idx = 0;
		for(int i=mid-1;i>=0;i--) {
			if(!ls.isEmpty() && ls.get(0)>=task[i]) {
				ls.remove(0);
			}else if(w>=0 && worker[w]>=task[i]) {
				w--;
			}else {
				while(w>=0 && worker[w]+strength>=task[i]) {
					ls.add(worker[w]);
					w--;
				}
				if(ls.isEmpty() || pills==0)return false;
				
				ls.remove(ls.size()-1);
				pills--;
				
				
			}
		}
		return true;
	}
}