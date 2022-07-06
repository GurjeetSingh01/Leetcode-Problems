class Solution {
    public int maxPoints(int[][] points) 
    {
        // If 0, 1, or 2 points, then there are that many points on a line.
        if (points.length <= 2)  return points.length;
        
        // Else 3 or more points were passed so we need to test for co-linear triples.
        int maxPointsOnALine = 0;
        // Loop through the passed points to get point1 as first point.
        for (int idx1 = points.length - 1; idx1 >= 2; idx1--) {
            int x1 = points[idx1][0];
            int y1 = points[idx1][1];
            // Loop through all points after point1, to get point2.  This will define 
            // a line through point1 and point2.
            for (int idx2 = idx1 - 1; idx2 >= 1; idx2--) {
                int deltaX21 = points[idx2][0] - x1;
                int deltaY21 = points[idx2][1] - y1;
                int curCount = 2;
                // Loop through all points after point2, to get point3.  If point3 is 
                // on the same line as point1 and point2, then count another point on 
                // that same point1:point2 line.
                for (int idx3 = idx2 - 1; idx3 >= 0; idx3--)
                    if ((points[idx3][1] - y1) * deltaX21 == (points[idx3][0] - x1) * deltaY21)
                        curCount++;
                maxPointsOnALine = Math.max(maxPointsOnALine, curCount);
            }
        }
        return maxPointsOnALine;
    }
}