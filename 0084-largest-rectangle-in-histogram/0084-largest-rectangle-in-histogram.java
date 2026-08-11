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
}