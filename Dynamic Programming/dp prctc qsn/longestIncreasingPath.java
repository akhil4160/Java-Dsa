

public class longestIncreasingPath {
    public static int lip(int n, int m, int arr[][]) {
        int lp;
        lp = arr[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i + 1][j] > arr[i][j]) {
                    lp += arr[i+1][j];
                } else if (arr[i][j + 1] > arr[i][j]) {
                    lp += arr[i][j+1];
                }
            }
        }
        return lp;
    }

    public static void main(String args[]) {
        int n = 4;
        int m = 4;
        int arr[][] = { { 1, 2, 3, 4 },
                { 2, 2, 3, 4 },
                { 3, 2, 3, 4 },
                { 4, 5, 6, 7 } };
        System.out.println(lip(n, m, arr));     
    }
}
