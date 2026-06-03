public class LcsTabulation {
    public static int lcst(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        if(n==0 || m==0){
            return 0;
        }
        for(int i = 1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    int a1 = dp[i][j-1];
                    int a2 = dp[i-1][j];
                    dp[i][j] = Math.max(a1, a2);
                }

            }
        }
        return dp[n][m];
    }
    public static void main(String args[]){
        String str1 = "abcdge";
        String str2 = "abde";
        System.out.println(lcst(str1, str2));
    }
}