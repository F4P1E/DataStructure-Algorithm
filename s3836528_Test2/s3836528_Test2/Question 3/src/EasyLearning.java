//Data Structure and Algorithms
//Date Create: 14/01/2023
//Student: Duong Phu Dong (s3836528)

public class EasyLearning {
    public static void main(String[] args) {
        int[][] costs = new int[][]
                {
                        {0, 1, 5},
                        {4, 0, 3},
                        {2, 1, 0}
                };

        EasyLearning easyLearning = new EasyLearning(costs);
        System.out.println(easyLearning.directSequence());
        System.out.println(easyLearning.compare(new int[]{0, 2}, new int[]{0, 1, 2}));
        System.out.println(easyLearning.bestSequence());
    }

    int[][] costs;

    public EasyLearning(int[][] costs) {
        this.costs = costs;
    }

    //directSequence complexity O(1)
    public int directSequence() {
        int numOfCourse = costs.length;
        return costs[0][numOfCourse - 1];
    }

    //compare complexity O(1)
    public int compare(int[] seq1, int[] seq2) {
        int numOfCourse1 = seq1.length;
        int numOfCourse2 = seq2.length;

        int cost1 = 0;
        int cost2 = 0;

        for (int i = 0; i < numOfCourse1 - 1; i++) {
            cost1 += costs[seq1[i]][seq1[i + 1]];
        }

        for (int i = 0; i < numOfCourse2 - 1; i++) {
            cost2 += costs[seq2[i]][seq2[i + 1]];
        }

        if (cost1 > cost2) // return 1 if the total switching cost of seq1 larger than seq2
        {
            return 1;
        } else if (cost1 < cost2) { // return -1 if the total switching cost of seq1 smaller than seq2
            return -1;
        }

        return 0; // the switching costs are equal
    }

    // bestSequence complexity O(N^2)
    public int bestSequence() {
        int n = costs.length;
        int length = 0;

        boolean[] added = new boolean[n];

        double[] distances = new double[n];
        for (int i = 0; i < n; i++) {
            distances[i] = Double.MAX_VALUE;
        }
        distances[0] = 0;

        System.out.print("The learning order: ");

        int nodeCount = 0;
        while (nodeCount < n) {
            double shortest = Double.MAX_VALUE;
            int shortestNode = -1;

            for (int i = 0; i < n; i++) {
                if (added[i]) {
                    continue;
                }
                if (shortest > distances[i]) {
                    shortest = distances[i];
                    shortestNode = i;
                }
            }

            System.out.print(shortestNode + " ");

            added[shortestNode] = true;
            length += distances[shortestNode];
            nodeCount++;

            for (int i = 0; i < n; i++) {
                if (added[i]) {
                    continue;
                }
                if (distances[i] > costs[shortestNode][i]) {
                    distances[i] = costs[shortestNode][i];
                }
            }
        }

        System.out.println();
        return length;
    }
}
