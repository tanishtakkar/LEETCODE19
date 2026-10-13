
class Solution {

    class Node {
        Node[] children = new Node[26];
        int prefixCount = 0;
    }

    Node root = new Node();

    public int prefixCount(String[] words, String pref) {

        for (String word : words) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];

                curr.prefixCount++;
            }
        }

        Node curr = root;

        for (char ch : pref.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                return 0;
            }

            curr = curr.children[idx];
        }

        return curr.prefixCount;
    }
}
