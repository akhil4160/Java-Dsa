public class StringConversion {
    public static int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];

        if(n==0 || m==0){
            return 0;
        }
        for(int i = 1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
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
        String str1 = "sea";
        String str2 = "pear";
        System.out.println((str2.length() - lcs(str1, str2)) + (str1.length() - lcs(str1, str2)));
    }
}
//DONE BY MYSELF