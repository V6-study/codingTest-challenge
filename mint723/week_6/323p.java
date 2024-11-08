// https://school.programmers.co.kr/learn/courses/30/lessons/42892

import java.util.*;

class Solution {
    
    class Node{
        int x, y, node;
        Node left, right;
        
        public Node(int x, int y, int node){
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }
    
    Node buildTree(int[][] nodeinfo){
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++){
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        
        Arrays.sort(nodes, (o1, o2) -> { // y는 내림차순 만약 같다면 x는 오름차순
           if(o1.y == o2.y) {
               return o1.x - o2.x;
           }
            return o2.y - o1.y;
        });
        
        Node root = nodes[0];
        
        for(int i=1; i<nodes.length; i++){
            Node parent = root;
            while(true){
                if(nodes[i].x < parent.x){
                    if(parent.left == null){
                        parent.left = nodes[i];
                        break;
                    }else{
                       parent = parent.left;
                    }
                }else{
                    if(parent.right == null){
                        parent.right = nodes[i];
                        break;
                    }else{
                        parent = parent.right;
                    }
                }
            }
        }
        
        return nodes[0];
    }
    
    void preOrder(Node cur, List<Integer> answer){
        if(cur == null)
            return;
        answer.add(cur.node);
        preOrder(cur.left, answer);
        preOrder(cur.right, answer);
    }
    
    void postOrder(Node cur, List<Integer> answer){
        if(cur == null)
            return;
        postOrder(cur.left, answer);
        postOrder(cur.right, answer);
        answer.add(cur.node);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node root = buildTree(nodeinfo);
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        preOrder(root, preList);
        postOrder(root, postList);
        
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preList.stream().mapToInt(i->i).toArray();
        answer[1] = postList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
