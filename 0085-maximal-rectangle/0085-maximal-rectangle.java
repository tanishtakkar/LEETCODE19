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
        int rows=matrix.length;
        int col= matrix[0].length;
        int [] heights=new int[col];
        int maxarea=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }
                else{
                    heights[j]=0;
                }
            }
            maxarea=Math.max(maxarea,largestRectangleArea(heights));
        }
        return maxarea;
    }
}