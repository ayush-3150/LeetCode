package Leetcode.Tree;

public class TopView {
    static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> al = new ArrayList<>();
        LinkedList<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair pair = q.remove();
            int l = pair.line;
            Node node = pair.node;

            if (map.get(l) == null) {
                map.put(l, node.data);
            }

            if (node.left != null) {
                q.add(new Pair(node.left, l - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, l + 1));
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            al.add(e.getValue());
        }

        return al;
    }

}


//Function to return a list of nodes visible from the top view
//from left to right in Binary Tree.



