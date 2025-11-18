import java.util.Arrays;

public class PageRank {
    public static void main(String[] args) {
        double[][] P = {
                {1.0/3, 0, 0, 1.0/3},
                {1.0/3, 0, 0, 1.0/3},
                {0, 1, 0, 1.0/3},
                {1.0/3, 0, 1, 0}
        };
        int n = P.length;
        double[] arr = new double[n];
        double d = 0.85;
        Arrays.fill(arr, 1.0/n);

        int i;
        for(i=1; i<=1000; i++) {
            if(calculatePageRank(P, n, arr, d)) {
                System.out.println("Number of iterations: " + i);
                break;
            }
        }

        System.out.println("Page Ranks are: " + Arrays.toString(arr));
        double sum = 0;
        for(double ele: arr)
            sum += ele;
        System.out.println("Net Probability: " + sum);
    }

    public static boolean calculatePageRank(double[][] P, int n, double[] arr, double d) {
        double[] currItr = new double[n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                currItr[i] += d * P[i][j] * arr[j];
            }
            currItr[i] += (1.0 - d) / n;
        }

        double sum = 0;
        boolean hasConverged = true;
        for(double ele: currItr)
            sum += ele;
        for(int i=0; i<n; i++) {
            if(Math.abs(currItr[i]-arr[i]) > 1e-10)
                hasConverged = false;
            currItr[i] /= sum;
            arr[i] = currItr[i];
        }

        return hasConverged;
    }
}
