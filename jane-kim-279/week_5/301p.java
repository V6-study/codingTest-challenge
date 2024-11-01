import java.util.*;
import java.io.*;

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main
{        
    static Node root;
    static StringBuilder sb = new StringBuilder();

    static void createNode(char data, char leftData, char rightData) {
        if (root == null) {
            root = new Node(data);

            if (leftData != '.') root.left = new Node(leftData);
            if (rightData != '.') root.right = new Node(rightData);
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    static void searchNode(Node node, char data, char leftData, char rightData) {
        if (node == null) return;

        if (node.data == data) {
            if (leftData != '.') node.left = new Node(leftData);
            if (rightData != '.') node.right = new Node(rightData);
        } else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    // 전위순회 Preorder : Root -> Left -> Right
    static void preorder(Node node) {
        if (node != null) {
            sb.append(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    // 중위순회 Inorder : Left -> Root -> Right 
    static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            sb.append(node.data);
            inorder(node.right);
        }
    }

    // 후위순위 PostOrder : Left -> Right -> Root
    static void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            sb.append(node.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char data = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            createNode(data, left, right);
        }

        // 전위 순회
        preorder(root);
        sb.append('\n');

        // 중위 순회
        inorder(root);
        sb.append('\n');

        // 후위 순회
        postorder(root);
        
        System.out.println(sb);
        br.close();
    }
}
