import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int num : arr) {

            if (st.isEmpty() || num >= st.peek()) {
                st.push(num);
            } 
            else {
            
                int max = st.pop();

                while (!st.isEmpty() && st.peek() > num) {
                    st.pop();
                }

                st.push(max);
            }
        }

        return st.size();
    }
}