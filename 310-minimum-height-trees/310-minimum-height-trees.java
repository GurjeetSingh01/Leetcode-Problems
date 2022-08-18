class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] <= 1) {
                leaves.add(i);
                degree[i] = 0;
            }
        }
        
        int c = leaves.size();
        
        while (c < n) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                for (int neighbor : map.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        newLeaves.add(neighbor);
                    }
                }
                degree[leaf] = 0;
            }
            c += newLeaves.size();
            leaves = newLeaves;
        }
        
        return leaves;
    }
}