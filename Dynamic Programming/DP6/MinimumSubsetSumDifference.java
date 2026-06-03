public class MinimumSubsetSumDifference {
    public static int mssd(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int W = sum / 2;
        int n = arr.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = arr[i - 1];
                if (v <= j) {
                    dp[i][j] = Math.max(v + dp[i - 1][j - v], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }
    public static void main(String args[]){
        int arr[] = {1, 6, 11, 5};
        System.out.println(mssd(arr));
    }
}