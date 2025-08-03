// Last updated: 3/8/2025, 11:57:03 pm
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int times = (int) Math.ceil((double) b.length() / a.length());
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < times; i++) {
            temp.append(a);
        }

        if (temp.toString().contains(b)) {
            return times;
        }

        temp.append(a);
        if (temp.toString().contains(b)) {
            return times + 1;
        }

        return -1;
    }
}
