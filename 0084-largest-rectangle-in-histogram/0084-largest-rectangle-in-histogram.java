class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {

            int curr = (i == heights.length) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] >= curr) {

                int h = heights[st.pop()];

                int width;

                if (st.isEmpty())
                    width = i;
                else
                    width = i - st.peek() - 1;

                int area = h * width;

                max = Math.max(max, area);
            }

            st.push(i);
        }

        return max;
    }
}