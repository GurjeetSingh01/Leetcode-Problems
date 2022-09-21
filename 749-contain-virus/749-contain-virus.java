class Solution {
    int rows, cols;
    int[][] directions = {
        {0,1},{0,-1},{1,0},{-1,0}
    };
    int[][] isInfected;
    public int containVirus(int[][] isInfected) {
        // 1. getRegions
        // 2. Sort in a decreasing order by most uninfected neighbours
        // 3. pick up the first element and mark it is as contained
        // 4. add the walls required in the result
        // 5. rest of the regions, we will mark infected for the uninfected neighbours
        rows = isInfected.length;
        cols = isInfected[0].length;
        this.isInfected = isInfected;
        if (this.isInfected == null || this.isInfected.length == 0) {
            return 0;
        }
        int result = 0;
        while (true) {
            List<Region> regions = new ArrayList();
            boolean[][] visited = new boolean[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (this.isInfected[row][col] == 1) {
                        Region region = new Region();
                        traverseRegion(row, col, region, visited);
                        
                        if (region.neighbours.size() > 0) {
                            regions.add(region);
                        }
                    }
                }
            }
            
            if (regions.size() == 0) {
                break;
            }
            
            Collections.sort(regions);
            
            Region mostContagiousRegion = regions.remove(0);
            result += mostContagiousRegion.wallsRequired;
            
            for (int infectedArea: mostContagiousRegion.infected) {
                int row = infectedArea / cols, col = infectedArea % cols;
                this.isInfected[row][col] = 2;
            }
            
            for (Region region: regions) {
                for (int neighbour: region.neighbours) {
                    int row = neighbour / cols, col = neighbour % cols;
                    this.isInfected[row][col] = 1;
                }
            }
        }
        return result;
    }
    
    private void traverseRegion(int row, int col, Region region, boolean[][] visited) {
        if (outOfBoundary(row, col)) {
            return;
        }
        
        if (this.isInfected[row][col] == 2) {
            return; // contained already
        }
        
        if (this.isInfected[row][col] == 1) {
            region.infected.add(row * cols + col);
            if (visited[row][col]) {
                return;
            }
        }

        visited[row][col] = true;
        if (this.isInfected[row][col] == 0) {
            region.neighbours.add(row * cols + col);
            region.wallsRequired++;
            return;
        }
        
        // traverse 4 directionally connected cells
        for (int[] direction: directions) {
            traverseRegion(direction[0] + row, direction[1] + col, region, visited);
        }
    }
    
    private boolean outOfBoundary(int row, int col) {
        return row < 0 || col < 0 || row >= rows || col >= cols;
    }
    
    static class Region implements Comparable {
        Set<Integer> infected;
        Set<Integer> neighbours;
        int wallsRequired;
        
        Region() {
            this.infected = new HashSet();
            this.neighbours = new HashSet();
            this.wallsRequired =0;
        }

        @Override
        public int compareTo(Object o) {
            Region r = (Region) o;
            return r.neighbours.size() - this.neighbours.size();
        }
        
        @Override
        public String toString() {
            return "Region{" +
                    "infected=" + infected +
                    ", neighbours=" + neighbours +
                    ", wallsRequired=" + wallsRequired +
                    '}';
        }
    }
}