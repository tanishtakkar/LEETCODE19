
class Solution {
    class Node {
        Node[] children = new Node[26];
        int count = 0;
    }

    public int prefixCount(String[] words, String pref) {
        Node root = new Node();

        for (String word : words) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (curr.children[idx] == null)
                    curr.children[idx] = new Node();

                curr = curr.children[idx];
                curr.count++;
            }
        }

        Node curr = root;

        for (char ch : pref.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null)
                return 0;

            curr = curr.children[idx];
        }

        return curr.count;
    }
}
