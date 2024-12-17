// https://www.acmicpc.net/problem/5639
import java.io.*;

public class Main {
    private static class Node{
        int item;
        Node left;
        Node right;
        public Node(int item){
            this.item = item;
        }
        void addChild(int childItem){
            if(item > childItem){ // 추가하는 값이 현재 노드의 값보다 작으면
                if(left == null){
                    left = new Node(childItem); // 왼쪽 자식 없으면 노드 생성
                }else {
                    left.addChild(childItem); // 왼쪽 자식 있으면 자식에 값 추가
                }
            }else{
                if(right == null){ // 추가하는 값이 현재 노드의 값보다 크면
                    right = new Node(childItem); // 오른쪽 자식 없으면 노드 생성
                }else {
                    right.addChild(childItem); // 오른쪽 자식 있으면 자식에 값 추가
                }
            }
        }
    }
    private static StringBuilder postorder = new StringBuilder();

    private static void dfs(Node node){
        if (node == null) return;
        dfs(node.left);
        dfs(node.right);
        postorder.append(node.item+"\n"); // 후위표현식: 자식 노드 다 탐색 후 출력
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String input ="";
        while((input=br.readLine()) != null && !input.isEmpty()){
            root.addChild(Integer.parseInt(input));
        }

        dfs(root); // dfs 탐색

        System.out.print(postorder.toString());
    }
}
