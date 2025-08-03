// Last updated: 4/8/2025, 12:01:30 am
class Solution {
    public String multiply(String num1, String num2) {
        return twoMul(num1,num2);
    }
   public static String twoMul(String a, String b) {
    int n = a.length(), m = b.length();
    int[] result = new int[n + m];

    for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
            int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
            int p1 = i + j, p2 = i + j + 1;

            int sum = mul + result[p2];
            result[p2] = sum % 10;
            result[p1] += sum / 10;
        }
    }

    StringBuilder sb = new StringBuilder();
    for (int num : result) {
        if (!(sb.length() == 0 && num == 0)) {
            sb.append(num);
        }
    }

    return sb.length() == 0 ? "0" : sb.toString();
}

}