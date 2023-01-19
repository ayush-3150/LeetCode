package Leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Travaersals {


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);


        System.out.print("preorder ");
        preOrder(root);
        System.out.println();
        System.out.print("postorder ");
        postOrder(root);
        System.out.println();
        System.out.print("inorder ");
        inOrder(root);
        List<List<Integer>> list = levelOrder(root);
        System.out.println();
        System.out.println("Level Order" + list);
        System.out.println();
        List<Integer> ll = preOrderIterative(root);
        System.out.println("preorder" + ll);
        List<Integer> inOrder = inOrderIterative(root);
        System.out.println("inorder" + inOrder);

        List<Integer> postOrder = postOrderIterative(root);
        System.out.println("postOrder" + postOrder);
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " -> ");
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " -> ");
    }

    public static List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> ll = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        ll.offer(root);

        while (ll.size() > 0) {
            int level = ll.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (ll.peek().left != null) ll.offer(ll.peek().left);
                if (ll.peek().right != null) ll.offer(ll.peek().right);
                l.add(ll.poll().data);
            }
            list.add(l);
        }
        return list;
    }


    public static List<Integer> preOrderIterative(Node node) {
        Stack<Node> s = new Stack<>();
        List<Integer> nodeValues = new ArrayList<>();
        if (node == null) {
            return nodeValues;
        }
        s.push(node);
        while (!s.isEmpty()) {
            int size = s.size();
            node = s.pop();
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
            nodeValues.add(node.data);
        }
        return nodeValues;
    }

    public static List<Integer> inOrderIterative(Node root) {
        Stack<Node> s = new Stack<>();
        List<Integer> inOrder = new ArrayList<>();
        Node node = root;
        while (true) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                if (s.isEmpty()) {
                    break;
                }
                node = s.pop();
                inOrder.add(node.data);
                node = node.right;
            }

        }
        return inOrder;
    }

    public static List<Integer> postOrderIterative(Node root) {

        List<Integer> postOrder = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        if (root == null) {
            return postOrder;
        }

        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }

        while (!s2.isEmpty()) {
            postOrder.add(s2.pop().data);
        }


        return postOrder;
    }
}


