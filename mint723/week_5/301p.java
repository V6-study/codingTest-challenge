// https://www.acmicpc.net/problem/1991
import java.io.*;
import java.util.*;

class Main {
    static Node head = new Node('A', null, null);

    static StringBuilder sb = new StringBuilder();

    static class Node{
        char alp;
        Node left;
        Node right;
        Node(char alp, Node left, Node right){
            this.alp = alp;
            this.left = left;
            this.right = right;
        }
    }

    static void insertNode(Node node, char alp, char left, char right){
        if(node.alp == alp){ //현재 노드의 알파벳이 삽입할 위치의 알파벳과 동일한 경우
            node.left = left == '.' ? null : new Node(left, null, null);
            node.right = right == '.' ? null : new Node(right, null, null);
        }else{ //다를 경우
            if(node.left != null){ //왼쪽 자식이 있으면
                insertNode(node.left, alp, left, right); //왼쪽 자식 노드로 내려가서 조건 검증
            }
            if(node.right != null){ //오른쪽 자식이 있으면
                insertNode(node.right, alp, left, right); //오른쪽 자식 노드로 내려가서 조건 검증
            }
        }
    }

    //전위 순회
    static void preOrder(Node node){
        if(node == null) return;
        sb.append(node.alp);
        preOrder(node.left);
        preOrder(node.right);
    }

    //중위 순회
    static void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        sb.append(node.alp);
        inOrder(node.right);
    }

    //후위 순회
    static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.alp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i <N; i++) {

            st = new StringTokenizer(br.readLine());
            char alp = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, alp, left, right);
        }

        preOrder(head);
        sb.append("\n");
        inOrder(head);
        sb.append("\n");
        postOrder(head);
        sb.append("\n");

        System.out.println(sb);
        br.close();
    }

}
