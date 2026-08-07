class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        solve(s, 0, curr, ans);

        return ans;
    }

    public void solve(String s, int index, List<String> curr, List<String> ans) {

        // 4 parts ban gaye
        if (curr.size() == 4) {

            // String bhi khatam ho gayi
            if (index == s.length()) {
                ans.add(String.join(".", curr));
            }

            return;
        }

        // 1,2,3 digit ka part banao
        for (int i = 1; i <= 3; i++) {

            // String ke bahar mat jao
            if (index + i > s.length())
                break;

            String part = s.substring(index, index + i);

            // Leading zero allowed nahi
            if (part.length() > 1 && part.charAt(0) == '0')
                continue;

            // 255 se bada nahi hona chahiye
            if (Integer.parseInt(part) > 255)
                continue;

            // Choose
            curr.add(part);

            // Explore
            solve(s, index + i, curr, ans);

            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }
}