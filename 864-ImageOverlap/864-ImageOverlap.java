// Last updated: 3/8/2025, 11:56:31 pm
class Solution {
  public int largestOverlap(int[][] img1, int[][] img2) {
    final int SHIFT_FACTOR = 100;  // Used to create a unique key for (rowShift, colShift)
    final int n = img1.length;
    int maxOverlap = 0;
    
    List<int[]> img1Ones = new ArrayList<>();
    List<int[]> img2Ones = new ArrayList<>();
    Map<Integer, Integer> shiftCountMap = new HashMap<>();

    // Collect coordinates of 1s in both images
    for (int row = 0; row < n; ++row) {
      for (int col = 0; col < n; ++col) {
        if (img1[row][col] == 1)
          img1Ones.add(new int[] {row, col});
        if (img2[row][col] == 1)
          img2Ones.add(new int[] {row, col});
      }
    }

    // Try aligning each 1 in img1 with each 1 in img2 and count offsets
    for (int[] coord1 : img1Ones) {
      for (int[] coord2 : img2Ones) {
        int rowShift = coord1[0] - coord2[0];
        int colShift = coord1[1] - coord2[1];
        int shiftKey = rowShift * SHIFT_FACTOR + colShift;

        shiftCountMap.merge(shiftKey, 1, Integer::sum);
      }
    }

    // Find the shift that gives the maximum overlap
    for (int count : shiftCountMap.values()) {
      maxOverlap = Math.max(maxOverlap, count);
    }

    return maxOverlap;
  }
}
