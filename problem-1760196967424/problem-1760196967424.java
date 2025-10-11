// Last updated: 11/10/2025, 9:06:07 pm
class ExamTracker {
		private List<Long> before;
	    private List<Integer> timels;

	    public ExamTracker() {
	        this.timels = new ArrayList<>();
	        this.before = new ArrayList<>();
	    }
	    
	    public long totalScore(int startTime, int endTime) {
	    		if(timels.isEmpty()) return 0;	    		
	    		int e = end(timels, endTime);
	    		int s = start(timels,startTime);
	    		
	    		return s > e ? 0 : before.get(e) - (s > 0 ? before.get(s - 1) : 0);
	    }
	    
	    public void record(int time, int score) {
	    	timels.add(time);
	        long res = before.isEmpty() ? 0 : before.get(before.size() - 1);
	        before.add(res + score);
	    }

	    private int start(List<Integer> ti, int num) {
	        int lo = 0;
	        int hi = ti.size() - 1;
	        int res = ti.size();
	        
	        while (lo <= hi) {
	            int m = lo + ((hi - lo) / 2);
	            if (ti.get(m) >= num) {
	                res = m;
	                hi = m - 1;
	            } else lo = m + 1;
	        }
	        return res;
	    }

	    private int end(List<Integer> ti, int num) {
	        int lo = 0;
	        int hi = ti.size() - 1;
	        int res = ti.size();
	        while (lo <= hi) {
	            int m = lo + ((hi - lo) / 2);
	            if (ti.get(m) > num) {
	                res = m;
	                hi = m - 1;
	            } else lo = m + 1;
	        }
	        return res - 1;
	    }
	}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */