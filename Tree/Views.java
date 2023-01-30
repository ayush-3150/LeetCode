package Leetcode.Tree;

import java.util.*;

class Pair {
    int line;
    Node node;

    Pair(Node node, int line) {
        this.line = line;
        this.node = node;
    }
}

public class Views {

    //Top View of Binary Tree
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


    //Bottom View
    public ArrayList<Integer> bottomView(Node root) {

        // Code here
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
            } else {
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

    //Right view of binary tree
    public List<Integer> rightSideView(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        rightView(root, 0, al);
        return al;

    }

    public void rightView(Node root, int level, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        if (level == al.size()) {
            al.add(root.data);
        }
        rightView(root.right, level + 1, al);
        rightView(root.left, level + 1, al);

    }

    //Left view of binary tree
    public List<Integer> leftSideView(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        leftView(root, 0, al);
        return al;

    }

    public void leftView(Node root, int level, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        if (level == al.size()) {
            al.add(root.data);
        }
        rightView(root.left, level + 1, al);
        rightView(root.right, level + 1, al);

    }


}




