class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {

            int curr = 0;

            if (i < heights.length)
                curr = heights[i];

            while (!st.isEmpty() && heights[st.peek()] > curr) {

                int h = heights[st.pop()];

                int width;

                if (st.isEmpty())
                    width = i;
                else
                    width = i - st.peek() - 1;

                max = Math.max(max, h * width);
            }

            st.push(i);
        }

        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int ans=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int height[]=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                }
                else{
                    height[j]=0;
                }
            }
            ans=Math.max(ans,largestRectangleArea(height));
        }
        return ans;
    }
}