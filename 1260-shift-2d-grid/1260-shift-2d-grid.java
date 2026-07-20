class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int p = m * n;

        int[][] ff = new int[m][n];
        int[] arr = new int[p];

        // 2D -> 1D
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        k = k % p;

        // Shift ke liye temp array
        int[] temp = new int[p];
        for (int i = 0; i < p; i++) {
            temp[(i + k) % p] = arr[i];
        }

        // 1D -> 2D
        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ff[i][j] = temp[idx++];
            }
        }

        // int[][] -> List<List<Integer>>
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(ff[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
}