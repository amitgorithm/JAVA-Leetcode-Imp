/** There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam. You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes. The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes. Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted. **/

import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] arr, int k) {
        PriorityQueue<double[]> q = new PriorityQueue<>((x, y) -> Double.compare(y[0], x[0]));
        for (int[] v : arr) {
            int a = v[0], b = v[1];
            q.offer(new double[]{diff(a, b), a, b});
        }
        for (int i = 0; i < k; i++) {
            double[] t = q.poll();
            int a = (int) t[1];
            int b = (int) t[2];
            a++;
            b++;
            q.offer(new double[]{diff(a, b), a, b});
        }
        double res = 0.0;
        while (!q.isEmpty()) {
            double[] t = q.poll();
            res += (double) t[1] / t[2];
        }
        return res / arr.length;
    }

    private double diff(int a, int b) {
        return ((double)(a + 1) / (b + 1)) - ((double) a / b);
    }
}
