import java.security.PublicKey;
import java.util.*;

import javax.management.relation.Role;

public class practice_dsa {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        }
        if (root.data > value) {
            root.left = insert(root.left, value);
        } else if (root.data < value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // left->root->right.
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // root->left->right.
    public static void PreOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        System.out.print(root.data + " ");
        postOrder(root.right);
    }

    // left->right->root
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        System.out.print(root.data + " ");
        postOrder(root.right);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNode = countNodes(root.left);
        int rightNode = countNodes(root.right);
        return leftNode + rightNode + 1;
    }
    public static int sumNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftNode = sumNodes(root.left);
        int rightNode = sumNodes(root.right);
        return leftNode + rightNode + root.data;
    }
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }   
    // O(N^2)
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) +1;
        return Math.max(diam2, Math.max(diam1,diam3));
    }
    static  class TreeInfo{
         int ht;
         int diam;
         TreeInfo(int ht , int diam){
            this.diam = diam;
            this.ht = ht;
         }
    }
    // O(N)
    public static TreeInfo diaameter2(Node root){
        if(root == null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = diaameter2(root.left);
        TreeInfo right = diaameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht);

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + left.diam +1;
        int mydiam = Math.max(diam2, Math.max(diam1, diam3));
        TreeInfo myinfo = new TreeInfo(myHeight, mydiam);
        return myinfo;
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

    }

    public static Node deleteNode(Node root, int key) {
        if (root.data > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }

    // ->Inorder successor is the left most node in thr right subtree.
    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root , int  X , int Y){
        if(root == null){
            return;
        }
        if(root.data >= X && root.data <= Y){
            printInRange(root, X, Y);
            System.out.print(root.data + " ");
            printInRange(root, X, Y);
        }
        else if(root.data >= Y){
            printInRange(root, X, Y);
        }
        else{
            printInRange(root, X, Y);
        }
    }
    public static void printPaths(ArrayList<Integer> path){
        for(int i =0;i<path.size()-1;i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();

    }
    public static void printRoot2leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left ==null && root.right == null){
            printPaths(path);
        }
        else{
            printRoot2leaf(root.left, path);
            printRoot2leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }
    public static boolean isIdentical(Node root, Node subRoot){
        if(subRoot == null && root == null){
            return true;
        }
        if(subRoot == null || root == null){
            return false;
        }
        if(root.data == subRoot.data){
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.left);
        }
        return false;
    }
    public static boolean isSubtree(Node root , Node subRoot){
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(isIdentical(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        // inOrder(root);
        // deleteNode(root, 5);
        // System.out.println( );
        // inOrder(root);
        levelOrder(root);
        System.out.println(height(root));
        System.out.println(sumNodes(root));
        System.out.println(countNodes(root));
    }
}