/* Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.

3 <= points.length <= 50
-50 <= xi, yi <= 50
All the given points are unique */

class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = triangleArea(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private double triangleArea(int[] A, int[] B, int[] C) {
        return 0.5 * Math.abs(
            A[0]*(B[1] - C[1]) +
            B[0]*(C[1] - A[1]) +
            C[0]*(A[1] - B[1])
        );
    }
}
