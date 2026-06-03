public class RodCutting {
    public static int rc(int val[], int lnth[], int tl){
        int n = val.length;
        int dp[][] = new int[n+1][tl+1];

        for (int i=0; i<=n; i++){
            for(int j=0; j<=tl; j++){
                if(i == 0 || j== 0){
                    dp[i][j] = 0;
                }
            }
        }    
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<=tl; j++){
                int v = val[i-1];
                int l = lnth[i-1];
                if(l<=j){
                    int inc = v + dp[i][j-l];
                    int exl = dp[i-1][j];
                    dp[i][j] = Math.max(inc, exl);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][tl];
    }
    public static void main(String args[]){
        int lnth[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int val[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int tl = 8;
        System.out.println(rc(val,lnth, tl));
    }
}
