public class TargetSumSubset {
    public static boolean tss(int arr[], int tgt){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][tgt + 1];
        for(int i = 0; i<=n; i++){ //filling trues in first coloumn
            dp[i][0] = true;
        }
        for(int i=1; i<=n; i++){
            for(int j = 1; j<=tgt; j++){
                int v = arr[i-1];
                if(v<=j && dp[i-1][j-v] == true){ //include
                    dp[i][j] = true;
                }else if(dp[i-1][j] == true){ //exclude
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][tgt];
    }
    public static void main(String args[]){
        int arr[] = {4, 2, 7, 1, 3};
        int tgt = 9;
        System.out.println(tss(arr, tgt));
    }
}