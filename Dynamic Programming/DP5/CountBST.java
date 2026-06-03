public class CountBST {
     public static int bst(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                int leftSubtre = dp[j];
                int ritSubtre = dp[i-j-1];
                dp[i] += leftSubtre * ritSubtre;
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n = 4;
        System.out.println(bst(n));
    }
}
