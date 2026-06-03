import java.util.Arrays;

public class CatlanMemoization {
    public static int crm(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        Arrays.fill(dp, -1);

        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += crm(i, dp) * crm(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    public static void main(String args[]) {
        int n = 6;
        int dp[] = new int[n+1];
        System.out.println(crm(n, dp));
    }
}