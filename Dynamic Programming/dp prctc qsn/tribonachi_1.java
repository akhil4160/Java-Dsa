public class tribonachi_1{
    public static int tribo(int n ,int dp[]){
        if(n==0||n==1){
            return 0;
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        dp[2] = 1;
        return dp[n] = tribo((n-1), dp) + tribo((n-2), dp)+ tribo((n-3), dp);
    }
    public static void main(String args[]){
        int n = 20;
        int dp[] = new int[n+1];
        System.out.println(tribo(n, dp));
        for(int i = 0; i<=n; i++){
            System.out.print(dp[i] + " ");
        }
    }
}