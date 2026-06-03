public class kanpsakTabulation{
    public static int kst(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=W; j++){

                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j){
                    int inclprft = v + dp[i-1][j-w];
                    int exclprft = dp[i-1][j];
                    dp[i][j] = Math.max(inclprft, exclprft);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printDP(dp);
        return dp[n][W];
    }
    public static void main(String args[]){
        int val[] = {15, 14, 10};
        int wt[] = {1, 5, 3};
        int W = 7;
        System.out.println(kst(val, wt, W));
    }
    public static void printDP(int dp[][]){
    for(int i = 0; i < dp.length; i++) {
        for(int j = 0; j < dp[0].length; j++) {
            System.out.print(dp[i][j] + " ");
        }
        System.out.println();
    }
    }
}