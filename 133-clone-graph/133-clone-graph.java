class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node[]visited = new Node[101];
        return helper(node,visited);
    }
    public Node helper(Node node,Node[]visited){
        Node nodeClone = new Node(node.val);
        visited[node.val] = nodeClone;
        
        for(Node nbr : node.neighbors){
            if(visited[nbr.val] == null){
                Node nbrClone = helper(nbr,visited);
                nodeClone.neighbors.add(nbrClone);
            }else{
                Node nbrClone = visited[nbr.val];
                nodeClone.neighbors.add(nbrClone);
            }
        }
        return nodeClone;
    }
}