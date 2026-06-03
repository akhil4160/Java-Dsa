import java.util.*;

public class LisM2Big {
    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (n == 0 || m == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int lis(int arr1[]) {
        HashSet<Integer> set = new HashSet<>();

        // step 1 : remove duplicates
        for (int i = 0; i <= arr1.length-1; i++){
            set.add(arr1[i]);
        }
        // Step 2: convert set → array
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] =num;
            i++;
        }
        // Step 3: sort
        Arrays.sort(arr2);
        // call lcs
        return lcs(arr1, arr2);
    }
    public static void main(String args[]){
        int arr1[] = {50, 3, 10, 7, 40, 80};
        System.out.println(lis(arr1));
    }
}
