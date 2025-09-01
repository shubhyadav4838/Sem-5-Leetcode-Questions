// Last updated: 2/9/2025, 12:26:58 am
class Solution {
    static class ClassInfo {
        double pass, total, gain;

        ClassInfo(double pass, double total) {
            this.pass = pass;
            this.total = total;
            this.gain = calcGain(pass, total);
        }

        void addStudent() {
            pass++;
            total++;
            gain = calcGain(pass, total);
        }

        static double calcGain(double pass, double total) {
            return (pass + 1) / (total + 1) - pass / total;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.gain, a.gain)
        );

        for (int[] c : classes) {
            pq.offer(new ClassInfo(c[0], c[1]));
        }

        while (extraStudents-- > 0) {
            ClassInfo best = pq.poll();
            best.addStudent();
            pq.offer(best);
        }

        double sum = 0.0;
        while (!pq.isEmpty()) {
            ClassInfo c = pq.poll();
            sum += c.pass / c.total;
        }

        return sum / classes.length;
    }
}