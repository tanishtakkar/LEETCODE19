class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {

            int curr = 0;

            if (i < heights.length)
                curr = heights[i];

            while (!st.isEmpty() && heights[st.peek()] >= curr) {

                int h = heights[st.pop()];

                int nse = i;
                int pse;

                if (st.isEmpty())
                    pse = -1;
                else
                    pse = st.peek();

                int width = nse - pse - 1;

                int area = h * width;

                max = Math.max(max, area);
            }

            st.push(i);
        }

        return max;
    }
}